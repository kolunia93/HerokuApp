package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.User;

public interface UserService {

	void save(User user);

	List<User> findAllUser();

	User findByPrincipal(String username);

	User findByUserNameWithDependency(String name);

	Page<User> findAllUserPageble(String username, Pageable pageable);

	Page<User> findAllFriend(String username, Pageable pageable);
	
	List<User> findAllFriend(String username);

}
