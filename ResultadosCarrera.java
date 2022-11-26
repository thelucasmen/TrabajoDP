
/**
 * Write a description of class ResultadosCarrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultadosCarrera
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Resultado resultado;
    private double energia;
    private boolean abandonado;

    public ResultadosCarrera(String nombre, double energia, Resultado resultado, boolean abandonado)
    {
        this.nombre = nombre;
        this.energia = energia;
        this.resultado = resultado;
        this.abandonado = abandonado;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setEnergia(double energia){
        this.energia = energia;
    }
    
    public double getEnergia(){
        return energia;
    }
    
    public void setResultado(Resultado resultado){
        this.resultado = resultado;
    }
    
    public Resultado getResultado(){
        return resultado;
    }
    
    public void setAbandonado(boolean abandonado){
        this.abandonado = abandonado;
    }
    
    public boolean getAbandonado(){
        return abandonado;
    }
    
    public void mostrar(){
        if(abandonado){
                    System.out.println("Nombre ciclista: " + nombre + "(abandonado)");
        } else {        
            System.out.println("Nombre ciclista: " + nombre);
        }
        System.out.println("Energia: " + energia);
        System.out.println("Resultado: ");
        resultado.mostrar();
    }
}
