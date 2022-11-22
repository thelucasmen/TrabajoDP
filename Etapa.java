import java.util.*;

/**
 * 
 * Cada etapa está compuesta por un nombre, una distancia y una dificultad.
 * Las operaciones en esta clase son las básicas para poder interactuar con
 * otras clases. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
    private double dificultad;
    private double distancia;
    private String nombre;
    private List<Ciclista> ciclistas;
    

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(String nombre, double dificultad, double distancia)
    {
        // initialise instance variables
        this.dificultad = dificultad;
        this.distancia = distancia;
        this.nombre = nombre;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public double getDificultad(){        
        return dificultad;    
    }  
    
    public double getDistancia(){      
        return distancia;        
    }
    
    public String getNombre(){       
        return nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public void setDistancia(double d){
        this.distancia = d;
    }
    
    public void setDificultad(double diff){
        this.dificultad = diff;
    }
    
    public void setCiclista(Ciclista ciclista){
        this.ciclistas.add(ciclista);
    }
    
    public void mostrar()
    {
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        System.out.println("Nombre etapa: " + nombre);
        System.out.println("Distancia: " + distancia + " kilómetros");
        System.out.println("Dificultad: " + dificultad); 
        System.out.println("Ciclistas: "); 
        
        if(ciclistas.size()>0){   
            while (itc.hasNext()) {
                itc.next().mostrar();
            }
        }
    }
}
