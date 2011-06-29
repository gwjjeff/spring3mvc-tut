package net.zhepu.web.model;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import net.zhepu.web.model.ValidModel.First;
import net.zhepu.web.model.ValidModel.Second;
import net.zhepu.web.valid.annotation.FixLength;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@GroupSequence({ ValidModel.class, First.class, Second.class })
public class ValidModel {

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@NotEmpty
	private String userName;

	@NotBlank
	@Email
	private String email;

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	@NotBlank(groups = First.class)
	@FixLength(length = 11, groups = Second.class)
	// @FixLength(length = 11)
	private String mobileNO;

	public interface First extends Default {
		
	}
	public interface Second {

	}
}
