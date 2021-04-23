package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDTO;
import com.myclass.entity.Role;
import com.myclass.repository.IRoleRepository;
import com.myclass.service.IRoleService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RoleServieImpl implements IRoleService {
	@Autowired
	private IRoleRepository iRoleRepository;

	@Override
	public List<RoleDTO> getListRole() {
		// TODO Auto-generated method stub
		List<Role> list = iRoleRepository.findAll();
		List<RoleDTO> listDTO = new LinkedList<RoleDTO>();
		for (Role role : list) {
			RoleDTO dto = new RoleDTO(role.getId(), role.getName(), role.getDescription());
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public RoleDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			Role role = iRoleRepository.findById(id).get();
			return new RoleDTO(role.getId(), role.getName(), role.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public RoleDTO add(RoleDTO dto) {
		// TODO Auto-generated method stub
		try {

			Role role = new Role();
			role.setId(dto.getId());
			role.setName(dto.getName());
			role.setDescription(dto.getDescription());
			iRoleRepository.save(role);
			return this.findByID(role.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RoleDTO edit(RoleDTO dto) {
		// TODO Auto-generated method stub
		try {

			Role role = iRoleRepository.findById(dto.getId()).get();
			if (role != null) {
				role.setName(dto.getName());
				role.setDescription(dto.getDescription());
				iRoleRepository.save(role);

			}
			return this.findByID(role.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {

			iRoleRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
