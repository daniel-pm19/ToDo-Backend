package edu.workshop.todo.todo_console.controller;

import edu.workshop.todo.todo_console.dto.AuthResponseDTO;
import edu.workshop.todo.todo_console.dto.LoginRequestDTO;
import edu.workshop.todo.todo_console.dto.RegisterRequestDTO;
import edu.workshop.todo.todo_console.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication operations")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/validate/login") // No se si asi sea la ruta
    public ResponseEntity<AuthResponseDTO> validateLoginCredentials(
            @Valid @RequestBody LoginRequestDTO credentials) {
        AuthResponseDTO response = authService.login(credentials);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate/register") // No se si asi sea la ruta
    public ResponseEntity<AuthResponseDTO> validateRegisterCredentials(
            @Valid @RequestBody RegisterRequestDTO credentials) {
        AuthResponseDTO response = authService.register(credentials);
        return ResponseEntity.ok(response);
    }

}
