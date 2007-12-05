package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.HibernateUtil;

public class GameManager {
	private List<Ticket> gameList = new ArrayList<Ticket>();

	public List<Ticket> getGameList() {

		Query q = null;
		List<Ticket> results = new ArrayList<Ticket>();
		gameList = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("select * from ticket");
		results = q.list();
		session.close();

		for (int i = 0; i < results.size(); i++) {
			gameList.add(results.get(i) );
		}
		return gameList;
	}
}
