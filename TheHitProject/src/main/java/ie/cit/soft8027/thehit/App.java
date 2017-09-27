package ie.cit.soft8027.thehit;

import ie.cit.soft8027.thehit.domain.*;
import ie.cit.soft8027.thehit.interfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class App {

	private static ApplicationContext context;
	private static ApplicationContext autoWirecontext;
	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("configuration.xml");
	autoWirecontext=new ClassPathXmlApplicationContext("autoWireConfiguration.xml");
		
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
	
	SongwriterImpl setterDISongwriter2 =(SongwriterImpl)context.getBean("setterSongwriter2");
	System.out.println("Songwriter firstname is: "+ setterDISongwriter2.getFirstName());
	System.out.println("Songwriter second name is: "+setterDISongwriter2.getLastName());
	System.out.println("Songwriter age is: "+setterDISongwriter2.getAge());
	System.out.println("Songwriter song details are: Song name: "+setterDISongwriter2.getSong().getName()+
	        		" Song lyrics are: "+setterDISongwriter2.getSong().getLyrics());                                
	                                
	//  setterDISongwriter and setterDISongwriter2 were both built using a reference to the same song bean
	// What happpens to the song bean if we update the song for one of them?
	setterDISongwriter.getSong().setName("new setterBeanSong name");
	System.out.println(setterDISongwriter.getSong().getName());
	System.out.println(setterDISongwriter2.getSong().getName());
	System.out.println(setterDISong.getName());
	Song setterDISong2 = (Song)context.getBean("setterBeanSong");
	System.out.println(setterDISong2.getName());
	// All the references to the setterBeanSong now have the new name inc. setterDISong2 as the setterBeanSong
	// is a singleton, ie the same instance of the song is returned
	
	
	Currency currency=(Currency)context.getBean("currency");
	System.out.println("Currency symbol: " + currency.getSymbol());
	
	// Note the use of Currency.class below - this is not the class specified in the bean (CurrencyFactory)
	// but the class of the object returned by the factory method
	Currency currency2 = context.getBean(Currency.class);
	System.out.println(currency2.getSymbol());
	
	
	//Note - the following CANNOT be used as although the bean "currency" is of class CurrencyFactory
	// the object returned by the factory method has class Currency which cannot be cast to CurrencyFactory
	//
	// CurrencyFactory currencyFactory = (CurrencyFactory)context.getBean("currency");
	//
	
	
	/**Singleton class
	* Even when we create 2 bean instances of the object Stage the same instance is returned.
	**/
	Stage stage=(Stage)context.getBean("theStage");
	System.out.println("Stage instance value: "+ stage.toString());
	Stage stage1=(Stage)context.getBean("theStage1");
	System.out.println("Stage instance value: "+ stage1.toString());
	
	stage.setTestVariable(99);
	System.out.println("stage: " + stage.getTestVariable() + " stage1: " + stage1.getTestVariable());
	stage1.setTestVariable(88);
	System.out.println("stage: " + stage.getTestVariable() + " stage1: " + stage1.getTestVariable());

	
	
	/**
	* Singleton Bean
	* Retrieving the same bean twice returns the same instance
	**/
	 Ticket ticketSingleton=(Ticket)context.getBean("ticket");
	 System.out.println("Instance:"+ ticketSingleton.toString());
	 Ticket ticketSingleton1=(Ticket)context.getBean("ticket");
	 System.out.println("Instance:"+ ticketSingleton1.toString());
	 
	 System.out.println(ticketSingleton.getTicketNumber() + ", " + ticketSingleton1.getTicketNumber());
	 ticketSingleton.setTicketNumber(5);
	 System.out.println(ticketSingleton.getTicketNumber() + ", " + ticketSingleton1.getTicketNumber());
	 
		/**
		* Prototype Bean
		* Retrieving the same bean twice returns different instances
		**/
	 Ticket ticketPrototype=(Ticket)context.getBean("ticketPrototype");
	 System.out.println("Instance:"+ ticketPrototype.toString());
	 Ticket ticketPrototypeAnother=(Ticket)context.getBean("ticketPrototype");
	 System.out.println("Instance:"+ ticketPrototypeAnother.toString());
	 
	 System.out.println(ticketPrototype.getTicketNumber() + ", " + ticketPrototypeAnother.getTicketNumber());
	 ticketPrototype.setTicketNumber(5);
	 System.out.println(ticketPrototype.getTicketNumber() + ", " + ticketPrototypeAnother.getTicketNumber());
	 
	 // Collections
	 CollectionsExample javaCollectionExample=(CollectionsExample)context.getBean("javaCollectionExample");
	 javaCollectionExample.getInstrumentList();
	 javaCollectionExample.getInstrumentSet();
	 javaCollectionExample.getInstrumentMap();
	 javaCollectionExample.getInstrumentProp();
	 javaCollectionExample.getMsg();
	 
	 
	 //Autowiring

	 SongwriterImpl songwriterAutoWire=(SongwriterImpl)autoWirecontext.getBean("autoWireExampleBean");
	 System.out.println("By Name:");
	 System.out.println("Song writer firstname is: "+ songwriterAutoWire.getFirstName());
	 System.out.println("Song writer lastname is: "+ songwriterAutoWire.getLastName());
	 System.out.println("Song writer age is: "+ songwriterAutoWire.getAge());
	 System.out.println("Song writer song name is: "+ songwriterAutoWire.getSong().getName()+ 
			 " lyrics: "+songwriterAutoWire.getSong().getLyrics());   
	 
	 
	 SingerImpl singerAutoWireByType=(SingerImpl)autoWirecontext.getBean("autoWireExampleByTypeBean");
	 System.out.println("By Type:");
	 System.out.println("Singer firstname is: "+ singerAutoWireByType.getFirstName());
	 System.out.println("Singer lastname is: "+ singerAutoWireByType.getLastName());
	 System.out.println("Singer age is: "+ singerAutoWireByType.getAge());
	 System.out.println("Singer song name is: "+ singerAutoWireByType.getSong().getName()+ " lyrics: "+singerAutoWireByType.getSong().getLyrics());   
	 
	 SingerImpl singerAutoWireByDefault=(SingerImpl)autoWirecontext.getBean("autoWireExampleByDefaultBean");
	 System.out.println("By Default:");
	 System.out.println("Singer firstname is: "+ singerAutoWireByDefault.getFirstName());
	 System.out.println("Singer lastname is: "+ singerAutoWireByDefault.getLastName());
	 System.out.println("Singer age is: "+ singerAutoWireByDefault.getAge());
	 System.out.println("Singer song name is: "+ singerAutoWireByDefault.getSong().getName()+ " lyrics: "+singerAutoWireByDefault.getSong().getLyrics());       
	   
	 SongwriterImpl autoWirebyConstructor=(SongwriterImpl)autoWirecontext.getBean("autoWireExampleConstructorBean");
	 System.out.println("By Constructor:");
	 System.out.println("Song writer firstname is: "+ autoWirebyConstructor.getFirstName());
	 System.out.println("Song writer lastname is: "+ autoWirebyConstructor.getLastName());
	 System.out.println("Song writer age is: "+ autoWirebyConstructor.getAge());
	 System.out.println("Song writer song name is: "+ autoWirebyConstructor.getSong().getName()+ " lyrics: "+autoWirebyConstructor.getSong().getLyrics());      
	  
	 SongwriterImpl autoWireOverride=(SongwriterImpl)autoWirecontext.getBean("notUsingAutoWireByNameBean");
	 System.out.println("Override autowiring");
	 System.out.println("Song writer firstname is: "+ autoWireOverride.getFirstName());
	 System.out.println("Song writer lastname is: "+ autoWireOverride.getLastName());
	 System.out.println("Song writer age is: "+ autoWireOverride.getAge());
	 System.out.println("Song writer song name is: "+ autoWireOverride.getSong().getName()+ " lyrics: "+autoWireOverride.getSong().getLyrics());      
	
	 //Lab3
	 
	 AudienceImpl audienceImplByType = (AudienceImpl)autoWirecontext.getBean("autowireByTypeAudience");
	 AudienceImpl audienceImplByName = (AudienceImpl)autoWirecontext.getBean("autowireByNameAudience");
	 AudienceImpl audienceImplByConstructor = (AudienceImpl)autoWirecontext.getBean("autowireByConstructorAudience");
	 
	 System.out.println(audienceImplByType);
	 System.out.println(audienceImplByName);
	 System.out.println(audienceImplByConstructor);
	}
	
}               
