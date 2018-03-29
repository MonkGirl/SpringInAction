/**
 * 
 */
package com.springinaction.chapter5.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MonkGirl
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}
