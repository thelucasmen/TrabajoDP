
/**
 * Cada bicicleta cuenta con un nombre y un peso.
 * 
 * La clase incluye ademas las operaciones necesarias para interactuar con el resto de objetos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class Bicicleta
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Peso peso;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta(String nombre, Peso peso)
    {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Changes the value of the String variable nombre in Bicicleta class
     * 
     * @param String variable to set in Bicicleta
     * @return
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Changes the value of the Peso variable in Bicicleta class
     * 
     * @param Peso variable to set in Bicicleta
     * @return
     */
    public void setPeso(Peso peso){
        this.peso = peso;
    }
    
    /**
     * Returns the value of the String variable nombre in Bicicleta class
     * 
     * @param
     * @return String variable
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Returns the value of the Peso variable in Bicicleta class
     * 
     * @param
     * @return Peso variable
     */
    public Peso getPeso(){
        return peso;
    }
    
    /**
     * Shows on screen all information about Bicicleta class
     * 
     * @param
     * @return
     */
    public void mostrar() {
        //<Bicicleta: SCOTT CONTESSA ADDICT RC 15> <peso: Pesada (valor: 7.85)>
        System.out.print("<Bicicleta: " + nombre + "> <peso: ");
        Salida.volcarLinea("<Bicicleta: " + nombre + "> <peso: " + "\n");
        peso.mostrar();
        System.out.print(">");
        Salida.volcarLinea(">" + "\n");
    }
    
        /*Funcionalidad */
    //habilidad*100/(peso*dificultad)
    /**
     * Returns the velocity of a cyclist in a certain stage.
     * 
     * @param Ciclista variable to know skill and Etapa variable to know difficulty
     * @return double variable with one hundred times the skill of the cyclist  divided by the multiplication of the weight and difficulty
     */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)    {
        return ciclista.getHabilidad().getHabilidadCiclista()*100/(peso.getPesoBici()*etapa.getDificultad().getDificultadEtapa());
    }
    
    //distancia/velocidad*60
    /**
     * Returns the time needed to finish a stage
     * 
     * @param Ciclista and Etapa variables to calculate velocity and time
     * @return double variable which is the distance divided by velocity
     */
    public double calculartiempo(Ciclista ciclista, Etapa etapa)    {
        //System.out.println(etapa.getDistancia().getDistanciaEtapa()+"/"+calcularVelocidad(ciclista, etapa)+"*"+60);
        return etapa.getDistancia().getDistanciaEtapa()/calcularVelocidad(ciclista, etapa)*60;
         
    }
}
