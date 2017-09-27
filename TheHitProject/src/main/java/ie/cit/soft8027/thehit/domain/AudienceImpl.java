package ie.cit.soft8027.thehit.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ie.cit.soft8027.thehit.interfaces.Audience;

public class AudienceImpl extends Person implements Audience {

	//set first
	@Autowired
	@Qualifier("premiumTicketPrototype")
	private Ticket ticket;
	
	public AudienceImpl() {
		super();
	}
	
	
	public AudienceImpl(String firstName, String lastName, int age) {
		
		super(firstName, lastName, age);
		
		
	}
	
	public AudienceImpl(String firstName, String lastName, int age, Ticket ticket) {
		
		super(firstName, lastName, age);
		
		this.ticket = ticket;
		
	}
	
	

	public Ticket getTicket() {
		return ticket;
	}


	//set third
	@Autowired
	@Qualifier("budgetTicketPrototype")
	public void setTicket(Ticket ticket) {
		System.out.println("In setTicket");
		this.ticket = ticket;
	}
	
	

	@Override
	public String toString() {
		return "AudienceImpl [ticket=" + ticket + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAge()=" + getAge() + "]";
	}

	//set second
	@Autowired
	@Qualifier("premiumTicketPrototype")
	public void purchaseTicket(Ticket ticket) {
		System.out.println("In purchaseTicket");
		System.out.println("Purchasing ticket: " + ticket);
		this.ticket = ticket;
	}

	public void refundTicket() {
		System.out.println("Refunding ticket: " + this.ticket);
		this.ticket = null;
		
		
	}

	
	
}
