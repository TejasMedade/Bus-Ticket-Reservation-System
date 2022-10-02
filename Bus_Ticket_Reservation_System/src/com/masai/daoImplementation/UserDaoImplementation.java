/**
 * 
 */
package com.masai.daoImplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Bus_Route;
import com.masai.bean.Ticket_Booking;
import com.masai.bean.Ticket_Status;
import com.masai.bean.User;
import com.masai.dao.UserDao;
import com.masai.exception.Bus_Route_Exception;
import com.masai.exception.TicketException;
import com.masai.exception.UserException;
import com.masai.utility.DatabaseUtility;

/**
 * @author tejas
 *
 */
public class UserDaoImplementation implements UserDao {

	public User loginUser(String user_Id, String user_Password) throws UserException {

		User user = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM user WHERE user_Id = ? AND user_Password = ?");

			statement.setString(1, user_Id);
			statement.setString(2, user_Password);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				String user_Name = result.getString("user_name");
				String user_Contact = result.getString("user_contact");
				String user_Email = result.getString("user_email");
				String user_id = result.getString("user_id");
				String user_password = result.getString("user_password");

				user = new User(user_Name, user_Contact, user_Email, user_id, user_password);
			} else {
				throw new UserException("Invalid User Id & Password");
			}

		} catch (SQLException e) {

			throw new UserException(e.getMessage());

		}

		return user;
	}

	@Override
	public String book_Ticket(Ticket_Booking Ticket, String active_User_Id) throws TicketException {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement_1 = connection
					.prepareStatement("SELECT * FROM BUS WHERE BUS_NO = ?");

			statement_1.setInt(1, Ticket.getBus_no());

			ResultSet response_1 = statement_1.executeQuery();

			if(response_1.next()) {
				
				int Passenger_Capacity = response_1.getInt("Passenger_Capacity");
				
				int available_Seats = response_1.getInt("Available_Seats");
				
				int difference = Passenger_Capacity - available_Seats;
				
				if(difference >= Ticket.getNo_of_Tickets()) {
					
					PreparedStatement statement = connection.prepareStatement(
							"INSERT INTO BOOKING(User_id,Route_id,Bus_no,No_of_Tickets,Travel_Date) VALUES (?,?,?,?,?)");

					statement.setString(1, active_User_Id);
					statement.setInt(2, Ticket.getRoute_Id());
					statement.setInt(3, Ticket.getBus_no());
					statement.setInt(4, Ticket.getNo_of_Tickets());
					statement.setDate(5, Ticket.getTravel_Date());

					int response = statement.executeUpdate();

					if (response > 0) {
						result = "Ticket Reservation Sucessfull ! Please Wait & Check For Your Ticket Confirmation !";
					}
					
				}
				else {
					throw new TicketException("Reservation Failed ! Number of Availabe Seats in the Bus are " +  available_Seats);
				}
			}
			


		} catch (SQLException e) {

			result = e.getMessage();
		}

		return result;
	}

	@Override
	public String cancel_Ticket(int booking_no) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("DELETE FROM BOOKING WHERE BOOKING_NO = ?");

			statement.setInt(1, booking_no);

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Ticket Reservation Cancelled Sucessfully !";
			}

		} catch (SQLException e) {

			result = e.getMessage();
		}

		return result;

	}

	@Override
	public List<Ticket_Status> show_Ticket_Status(String active_User_Id) throws TicketException {

		List<Ticket_Status> list_of_tickets = new ArrayList<Ticket_Status>();

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement(

					"SELECT BOOKING.BOOKING_NO, BOOKING.USER_ID, U.USER_NAME,BOOKING.BUS_NO, BUS.BUS_TYPE, ROUTE.ROUTE_ID, ROUTE.SOURCE,ROUTE.DESTINATION, BOOKING.NO_OF_TICKETS, ROUTE.DISTANCE*ROUTE.FARE_PER_KMS*BOOKING.NO_OF_TICKETS TOTAL_FARE,ROUTE.ARRIVAL_TIME, ROUTE.DEPARTURE_TIME, ROUTE.DAY, BOOKING.STATUS FROM BOOKING BOOKING INNER JOIN ROUTE ROUTE INNER JOIN BUS BUS  INNER JOIN USER U ON BOOKING.BUS_NO = ROUTE.BUS_NO AND BUS.BUS_NO = ROUTE.BUS_NO AND BOOKING.TRAVEL_DATE = ROUTE.DAY AND U.USER_ID = BOOKING.USER_ID AND BOOKING.USER_ID = ?");

			statement.setString(1, active_User_Id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				int booking_No = result.getInt("booking_no");

				String user_Id = result.getString("user_id");

				String user_Name = result.getString("user_name");

				int route_Id = result.getInt("route_id");

				int bus_No = result.getInt("bus_no");

				String bus_Type = result.getString("bus_type");

				String route_Source = result.getString("source");

				String route_Destination = result.getString("destination");

				int no_of_Tickets = result.getInt("no_of_tickets");

				int total_Fare = result.getInt("total_fare");

				Date travel_Date = result.getDate("Day");

				Time arrival_Time = result.getTime("arrival_Time");

				Time departure_Time = result.getTime("departure_Time");

				int status = result.getInt("status");

				Ticket_Status ticket_Status = new Ticket_Status(booking_No, user_Id, user_Name, route_Id, bus_No,
						bus_Type, route_Source, route_Destination, no_of_Tickets, total_Fare, travel_Date, arrival_Time,
						departure_Time, status);

				list_of_tickets.add(ticket_Status);
			}

		} catch (SQLException e) {
			throw new TicketException(e.getMessage());
		}

		if (list_of_tickets.size() == 0) {
			throw new TicketException("No Ticket Reservations found");
		}

		return list_of_tickets;
	}

	@Override
	public List<Bus_Route> bus_Timetable() throws Bus_Route_Exception {

		List<Bus_Route> list_of_routes = new ArrayList<Bus_Route>();

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ROUTE ORDER BY DAY,ARRIVAL_TIME");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				int route_Id = result.getInt("route_id");

				int bus_No = result.getInt("bus_no");

				String route_Source = result.getString("source");

				String route_Destination = result.getString("destination");

				int distance = result.getInt("Distance");

				int fare_per_kms = result.getInt("fare_per_kms");

				Date Day = result.getDate("Day");

				Time arrival_Time = result.getTime("arrival_Time");

				Time departure_Time = result.getTime("departure_Time");

				Bus_Route route = new Bus_Route(route_Id, bus_No, route_Source, route_Destination, distance,
						fare_per_kms, Day, arrival_Time, departure_Time);

				list_of_routes.add(route);
			}

		} catch (SQLException e) {

			throw new Bus_Route_Exception(e.getMessage());
		}

		if (list_of_routes.size() == 0) {

			throw new Bus_Route_Exception("No Bus Found in The Database");
		}

		return list_of_routes;
	}

	@Override
	public String registerUser(User user) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?)");

			statement.setString(1, user.getUser_Name());
			statement.setString(2, user.getUser_Contact());
			statement.setString(3, user.getUser_Email());
			statement.setString(4, user.getUser_Id());
			statement.setString(5, user.getUser_Password());

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "User Registered Sucessfully !";
			}

		} catch (SQLException e) {
			result = e.getMessage();
		}

		return result;

	}

	public static void main(String[] args) {

		String active_User_Name = null;

		String active_User_Id = null;

		UserDao user_dao = new UserDaoImplementation();
		
		
		
		

		try {
			User user = user_dao.loginUser("T@123", "1610");

			active_User_Name = user.getUser_Name();

			active_User_Id = user.getUser_Id();

		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		

	}

}
