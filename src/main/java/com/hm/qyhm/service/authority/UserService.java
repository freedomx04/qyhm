package com.hm.qyhm.service.authority;

import java.util.List;

import com.hm.qyhm.entity.authority.UserEntity;

public interface UserService {
	
	UserEntity findOne(Long userId);
	
	UserEntity findByUsername(String username);
	
	void save(UserEntity user);
	
	List<UserEntity> list();
	
	void delete(Long userId);
	
	void delete(List<Long> userIds);

}
