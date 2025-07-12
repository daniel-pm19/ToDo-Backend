package edu.workshop.todo.todo_console.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.workshop.todo.todo_console.dto.UsuarioDTO;
import edu.workshop.todo.todo_console.service.UsuarioService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> todosLosUsuarios() {
        return null;
    }
}
