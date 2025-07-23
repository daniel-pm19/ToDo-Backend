package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.ListaDeTareaResponseDTO;
import edu.workshop.todo.todo_console.dto.ListaDeTareaDTO;

public interface ListaDeTareaService {

    ListaDeTareaResponseDTO crearListaDeTarea(ListaDeTareaDTO dto);

    void eliminarListaDeTarea(Long id);

}