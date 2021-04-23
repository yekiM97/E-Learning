package com.myclass.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.config.ApiConfig;
import com.myclass.dto.RoleDTO;
import com.myclass.service.IRoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.ADMIN_ROLE)
public class AdminRoleController {

	@Autowired
	private IRoleService iRoleService;

	@RequestMapping(value = "getListRole", method = RequestMethod.POST)
	public ResponseEntity<List<RoleDTO>> getListCourse() {
		try {
			
			List<RoleDTO> listRole = iRoleService.getListRole();
			return new ResponseEntity<List<RoleDTO>>(listRole, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<RoleDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addRole", method = RequestMethod.POST)
	public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO dto) {
		try {

			return new ResponseEntity<RoleDTO>(iRoleService.add(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<RoleDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editRole", method = RequestMethod.POST)
	public ResponseEntity<RoleDTO> editRole(@RequestBody RoleDTO dto) {
		try {

			return new ResponseEntity<RoleDTO>(iRoleService.edit(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<RoleDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "findRoleByID", method = RequestMethod.POST)
	public ResponseEntity<RoleDTO> findRoleByID(@RequestBody RoleDTO dto) {
		try {

			return new ResponseEntity<RoleDTO>(iRoleService.findByID(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<RoleDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteRole", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteRole(@RequestBody RoleDTO dto) {
		try {
			
			return new ResponseEntity<Integer>(iRoleService.delete(dto.getId()),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
