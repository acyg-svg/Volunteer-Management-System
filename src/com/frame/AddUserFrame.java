package com.frame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.dao.UserDao;
import com.zzk.bean.User;

import java.awt.Dimension;

public class AddUserFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JTextField tf_user = null;
    private JPasswordField pf_pwd = null;
    private JPasswordField pf_okPwd = null;
    private JButton btn_save = null;
    private JButton btn_return = null;
    
    /**
     * This is the default constructor
     */
    public AddUserFrame() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(300, 190);
        this.setContentPane(getJContentPane());
        this.setTitle("申请新账户");
    }
    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel2 = new JLabel();
            jLabel2.setBounds(new Rectangle(26, 80, 69, 18));
            jLabel2.setText("确认密码：");
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(34, 49, 44, 18));
            jLabel1.setText("密码：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(33, 18, 45, 18));
            jLabel.setText("用户：");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabel, null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(jLabel2, null);
            jContentPane.add(getTf_user(), null);
            jContentPane.add(getPf_pwd(), null);
            jContentPane.add(getPf_okPwd(), null);
            jContentPane.add(getBtn_save(), null);
            jContentPane.add(getBtn_return(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes tf_user	
     * 	
     * @return javax.swing.JTextField	
     */
    private JTextField getTf_user() {
        if (tf_user == null) {
            tf_user = new JTextField();
            tf_user.setBounds(new Rectangle(95, 18, 166, 22));
        }
        return tf_user;
    }

    /**
     * This method initializes pf_pwd	
     * 	
     * @return javax.swing.JPasswordField	
     */
    private JPasswordField getPf_pwd() {
        if (pf_pwd == null) {
            pf_pwd = new JPasswordField();
            pf_pwd.setBounds(new Rectangle(95, 49, 164, 22));
            pf_pwd.setEchoChar('*');
        }
        return pf_pwd;
    }

    /**
     * This method initializes pf_okPwd	
     * 	
     * @return javax.swing.JPasswordField	
     */
    private JPasswordField getPf_okPwd() {
        if (pf_okPwd == null) {
            pf_okPwd = new JPasswordField();
            pf_okPwd.setBounds(new Rectangle(96, 78, 164, 22));
            pf_okPwd.setEchoChar('*');
        }
        return pf_okPwd;
    }

    /**
     * This method initializes btn_save	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_save() {
        if (btn_save == null) {
            btn_save = new JButton();
            btn_save.setBounds(new Rectangle(41, 111, 84, 23));
            btn_save.setText("保    存");
            btn_save.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String username = tf_user.getText().trim();
                    String password = new String(pf_pwd.getPassword());
                    String okPassword = new String(pf_okPwd.getPassword());
                    User user = new User();
                    user.setName(username);
                    user.setPwd(password);
                    user.setOkPwd(okPassword);
                    UserDao.insertUser(user);
                }
            });
        }
        return btn_save;
    }

    /**
     * This method initializes btn_return	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_return() {
        if (btn_return == null) {
            btn_return = new JButton();
            btn_return.setBounds(new Rectangle(151, 110, 85, 23));
            btn_return.setText("返    回");
            btn_return.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    dispose();
                }
            });
        }
        return btn_return;
    }
    
}  
