package ie.cit.soft8027.thehit.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ie.cit.soft8027.thehit.interfaces.*;

@Component("customBeanName")
public class SongwriterImpl2 extends Person implements Songwriter{
	
	@Autowired //autowiring by type so will look for bean of type Song2 (bean name will not nec. match property name here)
	private Song2 song;
	
	@Autowired
	// public SongwriterImpl2(@Value("Mary") String firstName, @Value("O'Brien") String lastName, @Value("33") int age,  Song2 song) {
	public SongwriterImpl2(@Value("${firstname}") String firstName, @Value("${lastname}") String lastName, @Value("${age}") int age,  Song2 song) {
		super(firstName, lastName, age);
		this.song = song;		
	};
	
	public Song2 getSong() {
		return song;
	}
	public void setSong(Song2 song) {
		this.song = song;
	}
	
	
	public void compose(Song song) {
		System.out.println("Composer " + getFirstName() + " " + getLastName() +
				" composed a song called " +song.getName() +
				". This song has the following lyrics "+ song.getLyrics());
	}

	
	
}
