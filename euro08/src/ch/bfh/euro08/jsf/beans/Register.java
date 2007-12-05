package ch.bfh.euro08.jsf.beans;


import java.util.Date;

import javax.faces.context.*;
import javax.faces.application.*;

import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.JSFUtil;
import ch.bfh.euro08.util.UserUtil;


public class Register {

	private String firstname;
	private String lastname;
	private String password;
	private String passwordConfirm;
	private String email;
	private String emailConfirm;
	
	private final static String AUTH_USER = "Authorized_User";

	public Register() {

	}

	public String register() {

		String toReturn = "failure";

		if (validateData()) {

			User newUser = new User();
			  
			newUser.setFirstname(firstname);
			newUser.setLastname(lastname);
			newUser.setEmail(email);
			newUser.setPassword(password);
			  
			UserRegistry ManagedUserRegistry = (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
			 
			if (ManagedUserRegistry.AddRegisteredUser(newUser) == null) {
			    // userid exists
			    
			    FacesContext.getCurrentInstance().addMessage(null, 
			      new FacesMessage("User with email " + newUser.getEmail() + " already exists! Please choose another." ));
			    newUser = null;
			    
			    return(null);
			  }
			  else {

			      // Is a new user, continue logging in
			    User managedUserBean = (User)JSFUtil.getManagedObject("User");
			    UserUtil.copyUserProperties(newUser, managedUserBean);
			    managedUserBean.setLoggedIn(true);

			    //Place AUTH_USER string on session to disable security filter on session to disable security filter
			    JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");

			    
			    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration Successful!"));
			    System.out.println("Done Registering User..");
			    return("main");
			  
			  }
			  
			
			return "success";
		}
		return toReturn;
	}

	private boolean validateData() {
		boolean toReturn = true;
		FacesContext ctx = FacesContext.getCurrentInstance();

		// check emailConfirm is same as email
		if (!emailConfirm.equals(getEmail())) {
			ctx.addMessage("registerForm:emailConfirm", new FacesMessage(
					"Email Confirm Error"));
			toReturn = false;
		}
		// check passwordConfirm is same as password
		if (!passwordConfirm.equals(getPassword())) {
			ctx.addMessage("registerForm:passwordConfirm", new FacesMessage(
					"Password Confirm Error"));
			toReturn = false;
		}
		return toReturn;
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

	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
