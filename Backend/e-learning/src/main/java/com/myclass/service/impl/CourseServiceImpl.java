package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDTO;
import com.myclass.entity.Category;
import com.myclass.entity.Course;
import com.myclass.entity.User_Course;
import com.myclass.repository.ICourseRepository;
import com.myclass.repository.IUserCourseRepository;
import com.myclass.service.ICourseService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepository iCourseRepository;
	
	@Autowired
	private IUserCourseRepository iUserCourseRepository;

	@Override
	public List<CourseDTO> getListCourse() {
		// TODO Auto-generated method stub
		List<Course> list = iCourseRepository.findAll();
		List<CourseDTO> listDTO = new LinkedList<CourseDTO>();
		try {
			for (Course course : list) {
				Category cate = course.getCategory();
				CourseDTO dto = new CourseDTO(course.getId(), course.getTitle(), course.getDescription(),
						course.getContent(), course.getImage(), course.getLeture_count(), course.getHour_count(),
						course.getView_count(), course.getPrice(), course.getDiscount(), course.getPromotion_price(),
						course.getLast_update(), course.getAuthor(), course.getPosition(), cate.getId());
				listDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDTO;
	}

	@Override
	public List<CourseDTO> getListCourseByID(int id) {
		// TODO Auto-generated method stub
		List<User_Course> ListUserCourse = iUserCourseRepository.findByUserID(id);
		List<Course> list = iCourseRepository.findAll();
		List<CourseDTO> listDTO = new LinkedList<CourseDTO>();
		try {
			for (Course course : list) {
				for (User_Course userCourse : ListUserCourse)
				if (course.getId() == userCourse.getCourse_id()) {

					Category cate = course.getCategory();
					CourseDTO dto = new CourseDTO(course.getId(), course.getTitle(), course.getDescription(),
							course.getContent(), course.getImage(), course.getLeture_count(), course.getHour_count(),
							course.getView_count(), course.getPrice(), course.getDiscount(),
							course.getPromotion_price(), course.getLast_update(), course.getAuthor(),
							course.getPosition(), cate.getId());
					listDTO.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDTO;
	}

	@Override
	public CourseDTO findByID(int id) {
		// TODO Auto-generated method stub
		Course course = iCourseRepository.findById(id).get();
		return new CourseDTO(course.getId(), course.getTitle(), course.getDescription(), course.getContent(),
				course.getImage(), course.getLeture_count(), course.getHour_count(), course.getView_count(),
				course.getPrice(), course.getDiscount(), course.getPromotion_price(), course.getLast_update(),
				course.getAuthor(), course.getPosition(), course.getCate_id());

	}

	@Override
	public CourseDTO add(CourseDTO dto) {
		// TODO Auto-generated method stub
		try {
			Course course = new Course();
			course.setId(dto.getId());
			course.setTitle(dto.getTitle());
			course.setContent(dto.getContent());
			course.setDescription(dto.getDescription());
			course.setImage(dto.getImage());
			course.setLeture_count(dto.getLeture_count());
			course.setHour_count(dto.getHour_count());
			course.setView_count(dto.getView_count());
			course.setPrice(dto.getPrice());
			course.setDiscount(dto.getDiscount());
			course.setPromotion_price(dto.getPromotion_price());
			course.setLast_update(dto.getLast_update());
			course.setAuthor(dto.getAuthor());
			course.setPosition(dto.getPosition());
			course.setCate_id(dto.getCate_id());
			iCourseRepository.save(course);

			return this.findByID(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CourseDTO edit(CourseDTO dto) {
		// TODO Auto-generated method stub
		try {

			Course course = iCourseRepository.findById(dto.getId()).get();
			if (course != null) {
				course.setTitle(dto.getTitle());
				course.setContent(dto.getContent());
				course.setDescription(dto.getDescription());
				course.setImage(dto.getImage());
				course.setLeture_count(dto.getLeture_count());
				course.setHour_count(dto.getHour_count());
				course.setView_count(dto.getView_count());
				course.setPrice(dto.getPrice());
				course.setDiscount(dto.getDiscount());
				course.setPromotion_price(dto.getPromotion_price());
				course.setLast_update(dto.getLast_update());
				course.setAuthor(dto.getAuthor());
				course.setPosition(dto.getPosition());
				course.setCate_id(dto.getCate_id());
				iCourseRepository.save(course);

				return this.findByID(course.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {
			iCourseRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
