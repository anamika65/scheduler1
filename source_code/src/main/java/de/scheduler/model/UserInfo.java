package de.scheduler.model;


public class UserInfo {
	
	private Integer usrId;
	
	private Boolean active;
	
	private String userName;
	
	private String password;
	
	private String userRole;

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usr_id) {
		this.usrId = usr_id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String user_role) {
		this.userRole = user_role;
	}
	
	
}
