package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.*;

import edu.workshop.todo.todo_console.model.Tarea;
import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);

    UsuarioResponseDTO updateUsuario(Long id, UsuarioRequestDTO dto);

    void eliminarUsuario(Long id);

    UsuarioResponseDTO getUsuarioById(Long id);

}
