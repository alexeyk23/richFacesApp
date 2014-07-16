package com.relex.practice.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "\"PRIVILEGES\"")
public class Privileges {
	@Id
	@Column(name = "\"PRIVILEGES_ID\"")
	private int id;

	@Column(name = "\"NAME\"")
	private String name;

	@ManyToMany(mappedBy = "applications")
	private Set<Application> applications = new HashSet<Application>();

	@ManyToMany(mappedBy = "privileges")
	private Set<Role> roles = new HashSet<Role>();

	public Set<Role> getRoles() {
		return roles;
	}

	public Privileges() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Application> getApplicat() {
		return applications;
	}

	public void setApplicat(Set<Application> applications) {
		this.applications = applications;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	};

}
