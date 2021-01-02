package com.sfofana.email.util;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailerUtilsTest {

    @Test
    void send() throws IOException, MessagingException {
        String recipient = "alfof1738@gmail.com";
        MailerUtils.send(recipient, "Alhaji Fofana");
    }

    @Test
    void stringReplace() {
        String name = "this is a phrase that will be replaced";
        String result = name.replaceAll("phrase", "saying");
        System.out.println(name);
        System.out.println(result);
    }
}