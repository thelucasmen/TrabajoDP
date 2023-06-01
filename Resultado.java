
/**
 * Cada clase resultado contiene una variable Etapa a la cual pertenece dicho resultado y el
 * tiempo que se ha tardado en terminar dicha etapa.
 * 
 * Contiene las operaciones necesarias para interactuar con otras clases y objetos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class Resultado
{
    // instance variables - replace the example below with your own
    private Etapa etapa;
    private double tiempo;

    //RESULTADO ETAPA TERMINADA
    /**
     * Constructor for class Resultado
     */
    public Resultado(Etapa etapa, double tiempo)
    {
        this.etapa = etapa;
        this.tiempo = tiempo;
    }

    //RESULTADO ETAPA SIN TERMINAR
    public Resultado(Etapa etapa)
    {
        this.etapa = etapa;
        this.tiempo = 0;
    }
    
    /**
     * Changes the value of the Etapa variable in a certain Resultado class
     * 
     * @param  Etapa variable to set in Resultado
     * @return     
     */
    public void setEtapa(Etapa e)
    {
        this.etapa = e;
    }
    
    /**
     * Changes the value of the double variable tiempo in a certain Resultado class
     * 
     * @param double variable to set in Resultado
     * @return
     */
    public void setTiempo(double t){
        this.tiempo = t;
    }
    
    /**
     * Returns the value of the Etapa variable in Resultados class
     * 
     * @param 
     * @return Etapa variable 
     */
    public Etapa getEtapa(){
        return etapa;
    }
    
    /**
     * Returns double variable tiempo in Resultados class
     * 
     * @param
     * @return double variable representing the time.
     */
    public double getTiempo(){
        return tiempo;
    }
    
    /**
     * Shows on screen all the information about Resultados class
     */
    public String toString(){
        //Carrera(sencilla intermedia) - Tiempo: 2.12 minutos
        String mostrar = "Carrera(" + etapa.getNombre() + ") - Tiempo: " + String.format("%.2f",tiempo) + " minutos ";
        
        return(mostrar);
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((etapa.getNombre() == null) ? 0 : etapa.getNombre().hashCode());
        return result;
    }
     
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Resultado other = (Resultado) obj;
        if (etapa.getNombre() == null) {
            if (other.etapa.getNombre() != null)
                return false;
            } else if (!other.etapa.getNombre().equals(other.etapa.getNombre()))
                return false;
        return true;
    }
}
