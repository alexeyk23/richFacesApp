package com.relex.practice.pojo;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "\"APPLICATION\"")
public class Application {
	@Id
	@Column(name = "\"APPLICATION_ID\"")
	private int id;

	@Column(name = "\"NAME\"")
	private String name;

	@ManyToMany
	@JoinTable(name = "\"APPLICATION_PRIVILEGES\"", joinColumns = { @JoinColumn(name = "\"APPLICATION_ID\"") }, inverseJoinColumns = { @JoinColumn(name = "\"PRIVILEGES_ID\"") })
	private Set<Privileges> applications;

	public Set<Privileges> getApplications() {
		return applications;
	}

	public void setApplications(Set<Privileges> applications) {
		this.applications = applications;
	}

	public Application() {
	};

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

}
