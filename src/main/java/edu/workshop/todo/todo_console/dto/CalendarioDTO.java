package edu.workshop.todo.todo_console.dto;

import edu.workshop.todo.todo_console.dto.TareaRequestDTOO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalendarioDTO {
    @Schema(description = "List of tareas", example = "tarea no.")
    private List<TareaRequestDTOO> tareas;
}
