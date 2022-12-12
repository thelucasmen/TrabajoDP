
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
    public void mostrar(){
        if(abandonado){
                    System.out.println("Nombre ciclista: " + nombre + "(abandonado)");
                    Salida.volcarLinea("Nombre ciclista: " + nombre + "(abandonado)"+"\n");
        } else {        
            System.out.println("Nombre ciclista: " + nombre);
            Salida.volcarLinea("Nombre ciclista: " + nombre + "\n");
        }
        System.out.println("Energia: " + energia);
        Salida.volcarLinea("Energia: " + energia + "\n");
        System.out.println("Resultado: ");
        Salida.volcarLinea("Resultado: " + "\n");
        resultado.mostrar();
    }
}
