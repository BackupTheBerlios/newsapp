package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Order;
import ch.bfh.euro08.hibernate.beans.Stade;
import ch.bfh.euro08.hibernate.beans.Team;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.GameListing;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;

public class GameRegistry {
	
	  private UIData data = null;
	  

	public List getOrderedGames()
	{
		List<GameListing> gameList = new ArrayList<GameListing>();
		
		Query q = null;
		List<Order> order_results = null;
		List<Ticket> ticket_results = null;
		List<Match> match_results = null;
		List<Team> team_results = null;
		List<Stade> stade_results = null;
		
		  User managedUserBean = 
		     (User)JSFUtil.getManagedObject("UserBean");  
		     
		  int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		//ORDER
		q = session.createQuery("SELECT FROM `order` WHERE order.user_fkey = :inuserid");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		for (int i = 0; i < order_results.size(); i++) {
			Order order = order_results.get(i);
			
			//TICKET
			q = session.createQuery("SELECT FROM `order` WHERE order.user_fkey = :inticketfkey");
			q.setParameter("inticketfkey", order.getTicket_fkey());
			ticket_results = q.list();

			Ticket ticket = ticket_results.get(0);
			
			//MATCH
			q = session.createQuery("SELECT FROM `match` WHERE order.user_fkey = :inmatchfkey");
			q.setParameter("inmatchfkey", ticket.getMatch_fkey());
			match_results = q.list();
			
			Match match = match_results.get(0);
			
			//STADE
			q = session.createQuery("SELECT FROM `stade` WHERE team.user_fkey = :instadefkey");
			q.setParameter("instadefkey", match.getStade_fkey());
			stade_results = q.list();
			
			Stade stade = stade_results.get(0);
			
			//TEAM1
			q = session.createQuery("SELECT FROM `team` WHERE team.team1_fkey = :inteam1fkey");
			q.setParameter("inteam1fkey", match.getTeam1_fkey());
			match_results = q.list();
			
			Team team1 = team_results.get(0);
			
			//TEAM2
			q = session.createQuery("SELECT FROM `team` WHERE team.team2_fkey = :inteam2fkey");
			q.setParameter("inteam2fkey", match.getTeam1_fkey());
			match_results = q.list();
			
			Team team2 = team_results.get(0);
			
			gameList.add(new GameListing(order.getId(), stade.getName(), match.getDatetime(), team1.getCountry(), team2.getCountry(), order.getQuantity()));
			
					
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
