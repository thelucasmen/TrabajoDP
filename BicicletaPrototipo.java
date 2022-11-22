
/**
 * Write a description of class BicicletaPrototipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaPrototipo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Peso peso;
//    private Ciclista ciclista;
//    private Etapa etapa;

    /**
     * Constructor for objects of class BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombre, Peso peso)
    {
        this.nombre = nombre;
        this.peso = peso;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPeso(Peso peso){
        this.peso = peso;
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
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(pesoReal*etapa.getDificultad());
    }
    
    public double calculartiempo(Ciclista ciclista, Etapa etapa)    {
        return etapa.getDistancia()/calcularVelocidad(ciclista, etapa)*60*ciclista.calculaDestreza();
         
    }
}
