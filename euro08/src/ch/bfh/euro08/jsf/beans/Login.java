package ch.bfh.euro08.jsf.beans;

import java.io.IOException;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.JSFUtil;
import ch.bfh.euro08.util.UserUtil;

public class Login {

	private HtmlInputText userid; 
	private HtmlInputSecret password;

	private final static String AUTH_USER = "Authorized_User";

	public Login() {
	}

	public String login() {

		UserRegistry userRegCopy = (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
		User currentUser = userRegCopy.findUserByCredentials(userid.getValue().toString(), password.getValue().toString());
		//User currentUser = userRegCopy.findUserByCredentials("schnl1@euro08.ch", "euro08");
		
		if (currentUser == null) {
			// login failed
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid Login!"));
			System.out.println("no");
			return "failure";
		} else {
			// login success
			User managedUserBean = (User) JSFUtil.getManagedObject("user");
			UserUtil.copyUserProperties(currentUser, managedUserBean);
			managedUserBean.setLoggedIn(true);

			// Place authorized user on session to disable security filter
			JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");
			System.out.println("yes");
			return "success";
		}
	}

	public String logout() throws IOException {
		ExternalContext ectx = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) ectx.getSession(false);
		session.invalidate();

		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();

		// To avoid using the navigation handler you could also use...
		// response.sendRedirect("../index.jsp");
		return "success";

	}

	public void setUserid(HtmlInputText userid) {
		this.userid = userid;
	}

	public HtmlInputText getUserid() {
		return userid;
	}

	public void setPassword(HtmlInputSecret password) {
		this.password = password;
	}

	public HtmlInputSecret getPassword() {
		return password;
	}
}
