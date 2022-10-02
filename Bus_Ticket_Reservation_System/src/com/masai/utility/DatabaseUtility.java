/**
 * 
 */
package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tejas
 *
 */
public class DatabaseUtility {

	/**
	 * @param args
	 */

	public static Connection provideConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/bus_reservation_system";

		try {
			connection = DriverManager.getConnection(url, "root", "Tejas@1998");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;

	}

	public static void main(String[] args) {

	}

}
