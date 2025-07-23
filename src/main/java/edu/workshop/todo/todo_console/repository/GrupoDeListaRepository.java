package edu.workshop.todo.todo_console.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.workshop.todo.todo_console.model.GrupoDeLista;

@Repository
public interface GrupoDeListaRepository extends JpaRepository<GrupoDeLista, Long> {

    List<GrupoDeLista> findByNombre(String nombre);

    Optional<GrupoDeLista> findById(Long usuario_id);

}
