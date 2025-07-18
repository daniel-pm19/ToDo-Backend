package edu.workshop.todo.todo_console.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.model.enums.Prioridad;

import java.util.Optional;
import java.util.*;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByName(String nombre);

    Optional<Tarea> findById(Long id);

    List<Tarea> findByEstado(Estado estado);

    List<Tarea> findByPrioridad(Prioridad prioridad);

}
