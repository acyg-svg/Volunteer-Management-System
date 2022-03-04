package com.dao;

import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.zzk.bean.User;

public interface UserMapperAnnotation {

	@Select("select * from tb_user where username=#{name}")
	public User userLogin(User user);

	@Insert("insert into tb_user(username,password) values(#{name},#{pwd})")
	public int insertUser(User user);

	@Update("update tb_user set password=#{password} where username=#{username}")
	public int updateUser(Map<String, Object> map);

}
