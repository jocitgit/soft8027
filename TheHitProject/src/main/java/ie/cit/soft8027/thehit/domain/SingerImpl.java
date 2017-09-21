package ie.cit.soft8027.thehit.domain;

import ie.cit.soft8027.thehit.interfaces.*;

public class SingerImpl extends Person implements Singer{

	private Song song;
	
	public SingerImpl() {
		super();
	}
	
	public SingerImpl(String firstName, String lastName, int age, Song song) {
		super(firstName, lastName, age);
		this.song = song;
		
	}
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
	public void perform(Song song) {
		//todo
		
	}

	
	
	
	
}
