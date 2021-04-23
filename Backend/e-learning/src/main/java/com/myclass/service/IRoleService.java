package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDTO;

public interface IRoleService {
	List<RoleDTO> getListRole();

	RoleDTO add(RoleDTO dto);

	RoleDTO edit(RoleDTO dto);

	RoleDTO findByID(int id);

	int delete(int id);

}
