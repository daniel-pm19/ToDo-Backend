package edu.workshop.todo.todo_console.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.model.Notificacion;
import edu.workshop.todo.todo_console.model.SubTarea;
import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.TareaRepository;
import edu.workshop.todo.todo_console.repository.ListaDeTareaRepository;
import edu.workshop.todo.todo_console.service.ListaDeTareaService;
import edu.workshop.todo.todo_console.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import edu.workshop.todo.todo_console.exception.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListaDeTareaImpl implements ListaDeTareaService {

    private final ListaDeTareaRepository listaDeTareaRepository;

    @Override
    @Transactional
    public ListaDeTareaResponseDTO crearListaDeTarea(ListaDeTareaDTO dto) {
        log.info("Creating a new Lista de tarea with ID: {}", dto.getId());

        List<Tarea> tareas = TareaMapper.toEntityList(dto.getTareas());

        ListaDeTarea listaDeTarea = ListaDeTarea.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .fechaDeCreacion(dto.getFechaDeCreacion())
                .tareas(tareas)
                .build();

        Usuarios usuario = new Usuarios();
        usuario.setId(dto.getUsuario_id());
        listaDeTarea.setUsuario(usuario);

        for (Tarea tarea : tareas) {
            tarea.setListaDeTarea(listaDeTarea);
        }
        ListaDeTarea savedSubTareas = listaDeTareaRepository.save(listaDeTarea);

        return mapToDto(savedSubTareas);
    }

    @Override
    @Transactional
    public void eliminarListaDeTarea(Long id) {
        log.info("Deleting Lista de tarea with ID: {}", id);
        listaDeTareaRepository.deleteById(id);
        log.info("Lista de tarea deleted successfully: {}", id);
    }

    public ListaDeTareaResponseDTO mapToDto(ListaDeTarea listaDeTarea) {
        return ListaDeTareaResponseDTO.builder()
                .id(listaDeTarea.getId())
                .nombre(listaDeTarea.getNombre())
                .fechaDeCreacion(listaDeTarea.getFechaDeCreacion())
                .tareas(TareaMapper.toDTOList(listaDeTarea.getTareas()))
                .usuario_id(listaDeTarea.getUsuario().getId())
                .build();
    }

}