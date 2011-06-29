package net.zhepu.web.model;

import java.util.Date;

public class Person {

	private int userid;
	private String email;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private Date date;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [userid=" + userid + ", email=" + email + ", date=" + date + "]";
	}
	
	
}
