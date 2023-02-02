import java.util.*;

/**
 * Write a description of class CiclistaEstrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaEstrella extends Ciclista 
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List<Resultado> resultados;
    private Equipo equipo;
    private int popularidad;

    /**
     * Constructor for objects of class Ciclista
     */
    public CiclistaEstrella(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, List<Resultado> resultados, Equipo equipo)
    {
       super(nombre, bicicleta, habilidad, energia, resultados, equipo);
       this.nombre = nombre;
       this.bicicleta = bicicleta;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;
       this.popularidad = 6; 
       this.resultados = resultados;
    }
    
    public CiclistaEstrella(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo); 
       this.nombre = nombre;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;       
       resultados = new ArrayList();
    }
    
    public void setPopularidad(int popularidad){
        this.popularidad = popularidad;
    }
    
    public int getPopularidad(){
        return popularidad;
    }

    public String toString()
    {
        //<CiclistaExperimentado:LABOUS> <energía: 1150.0> <habilidad:Buena (valor:8.0)> <tiempo acumulado sin abandonar: 0.0> <abandonado:false> <popularidad: 6>
        String mostrar = "<CiclistaEstrella: " + nombre + "> <energía: " + String.format("%.2f",energia) + "> <habilidad:";
        mostrar += habilidad; 
        mostrar += "> <tiempo acumulado sin abandonar: " + String.format("%.2f",tiempoAcumulado()) + 
                         "> <abandonado:" + abandonado() + "> <popularidad: " + getPopularidad() + ">";  
        
        return(mostrar);             
    }
    
        /*Funcionalidad */
    //Suma o resta popularidad segun el tiempo
    public String SerPopular(double tiempo){
        String salida = "";
        if(tiempo<160){
           setPopularidad(getPopularidad()+4); 
           salida += "+++ La popularidad del ciclista " + getNombre() + 
                         " ha aumentado y ahora su nivel de popularidad es de: " + getPopularidad() + " unidades\n" +
                         "@@@\n";
        } else {
            setPopularidad(getPopularidad()-1);
            salida += "+++ La popularidad del ciclista " + getNombre() + 
                         " ha disminuido y ahora su nivel de popularidad es de: " + getPopularidad() + " unidades\n" +
                         "@@@";
        }
        return salida;
    }
    
    //(((habilidad del Ciclista + 6) / 140) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 6) / 140 * 10;
    }
    
    //Devuelve un booleano que indica si el ciclista es estrella o no
    public boolean esEstrella(){
        return true;
    }
}
