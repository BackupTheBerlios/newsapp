package ch.bfh.euro08.hibernate.beans;

public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String password;
	private String activationcode;
	private boolean active;
	private String email;
	private boolean superuser;
	private String card;
	
	private boolean loggedIn;
	
	public User(){}
	
	public User(int id, String firstname, String lastname, String password,
			String activationcode, String email, boolean superuser, boolean active) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.activationcode = activationcode;
		this.active = active;
		this.email = email;
		this.superuser = superuser;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActivationcode() {
		return activationcode;
	}
	public void setActivationcode(String activationcode) {
		this.activationcode = activationcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSuperuser() {
		return superuser;
	}
	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.loggedIn = isLoggedIn;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

}