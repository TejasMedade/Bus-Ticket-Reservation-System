/**
 * 
 */
package com.masai.bean;

/**
 * @author tejas
 *
 */


public class Admin {

	/**
	 * @param args
	 */
	
	private String admin_id;
	private String admin_password;
	
	public Admin(String admin_id, String admin_password) {
		super();
		this.admin_id = admin_id;
		this.admin_password = admin_password;
	}


	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_password=" + admin_password + "]";
	}


	/**
	 * @return the admin_id
	 */
	public String getAdmin_id() {
		return admin_id;
	}


	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	/**
	 * @return the admin_password
	 */
	public String getAdmin_password() {
		return admin_password;
	}


	/**
	 * @param admin_password the admin_password to set
	 */
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
