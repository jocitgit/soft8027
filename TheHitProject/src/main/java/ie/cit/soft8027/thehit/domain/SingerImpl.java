package ie.cit.soft8027.thehit.domain;

import org.springframework.beans.factory.annotation.*;

import ie.cit.soft8027.thehit.interfaces.*;

public class SingerImpl extends Person implements Singer{

	private Song song;
	
	@Autowired
	@Qualifier("someSong")
	private Song song2;
	
	
	public SingerImpl() {
		super();
	}
	
	//@Autowired - constructor can be autowired, but 
	//should avoid autowiring with overloaded constructors, leads to ambiguity and wrong constructor being called
	public SingerImpl(String firstName, String lastName, int age, Song song) {
		super(firstName, lastName, age);
		this.song = song;
		
	}
	
	public Song getSong() {
		return song;
	}
	
	
	@Autowired
	@Qualifier("someSong")
	public void setSong(Song song) {
		this.song = song;
	}
	
	public Song getSong2() {
		return song2;
	}
	
	
	@Autowired
	@Qualifier("anotherSong")
	public void setSong2(Song song2) {
		this.song2 = song2;
	}
	
	
	public void perform(Song song) {
		//todo
		
	}

	
	
	
	
}
