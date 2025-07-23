package edu.workshop.todo.todo_console.service;

import edu.workshop.todo.todo_console.dto.AuthResponseDTO;
import edu.workshop.todo.todo_console.dto.LoginRequestDTO;
import edu.workshop.todo.todo_console.dto.RegisterRequestDTO;

public interface AuthService {

    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);

    AuthResponseDTO register(RegisterRequestDTO registerRequestDTO);

}
