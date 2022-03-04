package com.frame;

import javax.swing.SwingUtilities;

import com.dao.UserDao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UpdatePasswordFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JLabel jLabel2 = null;
    private JPasswordField pf_oldPwd = null;
    private JPasswordField pf_newPwd = null;
    private JPasswordField pf_okNewPwd = null;
    private JButton btn_update = null;
    private JButton btn_return = null;
    
    /**
     * This method initializes pf_oldPwd	
     * 	
     * @return javax.swing.JPasswordField	
     */
    private JPasswordField getPf_oldPwd() {
        if (pf_oldPwd == null) {
            pf_oldPwd = new JPasswordField();
            pf_oldPwd.setBounds(new Rectangle(93, 21, 185, 22));
            pf_oldPwd.setEchoChar('*');
            pf_oldPwd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    pf_newPwd.requestFocus();
                }
            });
        }
        return pf_oldPwd;
    }

    /**
     * This method initializes pf_newPwd	
     * 	
     * @return javax.swing.JPasswordField	
     */
    private JPasswordField getPf_newPwd() {
        if (pf_newPwd == null) {
            pf_newPwd = new JPasswordField();
            pf_newPwd.setBounds(new Rectangle(94, 54, 182, 22));
            pf_newPwd.setEchoChar('*');
            pf_newPwd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    pf_okNewPwd.requestFocus();
                }
            });
        }
        return pf_newPwd;
    }

    /**
     * This method initializes pf_okNewPwd	
     * 	
     * @return javax.swing.JPasswordField	
     */
    private JPasswordField getPf_okNewPwd() {
        if (pf_okNewPwd == null) {
            pf_okNewPwd = new JPasswordField();
            pf_okNewPwd.setBounds(new Rectangle(94, 90, 182, 22));
            pf_okNewPwd.setEchoChar('*');
            pf_okNewPwd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String oldPwd = new String(pf_oldPwd.getPassword());
                    String newPwd = new String(pf_newPwd.getPassword());
                    String okPwd = new String(pf_okNewPwd.getPassword());
                    UserDao.updateUser(oldPwd, newPwd, okPwd);
                }
            });
        }
        return pf_okNewPwd;
    }

    /**
     * This method initializes btn_update	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_update() {
        if (btn_update == null) {
            btn_update = new JButton();
            btn_update.setBounds(new Rectangle(40, 123, 75, 27));
            btn_update.setText("修    改");
            btn_update.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String oldPwd = new String(pf_oldPwd.getPassword());
                    String newPwd = new String(pf_newPwd.getPassword());
                    String okPwd = new String(pf_okNewPwd.getPassword());
                    UserDao.updateUser(oldPwd, newPwd, okPwd);
                }
            });
        }
        return btn_update;
    }

    /**
     * This method initializes btn_return	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_return() {
        if (btn_return == null) {
            btn_return = new JButton();
            btn_return.setBounds(new Rectangle(162, 124, 82, 26));
            btn_return.setText("返    回");
            btn_return.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    dispose();
                }
            });
        }
        return btn_return;
    }

    
    /**
     * This is the default constructor
     */
    public UpdatePasswordFrame() {
        super();
        initialize();
    }
    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(317, 205);
        this.setContentPane(getJContentPane());
        this.setTitle("修改用户密码");
    }
    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel2 = new JLabel();
            jLabel2.setBounds(new Rectangle(19, 86, 73, 27));
            jLabel2.setText("确认密码：");
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(20, 52, 70, 27));
            jLabel1.setText("新  密  码：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(18, 18, 71, 27));
            jLabel.setText("原  密  码：");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabel, null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(jLabel2, null);
            jContentPane.add(getPf_oldPwd(), null);
            jContentPane.add(getPf_newPwd(), null);
            jContentPane.add(getPf_okNewPwd(), null);
            jContentPane.add(getBtn_update(), null);
            jContentPane.add(getBtn_return(), null);
        }
        return jContentPane;
    }
    
}  
