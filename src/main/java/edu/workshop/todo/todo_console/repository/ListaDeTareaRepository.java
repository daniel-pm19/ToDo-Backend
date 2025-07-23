package edu.workshop.todo.todo_console.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.workshop.todo.todo_console.model.ListaDeTarea;

public interface ListaDeTareaRepository extends JpaRepository<ListaDeTarea, Long> {
    Optional<ListaDeTarea> findById(Long id);

    List<ListaDeTarea> findByNombre(String nombre);

}
