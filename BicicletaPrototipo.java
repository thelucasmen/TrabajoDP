
/**
 * Write a description of class BicicletaPrototipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaPrototipo extends Bicicleta
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
        super(nombre, peso);
    }
    
        /*Funcionalidad */    
    //distancia/velocidad*60*destreza
    public double calculartiempo(Ciclista ciclista, Etapa etapa)    {
        return etapa.getDistancia()/calcularVelocidad(ciclista, etapa)*60*ciclista.calculaDestreza();
    }
}
