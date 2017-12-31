	package ua.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user", indexes=@Index(columnList = "username"))
public class User extends AbstractEntity  implements UserDetails{
	
	private static final long serialVersionUID = -8288001889276940237L;
	
	int numoffriends;
	
	private volatile int avatar;	

	@Column(name = "version", nullable = true)
	private volatile Integer version;
	
	private String name;
	
	private String secondname;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	
	@NotEmpty
	@Email
	private String email;
	
	private String fone;
	
	@OneToMany(mappedBy="user")
	private Set<Image>avatars=new HashSet<Image>();
	
	@OneToMany(mappedBy="input")
	private Set<FriendReqest>input=new HashSet<FriendReqest>();
	
	@OneToMany(mappedBy="output")
	private Set<FriendReqest>output=new HashSet<FriendReqest>();
		
	@ManyToMany
    @JoinTable(
            name="User_Friend",	
            joinColumns = @JoinColumn( name="User_ID"),
            inverseJoinColumns = @JoinColumn( name="Friend_ID")
    )
	private Set<User> friends=new HashSet<User>();
	
	@ManyToMany(mappedBy="friends")
	private  Set<User> user=new HashSet<User>();
	
	@ManyToMany()
    @JoinTable( 
    		
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id",unique = false), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id",unique = false)) 
	
    private List<Role> roles=new ArrayList<Role>();
	
	@Enumerated
	private Gender gender;
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		for (Role role:roles) {
			list.add(new SimpleGrantedAuthority(role.getName()));
		}
		return list;
	}
		
	public User() {
	}

	public String getUsername() {
		
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {

		return true;
	}

	public boolean isCredentialsNonExpired() {

		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondname;
	}

	public void setSecondName(String secondName) {
		this.secondname = secondName;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}


	public Set<Image> getAvatars() {
		return avatars;
	}

	public void setAvatars(Set<Image> avatars) {
		this.avatars = avatars;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword() {
		return password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Set<FriendReqest> getInput() {
		return input;
	}

	public void setInput(Set<FriendReqest> input) {
		this.input = input;
	}

	public Set<FriendReqest> getOutput() {
		return output;
	}

	public void setOutput(Set<FriendReqest> output) {
		this.output = output;
	}

	public int getNumoffriends() {
		return numoffriends;
	}

	public void setNumoffriends(int numoffriends) {
		this.numoffriends = numoffriends;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public void setFriend(User user) {
		this.friends.add(user);
	}

	public void setOneRole(Role role) {
		this.roles.add(role);
		
	}
	
	
}