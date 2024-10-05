package com.umg.analisis_sistemas.exceptions;

/**
 *
 * @author capi juarez
 */

public enum ErrorEnum {

    I_DESCONOCIDO                           (1000, EstadoHttp.INTERNAL_SERVER_ERROR, "Error desconocido, comuniquese con el administrador del sitio"),
    USUARIO_NOT_FOUND                       (1001, EstadoHttp.BAD_REQUEST, "Error Usuario no encontrado"),
    I_PRIMARY_KEY                           (1002, EstadoHttp.INTERNAL_SERVER_ERROR, "No se pudo crear la llave primaria para el nuevo registro"),
    I_PROYECTO_S_TAREAS                     (1003, EstadoHttp.BAD_REQUEST, "El proyecto no tiene tareas asignadas, por favor asigne tareas al proyecto"),
    I_USUARIO_S_TAREAS                      (1004, EstadoHttp.BAD_REQUEST, "El usuario no tiene tareas asignadas");

//______________________________________________________________________________
    /**
     * <p>Codigo de error.</p>
     */
    private final int codigo;
//______________________________________________________________________________
    /**
     * <p>Codigo de estado Http.</p>
     */
    private final int estadoHttp;
//______________________________________________________________________________
    /**
     * <p>Descripcion del error.</p>
     */
    private final String descripcion;
//______________________________________________________________________________
    /**
     * <p>Constructor de la enumeracion, establece el valor de los atributos.</p>
     *
     * @param pCodigo Codigo de error
     * @param pEstadoHttp Codigo de estado de Http.
     * @param pMensaje Descripcion de error
     */
    private ErrorEnum(int pCodigo, int pEstadoHttp, String pMensaje) {
        this.codigo = pCodigo;
        this.estadoHttp = pEstadoHttp;
        this.descripcion = pMensaje;
    }
//______________________________________________________________________________
    /**
     * <p>Codigo que identifica el error de forma unica.</p>
     *
     * @return int Codigo de error
     */
    public int getCodigo() {
        return codigo;
    }
//______________________________________________________________________________
    /**
     * <p>Codigo de estado Http.</p>
     *
     * @return int Estado Http
     */
    public int getEstadoHttp() {
        return estadoHttp;
    }
//______________________________________________________________________________
    /**
     * <p>Descripcion del error, proporciona un punto de inicio para que el
     * usuario sepa que correcciones realizar.</p>
     *
     * @return String Descripcion del error
     */
    public String getDescripcion() {
        return descripcion;
    }
}

