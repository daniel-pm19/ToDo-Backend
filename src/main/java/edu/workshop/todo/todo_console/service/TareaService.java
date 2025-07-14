package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.*;

public interface TareaService {
    TareaResponseDTO crearTareaParaUsuario(Long id, TareaRequestDTOO dto);
}
