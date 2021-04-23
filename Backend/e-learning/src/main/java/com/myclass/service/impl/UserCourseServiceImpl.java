package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.User_CourseDTO;
import com.myclass.entity.Course;
import com.myclass.entity.User;
import com.myclass.entity.User_Course;
import com.myclass.repository.IUserCourseRepository;
import com.myclass.service.IUserCourseService;

@Service
@Transactional(rollbackOn = Exception.class)

public class UserCourseServiceImpl implements IUserCourseService {
	@Autowired
	private IUserCourseRepository iUserCourseRepository;

	@Override
	public List<User_CourseDTO> getListUserCourse() {
		// TODO Auto-generated method stub
		List<User_Course> list = iUserCourseRepository.findAll();
		List<User_CourseDTO> listDTO = new LinkedList<User_CourseDTO>();
		try {

			for (User_Course userCourse : list) {

				Course course = userCourse.getUser_course();
				User user = userCourse.getUsers();
				User_CourseDTO dto = new User_CourseDTO(userCourse.getId(), user.getRole_id(), user.getId(),
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
	public User_CourseDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			User_Course userCourse = iUserCourseRepository.findById(id).get();
			return new User_CourseDTO(userCourse.getId(), userCourse.getRole_id(), userCourse.getUser_id(),
					userCourse.getCourse_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public User_CourseDTO add(User_CourseDTO dto) {
		// TODO Auto-generated method stub

		try {
			List<User_CourseDTO> listUserCourseDTO = this.findByUserID(dto.getUser_id());
			User_Course userCourse = new User_Course();

			for (User_CourseDTO user_CourseDTO : listUserCourseDTO) {
				if (dto.getCourse_id() == user_CourseDTO.getCourse_id()) {
					throw new Exception("Lỗi 1 người không được đăng ký 1 khóa học quá 2 lần");
				}
			}
			userCourse.setId(dto.getId());
			userCourse.setRole_id(dto.getRole_id());
			userCourse.setUser_id(dto.getUser_id());
			userCourse.setCourse_id(dto.getCourse_id());
			iUserCourseRepository.save(userCourse);
			return this.findByID(userCourse.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User_CourseDTO edit(User_CourseDTO dto) {
		// TODO Auto-generated method stub
		try {

			User_Course userCourse = iUserCourseRepository.findById(dto.getId()).get();
			if (userCourse != null) {
				userCourse.setRole_id(dto.getRole_id());
				userCourse.setUser_id(dto.getUser_id());
				userCourse.setCourse_id(dto.getCourse_id());
				iUserCourseRepository.save(userCourse);
			}

			return this.findByID(userCourse.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public User_CourseDTO findUserCourseByCourseID(User_CourseDTO dto) {
		// TODO Auto-generated method stub
		try {
			List<User_CourseDTO> listUserCourseDTO = this.findByCourseID(dto.getCourse_id(), dto.getUser_id());
			List<User_CourseDTO> listUserCourse = this.getListUserCourse();

			for (User_CourseDTO user_CourseDTO : listUserCourseDTO) {
				for (User_CourseDTO user_CourseDTO2 : listUserCourse) {
					if ((user_CourseDTO.getCourse_id() == user_CourseDTO2.getCourse_id()) && (user_CourseDTO.getUser_id() == user_CourseDTO2.getUser_id())) {
						return user_CourseDTO;
					}	
				}
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

			iUserCourseRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User_CourseDTO> findByUserID(int id) {
		// TODO Auto-generated method stub
		List<User_Course> userCourse = iUserCourseRepository.findByUserID(id);
		List<User_CourseDTO> listDTO = new LinkedList<User_CourseDTO>();

		try {

			for (User_Course user_Course : userCourse) {
				User_CourseDTO dto = new User_CourseDTO(user_Course.getId(), user_Course.getRole_id(),
						user_Course.getUser_id(), user_Course.getCourse_id());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User_CourseDTO> findByCourseID(int courseId, int userId) {
		// TODO Auto-generated method stub
		List<User_Course> userCourse = iUserCourseRepository.findByCourseID(courseId, userId);
		List<User_CourseDTO> listDTO = new LinkedList<User_CourseDTO>();

		try {
			for (User_Course user_Course : userCourse) {
				User_CourseDTO dto = new User_CourseDTO(user_Course.getId(), user_Course.getRole_id(),
						user_Course.getUser_id(), user_Course.getCourse_id());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
