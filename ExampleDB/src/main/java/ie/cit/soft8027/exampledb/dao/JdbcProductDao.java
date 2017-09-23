package ie.cit.soft8027.exampledb.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ie.cit.soft8027.exampledb.domain.Product;
import ie.cit.soft8027.exampledb.rowmapper.ProductRowMapper;

public class JdbcProductDao implements ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcProductDao(DataSource ds) {
		super();
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public Product getById(int id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new ProductRowMapper());
	}

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM products";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}
	
}
