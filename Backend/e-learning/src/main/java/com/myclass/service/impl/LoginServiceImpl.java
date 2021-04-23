package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.login.UserDetailsDTO;
import com.myclass.entity.User;
import com.myclass.repository.IUserRepository;

@Service

public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// gọi hàm kiểm tra email
		User user = iUserRepository.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("Email không tồn tại");

		List<GrantedAuthority> listGrant = new LinkedList<GrantedAuthority>();
		String roleName = user.getRole().getName();
		listGrant.add(new SimpleGrantedAuthority(roleName));

		UserDetails userDetails = new UserDetailsDTO(user.getEmail(), user.getPassword(), listGrant);
		// return về đối tượng có kiểu dữ liệu là UserDetails
		return userDetails;
	}

}
