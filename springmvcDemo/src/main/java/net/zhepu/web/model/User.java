package net.zhepu.web.model;

public class User {

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private int userid;
	private String username;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	private Person person;
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", person=" + person + "]";
	}
}
