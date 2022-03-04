package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zzk.bean.ExpressMessage;


public class ahiyuanzheMessageDao {

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

	public static void insertExpress(zhiyuanzheMessage m) {
		// 信息为空(两种情况,一是为null,另一种是空串)校验
		if (m.getSendName() == null || m.getSendName().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "志愿者信息必须填写。");
			return;
		}
		if (m.getSendTelephone() == null || m.getSendTelephone().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "志愿者信息必须填写。");
			return;
		}
		if (m.getSendCompary() == null || m.getSendCompary().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "志愿者信息必须填写。");
			return;
		}
		if (m.getSendAddress() == null || m.getSendAddress().trim().equals("||")) {
			JOptionPane.showMessageDialog(null, "志愿者信息必须填写。");
			return;
		}
		if (m.getSendPostcode() == null || m.getSendPostcode().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "志愿者信息必须填写。");
			return;
		}

		if (m.getReceiveName() == null || m.getReceiveName().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "队长信息必须填写。");
			return;
		}
		if (m.getReceiveTelephone() == null || m.getReceiveTelephone().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "队长信息必须填写。");
			return;
		}
		if (m.getReceiveCompary() == null || m.getReceiveCompary().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "队长信息必须填写。");
			return;
		}
		if (m.getReceiveAddress() == null || m.getReceiveAddress().trim().equals("||")) {
			JOptionPane.showMessageDialog(null, "队长信息必须填写。");
			return;
		}
		if (m.getReceivePostcode() == null || m.getReceivePostcode().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "队长信息必须填写。");
			return;
		}
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		MessageMapper mapper = openSession.getMapper(MessageMapper.class);
		int flag = mapper.insertExpress(m);
		if (flag > 0) {// 如果有至少一行数据插入成功
			openSession.close();
			JOptionPane.showMessageDialog(null, "添加成功。");
		} else {
			JOptionPane.showMessageDialog(null, "添加失败。");
		}
	}

	public static void updateExpress(zhiyuanzheMessage m) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		MessageMapper mapper = openSession.getMapper(MessageMapper.class);
		int flag = mapper.updateExpress(m);
		if (flag > 0) {// 如果有至少一行数据修改成功
			openSession.close();
			JOptionPane.showMessageDialog(null, "修改成功。");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败。");
		}
	}

	public static Vector<zhiyuanzheMessage> queryAllExpress() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession(true);
		MessageMapper mapper = openSession.getMapper(MessageMapper.class);
		Vector<zhiyuanzheMessage> v = mapper.queryAllExpress();
		openSession.close();
		return v;
	}

}
