package ie.cit.soft8027.thehit.domain;

import ie.cit.soft8027.thehit.interfaces.*;


public class SongwriterImpl implements Songwriter{
	
	private String firstName;
	private String lastName;
	private int age;
	private Song song;
	
	public SongwriterImpl() {
	}
	
	public SongwriterImpl(String firstName, String lastName, int age, Song song) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.song = song;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
	
	@Override
	public void compose(Song song) {
		System.out.println("Composer " + firstName + " " + lastName + 
				" composed a song called " +song.getName() +
				". This song has the following lyrics "+ song.getLyrics());
	}

	
	
}
