package de.scheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personnel")
public class Person {
	
	@Id
	@Column(name = "PersID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer persID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Function")
	private String function;
	
	@Column(name = "Nickname")
	private String nickname;
	
	public Integer getPersID() {
		return persID;
	}

	public void setPersID(Integer persID) {
		this.persID = persID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}


}
