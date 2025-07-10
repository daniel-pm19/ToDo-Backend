package edu.workshop.todo.ToDo_maven.domain;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class ServicioDeNotificaciones {

    public void enviarNotificacion(Notificacion notificacion, Usuario usuario) {
        usuario.agregarNotificacion(notificacion);
        String host = "smtp.gmail.com";
        String from = "todoapplicationproject@gmail.com";
        String password = "fmffxdaokensoshj";
        String to = usuario.getCorreoElectronico();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {

        @Override    
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(notificacion.getTitulo());
            message.setText(notificacion.getMensaje());

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
