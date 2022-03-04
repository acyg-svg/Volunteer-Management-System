package com.frame;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dao.ExpressMessageDao;
import com.zzk.bean.ExpressMessage;
import com.zzk.panel.BackgroundPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Addmessage extends JFrame {
	

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private URL url = null;
    private Image image=null;
    private BackgroundPanel jPanel = null;
    private JTextField tf_sendName = null;
    private JTextField tf_sendTelephone = null;
    private JTextField tf_sendCompany = null;
    private JTextField tf_sendAddress1 = null;
    private JTextField tf_sendAddress2 = null;
    private JTextField tf_sendAddress3 = null;
    private JTextField tf_sendPostcode = null;
    private JTextField tf_receiveName = null;
    private JTextField tf_receiveTelephone = null;
    private JTextField tf_receiveCompany = null;
    private JTextField tf_receiveAddress1 = null;
    private JTextField tf_receiveAddress2 = null;
    private JTextField tf_receiveAddress3 = null;
    private JTextField tf_receivePostcode = null;
    private JPanel jPanel1 = null;
    private JButton btn_clear = null;
    private JButton btn_save = null;
    private JButton btn_return = null;
    /**
     * This method initializes jPanel1	
     * 	
     * @return javax.swing.JPanel	
     */ 
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jPanel1 = new JPanel();
            jPanel1.setLayout(new FlowLayout());
            jPanel1.add(getBtn_clear(), null);
            jPanel1.add(getBtn_save(), null);
            jPanel1.add(getBtn_return(), null);
        }
        return jPanel1;
    }

    

    /**
     * This method initializes btn_clear	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_clear() {
        if (btn_clear == null) {
            btn_clear = new JButton();
            btn_clear.setText("清    空");
            btn_clear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    tf_sendName.setText(null);
                    tf_sendTelephone.setText(null);
                    tf_sendCompany.setText(null);
                    tf_sendAddress1.setText(null);
                    tf_sendAddress2.setText(null);
                    tf_sendAddress3.setText(null);
                    tf_sendPostcode.setText(null);
                    tf_receiveName.setText(null);
                    tf_receiveTelephone.setText(null);
                    tf_receiveCompany.setText(null);
                    tf_receiveAddress1.setText(null);
                    tf_receiveAddress2.setText(null);
                    tf_receiveAddress3.setText(null);
                    tf_receivePostcode.setText(null);
                    tf_sendName.requestFocus();
                }
            });
        }
        return btn_clear;
    }

    /**
     * This method initializes btn_save	
     * 	
     * @return javax.swing.JButton	
     */
    private JButton getBtn_save() {
        if (btn_save == null) {
            btn_save = new JButton();
            btn_save.setText("保    存");
            btn_save.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    StringBuffer buffer = new StringBuffer();
                    zhiyuanzheMessage m = new zhiyuanzheMessage();
                    m.setSendName(tf_sendName.getText().trim());
                    m.setSendTelephone(tf_sendTelephone.getText().trim());
                    m.setSendCompary(tf_sendCompany.getText().trim());
                    m.setSendAddress(tf_sendAddress1.getText().trim()+"|"+tf_sendAddress2.getText().trim()+"|"+tf_sendAddress3.getText().trim());
                    m.setSendPostcode(tf_sendPostcode.getText().trim());
                    m.setReceiveName(tf_receiveName.getText().trim());
                    m.setReceiveTelephone(tf_receiveTelephone.getText().trim());
                    m.setReceiveCompary(tf_receiveCompany.getText().trim());
                    m.setReceiveAddress(tf_receiveAddress1.getText().trim()+"|"+tf_receiveAddress2.getText().trim()+"|"+tf_receiveAddress3.getText().trim());
                    m.setReceivePostcode(tf_receivePostcode.getText().trim());
                    buffer.append(tf_sendName.getX()+","+tf_sendName.getY()+"/");
                    buffer.append(tf_sendTelephone.getX()+","+tf_sendTelephone.getY()+"/");
                    buffer.append(tf_sendCompany.getX()+","+tf_sendCompany.getY()+"/");
                    buffer.append(tf_sendAddress1.getX()+","+tf_sendAddress1.getY()+"/");
                    buffer.append(tf_sendAddress2.getX()+","+tf_sendAddress2.getY()+"/");
                    buffer.append(tf_sendAddress3.getX()+","+tf_sendAddress3.getY()+"/");
                    buffer.append(tf_sendPostcode.getX()+","+tf_sendPostcode.getY()+"/");
                    buffer.append(tf_receiveName.getX()+","+tf_receiveName.getY()+"/");
                    buffer.append(tf_receiveTelephone.getX()+","+tf_receiveTelephone.getY()+"/");
                    buffer.append(tf_receiveCompany.getX()+","+tf_receiveCompany.getY()+"/");
                    buffer.append(tf_receiveAddress1.getX()+","+tf_receiveAddress1.getY()+"/");
                    buffer.append(tf_receiveAddress2.getX()+","+tf_receiveAddress2.getY()+"/");
                    buffer.append(tf_receiveAddress3.getX()+","+tf_receiveAddress3.getY()+"/");
                    buffer.append(tf_receivePostcode.getX()+","+tf_receivePostcode.getY());
                    m.setControlPosition(new String(buffer));
                    ahiyuanzheMessageDao.insertExpress(m);
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
     * @param owner
     */

    public Addmessage() {
        super();
        initialize();
    }

    
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
    	this.setResizable(false);
        this.setSize(1017, 575);
        this.setTitle("增加志愿者信息");
        this.setContentPane(getJContentPane());
    }


    
    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
           jContentPane.add(getJPanel(), BorderLayout.CENTER);
            jContentPane.add(getJPanel1(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }

    /**
     * This method initializes jPanel   
     *  
     * @return javax.swing.JPanel   
     */
    private BackgroundPanel getJPanel() {
        if (jPanel == null) {
            url = Addmessage.class.getResource("/image/添加志愿者信息.png");    
            image=new ImageIcon(url).getImage();                       
          jPanel = new BackgroundPanel(image);
            jPanel.setLayout(null);
            jPanel.add(getTf_sendName(), null);
            jPanel.add(getTf_sendTelephone(), null);
          jPanel.add(getTf_sendCompany(), null);
            jPanel.add(getTf_sendAddress1(), null);
            jPanel.add(getTf_sendAddress2(), null);
            jPanel.add(getTf_sendAddress3(), null);
            jPanel.add(getTf_sendPostcode(), null);
            jPanel.add(getTf_receiveName(), null);
            jPanel.add(getTf_receiveTelephone(), null);
            jPanel.add(getTf_receiveCompany(), null);
            jPanel.add(getTf_receiveAddress1(), null);
            jPanel.add(getTf_receiveAddress2(), null);
           jPanel.add(getTf_receiveAddress3(), null);
           jPanel.add(getTf_receivePostcode(), null);
        }
       return jPanel;
    }


    /**
     * This method initializes tf_sendName  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendName() {
        if (tf_sendName == null) {
            tf_sendName = new JTextField();
            tf_sendName.setBounds(new Rectangle(580 ,63, 150, 22));
        }
        return tf_sendName;
    }

    /**
     * This method initializes tf_sendTelephone 
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendTelephone() {
        if (tf_sendTelephone == null) {
            tf_sendTelephone = new JTextField();
            tf_sendTelephone.setBounds(new Rectangle(580, 103, 50, 22));
        }
        return tf_sendTelephone;
    }

    /**
     * This method initializes tf_sendCompany   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendCompany() {
        if (tf_sendCompany == null) {
            tf_sendCompany = new JTextField();
            tf_sendCompany.setBounds(new Rectangle(655, 155, 328, 22));
        }
        return tf_sendCompany;
    }

    /**
     * This method initializes tf_sendAddress1  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendAddress1() {
        if (tf_sendAddress1 == null) {
            tf_sendAddress1 = new JTextField();
            tf_sendAddress1.setBounds(new Rectangle(610, 195, 250, 22));
        }
        return tf_sendAddress1;
    }

    /**
     * This method initializes tf_sendAddress2  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendAddress2() {
        if (tf_sendAddress2 == null) {
            tf_sendAddress2 = new JTextField();
            tf_sendAddress2.setBounds(new Rectangle(610, 235, 250, 22));
        }
        return tf_sendAddress2;
    }

    /**
     * This method initializes tf_sendAddress3  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendAddress3() {
        if (tf_sendAddress3 == null) {
            tf_sendAddress3 = new JTextField();
            tf_sendAddress3.setBounds(new Rectangle(610, 275, 250, 22));
        }
        return tf_sendAddress3;
    }

    /**
     * This method initializes tf_sendPostcode  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_sendPostcode() {
        if (tf_sendPostcode == null) {
            tf_sendPostcode = new JTextField();
            tf_sendPostcode.setBounds(new Rectangle(580, 323, 250, 22));
        }
        return tf_sendPostcode;
    }

    /**
     * This method initializes tf_receiveName   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveName() {
        if (tf_receiveName == null) {
            tf_receiveName = new JTextField();
            tf_receiveName.setBounds(new Rectangle(80,63,150, 22));
        }
        return tf_receiveName;
    }

    /**
     * This method initializes tf_receiveTelephone  
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveTelephone() {
        if (tf_receiveTelephone == null) {
            tf_receiveTelephone = new JTextField();
            tf_receiveTelephone.setBounds(new Rectangle(80,103, 50, 22));
        }
        return tf_receiveTelephone;
    }

    /**
     * This method initializes tf_receiveCompany    
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveCompany() {
        if (tf_receiveCompany == null) {
            tf_receiveCompany = new JTextField();
            tf_receiveCompany.setBounds(new Rectangle(160, 155, 328, 22));
        }
        return tf_receiveCompany;
    }

    /**
     * This method initializes tf_receiveAddress1   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveAddress1() {
        if (tf_receiveAddress1 == null) {
            tf_receiveAddress1 = new JTextField();
            tf_receiveAddress1.setBounds(new Rectangle(110, 195, 250, 22));
        }
        return tf_receiveAddress1;
    }

    /**
     * This method initializes tf_receiveAddress2   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveAddress2() {
        if (tf_receiveAddress2 == null) {
            tf_receiveAddress2 = new JTextField();
            tf_receiveAddress2.setBounds(new Rectangle(110,235, 250, 22));
        }
        return tf_receiveAddress2;
    }

    /**
     * This method initializes tf_receiveAddress3   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receiveAddress3() {
        if (tf_receiveAddress3 == null) {
            tf_receiveAddress3 = new JTextField();
            tf_receiveAddress3.setBounds(new Rectangle(110, 275, 250, 22));
        }
        return tf_receiveAddress3;
    }

    /**
     * This method initializes tf_receivePostcode   
     *  
     * @return javax.swing.JTextField   
     */
    private JTextField getTf_receivePostcode() {
        if (tf_receivePostcode == null) {
            tf_receivePostcode = new JTextField();
            tf_receivePostcode.setBounds(new Rectangle(80,320, 250, 22));
        }
        return tf_receivePostcode;
    }
}
