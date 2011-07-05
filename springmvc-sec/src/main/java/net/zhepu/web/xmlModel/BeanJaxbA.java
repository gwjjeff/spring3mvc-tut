package net.zhepu.web.xmlModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xmlStrA")
public class BeanJaxbA {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String name;
	private String password;
	private long id;
	@Override
	public String toString() {
		return "BeanJaxbA [name=" + name + ", password=" + password + ", id=" + id + "]";
	}

}
