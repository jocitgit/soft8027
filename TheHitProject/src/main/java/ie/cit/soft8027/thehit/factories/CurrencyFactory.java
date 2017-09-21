package ie.cit.soft8027.thehit.factories;

import ie.cit.soft8027.thehit.domain.*;
import ie.cit.soft8027.thehit.interfaces.*;


public class CurrencyFactory {
	
	public static Currency createCurrency (String country) {
	       if (country.equalsIgnoreCase ("Ireland")){
	              return new Euro();
	       }else if(country.equalsIgnoreCase ("England")){
	              return new Pounds();
	       }
	       else return null;
	  }	 
	}