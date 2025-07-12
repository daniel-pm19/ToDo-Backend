package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.service.impl.*;
import edu.workshop.todo.todo_console.model.Notificacion;
import edu.workshop.todo.todo_console.model.Usuarios;

public interface NotificationService {

    void enviarNotificacion(Notificacion notificacion, Usuarios usuario);

}