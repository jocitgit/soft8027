package ie.cit.soft8027.jdbctemplateproject.domain;

import java.util.Collections;
import java.util.List;

public class Movement {

	private int id;
	private String name;
	private List<Artist> artists;
	
	public Movement() {
		// Prevents null pointer exception if there are no artists
		artists = Collections.<Artist>emptyList();
	}

	@Override
	public String toString() {
		String out = "Movement [id=" + id + ", name=" + name + ", artists=[";
		for (Artist a : artists ) {
			out += a.toString() + ", "; 
		}
		out += "]]";
		return out;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
	
}

