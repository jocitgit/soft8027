package ie.cit.soft8027.exampledb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.soft8027.exampledb.domain.*;
public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		return new Product(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getDouble("weight"),
				rs.getString("description"),
				rs.getDouble("unit_cost"));
	}

	
}
