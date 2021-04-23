package com.myclass.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDTO;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.IUserRepository;
import com.myclass.service.IUserService;

@Service
@Transactional(rollbackOn = Exception.class)

public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public List<UserDTO> getListUser() {
		// TODO Auto-generated method stub
		List<User> list = iUserRepository.findAll();
		List<UserDTO> listDTO = new LinkedList<UserDTO>();
		try {

			for (User user : list) {
				Role role = user.getRole();
				UserDTO dto = new UserDTO(user.getId(), user.getEmail(), user.getFullname(), user.getPassword(),
						user.getAvatar(), user.getPhone(), user.getAddress(), role.getId());
				listDTO.add(dto);
			}
			return listDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDTO findByID(int id) {
		// TODO Auto-generated method stub
		try {

			User user = iUserRepository.findById(id).get();
			return new UserDTO(user.getId(), user.getEmail(), user.getFullname(), user.getPassword(), user.getAvatar(),
					user.getPhone(), user.getAddress(), user.getRole_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public UserDTO add(UserDTO dto) {
		// TODO Auto-generated method stub
		String avatarEdit = dto.getAvatar().replace("C:\\fakepath\\", "");
		String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());

		User existUser = iUserRepository.findByEmail(dto.getEmail());
		if (existUser == null) {
			try {
				User user = new User();
				user.setId(dto.getId());
				user.setEmail(dto.getEmail());
				user.setFullname(dto.getFullname());
				user.setPassword(hashed);
				user.setAvatar(avatarEdit);
				user.setPhone(dto.getPhone());
				user.setAddress(dto.getAddress());
				user.setRole_id(dto.getRole_id());
				iUserRepository.save(user);

				return this.findByID(user.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public UserDTO edit(UserDTO dto) {
		// TODO Auto-generated method stub
		String avatarEdit = dto.getAvatar().replace("C:\\fakepath\\", "");
		try {
			User user = iUserRepository.findById(dto.getId()).get();

			user.setEmail(dto.getEmail());
			user.setFullname(dto.getFullname());
			user.setAvatar(avatarEdit);
			user.setPhone(dto.getPhone());
			user.setAddress(dto.getAddress());
			user.setRole_id(dto.getRole_id());
			iUserRepository.save(user);

			return this.findByID(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {

			iUserRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UserDTO getProfile() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String email = userDetails.getUsername();
		User user = iUserRepository.findByEmail(email);
		return new UserDTO(user.getId(), user.getEmail(), user.getFullname(), user.getAvatar(), user.getPhone(),
				user.getAddress(), user.getRole_id());
	}

	@Override
	public UserDTO findByEmail(UserDTO dto) {
		// TODO Auto-generated method stub
		try {
			User user = iUserRepository.findByEmail(dto.getEmail());
			return new UserDTO(user.getId(), user.getEmail(), user.getFullname(), user.getPassword(), user.getAvatar(),
					user.getPhone(), user.getAddress(), user.getRole_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public UserDTO editPassword(UserDTO dto) {
		// TODO Auto-generated method stub
		try {
			User user = iUserRepository.findByEmail(dto.getEmail());
			if (BCrypt.checkpw(dto.getPassword(), user.getPassword())) {
				throw new Exception("Password cũ và mới không được trùng nhau");

			} else {
				String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
				user.setPassword(hashed);
				iUserRepository.save(user);

				return this.findByID(user.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
