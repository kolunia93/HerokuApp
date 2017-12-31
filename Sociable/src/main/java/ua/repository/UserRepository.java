package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.friends LEFT JOIN FETCH u.input LEFT JOIN FETCH u.output WHERE u.username=:username")
	User findByUsernamewithDependency(@Param("username")String username);

	@Query(value="SELECT u FROM User u LEFT JOIN FETCH u.friends ",
			countQuery="SELECT count(u.id) FROM User u")
	Page<User> findAllWithFriendPageble(Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findByUsername(@Param("username")String username);
	
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.user f  WHERE f.username=:username")
	List<User> findAllFriend(@Param("username")String username);
	
	@Query(value="SELECT u FROM User u LEFT JOIN FETCH u.friends f WHERE f.username=:username",
			countQuery="SELECT count(u.id) FROM User u")
	Page<User> findAllFriend(@Param("username")String username,Pageable pageble);


	@Query("SELECT u FROM User u LEFT JOIN FETCH u.friends f WHERE f.username=:output and u.username=:username")
	User findOneFriend(@Param("username")String username, @Param("output")String output);
		
}
