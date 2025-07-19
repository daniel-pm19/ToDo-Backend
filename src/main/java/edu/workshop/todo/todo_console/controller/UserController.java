package edu.workshop.todo.todo_console.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.workshop.todo.todo_console.dto.UsuarioResponseDTO;
import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.dto.TareaResponseDTO;
import edu.workshop.todo.todo_console.dto.UsuarioRequestDTO;
import edu.workshop.todo.todo_console.service.UsuarioService;
import edu.workshop.todo.todo_console.service.TareaService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UsuarioService usuarioService;
    private final TareaService tareaService;

    public UserController(UsuarioService usuarioService, TareaService tareaService) {
        this.usuarioService = usuarioService;
        this.tareaService = tareaService;
    }

    // USUARIOS

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario(
            @Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO created = usuarioService.crearUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(
            @Parameter(description = "Student ID to be deleted", required = true) @PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(
            @Parameter(description = "Tarea ID to be deleted", required = true) @PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // TAREAS

    @PostMapping
    public ResponseEntity<TareaResponseDTO> crearTarea(
            @Valid @RequestBody TareaRequestDTOO dto) {
        TareaResponseDTO created = tareaService.crearTarea(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity<TareaResponseDTO> updateTarea(
            @Parameter(description = "Tarea to be updated", required = true) @PathVariable Long id,
            @Valid @RequestBody TareaRequestDTOO dto) {

        TareaResponseDTO tareaUpdated = tareaService.updateTarea(id, dto);

        return ResponseEntity.ok(tareaUpdated);
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<Void> eliminarTarea(
            @Parameter(description = "Tarea ID to be deleted", required = true) @PathVariable Long id) {

        tareaService.eliminarTarea(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tareas/{id}")
    public ResponseEntity<TareaResponseDTO> getTareaById(
            @Parameter(description = "Student ID to be deleted", required = true) @PathVariable Long id) {
        TareaResponseDTO tarea = tareaService.getTareaById(id);

        return ResponseEntity.ok(tarea);
    }
}
