package com.relex.practice.pojo;

import javax.persistence.*;

@Entity
@Table(name = "\"DIVISION\"")
public class Division {
	@ManyToOne
	@JoinColumn(name = "\"COMPANY_ID\"")
	private Company company;

	@Column(name = "\"DIVISION_NAME\"")
	private String divName;

	@Id
	@Column(name = "\"DIVISION_ID\"")
	private int divID;

	public Division() {

	}

	public Company getCompid() {
		return company;
	}

	public void setCompid(Company company) {
		this.company = company;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public int getDivID() {
		return divID;
	}

	public void setDivID(int divID) {
		this.divID = divID;
	}

}
