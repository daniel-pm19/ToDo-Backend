package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.workshop.todo.todo_console.model.enums.Estado;
import edu.workshop.todo.todo_console.model.enums.Prioridad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendario {
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "calendario_id")
    private List<Tarea> tareas;
}
