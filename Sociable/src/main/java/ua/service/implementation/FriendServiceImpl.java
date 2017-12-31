package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.FriendReqest;
import ua.entity.User;
import ua.entity.form.FriendReqestForm;
import ua.repository.FriendRequestRepository;
import ua.repository.UserRepository;
import ua.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FriendRequestRepository friendRequestRepository;
	
	@Override
	public Page<User> findFreandPagable(String username, Pageable pageable) {
		
		return null;
	}
	
	@Override
	public Page<FriendReqest> findChackedPagebleByPrinciple(String username, Pageable pageable) {
		 return friendRequestRepository.findAllCheackePagebleWithPrincipal(username, pageable);
	}
	

	@Override
	@Transactional
	public  String addNewFriend(FriendReqestForm form, String username) {
		List<FriendReqest> ob=friendRequestRepository.findByUserAndFriendName(username,form.getOutput());
		User user=userRepository.findOneFriend(username,form.getOutput());
		if (user!=null) {
			return form.getOutput();
		}
		if (ob.isEmpty()) {
			System.out.println("Empty");
		FriendReqest entity=new FriendReqest();
		User input=userRepository.findByUsername(username);
		System.out.println(input);
		User output=userRepository.findByUsername(form.getOutput());
		System.out.println(output);
		entity.setInput(input);
		entity.setOutput(output);
		entity.setMsg(form.getMsg());
		friendRequestRepository.save(entity);
		return null;
		}
		
		return form.getOutput();
	}

	@Override
	public Page<FriendReqest> findPagebleByName(String name, Pageable pageable) {
		
		return friendRequestRepository.findAllPagebleWithPrincipal(name, pageable);
	}
	
	@Override
	@Transactional
	public boolean friendAcept(FriendReqestForm form,String username) {

		int id=Integer.parseInt(form.getId());
		if (!form.isCheack()) {
		User user=userRepository.findByUsername(username);		
		User friend=userRepository.findByUsername(form.getInput());
		user.setFriend(friend);	
		friend.setFriend(user);
		userRepository.save(user);
		userRepository.save(friend);
		friendRequestRepository.delete(id);
		return true;		
		}
		FriendReqest fr=friendRequestRepository.getOne(id);
		fr.setCheack(true);
		friendRequestRepository.save(fr);
	return false;
	}

}
