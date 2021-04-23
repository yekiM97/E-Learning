package com.myclass.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.myclass.service.impl.LoginServiceImpl;

import io.jsonwebtoken.Jwts;

public class AuthFilter extends BasicAuthenticationFilter {
	private LoginServiceImpl loginServiceImpl;

	public AuthFilter(AuthenticationManager authenticationManager, LoginServiceImpl loginServiceImpl) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
		this.loginServiceImpl = loginServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String authorizationHeader = request.getHeader("Authorization");
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			
			// thay thế Bearer bằng "" đế lấy chuỗi token chính xác
			String token = authorizationHeader.replace("Bearer ", "");
			
			// Gaiari mã token lấy email
			String email = Jwts.parser().setSigningKey("MINH").parseClaimsJws(token).getBody().getSubject();

			// lấy thông tin user từ database
			UserDetails userDetails = this.loginServiceImpl.loadUserByUsername(email);

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		chain.doFilter(request, response);
	}
}
