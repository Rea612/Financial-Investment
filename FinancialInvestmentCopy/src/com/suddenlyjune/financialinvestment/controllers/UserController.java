package com.suddenlyjune.financialinvestment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suddenlyjune.financialinvestment.dao.User;
import com.suddenlyjune.financialinvestment.service.UsersService;

@Controller
public class UserController {
	private UsersService usersService;
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	//@RequestMapping("/")
	//one way to communicate between controller and jsp: HttpSession
/*	public String showHome(HttpSession session){
	session.setAttribute("name", "Summer");
		return "home";(in jsp file, use session.getattribute to retrieve data and show it in the Internet)
	}*/
	//another way to retrieve data from controller:ModelAndView
	/*public ModelAndView showHome(){
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		model.put("name", "River");
		return mv; // in jsp file, use request.getattribute to retrieve data and show it in the Internet.
	}
	*/
	
	
	@RequestMapping("/createuser")
	public String createOffers(Model model){
		model.addAttribute("user", new User());
		return "createuser";
	}
	
	@RequestMapping(value="/docreate", method = RequestMethod.POST)
	public String doCreate(@Valid User user, BindingResult result){
		
		if (result.hasErrors()) {
//			System.out.println("Form does not validate.");
//			List<ObjectError> errors = result.getAllErrors();
//			for (ObjectError error: errors){
//				System.out.println(error.getDefaultMessage());
//			}
			return "createuser";
		} 
		usersService.create(user);
		return "usercreated";
	}
	
//	//in case of database down, put error handler to avoid bad customer experience. Using annotation to 
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseException(DataAccessException ex){
//		return "error";
//	}

	
		
}
