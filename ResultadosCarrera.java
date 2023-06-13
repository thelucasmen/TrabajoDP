
/**
 * Cada clase ResultadosCarrera contiene el nombre de un ciclista,
 * el resultado de este en determinada etapa (variable tipo Resultado), la 
 * energia restante de este y un tipo boolean para saber si ha abandonado o no
 * la carrera.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class ResultadosCarrera
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Resultado resultado;
    private double energia;
    private boolean abandonado;
    
    /**
     * Constructor for class ResultadosCarrera
     */
    public ResultadosCarrera(String nombre, double energia, Resultado resultado, boolean abandonado)
    {
        this.nombre = nombre;
        this.energia = energia;
        this.resultado = resultado;
        this.abandonado = abandonado;
    }

    /**
     * Changes the value of the String variable nombre in ResultadosCarrera class
     * 
     * @param String variable to set in ResultadosCarrera
     * @return
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     *  Returns the value of the String variable nombre in ResultadosCarrera class
     *  
     *  @param
     *  @return String variable
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Changes the value of the double variable energia in ResultadosCarrera class
     * 
     * @param double variable to set in ResultadosCarrera
     * @return
     */
    public void setEnergia(double energia){
        this.energia = energia;
    }
    
    /**
     * Returns the value of the double variable energia in ResultadosCarrera class
     * 
     * @param
     * @return double variable
     */
    public double getEnergia(){
        return energia;
    }
    
    /**
     * Changes the value of the Resultado variable in ResultadosCarrera class
     * 
     * @param Resultado variable to set in ResultadosCarrera
     * @return
     */
    public void setResultado(Resultado resultado){
        this.resultado = resultado;
    }
    
    /**
     * Returns the value of the Resultado variable in ResultadosCarrera class
     * 
     * @param
     * @return Resultado variable
     */
    public Resultado getResultado(){
        return resultado;
    }
    
    /**
     * Changes the value of the boolean variable abandonado in ResultadosCarrera class
     * 
     * @param boolean variable to set in ResultadosCarrera
     * @return
     */
    public void setAbandonado(boolean abandonado){
        this.abandonado = abandonado;
    }
    
    /**
     * Returns the value of the boolean variable abandonado in ResultadosCarrera
     * 
     * @param
     * @return boolean variable
     */
    public boolean getAbandonado(){
        return abandonado;
    }
    
    /**
     * Shows on screen all the information about ResultadosCarrera
     * 
     * @param
     * @return
     */
    public String toString(){
        String mostrar = "";
        if(abandonado){
            mostrar += "Nombre ciclista: " + nombre + "(abandonado)";
        } else {        
            mostrar += "Nombre ciclista: " + nombre;
        }
        mostrar += "Energia: " + energia + "\nResultado:";
        mostrar += resultado;
        
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
        ResultadosCarrera other = (ResultadosCarrera) obj;
        if (other.getNombre() == null) {
            if (other.getNombre() != null)
                return false;
            } else if (!other.getNombre().equals(other.getNombre()))
                return false;
        return true;
    }
}
