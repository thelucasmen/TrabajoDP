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
    public CiclistaEstrella(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, List<Resultado> resultado, Equipo equipo)
    {
       super(nombre, bicicleta, habilidad, energia, resultado, equipo);
       this.popularidad = 6;       
    }
    
    public CiclistaEstrella(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo);
       this.nombre = nombre;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;
       this.popularidad = 6;  
    }
    
    public void setPopularidad(int popularidad){
        this.popularidad = popularidad;
    }
    
    public int getPopularidad(){
        return popularidad;
    }
    
    public void mostrar()
    {
        //<CiclistaExperimentado:LABOUS> <energía: 1150.0> <habilidad:Buena (valor:8.0)> <tiempo acumulado sin abandonar: 0.0> <abandonado:false> <popularidad: 6>
        System.out.print("<CiclistaEstrella: " + nombre + "> <energía: " + energia + "> <habilidad:");
        habilidad.mostrar(); 
        System.out.print("> <tiempo acumulado sin abandonar: " + tiempoAcumulado() + ">\n<abandonado:" + abandonado() + "> <popularidad: " + getPopularidad() + ">\n");                
    }
    
    //Suma o resta popularidad segun el tiempo
    public void SerPopular(double tiempo){
        if(tiempo<160){
           setPopularidad(getPopularidad()+4); 
        } else {
            setPopularidad(getPopularidad()-1);
        }
        
    }
    
    //(((habilidad del Ciclista + 6) / 140) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 6) / 140 * 10;
    }
}
