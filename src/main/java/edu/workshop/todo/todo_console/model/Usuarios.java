package edu.workshop.todo.todo_console.model;

import edu.workshop.todo.todo_console.dto.EstadisticaDTO;
import edu.workshop.todo.todo_console.service.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.Builder;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuarios {
    @Id
    @Column
    @NotBlank(message = "USER ID cannot be blank")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Full name cannot be blank")
    @Size(max = 100, message = "El nombre no debe contener mas de 100 caracteres")
    private String nombre;

    @Column
    @NotBlank(message = "Email no pueder estar vacio")
    @Email(message = "Email debe ser valido")
    @Size(max = 50, message = "Email debe tener como maximo 50 caracteres")
    private String correoElectronico;

    @Column(nullable = false)
    @NotBlank(message = "Contraseña no puede estar vacia")
    private String contraseña;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadistica_id")
    private Estadistica estadistica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "historial_id")
    private Historial historial;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<Notificacion> notificaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendario_id")
    private Calendario calendario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private List<GrupoDeLista> grupoDeListas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // añadir fks
    @JoinColumn(name = "usuario_id") // se refiere a la clave forannea en la tabla de lista de tareas
    private List<ListaDeTarea> listaDeTareas;

}