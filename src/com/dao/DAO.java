package com.dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO {
	private static DAO dao = new DAO(); 

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "数据库驱动加载失败，请将驱动包配置到构建路径中。\n"
					+ e.getMessage());
			e.printStackTrace();
		}
	}


	public static Connection getConn() {
		try {
			Connection conn = null; 
			String url = "jdbc:mysql://127.0.0.1:3306/db_expressprint?useUnicode=true&characterEncoding=utf8"; // 数据库db_Express的URL
			String username = "root"; 
			String password = "12346578"; 
			conn = DriverManager.getConnection(url, username, password); 
			System.out.println(conn);
			return conn; 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"数据库连接失败。\n请检查是否安装了SP4补丁，\n以及数据库用户名和密码是否正确。"
							+ e.getMessage());
			return null;
		}
	}
	public static void main(String[] args) {
        System.out.println(getConn());
    }
}
