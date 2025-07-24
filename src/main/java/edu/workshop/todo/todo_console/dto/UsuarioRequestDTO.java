package edu.workshop.todo.todo_console.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Data
@Getter
@Setter
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
    private List<TareaRequestDTOO> tareas;

    @Schema(description = "Initial password for the user", example = "SecureP@ss123")
    @NotBlank(message = "password cannot be blank")
    private String contrasena;
}
