package ch.bfh.euro08.jsf.beans;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.*;
import javax.faces.application.*;


public class Register {

	private String firstname;
	private String lastname;
	private String password;
	private String passwordConfirm;
	private String email;
	private String emailConfirm;

	public Register() {

	}

	public String register() {
		System.out.println("validate Email & Password");
		String toReturn = "failure";

		if (validateData()) {

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
