package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "listadetareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeTarea {
    @Id
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "El nombre no debe contener más de 100 caracteres")
    private String nombre;
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "listadetareas_id")
    private List<Tarea> tareas;
}