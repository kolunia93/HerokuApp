package ua.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.User;
import ua.service.UserService;

@Controller
@SessionAttributes(names="costumer")
@RequestMapping("/")
public class CostumerController {
	
	@Autowired
	UserService userService;
	
	@SuppressWarnings("unused")
	private UserController userController;
	
	@InitBinder
	  private void dateBinder(WebDataBinder binder) {
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	      binder.registerCustomEditor(Date.class, editor); 
	  }
	
	@ModelAttribute("user")
	public User getForm(){
		return new User();
	}
	
	@RequestMapping("/login")
	public String login(Model model){	
		return "user-login";
	}
	@RequestMapping()
	public String main(Model model,Principal principal){	
		if (principal!=null) {
			return"redirect:/user/"+principal.getName();	
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){	
		return "user-registration";
	}
	
	
	@RequestMapping(value="/registration", method=POST)
	public String registration(@ModelAttribute("user") @Valid User user, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){	
			return "user-registration";
		}
		userService.save(user);
		status.setComplete();
		return "redirect:/login";
	}
}
