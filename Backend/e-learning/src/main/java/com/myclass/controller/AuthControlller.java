package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.config.ApiConfig;
import com.myclass.dto.UserDTO;
import com.myclass.dto.login.LoginDTO;
import com.myclass.service.AuthService;
import com.myclass.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.LOGIN)
public class AuthControlller {

	@Autowired
	private IUserService iUserSerivce;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Object register(@RequestBody UserDTO dto) {
		try {
			return new ResponseEntity<Object>(iUserSerivce.add(dto), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<LoginDTO> post(@RequestBody LoginDTO dto) {
		try {
			return new ResponseEntity<LoginDTO>(authService.login(dto), HttpStatus.OK);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			return new ResponseEntity<LoginDTO>(HttpStatus.BAD_REQUEST);
		}
	}
}
