package com.andresdlrg.livechat.controller;

import java.io.IOException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.HtmlUtils;

import com.andresdlrg.livechat.dto.UserRegisterDto;
import com.andresdlrg.livechat.model.Greeting;
import com.andresdlrg.livechat.model.HelloMessage;
import com.andresdlrg.livechat.model.SystemUser;
import com.andresdlrg.livechat.service.SystemUserService;

@Controller
public class LoginController {

	private static final String LOGIN_PAGE = "login";
	private static final String REGISTER_PAGE = "register";
	private static final String HOME_PAGE = "home";

	@Autowired
	private SystemUserService systemUserService;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginPage() {
		return LOGIN_PAGE;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String regsterPage() {
		return REGISTER_PAGE;
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage() {
		return HOME_PAGE;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signUp(Model model, @Valid @ModelAttribute("registerForm") UserRegisterDto dto,
			BindingResult result) throws IOException {

		if (result.hasErrors()) {
			model.addAttribute("error", result.getFieldError());
			return REGISTER_PAGE;
		}
		
		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			model.addAttribute("error", "password must match");
			return REGISTER_PAGE;
		}
		
		SystemUser user = SystemUser.builder()
				.username(dto.getUsername())
				.password(dto.getPassword())
				.joinDate(new Date())
				.build();
		
		systemUserService.createSystemUser(user);

		return "redirect:/login";
	}

}
