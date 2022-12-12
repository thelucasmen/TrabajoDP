import java.io.*;

/**
 * La clase Salida almacena el contenido pasado en un
 * fichero
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez)
 * @version (9.12.22)
 */
public class Salida{
    private static BufferedWriter writer = null; 
    
    /**
     * Opens the stream to the folder
     * 
     * @param String variable with the name of the folder
     * @throws IOException in case of fail
     */
    public static void abrirFlujo(String fichero){
        if(writer == null){
            try{
                writer = new BufferedWriter(new FileWriter(fichero));
            } catch(IOException e){
                System.out.println(e);
            } 
        }
    }
    
    /**
     * Writes the line and makes a jump line indicating
     * time of stream being opened.
     * 
     * @param String variable with what is going to be written
     * @throws IOException in case of fail
     */
    public static void volcarLinea(String linea){
        try{
            if(writer != null){
                writer.write(linea + "\n");        
            }
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    /**
     * Closes the stream.
     * 
     * @throws IOException in case of fail
     */
    public static void cerrarFlujo(){
        try{
            if(writer != null){
                writer.close();
            }
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
