
/**
 * Bicicleta prototipo es una clase complementaria a Bicicleta.
 * Tiene las mismas caracteristicas que Bicicleta. Una Bicicleta no
 * tiene por que ser una BicicletaPrototipo, pero si lo es, no puede ser
 * una BicicletaRapida y viceversa.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
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
        this.nombre = nombre;
        this.peso = peso;
    }
    
    /**
     * Shows on screen all information about BicicletaPrototipo class
     * 
     * @param
     * @return
     */
    public String toString() {
        //<Bicicleta: SCOTT CONTESSA ADDICT RC 15> <peso: Pesada (valor: 7.85)>
        String mostrar = "<BicicletaPrototipo: " + nombre + "> <peso: ";
        Salida.volcarLinea("<BicicletaPrototipo: " + nombre + "> <peso: " + "\n");
        mostrar += peso;
        mostrar += ">";
        Salida.volcarLinea(">" + "\n");
        return(mostrar);
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        return result;
    }
     
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Etapa other = (Etapa) obj;
        if (other.getNombre() == null) {
            if (other.getNombre() != null)
                return false;
            } else if (!other.getNombre().equals(other.getNombre()))
                return false;
        return true;
    }
    
        /*Funcionalidad */    
    //distancia/velocidad*destreza
    /**
     * Returns the time needed to end a certain stage
     * 
     * @param Ciclista and Etapa variables to calculate time and velocity
     * @return double variable which is the distance divided by the multiplication of velocity and dexterity
     */
    public double calculartiempo(Ciclista ciclista, Etapa etapa) {
        return etapa.getDistancia().getDistanciaEtapa()/calcularVelocidad(ciclista, etapa)*ciclista.calculaDestreza();
    }
}