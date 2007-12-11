package ch.bfh.euro08.util;

import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;

public class UserListing {
	private String firstname;
	private String lastname;
	private String email;
	private boolean superuser;
	
	
	public UserListing(String firstname, String lastname, String email,
			boolean superuser) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.superuser = superuser;
		
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSuperuser() {
		return superuser;
	}

	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}

}
