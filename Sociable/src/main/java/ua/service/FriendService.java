package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.FriendReqest;
import ua.entity.User;
import ua.entity.form.FriendReqestForm;

public interface FriendService {

	String addNewFriend(FriendReqestForm form, String username);

	Page<FriendReqest> findPagebleByName(String username, Pageable pageable);

	Page<FriendReqest> findChackedPagebleByPrinciple(String username, Pageable pageable);

	Page<User> findFreandPagable(String username, Pageable pageable);

	boolean friendAcept(FriendReqestForm form, String username);


}
