package ie.cit.soft8027.thehit.domain;

import ie.cit.soft8027.thehit.interfaces.Currency;

public class Pounds implements Currency {

	private static final String GBP = "GBP";

	public String getSymbol() {
		return GBP;
	}
}

