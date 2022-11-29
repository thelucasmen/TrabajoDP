
/**
 * Write a description of class BicicletaRapida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaRapida extends Bicicleta
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Peso peso;
    private double velocidadExtra;
//    private Ciclista ciclista;
//    private Etapa etapa;

    /**
     * Constructor for objects of class BicicletaRapida
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {       
        super(nombre, peso);
        this.velocidadExtra = velocidadExtra;
    }
    
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    public Double getVelocidadExtra(){
        return velocidadExtra;
    }
    
    public void mostrar()    {
        System.out.println("Nombre : " + nombre);
        System.out.println("Peso: " + peso);
        System.out.println("Velocidad Extra: " + velocidadExtra);
    }
    
        /*Funcionalidad */
    //habilidad*100/(peso*dificultad)+velocidadExtra
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(getPeso().getPesoBici()*etapa.getDificultad().getDificultadEtapa())+velocidadExtra;
    }
}
