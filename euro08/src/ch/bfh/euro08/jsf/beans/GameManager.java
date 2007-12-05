package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.HibernateUtil;

public class GameManager {
	private List<Match> gameList = new ArrayList<Match>();

	public List<Match> getGameList() {

		Query q = null;
		List<Match> results = null;
		gameList = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("select * from Match");
		results = q.list();
		session.close();

		for (int i = 0; i < results.size(); i++) {
			gameList.add(results.get(i) );
		}
		return gameList;
	}
}
