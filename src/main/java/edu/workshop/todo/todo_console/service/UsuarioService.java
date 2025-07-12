package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> todosLosUsuarios();
}
