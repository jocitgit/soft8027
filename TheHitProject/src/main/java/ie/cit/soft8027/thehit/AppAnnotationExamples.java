package ie.cit.soft8027.thehit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.soft8027.thehit.domain.Venue;

public class AppAnnotationExamples {
	
	private static ApplicationContext context;

	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("annotationConfiguration.xml");
	
		
	
	Venue venue = (Venue)context.getBean("annotationRequiredExample");
	System.out.println(venue.getCapacity());
	
	}
}
