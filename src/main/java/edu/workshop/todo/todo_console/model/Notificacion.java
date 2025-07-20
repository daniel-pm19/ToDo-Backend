package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;
import lombok.Builder;

@Entity
@Table(name = "notificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notificacion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max = 100, message = "La máxima longitud del titulo es 100 caracteres")
    private String titulo;

    @Column(nullable = false)
    @Size(max = 100, message = "La máxima longitud del mensaje es 100 caracteres")
    private String mensaje;

    @Column
    @NotNull(message = "La fecha No puede ser nula")
    @PastOrPresent
    private LocalDate fechaDeCreacion;
}
