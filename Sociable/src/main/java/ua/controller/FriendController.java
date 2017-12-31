package ua.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.User;
import ua.entity.form.FriendReqestForm;
import ua.filter.FriendFilter;
import ua.service.FriendService;
import ua.service.ImageService;
import ua.service.UserService;

@Controller
@SessionAttributes(names="user")
@RequestMapping(value="user/{username}/friends")
public class FriendController {

	@Autowired
	UserService userService;
	
	@Autowired
	FriendService friendService;
	
	@Autowired
	ImageService imageService;
	
	@ModelAttribute("Friendfilter")
	public FriendFilter getUserFilter(){
		return new FriendFilter();
	}
	
	@ModelAttribute("user")
	public User getForm(Principal principal){		
		return userService.findByUserNameWithDependency(principal.getName());
	}
	
	@ModelAttribute("numUser")
	public int getnumOfUser(Principal principal){
		return userService.findAllFriend(principal.getName()).size();
	}
	
	@ModelAttribute("friendReqestForm")
	public FriendReqestForm getNewFriendForm(){
		return new FriendReqestForm();
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showAllUser(@PathVariable("username") String username, Model model, @PageableDefault Pageable pageable, @ModelAttribute("Friendfilter") FriendFilter filter){
		List<User> users=userService.findAllFriend(username);
		System.out.println(users.size());
		for (User u:users) {
			System.out.println(u.getUsername());
		}
			System.out.println(userService.findAllFriend(username, pageable));
		model.addAttribute("friends",userService.findAllFriend(username, pageable) );
		return "user-friend";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String showAll(@PathVariable("username") String username,Model model, @PageableDefault Pageable pageable, @ModelAttribute("Friendfilter") FriendFilter filter){		
		model.addAttribute("friends", userService.findAllUserPageble(username, pageable));
		return "user-find";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public String addFriend(@PathVariable("username") String username,@ModelAttribute("friendReqestForm") @Valid FriendReqestForm form, Model model,BindingResult br,@PageableDefault Pageable pageable, SessionStatus status){		
	String cheack=friendService.addNewFriend(form,username);
		System.out.println(cheack);
		if (cheack!=null) {	
			if (cheack.contains("F@*/")) {
				cheack=cheack.substring(4, cheack.length());
				br.rejectValue("cheack","", "This is already youre friend");
			}else {
			System.out.println("in if");
			
			br.rejectValue("cheack","", "You already add this friend");
				}
			model.addAttribute("existUser", cheack);
			}
		if (br.hasErrors()) {
			System.out.println("in br");
			model.addAttribute("friends", userService.findAllUserPageble(username, pageable));
		return "user-find";
	}	
		model.addAttribute("friends", userService.findAllUserPageble(username, pageable));
		return "redirect:/user/"+username+"/friends/find";
	}
	
	@RequestMapping(value="/reqest", method=RequestMethod.GET)
	public String cheackUser(@PathVariable("username") String username,Model model, @PageableDefault Pageable pageable, @ModelAttribute("Friendfilter") FriendFilter filter){		
		model.addAttribute("reqests", friendService.findPagebleByName(username, pageable));
		return "user-reqest";
	}
	
	
	@RequestMapping(value="/reqest", method=RequestMethod.POST)
	public String cheackUser(@PathVariable("username") String username,@ModelAttribute("friendReqestForm") @Valid FriendReqestForm form,Principal principal, BindingResult br, Model model, SessionStatus status){		
		if (br.hasErrors()) {
			System.out.println("errr");
		}	
		friendService.friendAcept(form,username);		
		return "redirect:/user/"+username+"/friends/reqest";
	}
	
	

	@RequestMapping("/reqest/old")
	public String showOldreqest(Model model, @PageableDefault Pageable pageable, @ModelAttribute("Friendfilter") FriendFilter filter, Principal principal){		
		model.addAttribute("page", friendService.findPagebleByName(principal.getName(), pageable));
		model.addAttribute("user", userService.findByUserNameWithDependency(principal.getName()));
		return "user-friendreqest";
		}
	}
