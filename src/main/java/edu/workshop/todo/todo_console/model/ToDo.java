package edu.workshop.todo.todo_console.service;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    @Id
    private long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ToDo_id")
    private ArrayList<Usuario> usuarios;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private Usuario usuarioActual;
}