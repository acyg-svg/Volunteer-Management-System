package com.dao;

import java.util.Map;

import com.zzk.bean.User;

public interface UserMapper {

	public User userLogin(User user);

	public int insertUser(User user);

	public int updateUser(Map<String, Object> map);

}
