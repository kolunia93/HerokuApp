package ua.controller;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.User;
import ua.entity.form.ImageSaveForm;
import ua.service.FriendService;
import ua.service.ImageService;
import ua.service.UserService;

@Controller
@SessionAttributes(names="user")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	FriendService friendService;
	
	@InitBinder
	  private void dateBinder(WebDataBinder binder) {
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	      binder.registerCustomEditor(Date.class, editor); 
	  }
	
	@ModelAttribute("user")
	public User getForm(Principal principal){
		
		return userService.findByPrincipal(principal.getName());
	}

	@ModelAttribute("images")
	public ImageSaveForm getFormImages(){
		return new ImageSaveForm();
	}
		
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String ShowUserPage(@PathVariable("username") String username,Model model,Pageable pageable){	
		model.addAttribute("user", userService.findByPrincipal(username)) ;
		model.addAttribute("friendsSize", userService.findAllFriend(username).size()) ;
		return "user-user";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String PutUser(@PathVariable("username") String username, @Valid User user, Model model,Pageable pageable){	
		model.addAttribute("user", user);
		model.addAttribute("friendsSize", userService.findAllFriend(username).size()) ;
		userService.save(user);
		return "user-user";
	}
	
	@RequestMapping(value="/{username}/save_image", method=POST)
	public String saveImage(@PathVariable("username") String username,@ModelAttribute("images") @Valid ImageSaveForm form, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){	
			System.out.println("error");
			return "user-user";
		}	
		System.out.println("save");
		System.out.println("save 22222");
		User user =userService.findByPrincipal(username);
		System.out.println("dsfgasdrfgsdf");
		System.out.println(user.getAvatar()+"fffffffffffff");
		model.addAttribute("user", userService.findByPrincipal(username)) ;
		imageService.saveAvatar(form, username);
		return "redirect:/user/"+username;
	}
	
	
}
