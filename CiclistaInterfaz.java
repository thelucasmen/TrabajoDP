import java.util.*;

/**
 * Interfaz de ciclista  
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
interface CiclistaInterfaz
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Ciclista
     */
    
    public void setNombre(String n);
    public String getNombre();
    
    public void setBicicleta(Bicicleta b);
    public Bicicleta getBicicleta();
    
    public void setHabilidad(Habilidad h);
    public Habilidad getHabilidad();
    
    public void setEnergia(double e);
    public double getEnergia();
        
    public void setResultado(Resultado r);
    public String getResultado();
    
    public void setEquipo(Equipo e);
    public Equipo getEquipo();
    
    public String toString();

    public int hashCode();
    public boolean equals(Object obj);
    
    /***Funcionalidad***/
        //Cambiar la bicicleta
    public void cambiarBici(Bicicleta bicicleta);
        //Comprueba si el ciclista ha abandonado
    public boolean abandonado();
        //Muestra resultados de cualquier etapa
    public double mostrarResultados();
        //Devuelve el numro de etapas
    public int numeroEtapas();
        //Devuelve el tiempo total acumulado entre los resultados
    public double tiempoAcumulado();
        //Devuelve el total de puntos anulados de un ciclista que ha abandonado
    public double puntosAnulados();
        //Muestra por pantalla las etapas abandonadas
    public String abandonada();
        //Guarda en resultados el tiempo        tiempo=bicicleta.calculartiempo(ciclista,etapa);
    public void funcionalidadCiclista(Etapa e, double tiempo);
        //Caclcula la destreza del ciclista
    public double calculaDestreza();
}
