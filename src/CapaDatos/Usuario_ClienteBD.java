
package CapaDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import CapaLogica.Usuario_Cliente;


public class Usuario_ClienteBD {
    private final String RUTA_ARCHIVO = System.getProperty("user.dir")+ "\\src\\Archivo\\Usuario_Cliente.txt";
    private FileOutputStream archivoSalida;
    private ObjectOutputStream oEscritor;
    private FileInputStream archivoEntrada;
    private ObjectInputStream oLector;
    private ArrayList<Usuario_Cliente> arrayUsuario_ClientesTemp;
    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static Usuario_ClienteBD instance = null;

    //Constructor privado, se implementa el patrón Singleton
    private Usuario_ClienteBD() {
       
    }

    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static Usuario_ClienteBD getInstance() {
        if (instance == null) {
            instance = new Usuario_ClienteBD();
        }
        return instance;
    }

    //OJO: este tipo de comentario genera la ayuda del método
    /**
     * Abre el archivo de datos, para escritura (de tipo output)
     * Tipo de Archivo: Secuencial. Lanza la Exception al
     * nivel donde fue llamado
     *
     * @param 
     * @return no retorna
     */
    public void abrirArchivoOutput() throws Exception { //para grabar en él
        //Abrir el archivo y colocarse al final del archivo
        try {
            File oArchivo = new File(RUTA_ARCHIVO);
            if (!oArchivo.exists()) {
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo
                //true indica que se agregarán registros al final            
                archivoSalida = new FileOutputStream(RUTA_ARCHIVO, true);
                oEscritor = new ObjectOutputStream(archivoSalida);
            } else {
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo y no se desea continuar escribiendo cabecera
                archivoSalida = new FileOutputStream(RUTA_ARCHIVO, true);
                oEscritor = new MiObjectOutputStream(archivoSalida);
            }
        } catch (Exception e) {
            throw e; //Se lanza al método que invocó al método en que estoy
        }
    }

    /**
     * Abre  el archivo de datos, para lectura (de tipo input) El
     * apuntador del archivo se coloca al inicio del archivo 
     * Tipo de Archivo: Secuencial.
     *
     * @param 
     * @return void
     */
    public void abrirArchivoInput() throws Exception { //para leer del archivo
        //Abrir el archivo y colocarse al inicio del mismo
        try {
            archivoEntrada = new FileInputStream(RUTA_ARCHIVO);
            oLector = new ObjectInputStream(archivoEntrada);
        } catch (Exception e) {
            throw e;
        }
    }

    
    public void cerrarArchivoOutput() throws Exception {
        try {
            if (oEscritor != null) {
                oEscritor.close();
                oEscritor = null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
     /**
     * Permite cerrar el archivo de datos que se abrió para lectura
     */
    private void cerrarArchivoInput() throws Exception {
        try {
            if (oLector != null) {
                oLector.close();
                oLector = null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Lista de todos los  que se encuentran en el archivo
     * @return ArrayList
     */
     public ArrayList<Usuario_Cliente> listaUsuario_Clientes(  ) throws Exception{
        ArrayList listaUsuario_Clientes= new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
      try {         
            abrirArchivoInput(); //Se coloca al inicio del archivo
             //Si no hay más datos que leer el ciclo infinito se suspende y se va al catch
            while(true){
                Usuario_Cliente usuario_Cliente1 = (Usuario_Cliente)oLector.readObject();                
                listaUsuario_Clientes.add(usuario_Cliente1);
            }
         } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
       catch(Exception ex ){
            
       }
      finally{
           //Ocurra o no ocurra la excepción se cierra el archivo
           cerrarArchivoInput();   
           return listaUsuario_Clientes;
        } 
       
    }

   //Busca y retorna el objeto  de acuerdo al código que recibe como 
   //parámetro, en caso de que no lo encuentre retorna null
    public Usuario_Cliente consultarUsuario_Cliente(String correoUsuario,String clave)throws Exception {
        Usuario_Cliente usuario_Cliente,usuario_ClienteBuscado= null ;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
             while(true){
                usuario_Cliente = (Usuario_Cliente)oLector.readObject();  //Lee un objeto a la vez  
              
                if(usuario_Cliente.getUsuario().getCorreo().equalsIgnoreCase(correoUsuario)&&usuario_Cliente.getUsuario().getClave().equals(clave)) {
                    usuario_ClienteBuscado = usuario_Cliente;
                }
             }            
        }catch(Exception e){
            
        }
        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
             cerrarArchivoInput();    
             return usuario_ClienteBuscado;
        }       
    }

//    public Usuario_Cliente consultarUsuario_Cliente_Por_Correo_Nombre_Cedula(String correoUsuario, String nombre, String cedula)throws Exception {
//        Usuario_Cliente usuario_Cliente,usuario_ClienteBuscado= null ;
//        try {
//            abrirArchivoInput();
//            //Si no hay más datos que leer el método available retorna cero
//             while(true){
//                usuario_Cliente = (Usuario_Cliente)oLector.readObject();  //Lee un objeto a la vez  
//              
//                if(usuario_Cliente.getUsuario().getCorreo().equalsIgnoreCase(correoUsuario)||usuario_Cliente.getUsuario().getNombre().equalsIgnoreCase(nombre)||
//                        usuario_Cliente.getIdentificacion().equalsIgnoreCase(cedula)) {
//                    usuario_ClienteBuscado = usuario_Cliente;
//                }
//             }            
//        }catch(Exception e){
//            
//        }
//        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
//             cerrarArchivoInput();    
//             return usuario_ClienteBuscado;
//        }       
//    }

    /**
     * Agregar un nuevo  al final del archivo
     * @param  
     * @return void
     */
    public  void agregarUsuario_Cliente(Usuario_Cliente usuario_Cliente)throws Exception {        
        try {
            this.abrirArchivoOutput(); //se coloca al final del archivo
            if (oEscritor != null) {
              //Ejecutar la escritura del objeto  en el archivo
               oEscritor.writeObject(usuario_Cliente); //Serializa el objeto y lo graba en el archivo
               oEscritor.flush();  //Envía el contenido del buffer al archivo
               oEscritor.reset();//Se requiere para cuando se reciben subclases de , es obligatorio si hay herencia
            }
        
        } catch (Exception e) {
            throw e;
        }
        finally{
            //Ocurra o no la excepción se debe cerrar el archivo
            this.cerrarArchivoOutput(); //Cierra el archivo
        }        
    }

    /**
     * Agregar un nuevo  al archivo
     * @param 
     * @return void
     */
      public void modificarUsuario_Cliente(Usuario_Cliente usuario_Cliente) throws Exception{
        arrayUsuario_ClientesTemp = new ArrayList<Usuario_Cliente>();
        try {            
            abrirArchivoInput();            
             //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
             Usuario_Cliente usuario1=null;
            //Si no hay más datos que leer el método available retorna cero
             while(true){//Si va a leer y no hay objeto  se va por el catch
                 usuario1 = (Usuario_Cliente)oLector.readObject(); //Si lee y no hay deparyamento que leer se cae
                 if(usuario1.getUsuario().getCorreo().equalsIgnoreCase(usuario_Cliente.getUsuario().getCorreo())) {
                   usuario1=usuario_Cliente;
                 }
                 arrayUsuario_ClientesTemp.add(usuario1);
             }  
        }
        catch(Exception ex){
            
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();        
        }
        
    }
    
    
    
    public void eliminarUsuario_Cliente(String correoUsuario) throws Exception {
        arrayUsuario_ClientesTemp = new ArrayList<Usuario_Cliente>();
        try {            
            abrirArchivoInput();
            Usuario_Cliente usuario1 = null;
            //Pasa al ArrayList temporal todos los  cuyo código es 
            //diferente al del  que se recibe como parámetro
            while(true){
                 usuario1 = (Usuario_Cliente)oLector.readObject();               
                 if(!usuario1.getUsuario().getCorreo().equalsIgnoreCase(correoUsuario)) {
                     arrayUsuario_ClientesTemp.add(usuario1);
                 }
             }                       
        }catch(Exception e){      
           
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo(); 
        }               
    }
    

    private void pasarArrayTemporal_Archivo() throws Exception {       
       File archivoOriginal = new File(RUTA_ARCHIVO);
       //Si hay  en el ArrayList y el archivo existe
       //borra el archivo original para volverlo a llenar           
       
            if(archivoOriginal.exists()){
                   archivoOriginal.delete();
            }
          if(!arrayUsuario_ClientesTemp.isEmpty()){
              
             abrirArchivoOutput();  //Crea el nuevo archivo .txt
          //Pasa todos los  del ArrayList al archivo
            for (Usuario_Cliente usuario_Cliente : arrayUsuario_ClientesTemp) {
             oEscritor.writeObject(usuario_Cliente);   
             oEscritor.flush(); //Lo envía a disco
             oEscritor.reset(); //limpia el escritor para que se puedan grabar diferentes subclases
            }     
          }
          cerrarArchivoOutput();
    }  
  
}
