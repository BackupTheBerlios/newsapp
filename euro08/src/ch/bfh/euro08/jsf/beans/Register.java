package ch.bfh.euro08.jsf.beans;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.*;
import javax.faces.application.*;


public class Register {

	private HtmlInputText firstname;
	private HtmlInputText lastname;
	private HtmlInputText password;
	private HtmlInputText passwordConfirm;
	private HtmlInputText email;
	private HtmlInputText emailConfirm;

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

	public HtmlInputText getFirstname() {
		return firstname;
	}

	public void setFirstname(HtmlInputText firstname) {
		this.firstname = firstname;
	}

	public HtmlInputText getLastname() {
		return lastname;
	}

	public void setLastname(HtmlInputText lastname) {
		this.lastname = lastname;
	}

	public HtmlInputText getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(HtmlInputText emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public HtmlInputText getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(HtmlInputText passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public HtmlInputText getPassword() {
		return password;
	}

	public void setPassword(HtmlInputText password) {
		this.password = password;
	}

	public HtmlInputText getEmail() {
		return email;
	}

	public void setEmail(HtmlInputText email) {
		this.email = email;
	}

}
