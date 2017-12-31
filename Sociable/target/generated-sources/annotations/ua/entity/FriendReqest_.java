package ua.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FriendReqest.class)
public abstract class FriendReqest_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<FriendReqest, String> msg;
	public static volatile SingularAttribute<FriendReqest, LocalDateTime> date;
	public static volatile SingularAttribute<FriendReqest, User> output;
	public static volatile SingularAttribute<FriendReqest, User> input;
	public static volatile SingularAttribute<FriendReqest, Boolean> cheack;

}

