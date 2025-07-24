package edu.workshop.todo.todo_console.service.impl;


import org.springframework.stereotype.Service;
import edu.workshop.todo.todo_console.dto.AuthResponseDTO;
import edu.workshop.todo.todo_console.dto.LoginRequestDTO;
import edu.workshop.todo.todo_console.dto.RegisterRequestDTO;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.model.Calendario;
import edu.workshop.todo.todo_console.model.Historial;
import edu.workshop.todo.todo_console.model.Estadistica;
import edu.workshop.todo.todo_console.model.enums.TipoHistorial;
import edu.workshop.todo.todo_console.repository.UsuarioRepository;
import edu.workshop.todo.todo_console.exception.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import edu.workshop.todo.todo_console.service.AuthService;
import edu.workshop.todo.todo_console.model.Usuarios;

import java.time.LocalDate;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
    Usuarios usuario = usuarioRepository
                .findByCorreoElectronico(loginRequestDTO.getCorreoElectronico())
                .orElseThrow(() -> new InvalidCredentialsException("Credenciales inválidas"));

        if (!usuario.getContrasena().equals(loginRequestDTO.getContrasena())) {
                throw new InvalidCredentialsException("Credenciales inválidas");
        }

        return AuthResponseDTO.builder()
                .correoElectronico(usuario.getCorreoElectronico())
                .nombre(usuario.getNombre())
                .build();
    }


    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        Optional<Usuarios> optionalUsuario = usuarioRepository
                .findByCorreoElectronico(registerRequestDTO.getCorreoElectronico());

        if (optionalUsuario.isPresent()) {
                throw new DuplicateResourceException("Ya existe un usuario con ese correo electrónico");
        }   


        Usuarios nuevoUsuario = Usuarios.builder()
        .nombre(registerRequestDTO.getNombre())
        .correoElectronico(registerRequestDTO.getCorreoElectronico())
        .contrasena(registerRequestDTO.getContrasena())
        .estadistica(
                Estadistica.builder()
                .tareas(0)
                .tareasFinalizadas(0)
                .build()
        )
        .historial(
                Historial.builder()
                .fechaDeCreacion(LocalDate.now())
                .tareas(new ArrayList<>())
                .tipoHistorial(TipoHistorial.TODO)
                .build()
        )
        .calendario(
                Calendario.builder()
                .tareas(new ArrayList<>())
                .build()
        )
        .notificaciones(new ArrayList<>())
        .grupoDeListas(new ArrayList<>())
        .listaDeTareas(new ArrayList<>())
        .tareas(new ArrayList<>())
        .build();


        usuarioRepository.save(nuevoUsuario);

        return AuthResponseDTO.builder()
            .correoElectronico(nuevoUsuario.getCorreoElectronico())
            .nombre(nuevoUsuario.getNombre())
            .build();
    }



}
