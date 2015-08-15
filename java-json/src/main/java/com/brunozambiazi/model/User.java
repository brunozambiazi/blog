
package com.brunozambiazi.model;

import java.util.Calendar;
import java.util.Set;


public class User {
	
	private Long id;
	private String name;
	private Calendar birthDate;
	private Set<String> emails;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	public Set<String> getEmails() {
		return emails;
	}
	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	
}
