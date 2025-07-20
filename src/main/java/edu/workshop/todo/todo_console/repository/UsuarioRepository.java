package edu.workshop.todo.todo_console.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.GrupoDeLista;
import edu.workshop.todo.todo_console.model.Estadistica;
import edu.workshop.todo.todo_console.model.Usuarios;
import java.util.Optional;
import java.util.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByCorreoElectronico(String correoElectronico);

    List<Usuarios> findByNombre(String nombre);

    Optional<Usuarios> findById(Long id);

    List<Usuarios> findByListaDeTareas(ListaDeTarea listaDeTarea);

}
