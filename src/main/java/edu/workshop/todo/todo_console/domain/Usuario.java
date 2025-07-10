package edu.workshop.todo.ToDo_maven.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correoElectronico;
    private String contraseña;
    private String nombre;

    private Estadistica estadistica;
    private TemporizadorPomodoro pomodoro;
    private Historial historial;
    private ArrayList<Notificacion> notificaciones;
    private Calendario calendario;
    private ArrayList<GrupoDeLista> grupoDeListas;
    private ArrayList<ListaDeTarea> listaDeTareas;

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

    public ArrayList<Notificacion> getNotificaciones() {
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
