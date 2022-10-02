/**
 * 
 */
package com.masai.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Bus_Route;
import com.masai.bean.Ticket_Status;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Bus_Route_Exception;
import com.masai.exception.TicketException;

/**
 * @author tejas
 *
 */
public interface AdminDao {

	public Admin loginAdmin(String admin_Id, String admin_password) throws AdminException;

	public String create_Bus(Bus bus);

	public String delete_Bus(int bus_no);

	public String create_Bus_Route(Bus_Route bus_route);

	public String delete_Route(int route_id);

	public String confirm_Booking(int booking_No);
	
	public List<Bus> view_All_Bus() throws BusException;
	
	public List<Bus_Route> bus_Timetable() throws Bus_Route_Exception;

	public List<Ticket_Status> view_Confirmed_Ticket_User_Details() throws TicketException;

	public List<Ticket_Status> view_Pending_Ticket_User_Details() throws TicketException;
}
