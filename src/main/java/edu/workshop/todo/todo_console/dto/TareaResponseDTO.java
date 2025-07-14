package edu.workshop.todo.todo_console.dto;

import java.util.List;

import edu.workshop.todo.todo_console.model.Calendario;
import edu.workshop.todo.todo_console.model.Estadistica;
import edu.workshop.todo.todo_console.model.GrupoDeLista;
import edu.workshop.todo.todo_console.model.Historial;
import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TareaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaLimite;
    private Estado estado;
    private Prioridad prioridad;
    private List<SubTarea> subtareas;
    private List<Notificacion> notificaciones;
}
