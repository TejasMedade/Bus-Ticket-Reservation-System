/**
 * 
 */
package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.bean.Bus_Route;
import com.masai.bean.Ticket_Booking;
import com.masai.bean.Ticket_Status;
import com.masai.bean.User;
import com.masai.exception.Bus_Route_Exception;
import com.masai.exception.TicketException;
import com.masai.exception.UserException;

/**
 * @author tejas
 *
 */
public interface UserDao {

	public User loginUser(String user_Id, String user_password) throws UserException;

	public String registerUser(User user);

	public String book_Ticket(Ticket_Booking Ticket, String active_User_Name)throws TicketException;

	public String cancel_Ticket(int booking_no);

	public List<Ticket_Status> show_Ticket_Status(String active_User_Id) throws TicketException;

	public List<Bus_Route> bus_Timetable() throws Bus_Route_Exception;

}
