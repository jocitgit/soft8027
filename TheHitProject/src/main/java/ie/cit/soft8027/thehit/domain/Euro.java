package ie.cit.soft8027.thehit.domain;

import ie.cit.soft8027.thehit.interfaces.*;

public class Euro implements Currency {

	private static final String EUR = "EUR";

	public String getSymbol() {
		return EUR;
	}
}
