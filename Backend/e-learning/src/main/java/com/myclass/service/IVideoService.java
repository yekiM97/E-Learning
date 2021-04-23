package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDTO;

public interface IVideoService {
	List<VideoDTO> getListVideo();
	
	List<VideoDTO> getListVideoByCourseID(int courseId);

	VideoDTO add(VideoDTO dto);

	VideoDTO edit(VideoDTO dto);

	VideoDTO findByID(int id);

	int delete(int id);
}
