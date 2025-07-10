package edu.workshop.todo.ToDo_maven.domain;

import java.util.ArrayList;

public class ToDo {
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    public ToDo() {
        usuarios = new ArrayList<>();
        usuarioActual = null;
    }

    public void registrarUsuario(String nombre, String email, String password) {
        usuarios.add(new Usuario(nombre, email, password));
    }

    public boolean iniciarSesion(String nombre, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    public void CerrarSesion() throws ToDoException {
        if (usuarioActual != null) {
            usuarioActual = null;
        } else {
            throw new ToDoException(ToDoException.USUARIO_NO_EXISTE);
        }
    }

}