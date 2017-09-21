package ie.cit.soft8027.thehit;

import ie.cit.soft8027.thehit.domain.*;
import ie.cit.soft8027.thehit.interfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext context;	
	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("configuration.xml");
		
	/** Simple bean blank constructor **/
	Songwriter simpleBeanExample=(Songwriter)context.getBean("ourFirstBean");                 
  
	SongwriterImpl songwriter=(SongwriterImpl)context.getBean("mary");
	
	System.out.println("The songwriters firstname is: " + songwriter.getFirstName() + 
			": The songwriters lastname is: "+ songwriter.getLastName() + 
			" The songwriters age is: " + songwriter.getAge() + 
			" The songwriters song name is: " + songwriter.getSong().getName() + 
			" The songwriters song lyrics are: " + songwriter.getSong().getLyrics());                            

	
	
	Venue venue = (Venue)context.getBean("hitvenue");
	System.out.println("The venues name is: " + venue.getName() + 
			" The venues address is: " + venue.getAddressLine1() + ", " + venue.getAddressLine2() + 
			" The venues country is: " + venue.getCountry() + 
			" The venues capacity is: " + venue.getCapacity());
	
	Song setterDISong =(Song)context.getBean("setterBeanSong");
	System.out.println("Song name is: "+ setterDISong.getName());
	System.out.println("Song lyrics are: "+ setterDISong.getLyrics());    
	
	SongwriterImpl setterDISongwriter =(SongwriterImpl)context.getBean("setterSongwriter");
	System.out.println("Songwriter firstname is: "+ setterDISongwriter.getFirstName());
	System.out.println("Songwriter second name is: "+setterDISongwriter.getLastName());
	System.out.println("Songwriter age is: "+setterDISongwriter.getAge());
	System.out.println("Songwriter song details are: Song name: "+setterDISongwriter.getSong().getName()+
	        		" Song lyrics are: "+setterDISongwriter.getSong().getLyrics());                                
	                                
	
	Currency currency=(Currency)context.getBean("currency");
	System.out.println("Currency symbol: " + currency.getSymbol());
	
	/**Singleton Example
	* Even when we create 2 bean instances of the object Stage the same instance is returned.
	**/
	Stage stage=(Stage)context.getBean("theStage");
	System.out.println("Stage instance value: "+ stage.toString());
	Stage stage1=(Stage)context.getBean("theStage1");
	System.out.println("Stage instance value: "+ stage1.toString());
	
	}
}               
