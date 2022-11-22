import java.util.*;

/**
 * Write a description of class CiclistaExperimentado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaExperimentado extends Ciclista
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List<Resultado> resultados;
    private Equipo equipo;

    /**
     * Constructor for objects of class CiclistaExperimentado
     */
    public CiclistaExperimentado(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo);
    }

    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 4) / 130 * 10;
    }
}
