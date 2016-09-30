package banana_admin.domain;

public class Ticket {

	private int ticketNumber;
	private String ticketName;
	private int price;
	private int expirationDate;
	private String ticketComment;
	
	public Ticket(String ticketName, int price, int expirationDate, String ticketComment) {
		this.ticketName = ticketName;
		this.price = price;
		this.expirationDate = expirationDate;
		this.ticketComment = ticketComment;
	}

	public Ticket(int ticketNumber, String ticketName, int price, int expirationDate, String ticketComment) {
		this.ticketNumber = ticketNumber;
		this.ticketName = ticketName;
		this.price = price;
		this.expirationDate = expirationDate;
		this.ticketComment = ticketComment;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getTicketComment() {
		return ticketComment;
	}

	public void setTicketComment(String ticketComment) {
		this.ticketComment = ticketComment;
	}

}