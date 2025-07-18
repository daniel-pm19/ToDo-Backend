package edu.workshop.todo.todo_console.service.impl;

import java.util.Properties;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.model.Notificacion;
import edu.workshop.todo.todo_console.service.NotificationService;
import edu.workshop.todo.todo_console.model.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioDeNotificacionesImpl implements NotificationService {

    public void enviarNotificacion(Notificacion notificacion, Usuarios usuario) {
        // usuario.agregarNotificacion(notificacion); IMPLEMENTAR SERVICIO
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
