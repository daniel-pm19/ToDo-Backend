package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.model.*;
import edu.workshop.todo.todo_console.service.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grupodelistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDeLista {

    @Id
    private Long id;

    private String nombre;
    private LocalDate fechaDeCreacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "grupodelistas_id")
    private List<ListaDeTarea> listasDeTareas;

}
