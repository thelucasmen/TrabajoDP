
import java.lang.*;
import java.util.*;
/**
 * Main simulation class. 
 * First, initial data are loaded. 
 * Then, while not end of the simulation, the actions will be performed.
 *
 * @author profesores DP 
 * @version 22/23
 */
public class CiclismoDemo
{    
    public static void main(String[] args)  throws java.io.IOException{
        Salida.abrirFlujo("Campeonato.txt");       
        HashSet<Etapa> etapas = new HashSet<Etapa>();
        HashMap<String, Equipo> equipos = new HashMap<String, Equipo>();
        List<Ciclista> ciclistasCarrera = new ArrayList<Ciclista>();
        
        Organizacion organizacion=new Organizacion("OrganizacionPrueba", etapas, equipos, ciclistasCarrera);
        //Descomentar de las líneas siguientes, la prueba que se quiera ejecutar
        
        /**DatosCampeonatoFinal**/
                //DatosCampeonatoCompletoFinal initdata = new DatosCampeonatoCompletoFinal(organizacion); 
                
        /**DatosCampeonatoAbandonosFinal**/
                DatosCampeonatoAbandonosFinal initdata = new DatosCampeonatoAbandonosFinal(organizacion); 
            
        organizacion.gestionarCarrera();
        
        Salida.cerrarFlujo();
    }    

}

