package edu.workshop.todo.ToDo_maven.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TemporizadorPomodoro {
    private static final int DURACION_POMODORO = 25;
    private static final int DURACION_DESCANSO_CORTO = 5;
    private static final int DURACION_DESCANSO_LARGO = 15;
    private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;
    private LocalDateTime tiempoInicioDescanso;
    private LocalDateTime tiempoFinDescanso;

    private Duration tiempoRestantePomodoro;
    private Duration tiempoRestanteDescansoCorto;
    private Duration tiempoRestanteDescansoLargo;
    private boolean pomodoroActivo;
    private boolean pomodoroPausado;
    private boolean descansoCortoActivo;
    private boolean descansoCortoPausado;
    private boolean descansoLargoActivo;
    private boolean descansoLargoPausado;

    public TemporizadorPomodoro(boolean nuevoPomodoroPausado, boolean nuevoDescansoCortoPausado,
            boolean nuevoDescansoLargoPausado) {
        tiempoInicio = null;
        tiempoFin = null;
        tiempoInicioDescanso = null;
        tiempoFinDescanso = null;
        tiempoRestantePomodoro = null;
        tiempoRestanteDescansoCorto = null;
        tiempoRestanteDescansoLargo = null;
        pomodoroActivo = false;
        pomodoroPausado = nuevoPomodoroPausado = false;
        descansoCortoActivo = false;
        descansoCortoPausado = nuevoDescansoCortoPausado = false;
        descansoLargoActivo = false;
        descansoLargoPausado = nuevoDescansoLargoPausado = false;
    }

    public boolean iniciarPomodoro() throws ToDoException {
        if (pomodoroActivo)
            throw new ToDoException(ToDoException.POMODORO_ACTIVO);
        tiempoInicio = LocalDateTime.now();
        tiempoFin = tiempoInicio.plusMinutes(DURACION_POMODORO);
        return pomodoroActivo = true;
    }

    public boolean detenerPomodoro() throws ToDoException {
        if (!pomodoroActivo)
            throw new ToDoException(ToDoException.POMODORO_NO_ACTIVO);
        tiempoRestantePomodoro = Duration.between(LocalDateTime.now(), tiempoFin);
        pomodoroPausado = true;
        return pomodoroActivo = false;
    }

    public boolean reanudarPomodoro() throws ToDoException {
        if (!pomodoroPausado)
            throw new ToDoException(ToDoException.POMODORO_NO_PAUSADO);
        tiempoInicio = LocalDateTime.now();
        tiempoFin = tiempoInicio.plus(tiempoRestantePomodoro);
        pomodoroPausado = false;
        return pomodoroActivo = true;
    }

    public void reiniciarPomodoro() {
        tiempoInicio = null;
        tiempoFin = null;
        tiempoRestantePomodoro = null;
        pomodoroPausado = false;
        pomodoroActivo = false;
    }

    public boolean iniciarDescansoCorto() throws ToDoException {
        if (descansoCortoActivo)
            throw new ToDoException(ToDoException.DESCANSO_CORTO_ACTIVO);
        tiempoInicioDescanso = LocalDateTime.now();
        tiempoFinDescanso = tiempoInicioDescanso.plusMinutes(DURACION_DESCANSO_CORTO);
        return descansoCortoActivo = true;
    }

    public boolean pausarDescansoCorto() throws ToDoException {
        if (!descansoCortoActivo)
            throw new ToDoException(ToDoException.DESCANSO_CORTO_NO_ACTIVO);
        tiempoRestanteDescansoCorto = Duration.between(LocalDateTime.now(), tiempoFinDescanso);
        descansoCortoPausado = true;
        return descansoCortoActivo = false;
    }

    public boolean reanudarDescansoCorto() throws ToDoException {
        if (!descansoCortoPausado)
            throw new ToDoException(ToDoException.DESCANSO_CORTO_NO_PAUSADO);
        tiempoInicioDescanso = LocalDateTime.now();
        tiempoFinDescanso = tiempoInicioDescanso.plus(tiempoRestanteDescansoCorto);
        descansoCortoPausado = false;
        return descansoCortoActivo = true;
    }

    public void reiniciarDescansoCorto() {
        tiempoInicioDescanso = null;
        tiempoFinDescanso = null;
        tiempoRestanteDescansoCorto = null;
        descansoCortoPausado = false;
    }

    public boolean iniciarDescansoLargo() throws ToDoException {
        if (descansoLargoActivo)
            throw new ToDoException(ToDoException.DESCANSO_LARGO_ACTIVO);
        tiempoInicioDescanso = LocalDateTime.now();
        tiempoFinDescanso = tiempoInicioDescanso.plusMinutes(DURACION_DESCANSO_LARGO);
        return descansoLargoActivo = true;
    }

    public boolean pausarDescansoLargo() throws ToDoException {
        if (!descansoLargoActivo)
            throw new ToDoException(ToDoException.DESCANSO_LARGO_NO_ACTIVO);
        tiempoRestanteDescansoLargo = Duration.between(LocalDateTime.now(), tiempoFinDescanso);
        descansoLargoPausado = true;
        return descansoLargoActivo = false;
    }

    public boolean reanudarDescansoLargo() throws ToDoException {
        if (!descansoLargoPausado)
            throw new ToDoException(ToDoException.DESCANSO_LARGO_NO_ACTIVO);
        tiempoInicioDescanso = LocalDateTime.now();
        tiempoFinDescanso = tiempoInicioDescanso.plus(tiempoRestanteDescansoLargo);
        descansoLargoPausado = false;
        return descansoLargoActivo = true;
    }

    public void reiniciarDescansoLargo() {
        tiempoInicioDescanso = null;
        tiempoFinDescanso = null;
        tiempoRestanteDescansoLargo = null;
        descansoLargoPausado = false;
    }

}
