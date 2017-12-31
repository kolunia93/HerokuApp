package ua.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Privilege extends AbstractEntity {
	
	String name;
	
	@ManyToMany(mappedBy = "privileges")
	private Set<Role> users=new HashSet<Role>();

	public Privilege(String name) {
	this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getUsers() {
		return users;
	}

	public void setUsers(Set<Role> users) {
		this.users = users;
	}

	public Privilege() {
		super();
	}

}
