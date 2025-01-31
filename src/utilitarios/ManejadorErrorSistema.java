/*
 * Universidad Técnica Nacional - UTN
 * Carrera de Ingeniería del Software
 * Curso ISW-311 Programación II
 * Prof. Ing. Alexánder Agüero Castillo
 */
package utilitarios;

/**
 * Clase ManejadorErrorSistema: Para el control de los errores que ocurren
 durante la ejecución de la aplicación
 Referencia: Material de Curso
 * @author Ing. Alexander Agüero Castillo
 * @version 3.0
 * @since Julio 2019
 */
public class ManejadorErrorSistema {
    private static boolean hayError = false;
    private static String identificadorError = "";
    private static String mensajeGeneral = "";
    private static String mensajeDetallado = "";
    private static String nombreClase = "";
    private static String nombreMetodo = "";

    /**
     * Constructor de la clase
     * @param identificadorError Identificador del error
     * @param mensajeGeneral Mensaje general del error
     * @param mensajeDetallado Mensaje detallado del error
     * @param nombreClase Nombre de la clase donde se disparó el error
     * @param nombreMetodo Nombre del método que originó el error
     */
    public static void registrarError(String identificadorError, String mensajeGeneral, String mensajeDetallado,
                               String nombreClase, String nombreMetodo) {
        ManejadorErrorSistema.hayError = true;
        ManejadorErrorSistema.identificadorError = identificadorError;
        ManejadorErrorSistema.mensajeGeneral = mensajeGeneral;
        ManejadorErrorSistema.mensajeDetallado = mensajeDetallado;
        ManejadorErrorSistema.nombreClase = nombreClase;
        ManejadorErrorSistema.nombreMetodo = nombreMetodo;
    }

    /**
     * Asigna la bandera del error en false
     * y todos los demas valores se inicializa
     * como vacios
     */
    public static void limpiarError() {
        ManejadorErrorSistema.hayError = false;
        ManejadorErrorSistema.identificadorError = "";
        ManejadorErrorSistema.mensajeGeneral = "";
        ManejadorErrorSistema.mensajeDetallado = "";
        ManejadorErrorSistema.nombreClase = "";
        ManejadorErrorSistema.nombreMetodo = "";
    }

    public static String getIdentificadorError() {
        return ManejadorErrorSistema.identificadorError;
    }

    public static boolean getHayError() {
        return ManejadorErrorSistema.hayError;
    }

    public static String getMensajeGeneral() {
        return ManejadorErrorSistema.mensajeGeneral;
    }

    public static String getMensajeDetallado() {
        return ManejadorErrorSistema.mensajeDetallado;
    }

    public static String getNombreClase() {
        return ManejadorErrorSistema.nombreClase;
    }

    public static String getNombreMetodo() {
        return nombreMetodo;
    }
    
    /**
     * Retornar el error si está registrado
     * @return El mensaje completo del error
     */
    public static String getMensajeErrorCompleto(){
        String vHilera = "";
        
        if (ManejadorErrorSistema.hayError){
            vHilera = "\nError " + ManejadorErrorSistema.identificadorError +
                      "\nDescripción del error : " + ManejadorErrorSistema.mensajeGeneral + 
                      "\nDetalle del error : " + ManejadorErrorSistema.mensajeDetallado + 
                      "\nClase/Método : [" + ManejadorErrorSistema.nombreClase + 
                      "].[" + ManejadorErrorSistema.nombreMetodo + "].";                   
        }else {
            vHilera = "\nNo hay errores registrados.";
        }
        
        return vHilera;    
    }    
}
