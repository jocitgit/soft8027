package ie.cit.soft8027.thehit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.soft8027.thehit.domain.AudienceImpl;
import ie.cit.soft8027.thehit.domain.SingerImpl;
import ie.cit.soft8027.thehit.domain.Venue;

public class AppAnnotationExamples {
	
	private static ApplicationContext context;

	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("annotationConfiguration.xml");
	
		
	
	Venue venue = (Venue)context.getBean("annotationRequiredExample");
	System.out.println(venue.getCapacity());
	
	SingerImpl someSinger = (SingerImpl)context.getBean("autowiredSinger");
	System.out.println(someSinger.getFirstName() + " " + someSinger.getSong().getName() + " " + someSinger.getSong().getLyrics());
	
	/*SingerImpl someOtherSinger = (SingerImpl)context.getBean("autowiredConstructorSinger");
	System.out.println(someOtherSinger.getFirstName() + " " + someOtherSinger.getSong().getName() + " " + someOtherSinger.getSong().getLyrics());
	System.out.println(someOtherSinger.getSong2().getName() + " " + someOtherSinger.getSong2().getLyrics());
	*/
	SingerImpl qualifierSinger = (SingerImpl)context.getBean("qualifierSinger");
	System.out.println(qualifierSinger.getFirstName());
	System.out.println(qualifierSinger.getSong().getName());
	System.out.println(qualifierSinger.getSong2().getName());
	
	AudienceImpl audienceImpl = (AudienceImpl)context.getBean("audienceImpl");
	System.out.println(audienceImpl);
	
	
	
	}
}
