package ie.cit.soft8027.thehit;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.soft8027.thehit.domain.Stage;

public class AppAbstractAppContext {
private static AbstractApplicationContext abstractContext;
 public static void main( String[] args )
    {
	 
	 	//must use abstract application context for destroy methods to be called
    	abstractContext=new ClassPathXmlApplicationContext("configuration.xml");  
    	Stage stageInitDestroyExample=(Stage)abstractContext.getBean("theStageInitDestroyExample");
    	//you need the line below or else it WILL NOT WORK!!!
    	abstractContext.registerShutdownHook();	    
    }

}                            

