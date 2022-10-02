/**
 * 
 */
package com.masai.bean;

import java.sql.Date;
import java.sql.Time;

/**
 * @author tejas
 *
 */
public class Ticket_Status {

	private int booking_No;
	private String user_Id;
	private String user_Name;
	private int route_Id;
	private int bus_No;
	private String bus_Type;
	private String route_Source;
	private String route_Destination;
	private int no_of_Tickets;
	private int total_Fare;
	private Date travel_Date;
	private Time arrival_Time;
	private Time departure_Time;
	private int status;

	/**
	 * @param booking_No
	 * @param user_Id
	 * @param user_Name
	 * @param route_Id
	 * @param bus_No
	 * @param bus_Type
	 * @param route_Source
	 * @param route_Destination
	 * @param no_of_Tickets
	 * @param total_Fare
	 * @param travel_Date
	 * @param arrival_Time
	 * @param departure_Time
	 * @param status
	 */
	public Ticket_Status(int booking_No, String user_Id, String user_Name, int route_Id, int bus_No, String bus_Type,
			String route_Source, String route_Destination, int no_of_Tickets, int total_Fare, Date travel_Date,
			Time arrival_Time, Time departure_Time, int status) {
		super();
		this.booking_No = booking_No;
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.route_Id = route_Id;
		this.bus_No = bus_No;
		this.bus_Type = bus_Type;
		this.route_Source = route_Source;
		this.route_Destination = route_Destination;
		this.no_of_Tickets = no_of_Tickets;
		this.total_Fare = total_Fare;
		this.travel_Date = travel_Date;
		this.arrival_Time = arrival_Time;
		this.departure_Time = departure_Time;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket_Status [booking_No=" + booking_No + ", user_Id=" + user_Id + ", user_Name=" + user_Name
				+ ", route_Id=" + route_Id + ", bus_No=" + bus_No + ", bus_Type=" + bus_Type + ", route_Source="
				+ route_Source + ", route_Destination=" + route_Destination + ", no_of_Tickets=" + no_of_Tickets
				+ ", total_Fare=" + total_Fare + ", travel_Date=" + travel_Date + ", arrival_Time=" + arrival_Time
				+ ", departure_Time=" + departure_Time + ", status=" + status + "]";
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
	 * @return the user_Name
	 */
	public String getUser_Name() {
		return user_Name;
	}

	/**
	 * @param user_Name the user_Name to set
	 */
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
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

	/**
	 * @return the route_Source
	 */
	public String getRoute_Source() {
		return route_Source;
	}

	/**
	 * @param route_Source the route_Source to set
	 */
	public void setRoute_Source(String route_Source) {
		this.route_Source = route_Source;
	}

	/**
	 * @return the total_Fare
	 */
	public int getTotal_Fare() {
		return total_Fare;
	}

	/**
	 * @param total_Fare the total_Fare to set
	 */
	public void setTotal_Fare(int total_Fare) {
		this.total_Fare = total_Fare;
	}

	/**
	 * @return the travel_Date
	 */
	public Date getTravel_Date() {
		return travel_Date;
	}

	/**
	 * @param travel_Date the travel_Date to set
	 */
	public void setTravel_Date(Date travel_Date) {
		this.travel_Date = travel_Date;
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
	 * @return the booking_No
	 */
	public int getBooking_No() {
		return booking_No;
	}

	/**
	 * @param booking_No the booking_No to set
	 */
	public void setBooking_No(int booking_No) {
		this.booking_No = booking_No;
	}

	/**
	 * @return the bus_No
	 */
	public int getBus_No() {
		return bus_No;
	}

	/**
	 * @param bus_No the bus_No to set
	 */
	public void setBus_No(int bus_No) {
		this.bus_No = bus_No;
	}

	/**
	 * @return the bus_Type
	 */
	public String getBus_Type() {
		return bus_Type;
	}

	/**
	 * @param bus_Type the bus_Type to set
	 */
	public void setBus_Type(String bus_Type) {
		this.bus_Type = bus_Type;
	}

	/**
	 * @return the route_Destination
	 */
	public String getRoute_Destination() {
		return route_Destination;
	}

	/**
	 * @param route_Destination the route_Destination to set
	 */
	public void setRoute_Destination(String route_Destination) {
		this.route_Destination = route_Destination;
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
	 * @return the arrival_Time
	 */
	public Time getArrival_Time() {
		return arrival_Time;
	}

	/**
	 * @param arrival_Time the arrival_Time to set
	 */
	public void setArrival_Time(Time arrival_Time) {
		this.arrival_Time = arrival_Time;
	}

	/**
	 * @return the departure_Time
	 */
	public Time getDeparture_Time() {
		return departure_Time;
	}

	/**
	 * @param departure_Time the departure_Time to set
	 */
	public void setDeparture_Time(Time departure_Time) {
		this.departure_Time = departure_Time;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
