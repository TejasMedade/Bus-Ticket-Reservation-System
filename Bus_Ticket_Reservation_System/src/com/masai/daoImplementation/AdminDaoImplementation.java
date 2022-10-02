package com.masai.daoImplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Bus_Route;
import com.masai.bean.Ticket_Status;
import com.masai.bean.User;
import com.masai.dao.AdminDao;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Bus_Route_Exception;
import com.masai.exception.TicketException;
import com.masai.exception.UserException;
import com.masai.utility.DatabaseUtility;

public class AdminDaoImplementation implements AdminDao {

	@Override
	public Admin loginAdmin(String admin_Id, String admin_password) throws AdminException {

		Admin admin = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM admin WHERE admin_Id = ? AND admin_Password = ?");

			statement.setString(1, admin_Id);
			statement.setString(2, admin_password);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				String id = result.getString("admin_id");
				String password = result.getString("admin_password");

				admin = new Admin(id, password);
			} else {
				throw new AdminException("Invalid Admin Id & Password");
			}

		} catch (SQLException e) {

			throw new AdminException(e.getMessage());

		}

		return admin;
	}

	@Override
	public String create_Bus(Bus bus) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO BUS VALUES(?,?,?,?)");

			statement.setInt(1, bus.getBus_No());
			statement.setInt(2, bus.getPassenger_Capacity());
			statement.setInt(3, bus.getAvailable_Seats());
			statement.setString(4, bus.getBus_Type());

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Bus Registered Sucessfully !";
			}

		} catch (SQLException e) {
			result = e.getMessage();
		}

		return result;
	}

	@Override
	public String delete_Bus(int bus_no) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("DROP FROM BUS WHERE BUS_NO = ?");

			statement.setInt(1, bus_no);

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Bus Deleted Sucessfully !";
			}

		} catch (SQLException e) {

			result = e.getMessage();
		}

		return result;
	}
	
	
	@Override
	public List<Bus> view_All_Bus() throws BusException  {

		List<Bus> list_of_Buses = new ArrayList<Bus>();

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM BUS");

			

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				int Bus_No = result.getInt("Bus_No");
				int Passenger_Capacity = result.getInt("Passenger_Capacity");
				int Available_Seats = result.getInt("Available_Seats");
				String Bus_Type = result.getString("Bus_Type");
				
				Bus bus = new Bus (Bus_No,Passenger_Capacity,Available_Seats,Bus_Type);
				
				list_of_Buses.add(bus);
			}

		} catch (SQLException e) {

			throw new BusException(e.getMessage());
		}
		
		if (list_of_Buses.size() == 0) {
			throw new BusException("No Ticket Reservations found");
		}

		return list_of_Buses;
	}

	@Override
	public String create_Bus_Route(Bus_Route bus_route) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO ROUTE VALUES(?,?,?,?,?,?,?,?,?)");

			statement.setInt(1, bus_route.getRoute_Id());
			statement.setInt(2, bus_route.getBus_No());
			statement.setString(3, bus_route.getSource());
			statement.setString(4, bus_route.getSource());
			statement.setInt(5, bus_route.getDistance());
			statement.setInt(6, bus_route.getFare_Per_Km());
			statement.setDate(7, bus_route.getDay());
			statement.setTime(8, bus_route.getArrival_Time());
			statement.setTime(9, bus_route.getDeparture_Time());

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Bus Route Created Sucessfully !";
			}

		} catch (SQLException e) {
			result = e.getMessage();
		}

		return result;

	}

	@Override
	public String delete_Route(int route_id) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("DROP FROM ROUTE WHERE ROUTE_ID = ?");

			statement.setInt(1, route_id);

			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Route Deleted Sucessfully !";
			}

		} catch (SQLException e) {

			result = e.getMessage();
		}

		return result;

	}

	@Override
	public String confirm_Booking(int booking_No) {

		String result = null;

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection
					.prepareStatement("UPDATE BOOKING SET STATUS = 1 WHERE STATUS = 0 AND BOOKING_NO = ?;");

			statement.setInt(1, booking_No);

			int response = statement.executeUpdate();

			if (response > 0) {

				PreparedStatement statement_1 = connection
						.prepareStatement("SELECT * FROM BOOKING WHERE BOOKING_NO = ?;");

				statement_1.setInt(1, booking_No);

				ResultSet result1 = statement_1.executeQuery();

				if (result1.next()) {

					int no_of_Tickets = result1.getInt("No_of_Tickets");

					int bus_no = result1.getInt("Bus_No");

					PreparedStatement statement_2 = connection
							.prepareStatement("SELECT AVAILABLE_SEATS FROM BUS WHERE BUS_NO = ?;");

					statement_2.setInt(1, bus_no);

					ResultSet result2 = statement_2.executeQuery();

					if (result2.next()) {

						int available_Seats = result2.getInt("Available_Seats");

						int new_available_Seats = available_Seats - no_of_Tickets;

						PreparedStatement statement_3 = connection
								.prepareStatement("UPDATE BUS SET AVAILABLE_SEATS = ? WHERE BUS_NO = ?;");

						statement_3.setInt(1, new_available_Seats);
						statement_3.setInt(2, bus_no);

						int result3 = statement_3.executeUpdate();

						if (result3 > 0) {
							result = "Booking Confirmed Sucessfully !";
						}
					}

				}
				else {
					result = "Booking Already Confirmed Or Does Not Exist !";
				}

			}

		} catch (SQLException e) {

			result = e.getMessage();
		}

		return result;

	}

	@Override
	public List<Ticket_Status> view_Confirmed_Ticket_User_Details() throws TicketException {

		List<Ticket_Status> list_of_tickets = new ArrayList<Ticket_Status>();

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement(

					"SELECT BOOKING.BOOKING_NO, BOOKING.USER_ID, U.USER_NAME,BOOKING.BUS_NO, BUS.BUS_TYPE, ROUTE.ROUTE_ID, ROUTE.SOURCE,ROUTE.DESTINATION, BOOKING.NO_OF_TICKETS, ROUTE.DISTANCE*ROUTE.FARE_PER_KMS*BOOKING.NO_OF_TICKETS TOTAL_FARE,ROUTE.ARRIVAL_TIME, ROUTE.DEPARTURE_TIME, ROUTE.DAY, BOOKING.STATUS FROM BOOKING BOOKING INNER JOIN ROUTE ROUTE INNER JOIN BUS BUS  INNER JOIN USER U ON BOOKING.BUS_NO = ROUTE.BUS_NO AND BUS.BUS_NO = ROUTE.BUS_NO AND BOOKING.TRAVEL_DATE = ROUTE.DAY AND U.USER_ID = BOOKING.USER_ID AND BOOKING.STATUS = 1");

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
	public List<Ticket_Status> view_Pending_Ticket_User_Details() throws TicketException {
		List<Ticket_Status> list_of_tickets = new ArrayList<Ticket_Status>();

		try (Connection connection = DatabaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement(

					"SELECT BOOKING.BOOKING_NO, BOOKING.USER_ID, U.USER_NAME,BOOKING.BUS_NO, BUS.BUS_TYPE, ROUTE.ROUTE_ID, ROUTE.SOURCE,ROUTE.DESTINATION, BOOKING.NO_OF_TICKETS, ROUTE.DISTANCE*ROUTE.FARE_PER_KMS*BOOKING.NO_OF_TICKETS TOTAL_FARE,ROUTE.ARRIVAL_TIME, ROUTE.DEPARTURE_TIME, ROUTE.DAY, BOOKING.STATUS FROM BOOKING BOOKING INNER JOIN ROUTE ROUTE INNER JOIN BUS BUS  INNER JOIN USER U ON BOOKING.BUS_NO = ROUTE.BUS_NO AND BUS.BUS_NO = ROUTE.BUS_NO AND BOOKING.TRAVEL_DATE = ROUTE.DAY AND U.USER_ID = BOOKING.USER_ID AND BOOKING.STATUS = 0");

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
}
