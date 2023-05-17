import java.util.*;

/**
 * La clase ciclista novato es un complemento excluyente de la clase ciclista.
 * Si un ciclista es novato, entonces no puede ser experimentado ni estrella.
 * 
 * Contiene además las operaciones basicas para interactuar con las otras clases
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class CiclistaNovato extends Ciclista
{
   // instance variables - replace the example below with your own
    //private String nombre;
    //private Bicicleta bicicleta;
    //private Habilidad habilidad;
    //private double energia;
    //private List resultados;
    //private Equipo equipo;

    /**
     * Constructor for objects of class Ciclista
     */
    /*public CiclistaNovato(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, List resultados, Equipo equipo)
    {
       super(nombre, bicicleta, habilidad, energia, resultados, equipo);
       this.nombre = nombre;
       this.bicicleta = bicicleta;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;
       this.resultados = resultados;
    }*/
    
    public CiclistaNovato(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo);          
       //resultados = new ArrayList();
    }
        
        /*Funcionalidad */        
    //((habilidad del Ciclista + 2) / 120) * 10
    @Override
    public double calculaDestreza(){    
        return (getHabilidad().getHabilidadCiclista() + 2) / 120 * 10;
    }
}