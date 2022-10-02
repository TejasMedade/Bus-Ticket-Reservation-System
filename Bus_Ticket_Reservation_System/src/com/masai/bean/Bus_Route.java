/**
 * 
 */
package com.masai.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author tejas
 *
 */
public class Bus_Route {

	/**
	 * @param args
	 */

	private int route_Id;
	private int bus_No;
	private String source;
	private String destination;
	private int distance;
	private int fare_Per_Km;
	private Date day;
	private Time arrival_Time;
	private Time departure_Time;

	/**
	 * @param route_Id
	 * @param bus_No
	 * @param source
	 * @param destination
	 * @param distance
	 * @param fare_Per_Km
	 * @param day
	 * @param arrival_Time
	 * @param departure_Time
	 */
	public Bus_Route(int route_Id, int bus_No, String source, String destination, int distance, int fare_Per_Km,
			Date day, Time arrival_Time, Time departure_Time) {
		super();
		this.route_Id = route_Id;
		this.bus_No = bus_No;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.fare_Per_Km = fare_Per_Km;
		this.day = day;
		this.arrival_Time = arrival_Time;
		this.departure_Time = departure_Time;
	}

	@Override
	public String toString() {
		return "Bus_Route [route_Id=" + route_Id + ", bus_No=" + bus_No + ", source=" + source + ", destination="
				+ destination + ", distance=" + distance + ", fare_Per_Km=" + fare_Per_Km + ", day=" + day
				+ ", arrival_Time=" + arrival_Time + ", departure_Time=" + departure_Time + "]";
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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * @return the fare_Per_Km
	 */
	public int getFare_Per_Km() {
		return fare_Per_Km;
	}

	/**
	 * @param fare_Per_Km the fare_Per_Km to set
	 */
	public void setFare_Per_Km(int fare_Per_Km) {
		this.fare_Per_Km = fare_Per_Km;
	}

	/**
	 * @return the day
	 */
	public Date getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(Date day) {
		this.day = day;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
