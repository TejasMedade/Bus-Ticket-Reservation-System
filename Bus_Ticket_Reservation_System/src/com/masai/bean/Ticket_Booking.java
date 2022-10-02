/**
 * 
 */
package com.masai.bean;

import java.sql.Date;

/**
 * @author tejas
 *
 */
public class Ticket_Booking {

	/**
	 * @param args
	 */

	private int booking_No;
	private String user_Id;
	private int route_Id;
	private int bus_no;
	private int no_of_Tickets;
	private int status;
	private Date Travel_Date;

	@Override
	public String toString() {
		return "Ticket_Booking [booking_no=" + booking_No + ", user_Id=" + user_Id + ", route_Id=" + route_Id
				+ ", bus_no=" + bus_no + ", no_of_Tickets=" + no_of_Tickets + ", status=" + status + ", Travel_Date="
				+ Travel_Date + "]";
	}

	/**
	 * @param booking_no
	 * @param user_Id
	 * @param route_Id
	 * @param bus_no
	 * @param no_of_Tickets
	 * @param status
	 * @param travel_Date
	 */
	public Ticket_Booking(int booking_no, String user_Id, int route_Id, int bus_no, int no_of_Tickets, int status,
			Date travel_Date) {
		super();
		this.booking_No = booking_no;
		this.user_Id = user_Id;
		this.route_Id = route_Id;
		this.bus_no = bus_no;
		this.no_of_Tickets = no_of_Tickets;
		this.status = status;
		this.Travel_Date = travel_Date;
	}

	/**
	 * @param user_Id
	 * @param route_Id
	 * @param bus_no
	 * @param no_of_Tickets
	 * @param travel_Date
	 */
	public Ticket_Booking(String user_Id, int route_Id, int bus_no, int no_of_Tickets, Date travel_Date) {
		super();
		this.user_Id = user_Id;
		this.route_Id = route_Id;
		this.bus_no = bus_no;
		this.no_of_Tickets = no_of_Tickets;
		this.Travel_Date = travel_Date;
	}

	/**
	 * @return the booking_no
	 */
	public int getBooking_no() {
		return booking_No;
	}

	/**
	 * @param booking_no the booking_no to set
	 */
	public void setBooking_no(int booking_no) {
		this.booking_No = booking_no;
	}

	/**
	 * @return the user_Id
	 */
	public String getUser_Id() {
		return user_Id;
	}

	/**
	 * @param user_Id the user_Id to set
	 */
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	/**
	 * @return the bus_no
	 */
	public int getBus_no() {
		return bus_no;
	}

	/**
	 * @param bus_no the bus_no to set
	 */
	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	/**
	 * @return the no_of_Tickets
	 */
	public int getNo_of_Tickets() {
		return no_of_Tickets;
	}

	/**
	 * @param no_of_Tickets the no_of_Tickets to set
	 */
	public void setNo_of_Tickets(int no_of_Tickets) {
		this.no_of_Tickets = no_of_Tickets;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the travel_Date
	 */
	public Date getTravel_Date() {
		return Travel_Date;
	}

	/**
	 * @param travel_Date the travel_Date to set
	 */
	public void setTravel_Date(Date travel_Date) {
		Travel_Date = travel_Date;
	}

	/**
	 * @return the route_Id
	 */
	public int getRoute_Id() {
		return route_Id;
	}

	/**
	 * @param route_Id the route_Id to set
	 */
	public void setRoute_Id(int route_Id) {
		this.route_Id = route_Id;
	}

	public static void main(String[] args) {

	}

}
