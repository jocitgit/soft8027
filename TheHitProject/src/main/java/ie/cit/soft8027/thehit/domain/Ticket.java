package ie.cit.soft8027.thehit.domain;

public class Ticket {
	private String ticketClass;
	private int ticketNumber;
	
	public Ticket(String ticketClass, int ticketNumber){
		this.ticketClass=ticketClass;
		this.ticketNumber=ticketNumber;		
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
}
