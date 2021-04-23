package com.myclass.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.login.LoginDTO;
import com.myclass.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/admin")
public class AdminLoginController {
	@Autowired
	private AuthService authService;

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
