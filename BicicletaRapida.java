
/**
 * Write a description of class BicicletaRapida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaRapida
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
        this.nombre = nombre;
        this.peso = peso;
        this.velocidadExtra = velocidadExtra;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPeso(Peso p){
        this.peso = peso;
    }
    
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    public Double getVelocidadExtra(){
        return velocidadExtra;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Peso getPeso(){
        return peso;
    }
    
    public void mostrar()    {
        System.out.println("Nombre : " + nombre);
        System.out.println("Peso: " + peso);
    }
    
        /*Funcionalidad */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        double pesoReal = 0;
        switch(getPeso()){
            case LIGERA:
                pesoReal = 7.35;
                break;
            case NORMAL :
                pesoReal = 7.50;
                break;
            case PESADA :
                pesoReal = 7.85;
                break;
        }
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(pesoReal*etapa.getDificultad())+velocidadExtra;
    }
    
    public double calculartiempo(Ciclista ciclista, Etapa etapa)    {
        return etapa.getDistancia()/calcularVelocidad(ciclista, etapa)*60;
         
    }
}
