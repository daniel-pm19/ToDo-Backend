package edu.workshop.todo.todo_console.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UsuarioRequestDTO extends BaseUsuarioDTO {

    private EstadisticaDTO estadistica;
    private HistorialDTO historial;
    private List<NotificacionDTO> notificaciones;
    private CalendarioDTO calendario;
    private List<GrupoDeListaDTO> grupoDelistas;
    private List<ListaDeTareaDTO> listaDeTareas;

    @Schema(description = "Initial password for the user", example = "SecureP@ss123")
    @NotBlank(message = "password cannot be blank")
    private String contraseña;
}
