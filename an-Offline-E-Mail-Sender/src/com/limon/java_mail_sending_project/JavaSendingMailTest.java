package com.limon.java_mail_sending_project;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaSendingMailTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("marufcucse797@gmail.com", "cse11Maruf11205030");

                    }

                }
        );
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("limoncsecu11@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("limoncsecu11@gmail.com"));
            //send email in multiple email address  
            //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("limoncsecu11@gmail.com,limon_cse_cu@yahoo.com"));
            message.setSubject("Mail Test");
            message.setText("Testing");

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
