package edu.workshop.todo.todo_console.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.workshop.todo.todo_console.model.Tarea;
import edu.workshop.todo.todo_console.model.SubTarea;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.model.enums.Prioridad;

import java.util.Optional;
import java.util.*;

@Repository
public interface SubTareaRepository extends JpaRepository<SubTarea, Long> {

    List<SubTarea> findByNombre(String nombre);

    Optional<SubTarea> findById(Long id);

    List<SubTarea> findByEstado(Estado estado);
}
