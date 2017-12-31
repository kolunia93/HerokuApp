package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ extends ua.entity.AbstractEntity_ {

	public static volatile ListAttribute<Role, Privilege> privileges;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile ListAttribute<Role, User> users;

}

