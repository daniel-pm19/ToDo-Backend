package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "grupodelistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GrupoDeLista {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String nombre;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column
    private LocalDate fechaDeCreacion;

    @OneToMany(mappedBy = "grupoDeLista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListaDeTarea> listasDeTareas;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuario;

}
