package edu.workshop.todo.todo_console.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.workshop.todo.todo_console.model.*;

import java.util.Optional;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {

    Optional<Estadistica> findById(Long id);

}
