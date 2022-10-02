/**
 * 
 */
package com.masai.run;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.bean.Bus_Route;
import com.masai.bean.Ticket_Booking;
import com.masai.bean.Ticket_Status;
import com.masai.bean.User;
import com.masai.dao.AdminDao;
import com.masai.dao.UserDao;
import com.masai.daoImplementation.AdminDaoImplementation;
import com.masai.daoImplementation.UserDaoImplementation;
import com.masai.exception.AdminException;
import com.masai.exception.BusException;
import com.masai.exception.Bus_Route_Exception;
import com.masai.exception.TicketException;
import com.masai.exception.UserException;

/**
 * @author tejas
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDao user_dao = new UserDaoImplementation();

		AdminDao admin_dao = new AdminDaoImplementation();

		boolean run = true;

		Scanner scanner = new Scanner(System.in);

		while (run) {

			System.out.println("Welcome To Bus Reservation System");

			System.out.println();

			System.out.println("Please Enter Your Choice");

			System.out.println("");

			System.out.println("1. Admin Login");
			System.out.println("2. User Login");
			System.out.println("3. Register User");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				System.out.println("");

				System.out.println("Admin Login");

				System.out.println("");

				scanner.nextLine();

				System.out.println("Enter Your Username");
				String admin_username = scanner.nextLine();

				System.out.println("Enter Your Password");
				String admin_password = scanner.nextLine();

				try {
					Admin admin = admin_dao.loginAdmin(admin_username, admin_password);

					if (admin != null) {

						Boolean admin_run = true;

						while (admin_run) {

							System.out.println("");

							System.out.println("Welcome to Admin Dashboard");

							System.out.println("");

							System.out.println("Please Enter Your Choice");

							System.out.println("");

							System.out.println("1. Bus");
							System.out.println("2. Bus Route");
							System.out.println("3. View Bus TimeTable");
							System.out.println("4. Manage Reservations ");
							System.out.println("5. Exit Admin Dashboard");
							System.out.println("6. Exit Application");

							int admin_choice = scanner.nextInt();

							switch (admin_choice) {
							case 1:

								Boolean Bus_run = true;

								while (Bus_run) {

									System.out.println("");

									System.out.println("Welcome to Bus Dashboard");

									System.out.println("");

									System.out.println("Please Enter Your Choice");

									System.out.println("");

									System.out.println("1. Add New Bus");
									System.out.println("2. Delete Bus From Timetable");
									System.out.println("3. View All Buses");
									System.out.println("4. Exit Bus Dashboard");
									System.out.println("5. Exit Admin Dashboard");
									System.out.println("6. Exit Application");

									int bus_choice = scanner.nextInt();

									switch (bus_choice) {

									case 1:
										System.out.println("");

										System.out.println("Please Enter Bus Details");

										System.out.println("");

										System.out.println("Please Enter Bus_No :");
										int bus_no = scanner.nextInt();

										System.out.println("Please Enter Bus Passengers Capacity :");
										int passengers_capacity = scanner.nextInt();

										int available_seats = passengers_capacity;

										scanner.nextLine();

										System.out.println("Please Enter Bus_Type :");
										String bus_type = scanner.nextLine();

										Bus bus = new Bus(bus_no, passengers_capacity, available_seats, bus_type);

										String result = admin_dao.create_Bus(bus);

										System.out.println(result);

										System.out.println();

										break;
									case 2:

										System.out.println("");

										System.out.println("Please Enter Bus Details You Wish To Delete");

										System.out.println("");

										System.out.println("Please Enter Bus_No :");
										int delete_bus_no = scanner.nextInt();

										String result_1 = admin_dao.delete_Bus(delete_bus_no);

										System.out.println(result_1);

										System.out.println();

										break;
									case 3:

										System.out.println("");

										System.out.println("Bus Details");

										System.out.println("");

										;

										try {
											List<Bus> list_of_buses = admin_dao.view_All_Bus();

											list_of_buses.forEach(b -> {

												System.out.println("Bus No :" + b.getBus_No());
												System.out.println("Bus Capacity :" + b.getPassenger_Capacity());
												System.out.println("Bus Available Seats :" + b.getAvailable_Seats());
												System.out.println("Bus Type :" + b.getBus_Type());

												System.out.println();
											});
										} catch (BusException e) {

											System.out.println(e.getMessage());
										}

										break;
									case 4:

										Bus_run = false;
										break;
									case 5:
										Bus_run = false;
										admin_run = false;
										break;
									case 6:
										System.out.println("Thank You For Using The Appilcation ! ");
										Bus_run = false;
										admin_run = false;
										run = false;
										break;
									default:
										System.out.println("Please Enter A Valid Choice !");

									}
								}

								break;
							case 2:

								Boolean Route_run = true;

								while (Route_run) {

									System.out.println("");

									System.out.println("Welcome to Route Dashboard");

									System.out.println("");

									System.out.println("Please Enter Your Choice");

									System.out.println("");

									System.out.println("1. Add Bus Route");
									System.out.println("2. Delete Bus Route From Timetable");
									System.out.println("3. View All Routes");
									System.out.println("4. Exit Route Dashboard");
									System.out.println("5. Exit Admin Dashboard");
									System.out.println("6. Exit Application");

									int route_choice = scanner.nextInt();

									switch (route_choice) {

									case 1:
										System.out.println("");

										System.out.println("Please Enter Route Details");

										System.out.println("");

										System.out.println("Please Enter Bus Route No :");
										int route_id = scanner.nextInt();

										System.out.println("Please Enter Bus No :");
										int bus_no = scanner.nextInt();
										scanner.nextLine();

										System.out.println("Please Enter Bus Route Source :");
										String source = scanner.nextLine();

										System.out.println("Please Enter Bus Route Destination :");
										String destination = scanner.nextLine();

										System.out.println("Please Enter Bus Route Distance :");
										int distance = scanner.nextInt();

										System.out.println("Please Enter Bus Route Fare per/Km :");
										int fare_per_KM = scanner.nextInt();
										scanner.nextLine();

										System.out.println("Please Enter Bus Route Date in YYYY-MM-DD Format :");
										String day = scanner.nextLine();

										Date route_day = Date.valueOf(day);

										System.out.println("Please Enter Bus Route Arrival Time in HH:MM:SS Format :");
										String a_time = scanner.nextLine();

										Time arrival_time = Time.valueOf(a_time);

										System.out
												.println("Please Enter Bus Route Departure Time in HH:MM:SS Format :");
										String d_time = scanner.nextLine();

										Time departure_time = Time.valueOf(d_time);

										Bus_Route bus_route = new Bus_Route(route_id, bus_no, source, destination,
												distance, fare_per_KM, route_day, arrival_time, departure_time);

										String result_3 = admin_dao.create_Bus_Route(bus_route);

										System.out.println(result_3);

										System.out.println();

										break;

									case 2:
										System.out.println("");

										System.out.println("Please Enter Route Details You Wish To Delete");

										System.out.println("");

										System.out.println("Please Enter Route_No :");
										int delete_route_no = scanner.nextInt();

										String result_4 = admin_dao.delete_Bus(delete_route_no);

										System.out.println(result_4);

										System.out.println();

										break;
									case 3:
										System.out.println("");

										System.out.println("Bus Timetable");

										System.out.println("");

										try {

											List<Bus_Route> Timetable = admin_dao.bus_Timetable();

											Timetable.forEach(t -> {

												System.out.println("Bus Route No :" + t.getRoute_Id());
												System.out.println("Bus No :" + t.getBus_No());
												System.out.println("Bus Route Source :" + t.getSource());
												System.out.println("Bus Route Destination :" + t.getDestination());
												System.out.println("Bus Route Distance :" + t.getDistance());
												System.out.println("Bus Route Fare per/Km :" + t.getFare_Per_Km());
												System.out.println("Bus Route Date :" + t.getDay());
												System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
												System.out
														.println("Bus Route Departure Time :" + t.getDeparture_Time());

												System.out.println();
											});
										} catch (Bus_Route_Exception e) {

											System.out.println(e.getMessage());
										}

										break;
									case 4:

										Route_run = false;
										break;
									case 5:
										Route_run = false;
										admin_run = false;
										break;
									case 6:
										System.out.println("Thank You For Using The Appilcation ! ");
										Route_run = false;
										admin_run = false;
										run = false;
										break;
									default:
										System.out.println("Please Enter A Valid Choice !");

									}
								}

								break;
							case 3:
								System.out.println("");

								System.out.println("Bus Timetable");

								System.out.println("");

								try {

									List<Bus_Route> Timetable = admin_dao.bus_Timetable();

									Timetable.forEach(t -> {

										System.out.println("Bus Route No :" + t.getRoute_Id());
										System.out.println("Bus No :" + t.getBus_No());
										System.out.println("Bus Route Source :" + t.getSource());
										System.out.println("Bus Route Destination :" + t.getDestination());
										System.out.println("Bus Route Distance :" + t.getDistance());
										System.out.println("Bus Route Fare per/Km :" + t.getFare_Per_Km());
										System.out.println("Bus Route Date :" + t.getDay());
										System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
										System.out.println("Bus Route Departure Time :" + t.getDeparture_Time());

										System.out.println();
									});
								} catch (Bus_Route_Exception e) {

									System.out.println(e.getMessage());
								}

								break;

							case 4:
								boolean reservation_run = true;

								while (reservation_run) {

									System.out.println("");

									System.out.println("Welcome to Reservation Management Dashboard");

									System.out.println("");

									System.out.println("Please Enter Your Choice");

									System.out.println("");

									System.out.println("1. Confirm Reservations");
									System.out.println("2. View Confirmed Reservations");
									System.out.println("3. View Pending Reservations");
									System.out.println("4. Exit Reservations Management Dashboard");
									System.out.println("5. Exit Admin Dashboard");
									System.out.println("6. Exit Application");

									int reservation_choice = scanner.nextInt();

									switch (reservation_choice) {

									case 1:

										System.out.println("");

										System.out.println("Please Enter Booking Number");

										int booking_No = scanner.nextInt();

										String result = admin_dao.confirm_Booking(booking_No);

										System.out.println(result);

										System.out.println();

										break;
									case 2:

										try {
											List<Ticket_Status> list_of_tickets = admin_dao
													.view_Confirmed_Ticket_User_Details();

											list_of_tickets.forEach(t -> {

												System.out.println("Ticket Booking No :" + t.getBooking_No());
												System.out.println("Traveller's User Id :" + t.getUser_Id());
												System.out.println("Traveller's User Name :" + t.getUser_Name());
												System.out.println("Bus Route No :" + t.getRoute_Id());
												System.out.println("Bus No :" + t.getBus_No());
												System.out.println("Bus Type :" + t.getBus_No());
												System.out.println("Bus Route Source :" + t.getRoute_Source());
												System.out
														.println("Bus Route Destination :" + t.getRoute_Destination());
												System.out.println("No. of Tickets :" + t.getNo_of_Tickets());
												System.out.println("Bus Route Total Fare :" + t.getTotal_Fare());
												System.out.println("Travel Date :" + t.getTravel_Date());
												System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
												System.out
														.println("Bus Route Departure Time :" + t.getDeparture_Time());
												System.out.println("Reservation Confirmation Status : Confirmed ");

												System.out.println();
											});

										} catch (TicketException e) {

											System.out.println(e.getMessage());
										}

										break;
									case 3:
										try {
											List<Ticket_Status> list_of_tickets = admin_dao
													.view_Pending_Ticket_User_Details();

											list_of_tickets.forEach(t -> {

												System.out.println("Ticket Booking No :" + t.getBooking_No());
												System.out.println("Traveller's User Id :" + t.getUser_Id());
												System.out.println("Traveller's User Name :" + t.getUser_Name());
												System.out.println("Bus Route No :" + t.getRoute_Id());
												System.out.println("Bus No :" + t.getBus_No());
												System.out.println("Bus Type :" + t.getBus_No());
												System.out.println("Bus Route Source :" + t.getRoute_Source());
												System.out
														.println("Bus Route Destination :" + t.getRoute_Destination());
												System.out.println("No. of Tickets :" + t.getNo_of_Tickets());
												System.out.println("Bus Route Total Fare :" + t.getTotal_Fare());
												System.out.println("Travel Date :" + t.getTravel_Date());
												System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
												System.out
														.println("Bus Route Departure Time :" + t.getDeparture_Time());
												System.out.println("Reservation Confirmation Status : Not Confirmed");

												System.out.println();
											});

										} catch (TicketException e) {

											System.out.println(e.getMessage());
										}

										break;
									case 4:
										reservation_run = false;
										break;
									case 5:
										reservation_run = false;
										admin_run = false;
										break;
									case 6:
										System.out.println("Thank You For Using The Appilcation ! ");
										reservation_run = false;
										admin_run = false;
										run = false;
										break;
									default:
										System.out.println("Please Enter A Valid Choice !");

									}

								}

								break;
							case 5:
								admin_run = false;
								break;
							case 6:
								System.out.println("Thank You For Using The Appilcation ! ");
								admin_run = false;
								run = false;
								break;
							default:
								System.out.println("Please Enter A Valid Choice !");

							}
						}
					}

				} catch (AdminException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:

				System.out.println("");

				System.out.println("User Login");

				System.out.println("");

				scanner.nextLine();

				System.out.println("Enter Your User_Id");
				String user_username = scanner.nextLine();

				System.out.println("Enter Your user_Password");
				String user_password = scanner.nextLine();

				try {
					User user = user_dao.loginUser(user_username, user_password);

					if (user != null) {

						String active_User_Id = user.getUser_Id();

						Boolean user_run = true;

						while (user_run) {

							System.out.println("");

							System.out.println("Welcome to User Dashboard");

							System.out.println("");

							System.out.println("Please Enter Your Choice");

							System.out.println("");

							System.out.println("1. Book Reservation");
							System.out.println("2. Cancel Reservation");
							System.out.println("3. View Bus TimeTable");
							System.out.println("4. Check Reservation Status");
							System.out.println("5. Exit User Dashboard");
							System.out.println("6. Exit Application");

							int user_choice = scanner.nextInt();

							switch (user_choice) {

							case 1:
								System.out.println();

								System.out.println("Please Enter Booking Details From Bus Timetable: ");

								System.out.println();

								System.out.println("Please Enter Route Id : ");
								int route_id = scanner.nextInt();

								System.out.println("Please Enter Bus No : ");
								int bus_no = scanner.nextInt();

								System.out.println("Please Enter No. of Tickets : ");
								int no_of_tickets = scanner.nextInt();
								scanner.nextLine();

								System.out.println("Please Enter Travel Date in YYYY-MM-DD Format : ");
								String t_date = scanner.nextLine();

								Date Travel_date = Date.valueOf(t_date);

								Ticket_Booking Ticket = new Ticket_Booking(active_User_Id, route_id, bus_no,
										no_of_tickets, Travel_date);

								String result;
								try {
									result = user_dao.book_Ticket(Ticket, active_User_Id);

									System.out.println(result);

									System.out.println();
								} catch (TicketException e1) {

									System.out.println(e1.getMessage());
								}

								break;

							case 2:
								System.out.println();

								System.out.println("Please Enter Booking No You Wish to Cancel: ");
								int booking_no = scanner.nextInt();

								String result_5 = user_dao.cancel_Ticket(booking_no);

								System.out.println(result_5);

								System.out.println();

								break;

							case 3:
								System.out.println("");

								System.out.println("Bus Timetable");

								System.out.println("");

								try {

									List<Bus_Route> Timetable = admin_dao.bus_Timetable();

									Timetable.forEach(t -> {

										System.out.println("Bus Route No :" + t.getRoute_Id());
										System.out.println("Bus No :" + t.getBus_No());
										System.out.println("Bus Route Source :" + t.getSource());
										System.out.println("Bus Route Destination :" + t.getDestination());
										System.out.println("Bus Route Distance :" + t.getDistance());
										System.out.println("Bus Route Fare per/Km :" + t.getFare_Per_Km());
										System.out.println("Bus Route Date :" + t.getDay());
										System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
										System.out.println("Bus Route Departure Time :" + t.getDeparture_Time());

										System.out.println();
									});
								} catch (Bus_Route_Exception e) {

									System.out.println(e.getMessage());
								}

								break;

							case 4:
								System.out.println("Ticket Reservation Status ");

								System.out.println();

								try {
									List<Ticket_Status> list_of_tickets = user_dao.show_Ticket_Status(active_User_Id);

									list_of_tickets.forEach(t -> {

										System.out.println("Ticket Booking No :" + t.getBooking_No());
										System.out.println("Traveller's User Id :" + t.getUser_Id());
										System.out.println("Traveller's User Name :" + t.getUser_Name());
										System.out.println("Bus Route No :" + t.getRoute_Id());
										System.out.println("Bus No :" + t.getBus_No());
										System.out.println("Bus Type :" + t.getBus_No());
										System.out.println("Bus Route Source :" + t.getRoute_Source());
										System.out.println("Bus Route Destination :" + t.getRoute_Destination());
										System.out.println("No. of Tickets :" + t.getNo_of_Tickets());
										System.out.println("Bus Route Total Fare :" + t.getTotal_Fare());
										System.out.println("Travel Date :" + t.getTravel_Date());
										System.out.println("Bus Route Arrival Time :" + t.getArrival_Time());
										System.out.println("Bus Route Departure Time :" + t.getDeparture_Time());

										if (t.getStatus() == 1) {
											System.out.println("Reservation Confirmation Status : Confirmed");
										} else {
											System.out.println("Reservation Confirmation Status : Pending");
										}

										System.out.println();
									});

								} catch (TicketException e) {

									e.printStackTrace();

								}
								break;
							case 5:
								user_run = false;
								break;

							case 6:
								user_run = false;
								run = false;
								break;
							}

						}

					}

				} catch (UserException e) {
					System.out.println(e.getMessage());
				}

				break;
				
				case 3:
					System.out.println("");

					System.out.println("Please Enter User Details");

					System.out.println("");
					
					scanner.nextLine();
					
					System.out.println("Please Enter User Name");
					
					String user_name = scanner.nextLine();
					
					System.out.println("Please Enter User Contact");
					
					String user_contact = scanner.nextLine();
					
					System.out.println("Please Enter User Email");
					
					String user_email = scanner.nextLine();
					

					System.out.println("Please Enter User Login Id");
					
					String user_login_id = scanner.nextLine();
					

					System.out.println("Please Enter User Login Password");
					
					String user_login_password = scanner.nextLine();
					
					User user = new User(user_name,user_contact,user_email,user_login_id,user_login_password);
					
					String result = user_dao.registerUser(user);
					
					System.out.println(result);
					
					break;
			case 4:
				System.out.println("Thank You For Using The Appilcation ! ");
				run = false;
				break;
			default:
				System.out.println("Please Enter A Valid Choice !");
			}
		}

	}

}
