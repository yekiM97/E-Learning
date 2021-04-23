package com.myclass.service;

import java.util.List;

import com.myclass.dto.TargetDTO;

public interface ITargetService {
	List<TargetDTO> getListTarget();

	TargetDTO add(TargetDTO dto);

	TargetDTO edit(TargetDTO dto);

	TargetDTO findByID(int id);
	
	List<TargetDTO> findTargetByCourseID(int id);

	int delete(int id);
}
