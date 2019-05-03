package com.limon.java_mail_sending_project;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class SentEmailProject extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel id = new JLabel("Enter Your Email ID :");
    JPasswordField t_cost = new JPasswordField(15);

    JLabel cost = new JLabel("Enter Your Password :");
    JLabel cost_details = new JLabel("To :                 ");

    JTextField t_id = new JTextField(15);
    JTextField t_cost_details = new JTextField("Send mail single or multiple users");

    JLabel earn = new JLabel("Subject :               ");
    JTextField t_earn = new JTextField(15);

    JLabel earn_details = new JLabel("Enter Text : ");
    // JTextField t_earn_details = new JTextField(15);

    TextArea t_earn_details = new TextArea();

    JButton sb = new JButton("Send", new ImageIcon("image/Save.gif"));
    JButton bb = new JButton("Cancel", new ImageIcon("image/Regis.png"));

    Font font = new Font("SERIF", Font.BOLD | Font.PLAIN, 15);
    ImageIcon ic = new ImageIcon();
    
    JFileChooser chooser=new JFileChooser();
    

    SentEmailProject() {

        super("Save Estimation Record");
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        add(panel);
        setSize(550, 600);
        setVisible(true);
        setLocation(480, 90);
        Add_Component_E();

    }
    void addFile()
    {
        chooser.showOpenDialog(null);
       File file=chooser.getSelectedFile();
       
       
    }
    void Add_Component_E() {

        id.setBounds(30, 30, 130, 40);
        t_id.setBounds(170, 30, 250, 40);
        panel.add(id);
        panel.add(t_id);

        cost.setBounds(30, 100, 130, 40);
        t_cost.setBounds(170, 100, 250, 40);
        panel.add(cost);
        panel.add(t_cost);

        cost_details.setBounds(30, 230, 130, 40);
        t_cost_details.setBounds(170, 230, 250, 40);
        panel.add(cost_details);
        panel.add(t_cost_details);

        earn.setBounds(30, 280, 130, 40);
        t_earn.setBounds(170, 280, 250, 40);
        panel.add(earn);
        panel.add(t_earn);

        earn_details.setBounds(30, 330, 130, 40);
        t_earn_details.setBounds(170, 330, 250, 120);
        panel.add(earn_details);
        panel.add(t_earn_details);

        sb.setBounds(120, 500, 140, 40);
        sb.setForeground(Color.MAGENTA);
        sb.addActionListener(this);
        sb.setToolTipText("Save");
        sb.setMnemonic(KeyEvent.VK_S);
        panel.add(sb);

        bb.setBounds(270, 500, 140, 40);
        bb.setForeground(Color.MAGENTA);
        bb.setToolTipText("Back");
        bb.setMnemonic(KeyEvent.VK_B);
        bb.addActionListener(this);
        panel.add(bb);

    }

    public static void main(String args[]) {

        SentEmailProject ob = new SentEmailProject();
    }

    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == sb) {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(t_id.getText(),t_cost.getText());

                        }

                    }
            );
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(t_id.getText()));
           //     message.addRecipient(Message.RecipientType.TO, new InternetAddress(t_cost_details.getText()));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(t_cost_details.getText()));
                message.setSubject(t_earn.getText());
                message.setText(t_earn_details.getText());

                Transport.send(message);
                JOptionPane.showMessageDialog(null, "Message Sent!!!!");
                System.out.println("message sent successfully...");
                
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Sorry!!!!");
                System.out.println("Error is.\t"+e.toString());

            }
        }

    }

}
