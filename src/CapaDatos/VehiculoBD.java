
package CapaDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import CapaLogica.Vehiculo;


public class VehiculoBD {
    private final String RUTA_ARCHIVO = System.getProperty("user.dir")+ "\\src\\Archivo\\Vehiculo.txt";
    private FileOutputStream archivoSalida;
    private ObjectOutputStream oEscritor;
    private FileInputStream archivoEntrada;
    private ObjectInputStream oLector;
    private ArrayList<Vehiculo> arrayVehiculosTemp;
    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static VehiculoBD instance = null;

    //Constructor privado, se implementa el patrón Singleton
    private VehiculoBD() {
       
    }

    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static VehiculoBD getInstance() {
        if (instance == null) {
            instance = new VehiculoBD();
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
     public ArrayList<Vehiculo> listaVehiculo(  ) throws Exception{
        ArrayList listaVehiculos= new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
      try {         
            abrirArchivoInput(); //Se coloca al inicio del archivo
             //Si no hay más datos que leer el ciclo infinito se suspende y se va al catch
            while(true){
                Vehiculo vehiculo1 = (Vehiculo)oLector.readObject();                
                listaVehiculos.add(vehiculo1);
            }
         } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
       catch(Exception ex ){
            
       }
      finally{
           //Ocurra o no ocurra la excepción se cierra el archivo
           cerrarArchivoInput();   
           return listaVehiculos;
        } 
       
    }

   //Busca y retorna el objeto  de acuerdo al código que recibe como 
   //parámetro, en caso de que no lo encuentre retorna null
    public Vehiculo consultarVehiculo(String codigo)throws Exception {
        Vehiculo vehiculo,vehiculoBuscado= null ;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
             while(true){
                vehiculo = (Vehiculo)oLector.readObject();  //Lee un objeto a la vez  
              
                if(vehiculo.getCodigoAuto().equals(codigo)) {
                    vehiculoBuscado = vehiculo;
                }
             }            
        }catch(Exception e){
            
        }
        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
             cerrarArchivoInput();    
             return vehiculoBuscado;
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
    public  void agregarVehiculo(Vehiculo vehiculo)throws Exception {        
        try {
            this.abrirArchivoOutput(); //se coloca al final del archivo
            if (oEscritor != null) {
              //Ejecutar la escritura del objeto  en el archivo
               oEscritor.writeObject(vehiculo); //Serializa el objeto y lo graba en el archivo
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
      public void modificarVehiculo(Vehiculo vehiculo) throws Exception{
        arrayVehiculosTemp = new ArrayList<Vehiculo>();
        try {            
            abrirArchivoInput();            
             //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
             Vehiculo vehiculo1=null;
            //Si no hay más datos que leer el método available retorna cero
             while(true){//Si va a leer y no hay objeto  se va por el catch
                 vehiculo1 = (Vehiculo)oLector.readObject(); //Si lee y no hay deparyamento que leer se cae
                 if(vehiculo1.getCodigoAuto().equalsIgnoreCase(vehiculo.getCodigoAuto())) {
                   vehiculo1=vehiculo;
                 }
                 arrayVehiculosTemp.add(vehiculo1);
             }  
        }
        catch(Exception ex){
            
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();        
        }
        
    }
    
    
    
    public void eliminarVehiculo(String codigo) throws Exception {
        arrayVehiculosTemp = new ArrayList<Vehiculo>();
        try {            
            abrirArchivoInput();
            Vehiculo vehiculo1 = null;
            //Pasa al ArrayList temporal todos los  cuyo código es 
            //diferente al del  que se recibe como parámetro
            while(true){
                 vehiculo1 = (Vehiculo)oLector.readObject();               
                 if(!vehiculo1.getCodigoAuto().equalsIgnoreCase(codigo)) {
                     arrayVehiculosTemp.add(vehiculo1);
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
          if(!arrayVehiculosTemp.isEmpty()){
              
             abrirArchivoOutput();  //Crea el nuevo archivo .txt
          //Pasa todos los  del ArrayList al archivo
            for (Vehiculo vehiculo : arrayVehiculosTemp) {
             oEscritor.writeObject(vehiculo);   
             oEscritor.flush(); //Lo envía a disco
             oEscritor.reset(); //limpia el escritor para que se puedan grabar diferentes subclases
            }     
          }
          cerrarArchivoOutput();
    }  
  
}
