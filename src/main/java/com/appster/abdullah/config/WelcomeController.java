package com.appster.abdullah.config;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private static final Logger LOG = Logger.getLogger(WelcomeController.class);

	@Autowired
	public WelcomeController() {
		
	}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
	    LOG.info("Home page accessed.");
		model.put("message", "User name : " + " null as of now!");
		return "welcome";
	}

}