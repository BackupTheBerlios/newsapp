package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;



import org.hibernate.Query;
import org.hibernate.Session;


import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.Stade;
import ch.bfh.euro08.hibernate.beans.Team;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.GameListing;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;
import ch.bfh.euro08.util.UserListing;


public class UserRegistry {
	private UIData data = null;
	
	public UserRegistry() {}

	public String AddRegisteredUser(User newUser) {
		{

			if (!userAlreadyExists(newUser.getEmail())) {

				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();

				try {
					session.save(newUser);
					session.getTransaction().commit();
					return String.valueOf(newUser.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}

	public User findUserByCredentials(String userid, String password) {

		Query q = null;
		List<User> results = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("select from User usr where usr.email = :inuserid and usr.password = :inuserpassword");
		q.setParameter("inuserid", userid);
		q.setParameter("inuserpassword", password);
		results = q.list();
		session.close();

		for (int i = 0; i < results.size(); i++) {
			User user = results.get(i);
			return user;
		}
		return null;//new User(1, "Not", "Existing", "pwd", "actCode", "notexisting@euro08.ch", true);
	}

	public boolean userAlreadyExists(String email) {

		Query q = null;
		List<User> results = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("from User usr where usr.email = :inuserid");
		q.setParameter("inuserid", email);
		results = q.list();
		session.close();

		for (int i = 0; i < results.size(); i++) {
			results.get(i);
			return true;
		}
		return false;
	}
	
	public List getAllUsers() {
		List<UserListing> userList = new ArrayList<UserListing>();
		List<User> users_results = null;
		Query q = null;
		
		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		int userid = managedUserBean.getId();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session.createQuery("select from User usr order by usr.lastname");
		users_results = q.list();
		
		for (int i = 0; i < users_results.size(); i++) {
			System.out.println("found all users");
			User user = users_results.get(i);

			userList.add(new UserListing(user.getFirstname(), user.getLastname(),
					user.getEmail(), user.isSuperuser()));
		}

		session.close();
		return userList;
	}

	public UIData getData() {
		return data;
	}

	public void setData(UIData data) {
		this.data = data;
	}
}
	
