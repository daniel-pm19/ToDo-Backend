package edu.workshop.todo.todo_console.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.workshop.todo.todo_console.dto.UsuarioResponseDTO;
import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.dto.*;
import edu.workshop.todo.todo_console.dto.SubTareaResponseDTO;
import edu.workshop.todo.todo_console.dto.SubTareaDTO;
import edu.workshop.todo.todo_console.dto.UsuarioRequestDTO;
import edu.workshop.todo.todo_console.service.UsuarioService;
import edu.workshop.todo.todo_console.service.TareaService;
import edu.workshop.todo.todo_console.service.SubTareaService;
import edu.workshop.todo.todo_console.service.ListaDeTareaService;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UsuarioService usuarioService;
    private final TareaService tareaService;
    private final SubTareaService subTareaService;
    private final ListaDeTareaService listaDeTareaService;

    public UserController(UsuarioService usuarioService, TareaService tareaService, SubTareaService subTareaService,
            ListaDeTareaService listaDeTareaService) {

        this.usuarioService = usuarioService;
        this.tareaService = tareaService;
        this.subTareaService = subTareaService;
        this.listaDeTareaService = listaDeTareaService;

    }

    // USUARIOS
    @GetMapping("")
    public ResponseEntity<Iterable<UsuarioResponseDTO>> getAllUsuarios() {
        Iterable<UsuarioResponseDTO> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("")
    public ResponseEntity<UsuarioResponseDTO> createUsuario(
            @Valid @RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO created = usuarioService.crearUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(
            @Parameter(description = "Usuario to be updated", required = true) @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO usuarioUpdated = usuarioService.updateUsuario(id, dto);

        return ResponseEntity.ok(usuarioUpdated);
    }

    @GetMapping("/usuarios/{id}")
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

    @PostMapping("/usuarios/tareas")
    public ResponseEntity<TareaResponseDTO> crearTarea(
            @Valid @RequestBody TareaRequestDTOO dto) {
        TareaResponseDTO created = tareaService.crearTarea(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/usuarios/tareas/{id}")
    public ResponseEntity<TareaResponseDTO> updateTarea(
            @Parameter(description = "Tarea to be updated", required = true) @PathVariable Long id,
            @Valid @RequestBody TareaRequestDTOO dto) {

        TareaResponseDTO tareaUpdated = tareaService.updateTarea(id, dto);

        return ResponseEntity.ok(tareaUpdated);
    }

    @DeleteMapping("/usuarios/tareas/{id}")
    public ResponseEntity<Void> eliminarTarea(
            @Parameter(description = "Tarea ID to be deleted", required = true) @PathVariable Long id) {

        tareaService.eliminarTarea(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuarios/tareas/{id}")
    public ResponseEntity<TareaResponseDTO> getTareaById(
            @Parameter(description = "Student ID to be deleted", required = true) @PathVariable Long id) {
        TareaResponseDTO tarea = tareaService.getTareaById(id);

        return ResponseEntity.ok(tarea);
    }

    // SUBTAREAS
    @PostMapping("/usuarios/subtareas")
    public ResponseEntity<SubTareaResponseDTO> crearSubTarea(
            @Valid @RequestBody SubTareaDTO dto) {
        SubTareaResponseDTO created = subTareaService.crearSubTarea(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/usuarios/subtareas/{id}")
    public ResponseEntity<Void> eliminarSubTarea(
            @Parameter(description = "Tarea ID to be deleted", required = true) @PathVariable Long id) {
        subTareaService.eliminarSubTarea(id);
        return ResponseEntity.noContent().build();
    }

    // LISTADETAREAS
    @PostMapping("/usuarios/listadetareas")
    public ResponseEntity<ListaDeTareaResponseDTO> crearListaDeTarea(
            @Valid @RequestBody ListaDeTareaDTO dto) {
        ListaDeTareaResponseDTO created = listaDeTareaService.crearListaDeTarea(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/usuarios/listadetareas/{id}")
    public ResponseEntity<Void> eliminarListaDeTarea(
            @Parameter(description = "Tarea ID to be deleted", required = true) @PathVariable Long id) {
        listaDeTareaService.eliminarListaDeTarea(id);
        return ResponseEntity.noContent().build();
    }

}