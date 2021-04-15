package com.lemonfree.dja.ctrl;

import com.lemonfree.dja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 사용자 PUT
	 *
	 * @return ModelAndView
	 * @author l2jong
	 * @since 2021-04-15
	 */
	@GetMapping(value = "/rank")
	public ModelAndView rank() {
		ModelAndView mav = new ModelAndView("user/rank");

		return mav;
	}
}
