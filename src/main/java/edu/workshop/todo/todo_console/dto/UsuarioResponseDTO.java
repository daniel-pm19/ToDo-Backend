package edu.workshop.todo.todo_console.dto;

import java.util.List;

import edu.workshop.todo.todo_console.model.Calendario;
import edu.workshop.todo.todo_console.model.Estadistica;
import edu.workshop.todo.todo_console.model.GrupoDeLista;
import edu.workshop.todo.todo_console.model.Historial;
import edu.workshop.todo.todo_console.model.ListaDeTarea;
import edu.workshop.todo.todo_console.model.Notificacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UsuarioResponseDTO {
    private Long id;
    private String correoElectronico;
    private String nombre;
    private Estadistica estadistica;
    private Historial historial;
    private List<Notificacion> notificaciones;
    private Calendario calendario;
    private List<GrupoDeLista> grupoDeListas;
    private List<ListaDeTarea> listaDeTareas;
}
