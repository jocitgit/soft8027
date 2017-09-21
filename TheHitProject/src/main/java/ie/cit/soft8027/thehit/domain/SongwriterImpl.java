package ie.cit.soft8027.thehit.domain;

import ie.cit.soft8027.thehit.interfaces.*;


public class SongwriterImpl extends Person implements Songwriter{
	
	private Song song;
	
	public SongwriterImpl() {
		super();
	}
	
	public SongwriterImpl(String firstName, String lastName, int age, Song song) {
		super(firstName, lastName, age);
		this.song = song;
		
	}
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
	
	public void compose(Song song) {
		System.out.println("Composer " + getFirstName() + " " + getLastName() +
				" composed a song called " +song.getName() +
				". This song has the following lyrics "+ song.getLyrics());
	}

	
	
}
