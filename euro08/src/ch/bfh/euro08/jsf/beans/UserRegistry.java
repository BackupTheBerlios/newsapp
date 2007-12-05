package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.soap.MessageFactory;
import java.util.*;

import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.hibernate.Query;
import org.hibernate.Session;


import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.HibernateUtil;


public class UserRegistry {

	private List RegisteredUsers = new ArrayList();

	public UserRegistry() {}

	public String AddRegisteredUser(User newUser) {
		{

			if (!userIdAlreadyExists(newUser.getId())) {

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

		q = session.createQuery("select from User usr where usr.email = :inuserid and usr.password = PASSWORD(:inuserpassword)");
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

	public boolean userIdAlreadyExists(int userid) {

		Query q = null;
		List<User> results = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("from User usr where usr.id = :inuserid");
		q.setParameter("inuserid", userid);
		results = q.list();
		session.close();

		for (int i = 0; i < results.size(); i++) {
			results.get(i);
			return true;
		}
		return false;
	}
	
}
