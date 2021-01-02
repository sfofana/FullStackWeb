package com.sfofana.email.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MailerUtils {

    private static final String email = "your-email";
    private static final String password = "your-password";
    private static final String templatePath = String.format("%s/templates/email.html", System.getProperty("user.dir"));

    public static void send(String recipient, String name) throws MessagingException, IOException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        Message message = prepareMessage(session, email, recipient, name);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String email, String recipient, String name) throws MessagingException, IOException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("Thank you for registering with JSF Banking!");
//        message.setText("testing emails service");
        message.setContent(emailTemplate(name), "text/html");
        return message;
    }

    public static String emailTemplate(String message) throws IOException {
        Stream<String> template = Files.lines(Paths.get(templatePath));
        List<String> formatted = new ArrayList<>();
        template.forEach(line -> {
            formatted.add(line.replaceAll("NAME PLACEHOLDER", message));
        });
        return formatted.stream().collect(Collectors.joining());
    }
}
