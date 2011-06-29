package net.zhepu.web.model;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("set as text " + text);
		String[] s = text.split(";");
		User u = new User();
		u.setUserName(s[0]);
		u.setPassword(s[1]);
		u.setMobileNO(s[2]);
		setValue(u);
	}
	
	@Override
	public String getAsText() {
		System.out.println("get as text " );
		return super.getAsText();
	}
	@Override
	public boolean supportsCustomEditor() {
		// TODO Auto-generated method stub
		return true;
	}
}
