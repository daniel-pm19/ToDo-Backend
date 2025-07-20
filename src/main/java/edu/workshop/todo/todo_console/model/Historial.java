package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import edu.workshop.todo.todo_console.model.enums.TipoHistorial;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "historial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Historial {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historial_id")
    private List<Tarea> tareas;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoHistorial tipoHistorial;
}
