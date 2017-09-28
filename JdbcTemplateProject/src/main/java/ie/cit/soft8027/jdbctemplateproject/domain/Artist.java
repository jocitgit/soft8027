package ie.cit.soft8027.jdbctemplateproject.domain;

import java.util.Collections;
import java.util.List;

public class Artist {
	
	private int id;
	private String name;
	private String gender;
	private List<Movement> movements;
	
	public Artist() {
		// Prevents null pointer exception if there are no movements
		movements = Collections.<Movement>emptyList();
	}

	@Override
	public String toString() {
		String out = "Artist [id=" + id + ", name=" + name +
				", gender="	+ gender + ", movements=["; 
		for (Movement m : movements) {
			out += m.toString() + ", ";
		}
		out += "]]";
		return out;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	
	
	

}
