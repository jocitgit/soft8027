package ie.cit.soft8027.thehit.domain;

public class Ticket {
	private String ticketClass;
	private int ticketNumber;
	private double ticketPrice;
	
	
	public Ticket(String ticketClass, int ticketNumber){
		this.ticketClass=ticketClass;
		this.ticketNumber=ticketNumber;		
	}
	
	public Ticket(String ticketClass, int ticketNumber, double ticketPrice){
		this.ticketClass=ticketClass;
		this.ticketNumber=ticketNumber;	
		this.ticketPrice = ticketPrice;
	}

	public String getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}	
	
	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Ticket [ticketClass=" + ticketClass + ", ticketNumber=" + ticketNumber + ", ticketPrice=" + ticketPrice
				+ "]";
	}
	
	

}
