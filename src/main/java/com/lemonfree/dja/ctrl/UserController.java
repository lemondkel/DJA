package com.lemonfree.dja.ctrl;

import com.lemonfree.dja.service.StatisticService;
import com.lemonfree.dja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	private final StatisticService statisticService;

	@Autowired
	public UserController(UserService userService, StatisticService statisticService) {
		this.userService = userService;
		this.statisticService = statisticService;
	}

	/**
	 * 사용자 RANK
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
