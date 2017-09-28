package ie.cit.soft8027.thehit.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Song2 {
	private String name;
	private String lyrics;
	
	// public Song2(){} 
	
	
	
	// using fixed values
	// @Autowired
	// public Song2(@Value("Oh Danny Boy") String name, @Value("The pipes the pipes are calling")String lyrics){
	
	// using properties file
	@Autowired
	public Song2(@Value("${sname}") String name, @Value("${slyrics}")String lyrics) {   
		this.name=name;
		this.lyrics=lyrics;
	}                                
	
	
	                                

	/*public Song2(String name, String lyrics){
		this.name=name;
		this.lyrics=lyrics;
		
	}*/
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}	
}
