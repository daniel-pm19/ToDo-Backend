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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UsuarioResponseDTO {
    private Long id;
    private String correoElectronico;
    private String nombre;
    private EstadisticaDTO estadistica;
    private HistorialDTO historial;
    private List<NotificacionDTO> notificaciones;
    private CalendarioDTO calendario;
    private List<GrupoDeListaDTO> grupoDeListas;
    private List<ListaDeTareaDTO> listaDeTareas;
    private List<TareaRequestDTOO> tareas;
}
