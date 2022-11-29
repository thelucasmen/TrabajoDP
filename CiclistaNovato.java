import java.util.*;

/**
 * Write a description of class CiclistaNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaNovato extends Ciclista
{
   // instance variables - replace the example below with your own
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List<Resultado> resultados;
    private Equipo equipo;

    /**
     * Constructor for objects of class Ciclista
     */
    public CiclistaNovato(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, List<Resultado> resultado, Equipo equipo)
    {
       super(nombre, bicicleta, habilidad, energia, resultado, equipo);
    }
    
    public CiclistaNovato(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo);
    }

    //((habilidad del Ciclista + 2) / 120) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 2) / 120 * 10;
    }
}
