package ua.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<User, LocalDate> birthday;
	public static volatile SingularAttribute<User, Gender> gender;
	public static volatile ListAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, Integer> avatar;
	public static volatile SingularAttribute<User, Integer> version;
	public static volatile SetAttribute<User, User> friends;
	public static volatile SingularAttribute<User, String> secondname;
	public static volatile SingularAttribute<User, String> fone;
	public static volatile SetAttribute<User, FriendReqest> output;
	public static volatile SetAttribute<User, FriendReqest> input;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SetAttribute<User, User> user;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SetAttribute<User, Image> avatars;

}

