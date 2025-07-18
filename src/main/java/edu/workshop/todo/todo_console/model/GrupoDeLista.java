package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "grupodelistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrupoDeLista {

    @Id
    @NotBlank(message = "ID cannot be blank")
    @Column
    private Long id;

    @Column
    @NotBlank
    private String nombre;

    @PastOrPresent
    @Column
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "grupodelistas_id")
    private List<ListaDeTarea> listasDeTareas;

}
