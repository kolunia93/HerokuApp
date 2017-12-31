package ua.service.implementation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Role;
import ua.entity.User;
import ua.repository.RoleRepository;
import ua.repository.UserRepository;
import ua.service.UserService;

@Component
@Service("userDetailsService")	
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PersistenceContext
	protected EntityManager emf;
	
	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {

		return userRepository.findByUsername(name);
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		Role role= roleRepository.findByName("ROLE_USER");
		user.setOneRole(role);
		userRepository.save(user);
	}
	
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public Page<User> findAllUserPageble(String username, Pageable pageable) {
		Page<User> users= userRepository.findAll(pageable);
		Iterator<User> iterator=users.iterator();
		 while (iterator.hasNext()) {
			if (iterator.next().getUsername().equals(username)) {
				iterator.remove();
			}	
			
		}
		return users;
	}
	
	@Override
	public Page<User> findAllFriend(String username, Pageable pageable) {	
		return userRepository.findAllFriend(username, pageable);
	}
	
	@Override
	public List<User> findAllFriend(String username) {
		return userRepository.findAllFriend(username);
	}
	
	@Override
	public User findByUserNameWithDependency(String name) {
	
		return userRepository.findByUsernamewithDependency(name);
	}


	@Override
	public User findByPrincipal(String username) {
		User user=userRepository.findByUsername(username);
		return user;
	}
	
	@PostConstruct
	@Transactional
	public void admin(){
		Role admin=roleRepository.findByName("ROLE_ADMIN");
		Role userRole=roleRepository.findByName("ROLE_USER");
		if (admin==null) {
			admin=new Role("ROLE_ADMIN");
			roleRepository.save(admin);
			
		}
		if (userRole==null) {
			userRole=new Role("ROLE_USER");
			roleRepository.save(userRole);
		}
		User user = userRepository.findByUsername("admin");
		if(user==null){
			user = new User();
			user.setEmail("qqq@mail.ru");
			user.setPassword(encoder.encode("123456"));
			user.setOneRole(admin);			
			user.setBirthday(LocalDate.now());
			user.setUsername("admin");
			user.setFone("099-99-99-999");
			user.setName("adminName");
			user.setSecondname("adminSecondName");
			userRepository.save(user);
			System.out.println("admin create");
		}
//		for (int i = 0; i < 10; i++) {
//			user = userRepository.findByUsername("user"+i);
//			if(user==null){
//				user = new User();
//				user.setEmail("qqq@mail.ru");
//				user.setPassword(encoder.encode("123456"));
//				user.setOneRole(userRole);
//				user.setUsername("user"+i);
//				user.setFone("1");
//				user.setName("userName"+i);
//				user.setSecondname("adminSecondName"+i);
//				userRepository.save(user);
//			}
//		}
		
	}


	public UserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

}
