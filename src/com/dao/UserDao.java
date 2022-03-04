package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tool.SaveUserStateTool;
import com.zzk.bean.User;

public class UserDao {

	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static boolean userLogin(User user) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User u = mapper.userLogin(user);

		if (u == null) {
			JOptionPane.showMessageDialog(null, "用户名不存在。");
			return false; 
		}
		if (u.getPwd().trim().equals(user.getPwd().trim())) {
			SaveUserStateTool.setUsername(user.getName().trim());
			SaveUserStateTool.setPassword(user.getPwd().trim());
			openSession.close();
			return true; 
		} else {
			JOptionPane.showMessageDialog(null, "密码不正确。");
			return false; 
		}
	}

	public static void insertUser(User user) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = openSession.getMapper(UserMapper.class);

		String username = user.getName();
		String pwd = user.getPwd();
		String okPwd = user.getOkPwd();
		if (username == null || username.trim().equals("") || pwd == null || pwd.trim().equals("") || okPwd == null
				|| okPwd.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空。");
			return;
		}
		if (!pwd.trim().equals(okPwd.trim())) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
			return;
		}
		User u = new User(username, pwd);
		int flag = mapper.insertUser(u);
		if (flag > 0) {
			openSession.close();
			JOptionPane.showMessageDialog(null, "添加成功。");
		} else {
			JOptionPane.showMessageDialog(null, "添加失败。");
		}
	}

	public static void updateUser(String oldPwd, String newPwd, String okPwd) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = openSession.getMapper(UserMapper.class);

		if (!newPwd.trim().equals(okPwd.trim())) {
			JOptionPane.showMessageDialog(null, "两次输入的密码不一致。");
			return;
		}
		if (!oldPwd.trim().equals(SaveUserStateTool.getPassword())) {
			JOptionPane.showMessageDialog(null, "原密码不正确。");
			return;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("password", newPwd.trim());
		map.put("username", SaveUserStateTool.getUsername());
		int flag = mapper.updateUser(map);
		if (flag > 0) {
			openSession.close();
			JOptionPane.showMessageDialog(null, "修改成功。");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败。");
		}
	}

}
