package spring;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
	private long id;
	private String email;
	private String password;
	private String name;
	private Timestamp regdate;
	
	public Member(String email, String password, String name, Timestamp regdate, long id) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}
	
	public Member(String email, String password, String name, Timestamp regdate) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.regdate = regdate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	//암호변경 기능을 구현하는 메서드
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new IdPasswordMatchingException();
		}
		this.password = newPassword;
	}
	
	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}
}
