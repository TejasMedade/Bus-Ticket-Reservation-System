/**
 * 
 */
package com.masai.bean;

/**
 * @author tejas
 *
 */
public class User {

	/**
	 * @param args
	 */

	private String user_Name;
	private String user_Contact;
	private String user_Email;
	private String user_Id;
	private String user_Password;

	public User(String user_Name, String user_Contact, String user_Email, String user_Id, String user_Password) {
		super();
		this.user_Name = user_Name;
		this.user_Contact = user_Contact;
		this.user_Email = user_Email;
		this.user_Id = user_Id;
		this.user_Password = user_Password;
	}

	@Override
	public String toString() {
		return "User [user_Name=" + user_Name + ", user_Contact=" + user_Contact + ", user_Email=" + user_Email
				+ ", user_Id=" + user_Id + ", user_Password=" + user_Password + "]";
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
	 * @return the user_Contact
	 */
	public String getUser_Contact() {
		return user_Contact;
	}

	/**
	 * @param user_Contact the user_Contact to set
	 */
	public void setUser_Contact(String user_Contact) {
		this.user_Contact = user_Contact;
	}

	/**
	 * @return the user_Email
	 */
	public String getUser_Email() {
		return user_Email;
	}

	/**
	 * @param user_Email the user_Email to set
	 */
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
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
	 * @return the user_Password
	 */
	public String getUser_Password() {
		return user_Password;
	}

	/**
	 * @param user_Password the user_Password to set
	 */
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}

	public static void main(String[] args) {

	}

}
