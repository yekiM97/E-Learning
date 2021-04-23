package com.myclass.controller;

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
import com.myclass.dto.VideoDTO;
import com.myclass.service.IVideoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ApiConfig.VIDEO)
public class VideoController {
	@Autowired
	private IVideoService iVideoService;

	@RequestMapping(value = "getListVideo", method = RequestMethod.POST)
	public ResponseEntity<List<VideoDTO>> getListVideo() {
		try {
			List<VideoDTO> listVideo = iVideoService.getListVideo();
			return new ResponseEntity<List<VideoDTO>>(listVideo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<VideoDTO>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "addVideo", method = RequestMethod.POST)
	public Object addVideo(@RequestBody VideoDTO dto) {
		try {

			return new ResponseEntity<VideoDTO>(iVideoService.add(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<VideoDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "editVideo", method = RequestMethod.POST)
	public ResponseEntity<VideoDTO> editVideo(@RequestBody VideoDTO dto) {
		try {

			return new ResponseEntity<VideoDTO>(iVideoService.edit(dto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<VideoDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "getListVideoByCourseID", method = RequestMethod.POST)
	public ResponseEntity<List<VideoDTO>> getListVideoByCourseID(@RequestBody VideoDTO dto) {
		try {

			return new ResponseEntity<List<VideoDTO>>(iVideoService.getListVideoByCourseID(dto.getCourse_id()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<List<VideoDTO>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "findVideoByID", method = RequestMethod.POST)
	public ResponseEntity<VideoDTO> findVideoByID(@RequestBody VideoDTO dto) {
		try {

			return new ResponseEntity<VideoDTO>(iVideoService.findByID(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<VideoDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteVideo", method = RequestMethod.POST)
	public ResponseEntity<Integer> deleteVideo(@RequestBody VideoDTO dto) {
		try {

			return new ResponseEntity<Integer>(iVideoService.delete(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
	}
}
