package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "listadetareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListaDeTarea {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "El nombre no debe contener más de 100 caracteres")
    private String nombre;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past
    private LocalDate fechaDeCreacion;

    @OneToMany(mappedBy = "listaDeTarea", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "grupoDeLista_id")
    private GrupoDeLista grupoDeLista;
}