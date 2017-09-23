package ie.cit.soft8027.exampledb.dao;

import java.util.List;

import ie.cit.soft8027.exampledb.domain.Product;

public interface ProductDao {

	
	Product getById(int id);
	
	List<Product> findAll();
	
}
