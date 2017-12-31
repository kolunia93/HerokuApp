package ua.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Image.class)
public abstract class Image_ extends ua.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Image, LocalDateTime> date;
	public static volatile SingularAttribute<Image, String> name;
	public static volatile SingularAttribute<Image, String> comment;
	public static volatile SingularAttribute<Image, User> user;

}

