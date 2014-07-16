package com.relex.practice.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "\"ROLE\"")
public class Role {
	@Id
      //  @GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_id_role")
	@Column(name = "\"ROLE_ID\"")
	private int role_id;

	@Column(name = "\"NAME\"")
	private String role_name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	@ManyToMany
	@JoinTable(name = "\"ROLE_PRIVILEGES\"", joinColumns = @JoinColumn(name = "\"ROLE_ID\""), inverseJoinColumns = @JoinColumn(name = "\"PRIVILEGES_ID\""))
	private Set<Privileges> privileges;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getId() {
		return role_id;
	}

	public String getName() {
		return role_name;
	}

	public void setId(int id) {
		this.role_id = id;
	}

	public void setName(String name) {
		this.role_name = name;

	}

	public Role() {
		this.privileges = new HashSet<Privileges>();
		this.users = new HashSet<User>();
	}

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
        

}
