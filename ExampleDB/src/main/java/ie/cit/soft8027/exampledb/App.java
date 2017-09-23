package ie.cit.soft8027.exampledb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.soft8027.exampledb.dao.ProductDao;
import ie.cit.soft8027.exampledb.domain.Product;

public class App {

	private static ApplicationContext context;
	
	public static void main(String args[]) {
		
		context = new ClassPathXmlApplicationContext("config.xml");
		
		// Option using bean name - requires casting
		// ProductDao product = (ProductDao)context.getBean("productDao");
		
		// Alternate option - assumes only one implementation of ProductDao
		ProductDao productDao = context.getBean(ProductDao.class);
		
		Product oldXboxOne = productDao.getById(1);
		System.out.println(oldXboxOne.toString());
		
		List<Product> products = productDao.findAll();
		System.out.println("I found " + products.size() + " product(s)");
		
		
	}
}
