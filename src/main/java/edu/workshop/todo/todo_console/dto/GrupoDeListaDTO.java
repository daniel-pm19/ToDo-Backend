package edu.workshop.todo.todo_console.dto;

import edu.workshop.todo.todo_console.model.*;
import edu.workshop.todo.todo_console.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.EqualsAndHashCode;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.time.*;

public class GrupoDeListaDTO {
    private String nombre;
    private LocalDate fechaDeCreacion;
    private List<ListaDeTareaDTO> listaDeTareas;
}