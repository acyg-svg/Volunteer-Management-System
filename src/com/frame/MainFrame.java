package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import com.zzk.panel.BackgroundPanel;

import java.net.URL;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private URL url = null;
	private Image image = null;
	private BackgroundPanel jPanel = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem addExpressMI = null;
	private JMenuItem updateExpressMI = null;
	private JMenu systemMenu = null;
	private JMenuItem printMI = null;
	private JMenuItem changePasswordMI = null;
	private JMenuItem exitMI = null;
	private JMenuItem addUserMI = null;

	public MainFrame() {
		super();
		initialize();
	}


	private void initialize() {
		this.setSize(476, 301);
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("从化区高校志愿者信息管理系统");
		this.setContentPane(getJContentPane());
		this.setResizable(false);
	}


	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}


	private BackgroundPanel getJPanel() {
		if (jPanel == null) {
			url = MainFrame.class.getResource("/image/主界面.jpg"); 
			image = new ImageIcon(url).getImage(); 
			jPanel = new BackgroundPanel(image);
			jPanel.setLayout(null);
	}
		return jPanel;
	}


	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getsystemMenu());
		}
		return jJMenuBar;
	}


	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("志愿者信息管理");
			jMenu.add(getJMenuItem());
			jMenu.add(getupdateExpressMI());
		}
		return jMenu;
	}


	private JMenuItem getJMenuItem() {
		if (addExpressMI == null) {
			addExpressMI = new JMenuItem();
			addExpressMI.setText("添加志愿者信息");
			addExpressMI.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Addmessage thisClass = new Addmessage();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation(
							(dm.width - thisClass.getWidth()) / 2,
							(dm.height - thisClass.getHeight()) / 2);
					thisClass.setVisible(true);
				}
			});
		}
		return addExpressMI;
	}


	private JMenuItem getupdateExpressMI() {
		if (updateExpressMI == null) {
			updateExpressMI = new JMenuItem();
			updateExpressMI.setText("修改志愿者信息");
			updateExpressMI
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							UpdatemessgeFrame thisClass = new UpdatemessgeFrame();
							thisClass
									.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							Toolkit tookit = thisClass.getToolkit();
							Dimension dm = tookit.getScreenSize();
							thisClass.setLocation(
									(dm.width - thisClass.getWidth()) / 2,
									(dm.height - thisClass.getHeight()) / 2);
							thisClass.setVisible(true);
						}
					});
		}
		return updateExpressMI;
	}



	private JMenu getsystemMenu() {
		if (systemMenu == null) {
			systemMenu = new JMenu();
			systemMenu.setText("账号安全中心");
			systemMenu.add(getaddUserMI());
			systemMenu.add(getchangePasswordMI());
			systemMenu.add(getexitMI());
		}
		return systemMenu;
	}


	private JMenuItem getprintMI() {
		if (printMI == null) {
			printMI = new JMenuItem();
			printMI.setText("查看志愿者信息");
			printMI.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PrintAndPrintSetFrame thisClass = new PrintAndPrintSetFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation(
							(dm.width - thisClass.getWidth()) / 2,
							(dm.height - thisClass.getHeight()) / 2);
					thisClass.setVisible(true);
				}
			});
		}
		return printMI;
	}


	private JMenuItem getchangePasswordMI() {
		if (changePasswordMI == null) {
			changePasswordMI = new JMenuItem();
			changePasswordMI.setText("修改账号密码");
			changePasswordMI
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							UpdatePasswordFrame thisClass = new UpdatePasswordFrame();
							thisClass
									.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							Toolkit tookit = thisClass.getToolkit();
							Dimension dm = tookit.getScreenSize();
							thisClass.setLocation(
									(dm.width - thisClass.getWidth()) / 2,
									(dm.height - thisClass.getHeight()) / 2);
							thisClass.setVisible(true);
						}
					});
		}
		return changePasswordMI;
	}


	private JMenuItem getexitMI() {
		if (exitMI == null) {
			exitMI = new JMenuItem();
			exitMI.setText("退出");
			exitMI.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMI;
	}


	private JMenuItem getaddUserMI() {
		if (addUserMI == null) {
			addUserMI = new JMenuItem();
			addUserMI.setText("申请新账号");
			addUserMI.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AddUserFrame thisClass = new AddUserFrame();
					thisClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Toolkit tookit = thisClass.getToolkit();
					Dimension dm = tookit.getScreenSize();
					thisClass.setLocation(
							(dm.width - thisClass.getWidth()) / 2,
							(dm.height - thisClass.getHeight()) / 2);
					thisClass.setVisible(true);
				}
			});
		}
		return addUserMI;
	}
}
