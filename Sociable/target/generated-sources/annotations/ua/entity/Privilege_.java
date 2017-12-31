package ua.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Privilege.class)
public abstract class Privilege_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Privilege, String> name;
	public static volatile SetAttribute<Privilege, Role> users;

}

