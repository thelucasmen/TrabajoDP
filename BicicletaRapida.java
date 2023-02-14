
/**
 * La clase bicicleta rapida es un complemento de la clase bicicleta.
 * Tiene las mismas funcionalidades, pero con un atributo extra. No todas las bicicletas tienen por que
 * ser bicicletas rapidas
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class BicicletaRapida extends Bicicleta
{
    // instance variables - replace the example below with your own
    //private String nombre;
    //private Peso peso;
    private double velocidadExtra;
    //private Ciclista ciclista;
    //private Etapa etapa;

    /**
     * Constructor for objects of class BicicletaRapida
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {       
        super(nombre, peso);
        this.velocidadExtra = velocidadExtra;
    }
    
    /**
     * Changes the value of the double variable velocidadExtra in BicicletaRapida class
     * 
     * @param double variable to set in velocidadExtra
     * @return
     */
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    /**
     * Returns the value of the double variable velocidadExtra in BicicletaRapida class
     * 
     * @param
     * @return double variable
     */
    public Double getVelocidadExtra(){
        return velocidadExtra;
    }
    
    /**
     * Shows on screen all the information about BicicletaRapida class
     * 
     * @param
     * @return
     */
    public String toString() {
        //<Bicicleta: SCOTT CONTESSA ADDICT RC 15> <peso: Pesada (valor: 7.85)> en etapa sencilla intermedia
        String mostrar = "<BicicletaRapida: " + nombre + "> <peso: ";
        mostrar += peso;
        mostrar += "> <Velocidad Extra: " + velocidadExtra + ">";
        
        return(mostrar);
    }
    
        /*Funcionalidad */
    //habilidad*100/(peso*dificultad)+velocidadExtra
    /**
     * Returns the value of the increased velocity depending on the velocidadExtra variable
     * 
     * @param Ciclista and Etapa variables to calculate velocity
     * @return double variable calculated this time adding the value of velocidadExtra
     */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(getPeso().getPesoBici()*etapa.getDificultad().getDificultadEtapa())+velocidadExtra;
    }
}