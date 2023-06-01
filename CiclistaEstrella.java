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
    //private String nombre;
    //private Bicicleta bicicleta;
    //private Habilidad habilidad;
    //private double energia;
    private List<Resultado> resultados;
    //private Equipo equipo;
    private int popularidad;

    /**
     * Constructor for objects of class Ciclista
     */   
    public CiclistaEstrella(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo); 
       this.popularidad = 6;
       resultados = new ArrayList();
    }
    
    public void setPopularidad(int popularidad){
        this.popularidad = popularidad;
    }
    
    public int getPopularidad(){
        return popularidad;
    }
    
    @Override
    public String toString(){
        return super.toString() + "<popularidad: " + getPopularidad() + ">";
    }
    
    /*   Funcionalidad   */     
    @Override
    public void funcionalidadCiclista(Etapa e, double tiempo){
        super.funcionalidadCiclista(e, tiempo);
        if(tiempo < 160){
            setPopularidad(getPopularidad() + 4);
        } else{
            setPopularidad(getPopularidad() - 1);
        }
    }
 
    /**
     * Prepare a String for the specific ciclista.
     * 
     * @param tiempo and energiaPrevia variables double  
     * @return String variable.
     * 
     */    
    @Override
    public String salidaFinalCiclista(double tiempo, double energiaPrevia){
        String salida = "";
        if(!abandonado()){
            salida += "+++ " + getNombre() + " termina la etapa en " + String.format("%.2f",tiempo) + " minutos +++\n" +
            "+++ La energía del ciclista " + getNombre() + " tras la carrera es " + 
            String.format("%.2f",getEnergia()) + " +++\n" + "@@@\n";
        } else {
            salida += "¡¡¡ El ciclista " + getNombre() + " se quedó sin energia a falta de " + 
                String.format("%.2f",getEnergia()*(-1)) + " minutos para terminar !!!\n" +
                "¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + 
                String.format("%.2f",energiaPrevia) + " minutos !!!\n" +
                "+++ La energía del ciclista " + getNombre() + " tras la carrera es " + 
                String.format("%.2f",getEnergia()) + " +++\n@@@\n";
        }
        
        if(tiempo<160){ 
           salida += "+++ La popularidad del ciclista " + getNombre() + 
                         " ha aumentado y ahora su nivel de popularidad es de: " + getPopularidad() + " unidades\n" +
                         "@@@\n";
        } else {
            salida += "--- La popularidad del ciclista " + getNombre() + 
                         " ha disminuido y ahora su nivel de popularidad es de: " + getPopularidad() + " unidades\n" +
                         "@@@\n";
        }
        return salida;
    }
    
    //(((habilidad del Ciclista + 6) / 140) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 6) / 140 * 10;
    }
}
