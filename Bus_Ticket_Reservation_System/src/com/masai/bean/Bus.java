/**
 * 
 */
package com.masai.bean;

/**
 * @author tejas
 *
 */
public class Bus {

	/**
	 * @param args
	 */

	private int bus_No;
	private int passenger_Capacity;
	private int available_Seats;
	private String bus_Type;

	public Bus(int bus_No, int passenger_Capacity, int available_Seats, String bus_Type) {
		super();
		this.bus_No = bus_No;
		this.passenger_Capacity = passenger_Capacity;
		this.available_Seats = available_Seats;
		this.bus_Type = bus_Type;
	}

	@Override
	public String toString() {
		return "Bus [bus_No=" + bus_No + ", passenger_Capacity=" + passenger_Capacity + ", available_Seats="
				+ available_Seats + ", bus_Type=" + bus_Type + "]";
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
	 * @return the passenger_Capacity
	 */
	public int getPassenger_Capacity() {
		return passenger_Capacity;
	}

	/**
	 * @param passenger_Capacity the passenger_Capacity to set
	 */
	public void setPassenger_Capacity(int passenger_Capacity) {
		this.passenger_Capacity = passenger_Capacity;
	}

	/**
	 * @return the available_Seats
	 */
	public int getAvailable_Seats() {
		return available_Seats;
	}

	/**
	 * @param available_Seats the available_Seats to set
	 */
	public void setAvailable_Seats(int available_Seats) {
		this.available_Seats = available_Seats;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
