package com.relex.practice.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "\"USER\"")
public class User {
	@Id
        @SequenceGenerator(name="my_seq", sequenceName="auto_id_user")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_seq")
	@Column(name = "\"USER_ID\"")
	private int id_user;

	@Column(name = "\"NAME\"")
	private String name;

	@Column(name = "\"SURNAME\"")
	private String surname;

	@Column(name = "\"MAIL\"")
	private String mail;

	@Column(name = "\"DATAREG\"")
	private Date data;

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	@ManyToOne
	@JoinColumn(name = "\"DIVISION_ID\"")
	private Division division;
	@ManyToMany
	@JoinTable(name = "\"USER_ROLE\"", joinColumns = @JoinColumn(name = "\"USER_ID\""), inverseJoinColumns = @JoinColumn(name = "\"ROLE_ID\""))
	private Set<Role> roles = new HashSet<Role>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
