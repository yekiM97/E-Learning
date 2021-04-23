package com.myclass.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.myclass.dto.login.LoginDTO;
import com.myclass.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public LoginDTO login(LoginDTO dto) {
		Date now = new Date();

		Authentication authentication = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

		authenticationManager.authenticate(authentication);

		String token = Jwts.builder().setSubject(dto.getEmail()).setIssuedAt(now)
				.setExpiration(
						new Date(now.getTime() + 300)).signWith(SignatureAlgorithm.HS256, "MINH")
				.compact();
		
		dto.setToken(token);
		return dto;
	}

}
