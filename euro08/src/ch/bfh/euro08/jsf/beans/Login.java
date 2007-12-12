package ch.bfh.euro08.jsf.beans;

import java.io.IOException;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;
import ch.bfh.euro08.util.UserUtil;

public class Login {

	private HtmlInputText userid; 
	private HtmlInputSecret password;
	private HtmlInputText activationcode;

	private final static String AUTH_USER = "Authorized_User";
	private final static String ACT_USER = "Activated_User";
	private final static String SUP_USER = "Super_User";

	public Login() {
	}

	public String login() {

		UserRegistry userRegCopy = (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
		User currentUser = userRegCopy.findUserByCredentials(userid.getValue().toString(), password.getValue().toString());
		
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
			JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");

			if (!currentUser.isActive()) {
				// ask for activation code
				System.out.println(currentUser.isActive() + " ask for activation code");
				return "activationcode";
			} else {
				// Place ACT_USER user on session to disable security filter
				JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), ACT_USER, "Activated_User");
			}
			if (currentUser.isSuperuser()) {
				// Place SUP_USER user on session to disable admin-security filter and go to admin interface
				JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), SUP_USER, "Super_User");
				System.out.println(currentUser.isSuperuser() + " go to admin interface");
				return "admin";
			}
			
			
			return "success";
		}
	}

	public String activate() {
		User user = (User) JSFUtil.getManagedObject("user");
		System.out.println("Activating...");
		// Compare Activationcode with DB-Value
		if (user.getActivationcode().equals((String) activationcode.getValue())) {
			
			System.out.println("Correct Activationcode");
			
			// Set Activated Flag
			user.setActive(true);
			
			// Set Activated-Session Variable
			JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), ACT_USER, "Activated_User");
		
			// Persist to Database
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			try {
				session.update(user);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Redirect User
			if (user.isSuperuser()) {
				System.out.println("Go to Admininterface");
				return "admin";
			}
			System.out.println("Go to Userinterface");
			return "userview";
		}
		System.out.println("Wrong Activationcode");
		return "activationcode";
		
	}
	
	public String logout() throws IOException {
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) ectx.getSession(false);
		session.invalidate();
		System.out.println("logout");
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

	public HtmlInputText getActivationcode() {
		return activationcode;
	}

	public void setActivationcode(HtmlInputText activationcode) {
		this.activationcode = activationcode;
	}
}
