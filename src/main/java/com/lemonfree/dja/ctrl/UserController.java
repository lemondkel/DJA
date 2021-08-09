package com.lemonfree.dja.ctrl;

import com.lemonfree.dja.entity.Statistic;
import com.lemonfree.dja.service.StatisticService;
import com.lemonfree.dja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * user rank page
 *
 * @author leedujong
 * @since 2021-04-24
 */
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

		List<Statistic> statisticList = statisticService.findAll();
		String names = userService.getNames();

		mav.addObject("statisticList", statisticList);
		mav.addObject("names", names);

		return mav;
	}
}
