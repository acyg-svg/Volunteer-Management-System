package com.dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAO {
	private static DAO dao = new DAO(); 

	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "���ݿ���������ʧ�ܣ��뽫���������õ�����·���С�\n"
					+ e.getMessage());
			e.printStackTrace();
		}
	}


	public static Connection getConn() {
		try {
			Connection conn = null; 
			String url = "jdbc:mysql://127.0.0.1:3306/db_expressprint?useUnicode=true&characterEncoding=utf8"; // ���ݿ�db_Express��URL
			String username = "root"; 
			String password = "12346578"; 
			conn = DriverManager.getConnection(url, username, password); 
			System.out.println(conn);
			return conn; 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"���ݿ�����ʧ�ܡ�\n�����Ƿ�װ��SP4������\n�Լ����ݿ��û����������Ƿ���ȷ��"
							+ e.getMessage());
			return null;
		}
	}
	public static void main(String[] args) {
        System.out.println(getConn());
    }
}
