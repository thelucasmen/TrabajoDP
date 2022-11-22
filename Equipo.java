import java.util.*;

/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo 
{
    // instance variables - replace the example below with your own
    private String nombre;
    private List<Ciclista> ciclistas;
    private List<Ciclista> ciclistasA;
    private List<Bicicleta> bicicletas;
    
    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre)
    {    
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasA = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();
    }   

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public void addCiclista(Ciclista ciclista){
        this.ciclistas.add(ciclista);
    }
    
    public void setCa(Ciclista ciclistaA){
        this.ciclistasA.add(ciclistaA);
    }
    
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    public String getNombre(){
        return nombre;
    }
    
        /*Funcionalidad */    
    public void mostrar(){
        System.out.println("Nombre equipo: " + nombre);
        if(ciclistas.size()>0){
            for(Ciclista ciclista : ciclistas){
                ciclista.mostrar();
            }
        }
        else{
            System.out.println("El equipo no tiene ningún ciclista");
        }
        if(ciclistasA.size()>0){
            for(Ciclista ciclistaA : ciclistasA){
                ciclistaA.mostrar();
            }
        }
        else{
            System.out.println("Ningún ciclista del equipo ha abandonado");
        }
        if(bicicletas.size()>0){
            for(Bicicleta bicicleta : bicicletas){
                bicicleta.mostrar();
            }
        }
        else{
            System.out.println("El equipo no posee ninguna bicicleta");
        }
    }
    
    public Ciclista getCiclista(int i){
        //si el i elegido es mas grande que el numero de ciclistas devuelve un ciclista null 
        Ciclista ciclista = null;
        if(i>=0 && i<ciclistas.size()){
            ciclista = ciclistas.get(i);
        }
        else{
            System.out.println("El número elegido es mayor que la cantidad de ciclistas");
        }
        return ciclista;
    }
    
    public Ciclista getCa(int i){
        return ciclistasA.get(i);
    }
    
    public Bicicleta getBicicleta(int i){
        return bicicletas.get(i);
    }
    //cambiar borrar x borrar con iterator
    public void borrarCiclista(int i){
        if(i>=0 && i<ciclistas.size()){
            ciclistas.remove(i);
        }
        else{
            System.out.println("El número elegido es mayor que la cantidad de ciclistas");
        }
    }
    
    public void borrarCiclistaA(int i){
        if(i>=0 && i<ciclistasA.size()){
            ciclistasA.remove(i);
        }
        else{
            System.out.println("El número elegido es mayor que la cantidad de ciclistas que han abandonado");
        }
    }
    
    public void borrarBicicletas(int i){
        if(i>=0 && i<bicicletas.size()){
            bicicletas.remove(i);
        }
        else{
            System.out.println("El número elegido es mayor que la cantidad de bicicletas");
        }
    }
    
    public int totalPuntos(Ciclista c, List<Etapa> e){
        for(Etapa etapa : e){
            c.mostrarResultados(etapa);
        }
        return 0;
    }
}
