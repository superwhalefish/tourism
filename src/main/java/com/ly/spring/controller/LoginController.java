package com.ly.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.spring.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("toLgin")
	public Integer toLogin(String usr, String pwd) {

		return loginService.tologin(usr, pwd);
	}

}
