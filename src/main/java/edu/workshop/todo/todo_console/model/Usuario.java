package edu.workshop.todo.todo_console.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    private String correoElectronico;
    private String contraseña;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estadistica_id")
    private Estadistica estadistica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pomodoro_id")
    private TemporizadorPomodoro pomodoro;

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

    public Usuario() {
    }

    public Usuario(String newNombre, String newCorreoElectronico, String newContraseña, Estadistica newEstadistica,
            TemporizadorPomodoro newPomodoro,
            Historial newHistorial, Calendario newCalendario) {

        correoElectronico = newCorreoElectronico;
        contraseña = newContraseña;
        nombre = newNombre;
        estadistica = newEstadistica;
        pomodoro = newPomodoro;
        historial = newHistorial;
        calendario = newCalendario;
        grupoDeListas = new ArrayList<>();
        listaDeTareas = new ArrayList<>();
        notificaciones = new ArrayList<>();
    }

    public Usuario(String newNombre, String newCorreoElectronico, String newContraseña) {
        nombre = newNombre;
        correoElectronico = newCorreoElectronico;
        contraseña = newContraseña;
    }

    private Notificacion buscarNotificacion(String mensaje) throws ToDoException {
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.getMensaje().equals(mensaje)) {
                return notificacion;
            }
        }
        throw new ToDoException(ToDoException.NO_EXISTE_UNA_NOTIFICACION_CON_ESE_MENSAJE);
    }

    public String mostrarNotificacion(String mensaje) throws ToDoException {
        return buscarNotificacion(mensaje).getMensaje();
    }

    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void crearLista(String nombreLista) throws ToDoException {
        if (nombreLista == null || nombreLista.isEmpty())
            throw new ToDoException(ToDoException.NOMBRE_LISTA_INVALIDO);

        int cont = 0;
        for (ListaDeTarea lista : listaDeTareas) {
            if (lista.getNombre().equals(nombreLista)) {
                nombreLista = nombreLista + " (" + cont + ")";
            }
        }
        ListaDeTarea nuevaLista = new ListaDeTarea(nombreLista, LocalDate.now());
        listaDeTareas.add(nuevaLista);
    }

    public void eliminarLista(ListaDeTarea lista) throws ToDoException {
        if (lista == null)
            throw new ToDoException(ToDoException.LISTA_INEXISTENTE);
        listaDeTareas.remove(lista);
    }

    public void crearGrupo(String nombreGrupo) throws ToDoException {
        if (nombreGrupo == null || nombreGrupo.isEmpty())
            throw new ToDoException(ToDoException.NOMBRE_GRUPO_INVALIDO);

        int cont = 0;
        for (GrupoDeLista grupo : grupoDeListas) {
            if (grupo.getNombre().equals(nombreGrupo)) {
                nombreGrupo = nombreGrupo + " (" + cont + ")";
            }
        }

        GrupoDeLista nuevoGrupo = new GrupoDeLista(nombreGrupo, LocalDate.now());
        grupoDeListas.add(nuevoGrupo);

    }

    public void eliminarGrupo(GrupoDeLista grupo) throws ToDoException {
        if (grupo == null)
            throw new ToDoException(ToDoException.GRUPO_INEXISTENTE);
        grupoDeListas.remove(grupo);
    }

    public String mostrarHistorial() {
        return historial.historialTareas();
    }

}
