package com.springinaction.chapter5.spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springinaction.chapter5.spittr.data.SpitterRepository;
import com.springinaction.chapter5.spittr.entity.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	
	public SpitterController() {
		super();
	}
	@Autowired
	public SpitterController(SpitterRepository repository) {
		spitterRepository = repository;
	}
	
	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
//	@RequestMapping(value="/register", method=POST)
//	public String processRegistration(Spitter spitter){
//		spitterRepository.save(spitter);
//		return "redirect:/spitter/"+spitter.getUsername();
//	}
	
	@RequestMapping(value="/{username}", method=GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors){//启用校验
		if(errors.hasErrors()) {
			return "registerForm";
		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
}
