package ua.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role extends AbstractEntity implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String name;
    @ManyToMany(mappedBy = "roles" )
    private List<User> users;
 
    @ManyToMany()
    @JoinTable(
            name = "roles_privileges", 
            joinColumns = @JoinColumn(
              name = "role_id", referencedColumnName = "id"), 
            inverseJoinColumns = @JoinColumn(
              name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;

	public Role(String name) {
		this.name=name;
	}
	
	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}   
    
    
}