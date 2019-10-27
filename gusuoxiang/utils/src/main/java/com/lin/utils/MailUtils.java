package com.lin.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailUtils {
    private static String from = "linchengwu_1@163.com";
    private static String user = "linchengwu_1@163.com";
    private static String password = "131452046aa";
    private static String mailHost = "smtp.163.com";

    /**
     * @param to
     * @param text
     * @param title
     */
    public static boolean sendMail(String to, String text, String title) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailHost);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(title);
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(text, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(mailHost, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("发送邮件成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
            String toMail = "1468494508@qq.com";
              String text = "验证码";
               String title = "亲爱的用户：\n " +
                       "本次的邮箱验证码为：9020 （验证码在10分钟内有效）\n" +
                       " 如果这不是您的邮件，请忽略此邮件。\n" +
                       "沽所向系统邮件，请勿回复。\n";
            sendMail(toMail, text, title);
    }

}


