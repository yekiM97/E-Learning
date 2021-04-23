package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDTO;
import com.myclass.entity.Course;
import com.myclass.entity.Video;
import com.myclass.repository.IVideoRepository;
import com.myclass.service.IVideoService;

@Service
@Transactional(rollbackOn = Exception.class)

public class VideoServiceImpl implements IVideoService {
	@Autowired
	private IVideoRepository iVideoRepository;

	@Override
	public List<VideoDTO> getListVideo() {
		// TODO Auto-generated method stub
		List<Video> list = iVideoRepository.findAll();
		List<VideoDTO> listDTO = new LinkedList<VideoDTO>();
		try {

			for (Video video : list) {
				Course course = video.getVideo_course();
				VideoDTO dto = new VideoDTO(video.getId(), video.getTitle(), video.getUrl(), video.getTime_count(),
						course.getId());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<VideoDTO> getListVideoByCourseID(int courseId) {
		// TODO Auto-generated method stub
		List<Video> list = iVideoRepository.findByCourseID(courseId);
		List<VideoDTO> listDTO = new LinkedList<VideoDTO>();
		try {
			for (Video video : list) {
				VideoDTO dto = new VideoDTO(video.getId(), video.getTitle(), video.getUrl(), video.getTime_count(),
						video.getCourse_id());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public VideoDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			Video video = iVideoRepository.findById(id).get();
			return new VideoDTO(video.getId(), video.getTitle(), video.getUrl(), video.getTime_count(),
					video.getCourse_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public VideoDTO add(VideoDTO dto) {
		// TODO Auto-generated method stub
		try {

			Video video = new Video();
			video.setId(dto.getId());
			video.setTitle(dto.getTitle());
			video.setUrl(dto.getUrl());
			video.setTime_count(dto.getTime_count());
			video.setCourse_id(dto.getCourse_id());
			iVideoRepository.save(video);
			return this.findByID(video.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public VideoDTO edit(VideoDTO dto) {
		// TODO Auto-generated method stub
		try {

			Video video = iVideoRepository.findById(dto.getId()).get();
			if (video != null) {
				video.setTitle(dto.getTitle());
				video.setUrl(dto.getUrl());
				video.setTime_count(dto.getTime_count());
				video.setCourse_id(dto.getCourse_id());
				iVideoRepository.save(video);
			}
			return this.findByID(video.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {

			iVideoRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
