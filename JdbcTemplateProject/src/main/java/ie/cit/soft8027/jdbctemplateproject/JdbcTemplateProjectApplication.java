package ie.cit.soft8027.jdbctemplateproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import ie.cit.soft8027.jdbctemplateproject.domain.Artist;
import ie.cit.soft8027.jdbctemplateproject.domain.Movement;
import ie.cit.soft8027.jdbctemplateproject.rowmapper.ArtistRowMapper;
import ie.cit.soft8027.jdbctemplateproject.rowmapper.MovementRowMapper;

@SpringBootApplication
public class JdbcTemplateProjectApplication implements CommandLineRunner{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateProjectApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		query01();
		query02();
		query03();
		query04();
		query05();
		query06();
		query07();
		query08();
		
	}
	
	public void query01() {
		// Query for a list of maps with key-value pairs
		// The hard way!!!
			
		System.out.println("\nQuery 1 (List all artists using resultset Map)\n----------------");
			
		String sql = "SELECT * FROM artists";
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
			
		for (Map<String, Object> row : resultSet) {
			System.out.println("Name: " + row.get("fullName"));
			System.out.println("ID: " + row.get("id"));
			System.out.println("Gender: " + row.get("gender") + "\n");
		}
	}
	
	public void query02() {
		// Query for a list of objects - automatic mapping from row to object using RowMapper class
		// Using parameterised "prepared statements" reduces the risk of a SQL inject attack
			
		System.out.println("\nQuery 2 (List male artists using RowMapper)\n-----------------");
			
		String sql = "SELECT * FROM artists WHERE gender = ?";
		List<Artist> artists = jdbcTemplate.query(sql, new Object[] { "male" }, new ArtistRowMapper());
			
		for (Artist artist : artists) {
			System.out.println(artist.toString());
		}
	}
	
	public void query03() {
		// Query for a specific object - automatic mapping from row to object using RowMapper class
			
		System.out.println("\nQuery 3 (Print artist with id 1 - uses RowMapper)\n------------------");
			
		String sql = "SELECT * FROM artists WHERE id = ?";
		Artist artist = jdbcTemplate.queryForObject(sql, new Object[] { 1 }, new ArtistRowMapper());
			
		System.out.println(artist.toString());
	}

	public void query04() {
		// Query for specific column values
			
		System.out.println("\nQuery 4 (Specfic columns)\n------------------");
			
		// Old version (now deprecated)
//		String sql = "SELECT count(*) FROM artists";
//		int artistCount = jdbcTemplate.queryForInt(sql);
//		System.out.printf("Number of artists: %d\n", artistCount);
			
		// New way
		String sql = "SELECT count(*) FROM movements";
		int movementCount = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.printf("Number of movements: %d\n", movementCount);
			
		// Getting a map of values
		sql = "SELECT fullName, gender FROM artists WHERE id = 1";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		System.out.printf("Name: %s, Gender: %s\n", map.get("fullName"), 
						map.get("gender"));
	}
	
	public void query05() {
		// Specific artist and the artist's movements (many-to-many)
		// This is an inefficient version with 2 separate queries

		System.out.println("\nQuery 5 (Print artist and movements - 2 queries)\n------------------");

		String sql = "SELECT * FROM artists WHERE id = ?";
		Artist artist = jdbcTemplate.queryForObject(sql, new Object[] { 1 }, new ArtistRowMapper());

		sql = "SELECT m.* FROM movements m, artist_movements am WHERE m.id = am.movement_id AND am.artist_id = ?";
		List<Movement> movements = jdbcTemplate.query(sql, new Object[] { 1 }, new MovementRowMapper());
			
		artist.setMovements(movements);
		
		System.out.println(artist.toString());
	}

	public void query06() {
		// Specific artist and the artist's movements (many-to-many)
		// More efficient version with a single join query and
		// a ResultSetExtractor.... but it can get messy the more
		// complicated the join queries! The solution? ORM.

		System.out.println("\nQuery 6 (Print artist and movements - 1 join query)\n------------------");

		String sql = "SELECT a.id as artistid, a.fullName, a.gender, m.id as movementid, m.name " + 
				"FROM artists a, movements m, artist_movements am " + 
				"WHERE m.id = am.movement_id AND a.id = am.artist_id AND am.artist_id = ?";
		Artist artist = jdbcTemplate.query(sql, new Object[] { 1 }, 
				new ResultSetExtractor<Artist>() {			// Anonymous inner class implements ResultSetExtractor

					@Override
					public Artist extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						;
						Artist artist = null;
						List<Movement> movements = new ArrayList<>();
						
						while (rs.next()) {
							if (artist == null) {
								artist = new Artist();
								artist.setId(rs.getInt("artistid"));
								artist.setName(rs.getString("fullName"));
								artist.setGender(rs.getString("gender"));
							}
							Movement movement = new Movement();
							movement.setId(rs.getInt("movementid"));
							movement.setName(rs.getString("name"));
							movements.add(movement);
						}
						
						artist.setMovements(movements);
						return artist;
					}
				}
		);
		
		System.out.println(artist.toString());
	}
	
	public void query07() {
		// Specific movement and the movement's artists (many-to-many)
		// This is an inefficient version with 2 separate queries

		System.out.println("\nQuery 7 (Print movement and artists - 2 queries)\n------------------");

		String sql = "SELECT * FROM movements WHERE id = ?";
		Movement movement = jdbcTemplate.queryForObject(sql, new Object[] { 4 }, new MovementRowMapper());

		sql = "SELECT a.* FROM artists a, artist_movements am WHERE a.id = am.artist_id AND am.movement_id = ?";
		List<Artist> artists = jdbcTemplate.query(sql, new Object[] { 4 }, new ArtistRowMapper());
			
		movement.setArtists(artists);
		
		System.out.println(movement.toString());
	}

	public void query08() {
		// Specific movement and the movement's artists (many-to-many)
		// More efficient version with a single join query and
		// a ResultSetExtractor.... but it can get messy the more
		// complicated the join queries! The solution? ORM.

		System.out.println("\nQuery 8 (Print movement and artists - 1 join query)\n------------------");

		String sql = "SELECT m.id as movementid, m.name, a.fullName, a.gender, a.id as artistid " + 
				"FROM artists a, movements m, artist_movements am " + 
				"WHERE m.id = am.movement_id AND a.id = am.artist_id AND am.movement_id = ?";
		Movement movement = jdbcTemplate.query(sql, new Object[] { 4 }, 
				new ResultSetExtractor<Movement>() {			// Anonymous inner class implements ResultSetExtractor

					@Override
					public Movement extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						;
						Movement movement = null;
						List<Artist> artists = new ArrayList<>();
						
						while (rs.next()) {
							if (movement == null) {
								movement = new Movement();
								movement.setId(rs.getInt("movementid"));
								movement.setName(rs.getString("name"));
							}
							Artist artist = new Artist();
							artist.setId(rs.getInt("artistid"));
							artist.setName(rs.getString("fullName"));
							artist.setGender(rs.getString("gender"));
							
							artists.add(artist);
						}
						
						movement.setArtists(artists);
						return movement;
					}
				}
		);
		
		System.out.println(movement.toString());
	}




}
