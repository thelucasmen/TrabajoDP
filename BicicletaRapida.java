
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
        this.nombre = nombre;
        this.peso = peso;
        this.velocidadExtra = velocidadExtra;
    }
    
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    public Double getVelocidadExtra(){
        return velocidadExtra;
    }
    
    public void mostrar() {
        //<Bicicleta: SCOTT CONTESSA ADDICT RC 15> <peso: Pesada (valor: 7.85)> en etapa sencilla intermedia
        System.out.print("<BicicletaRapida: " + nombre + "> <peso: ");
        peso.mostrar();
        System.out.print("> <Velocidad Extra: " + velocidadExtra + ">");
    }
    
        /*Funcionalidad */
    //habilidad*100/(peso*dificultad)+velocidadExtra
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(getPeso().getPesoBici()*etapa.getDificultad().getDificultadEtapa())+velocidadExtra;
    }
}
