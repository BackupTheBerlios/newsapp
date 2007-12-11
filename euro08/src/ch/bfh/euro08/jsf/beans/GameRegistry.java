package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
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

public class GameRegistry {

	private UIData data = null;

	public void delete(int id){
		System.out.println(id);
	}
	public List getOrderedGames() {
		List<GameListing> gameList = new ArrayList<GameListing>();

		Query q = null;
		List<Ordering> order_results = null;
		List<Ticket> ticket_results = null;
		List<Match> match_results = null;
		List<Team> team_results = null;
		List<Stade> stade_results = null;

		User managedUserBean = (User) JSFUtil.getManagedObject("user");

		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session
				.createQuery("select from Ordering ord where ord.user_fkey = :inuserid and ord.status = 0");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		for (int i = 0; i < order_results.size(); i++) {
			System.out.println("found tickets");
			Ordering order = order_results.get(i);

			gameList.add(new GameListing(order.getId(), order.getTicket_fkey()
					.getMatch_fkey().getStade_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getDatetime(), order
					.getTicket_fkey().getMatch_fkey().getTeam1_fkey()
					.getCountry(), order.getTicket_fkey().getMatch_fkey()
					.getTeam2_fkey().getCountry(), order.getQuantity(), order
					.getTicket_fkey().getCategory_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getStade_fkey()
					.getCountry()));
		}

		session.close();
		return gameList;
	}

	public Match getTrainingEventById(int id) {

		Match match = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		match = (Match) session.get(Match.class, new Long(id));
		session.close();
		return match;

	}

	public List getAllEvents() {
		System.out.println("geteventlist!");
		List elist = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		elist = session.createCriteria(Match.class).list();

		session.close();
		return elist;
	}

	public void scroll(int row) {

		int rows = data.getRows();
		if (rows < 1) {
			return; // Showing entire table already
		}
		if (row < 0) {
			data.setFirst(0);
		} else if (row >= data.getRowCount()) {
			data.setFirst(data.getRowCount() - 1);
		} else {
			data.setFirst(row - (row % rows));
		}

	}

	public UIData getData() {
		return data;
	}

	public void setData(UIData data) {
		this.data = data;
	}
}
