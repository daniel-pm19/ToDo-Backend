package edu.workshop.todo.todo_console.service.impl;

import org.springframework.stereotype.Service;
import edu.workshop.todo.todo_console.dto.AuthResponseDTO;
import edu.workshop.todo.todo_console.dto.LoginRequestDTO;
import edu.workshop.todo.todo_console.dto.RegisterRequestDTO;
import edu.workshop.todo.todo_console.model.Usuarios;
import edu.workshop.todo.todo_console.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import edu.workshop.todo.todo_console.service.AuthService;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {

        Optional<Usuarios> optionalUsuario = usuarioRepository
                .findByCorreoElectronico(loginRequestDTO.getCorreoElectronico());

        if (optionalUsuario.isEmpty()) {
            return AuthResponseDTO.builder()
                    .correoElectronico(loginRequestDTO.getCorreoElectronico())
                    .nombre("Usuario no encontrado")
                    .build();
        }

        Usuarios usuario = optionalUsuario.get();

        if (!usuario.getContraseña().equals(loginRequestDTO.getContraseña())) {
            return AuthResponseDTO.builder()
                    .correoElectronico(loginRequestDTO.getCorreoElectronico())
                    .nombre("Contraseña incorrecta")
                    .build();
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
            return AuthResponseDTO.builder()
                    .correoElectronico(registerRequestDTO.getCorreoElectronico())
                    .nombre("Usuario ya existe")
                    .build();
        }

        return AuthResponseDTO.builder()
                .correoElectronico(registerRequestDTO.getCorreoElectronico())
                .nombre(registerRequestDTO.getNombre())
                .build();
    }
}
