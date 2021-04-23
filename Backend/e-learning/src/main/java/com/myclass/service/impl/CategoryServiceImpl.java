package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDTO;
import com.myclass.entity.Category;
import com.myclass.repository.ICategoryRepository;
import com.myclass.service.ICategoryService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository iCategoryRepository;

	@Override
	public List<CategoryDTO> getListCategory() {
		// TODO Auto-generated method stub
		try {

			List<Category> list = iCategoryRepository.findAll();
			List<CategoryDTO> listDTO = new LinkedList<CategoryDTO>();
			for (Category category : list) {
				CategoryDTO dto = new CategoryDTO(category.getId(), category.getName(), category.getIcon());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryDTO> getListCategoryByID(int id) {
		// TODO Auto-generated method stub
		try {

			List<Category> list = iCategoryRepository.findAll();
			List<CategoryDTO> listDTO = new LinkedList<CategoryDTO>();
			for (Category category : list) {
				if (category.getId() == id) {

					CategoryDTO dto = new CategoryDTO(category.getId(), category.getName(), category.getIcon());
					listDTO.add(dto);
				}
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			Category cate = iCategoryRepository.findById(id).get();
			return new CategoryDTO(cate.getId(), cate.getName(), cate.getIcon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public CategoryDTO add(CategoryDTO dto) {
		// TODO Auto-generated method stub
		try {

			Category cate = new Category();
			cate.setId(dto.getId());
			cate.setName(dto.getName());
			cate.setIcon(dto.getIcon());
			iCategoryRepository.save(cate);
			return this.findByID(cate.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CategoryDTO edit(CategoryDTO dto) {
		// TODO Auto-generated method stub
		try {

			Category cate = iCategoryRepository.findById(dto.getId()).get();
			if (cate != null) {
				cate.setName(dto.getName());
				cate.setIcon(dto.getIcon());
				iCategoryRepository.save(cate);

			}
			return this.findByID(cate.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {

			iCategoryRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
