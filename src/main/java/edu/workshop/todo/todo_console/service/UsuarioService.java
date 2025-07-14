package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.UsuarioRequestDTO;
import edu.workshop.todo.todo_console.dto.UsuarioResponseDTO;
import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;

import edu.workshop.todo.todo_console.model.Tarea;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);
}
