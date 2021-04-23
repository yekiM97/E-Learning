package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDTO;

public interface IUserService {
	List<UserDTO> getListUser();

	UserDTO add(UserDTO dto);

	UserDTO edit(UserDTO dto);
	
	UserDTO editPassword(UserDTO dto);

	UserDTO findByID(int id);
	
	UserDTO findByEmail(UserDTO dto);

	int delete(int id);
	
	UserDTO getProfile();
}
