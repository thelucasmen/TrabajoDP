
/**
 * Write a description of class Bicicleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicicleta
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Peso peso;
//    private Ciclista ciclista;
//    private Etapa etapa;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta(String nombre, Peso peso)
    {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
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
        System.out.print("Peso: ");
        peso.mostrar();
    }
    
        /*Funcionalidad */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(peso.getPesoBici()*etapa.getDificultad());
    }
    
    public double calculartiempo(Ciclista ciclista, Etapa etapa)    {
        return etapa.getDistancia()/calcularVelocidad(ciclista, etapa)*60;
         
    }
}
