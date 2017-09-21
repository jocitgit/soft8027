package ie.cit.soft8027.thehit;

import ie.cit.soft8027.thehit.interfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext context;	
	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("configuration.xml");
		
	/** Simple bean blank constructor **/
	Songwriter simpleBeanExample=(Songwriter)context.getBean("ourFirstBean");                 
    }
  
}               
