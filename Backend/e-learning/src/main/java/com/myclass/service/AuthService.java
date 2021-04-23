package com.myclass.service;

import com.myclass.dto.login.LoginDTO;

public interface AuthService {
	LoginDTO login(LoginDTO dto);
}
