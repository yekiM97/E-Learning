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
import com.myclass.dto.TargetDTO;
import com.myclass.service.ITargetService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.ADMIN_TARGET)
public class AdminTargetController {
	@Autowired
	private ITargetService iTargetService;

	@RequestMapping(value = "getListTarget", method = RequestMethod.POST)
	public ResponseEntity<List<TargetDTO>> getListTarget() {
		try {
			List<TargetDTO> listTarget = iTargetService.getListTarget();
			return new ResponseEntity<List<TargetDTO>>(listTarget, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<TargetDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addTarget", method = RequestMethod.POST)
	public ResponseEntity<TargetDTO> addTarget(@RequestBody TargetDTO dto) {
		try {
			
			return new ResponseEntity<TargetDTO>(iTargetService.add(dto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<TargetDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editTarget", method = RequestMethod.POST)
	public ResponseEntity<TargetDTO> editTarget(@RequestBody TargetDTO dto) {
		try {
			
			return new ResponseEntity<TargetDTO>(iTargetService.edit(dto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<TargetDTO>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "findTargetByID", method = RequestMethod.POST)
	public ResponseEntity<TargetDTO> findTargetByID(@RequestBody TargetDTO dto) {
		try {
			
			return new ResponseEntity<TargetDTO>(iTargetService.findByID(dto.getId()),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<TargetDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteTarget", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteTarget(@RequestBody TargetDTO dto) {
		try {
			
			return new ResponseEntity<Integer>(iTargetService.delete(dto.getId()),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
