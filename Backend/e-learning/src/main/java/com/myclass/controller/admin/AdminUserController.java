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
import com.myclass.dto.UserDTO;
import com.myclass.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.ADMIN_USER)
public class AdminUserController {
	@Autowired
	private IUserService iUserService;

	@RequestMapping(value = "getListUser", method = RequestMethod.POST)
	public ResponseEntity<List<UserDTO>> getListUser() {
		try {
			List<UserDTO> listUser = iUserService.getListUser();
			return new ResponseEntity<List<UserDTO>>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO dto) {
		try {
			
			return new ResponseEntity<UserDTO>(iUserService.add(dto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO dto) {
		try {
			
			return new ResponseEntity<UserDTO>(iUserService.edit(dto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "findUserByID", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> findUserByID(@RequestBody UserDTO dto) {
		try {
			
			return new ResponseEntity<UserDTO>(iUserService.findByID(dto.getId()),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteUser(@RequestBody UserDTO dto) {
		try {
			
			return new ResponseEntity<Integer>(iUserService.delete(dto.getId()),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
