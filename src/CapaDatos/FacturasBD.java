
package CapaDatos;

import CapaLogica.Factura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FacturasBD {
    private final String RUTA_ARCHIVO = System.getProperty("user.dir")+ "\\src\\Archivo\\Factura.txt";
    private FileOutputStream archivoSalida;
    private ObjectOutputStream oEscritor;
    private FileInputStream archivoEntrada;
    private ObjectInputStream oLector;
    private ArrayList<Factura> arrayFacturasTemp;
    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static FacturasBD instance = null;

    //Constructor privado, se implementa el patrón Singleton
    private FacturasBD() {
       
    }

    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static FacturasBD getInstance() {
        if (instance == null) {
            instance = new FacturasBD();
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
     * 
     * @return ArrayList
     */
     public ArrayList<Factura> listaFacturas(  ) throws Exception{
        ArrayList listaFacturas= new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
      try {         
            abrirArchivoInput(); //Se coloca al inicio del archivo
             //Si no hay más datos que leer el ciclo infinito se suspende y se va al catch
            while(true){
                Factura factura1 = (Factura)oLector.readObject();                
                listaFacturas.add(factura1);
            }
         } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
       catch(Exception ex ){
            
       }
      finally{
           //Ocurra o no ocurra la excepción se cierra el archivo
           cerrarArchivoInput();   
           return listaFacturas;
        } 
       
    }

   //Busca y retorna el objeto  de acuerdo al código que recibe como 
   //parámetro, en caso de que no lo encuentre retorna null
    public Factura consultarFacturas(int numeroFactura)throws Exception {
        Factura factura,facturaBuscada= null ;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
             while(true){
                factura = (Factura)oLector.readObject();  //Lee un objeto a la vez  
              
                if(factura.getNumeroFactura()==numeroFactura) {
                    facturaBuscada = factura;
                }
             }            
        }catch(Exception e){
            
        }
        finally{ //Suceda o no suceda la excepción se deben cerrar los archivos
             cerrarArchivoInput();    
             return facturaBuscada;
        }       
    }


    /**
     * 
     * @param 
     * @return void
     */
    public  void agregarFactura(Factura factura)throws Exception {        
        try {
            this.abrirArchivoOutput(); //se coloca al final del archivo
            if (oEscritor != null) {
              //Ejecutar la escritura del objeto  en el archivo
               oEscritor.writeObject(factura); //Serializa el objeto y lo graba en el archivo
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
     * 
     * @param 
     * @return void
     */
      public void modificarFactura(Factura factura) throws Exception{
        arrayFacturasTemp = new ArrayList<Factura>();
        try {            
            abrirArchivoInput();            
             //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
             Factura factura1=null;
            //Si no hay más datos que leer el método available retorna cero
             while(true){//Si va a leer y no hay objeto  se va por el catch
                 factura1 = (Factura)oLector.readObject(); //Si lee y no hay deparyamento que leer se cae
                 if(factura1.getNumeroFactura()==factura.getNumeroFactura()) {
                   factura1=factura;
                 }
                 arrayFacturasTemp.add(factura1);
             }  
        }
        catch(Exception ex){
            
        }
        finally{
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();        
        }
        
    }
    
    
    
    public void eliminarFactura(int numeroFactura) throws Exception {
        arrayFacturasTemp = new ArrayList<Factura>();
        try {            
            abrirArchivoInput();
            Factura factura = null;
            //Pasa al ArrayList temporal 
            while(true){
                 factura = (Factura)oLector.readObject();               
                 if(!(factura.getNumeroFactura()==numeroFactura)) {
                     arrayFacturasTemp.add(factura);
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
          if(!arrayFacturasTemp.isEmpty()){
              
             abrirArchivoOutput();  //Crea el nuevo archivo .txt
          //Pasa todos los del ArrayList al archivo
            for (Factura factura : arrayFacturasTemp) {
             oEscritor.writeObject(factura);   
             oEscritor.flush(); //Lo envía a disco
             oEscritor.reset(); //limpia el escritor para que se puedan grabar diferentes subclases
            }     
          }
          cerrarArchivoOutput();
    }  
  
}
