package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDTO;
import com.myclass.entity.Course;
import com.myclass.entity.Target;
import com.myclass.repository.ITargetRepository;
import com.myclass.service.ITargetService;

@Service
@Transactional(rollbackOn = Exception.class)

public class TargetServiceImpl implements ITargetService {
	@Autowired
	private ITargetRepository iTargetRepository;

	@Override
	public List<TargetDTO> getListTarget() {
		// TODO Auto-generated method stub
		List<Target> list = iTargetRepository.findAll();
		List<TargetDTO> listDTO = new LinkedList<TargetDTO>();
		try {

			for (Target target : list) {
				Course course = target.getTarget_course();
				TargetDTO dto = new TargetDTO(target.getId(), target.getTitle(), course.getId());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TargetDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			Target target = iTargetRepository.findById(id).get();
			return new TargetDTO(target.getId(), target.getTitle(), target.getCourse_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public TargetDTO add(TargetDTO dto) {
		// TODO Auto-generated method stub
		try {

			Target target = new Target();
			target.setId(dto.getId());
			target.setTitle(dto.getTitle());
			target.setCourse_id(dto.getCourse_id());
			iTargetRepository.save(target);
			
			return this.findByID(target.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TargetDTO edit(TargetDTO dto) {
		// TODO Auto-generated method stub
		try {

			Target target = iTargetRepository.findById(dto.getId()).get();
			if (target != null) {
				target.setTitle(dto.getTitle());
				target.setCourse_id(dto.getCourse_id());
				iTargetRepository.save(target);
			}
			return this.findByID(target.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {

			iTargetRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TargetDTO> findTargetByCourseID(int id) {
		// TODO Auto-generated method stub
		try {

			List<Target> target = iTargetRepository.findTargetByCourseID(id);
			List<TargetDTO> listDto = new LinkedList<TargetDTO>();
			
			for (Target targetDTO : target) {
				TargetDTO dto = new TargetDTO(targetDTO.getId(), targetDTO.getTitle(), targetDTO.getCourse_id());
				listDto.add(dto);
			}
			return listDto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
