package ie.cit.soft8027.thehit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.soft8027.thehit.domain.SongwriterImpl2;

public class AppComponent {


	private static ApplicationContext context;

	public static void main( String[] args )
	{        
		context=new ClassPathXmlApplicationContext
				("componentConfiguration.xml");
		
		// Default bean name if not specified
		// SongwriterImpl2 songwriterImpl2=(SongwriterImpl2)context.getBean("songwriterImpl2");
		
		// custom bean name specified after @Component
		SongwriterImpl2 songwriterImpl2=(SongwriterImpl2)context.getBean("customBeanName");
		System.out.println(songwriterImpl2.toString());
		
		System.out.println("Firstname:"+songwriterImpl2.getFirstName()+ ", Lastname: "+songwriterImpl2.getLastName()
        +", age:"+songwriterImpl2.getAge()+", song name:"+songwriterImpl2.getSong().getName()
        +", song lyrics:"+songwriterImpl2.getSong().getLyrics());
  
	}



}
