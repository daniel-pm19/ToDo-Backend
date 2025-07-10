package edu.workshop.todo.ToDo_maven.domain;

public class ToDoException extends Exception {

    public final static String TAREA_INEXISTENTE = "LA TAREA NO EXISTE";
    public final static String LISTA_INEXISTENTE = "LA LISTA NO EXISTE";
    public final static String GRUPO_INEXISTENTE = "EL GRUPO NO EXISTE";
    public final static String NOMBRE_GRUPO_INVALIDO = "NOMBRE DE GRUPO INVÁLIDO";
    public final static String LISTA_NO_ENCONTRADA = "LA LISTA NO SE ENCUENTRA";
    public final static String NOMBRE_LISTA_INVALIDO = "NOMBRE DE LISTA INVÁLIDO";
    public final static String USUARIO_NO_EXISTE = "EL USUARIO NO EXISTE";
    public final static String POMODORO_NO_PAUSADO = "EL POMODORO NO ESTÁ PAUSADO";
    public final static String POMODORO_ACTIVO = "YA HAY UN POMODORO ACTIVO";
    public final static String POMODORO_NO_ACTIVO = "NO HAY UN POMODORO ACTIVO";
    public final static String DESCANSO_CORTO_ACTIVO = "YA HAY UN DESCANSO CORTO ACTIVO";
    public final static String DESCANSO_CORTO_NO_ACTIVO = "NO HAY UN DESCANSO CORTO ACTIVO";
    public final static String DESCANSO_CORTO_NO_PAUSADO = "EL DESCANSO CORTO NO ESTA PAUSADO";
    public final static String DESCANSO_LARGO_ACTIVO = "YA HAY UN DESCANSO LARGO ACTIVO";
    public final static String DESCANSO_LARGO_NO_ACTIVO = "NO HAY UN DESCANSO LARGO ACTIVO";
    public final static String NO_EXISTE_UNA_NOTIFICACION_CON_ESE_MENSAJE = "LA NOTIFICACIÓN CON ESE MENSAJE NO EXISTE";

    public ToDoException(String message) {
        super(message);
    }
}
