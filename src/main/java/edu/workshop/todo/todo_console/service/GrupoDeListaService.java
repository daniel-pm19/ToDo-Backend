package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.GrupoDeListaDTO;
import edu.workshop.todo.todo_console.dto.GrupoDeListaResponseDTO;

public interface GrupoDeListaService {

    GrupoDeListaResponseDTO crearGrupoDeLista(GrupoDeListaDTO dto);

    void eliminarGrupoDeLista(Long id);

}
