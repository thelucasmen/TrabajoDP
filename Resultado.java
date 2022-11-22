
/**
 * Write a description of class Resultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultado
{
    // instance variables - replace the example below with your own
    private Etapa etapa;
    private double tiempo;

    //RESULTADO ETAPA TERMINADA
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setEtapa(Etapa e)
    {
        this.etapa = e;
    }
    
    public void setTiempo(double t){
        this.tiempo = t;
    }
    
    public Etapa getEtapa(){
        return etapa;
    }
    
    public double getTiempo(){
        return tiempo;
    }
    
    public void mostrar(){
        System.out.println("Etapa: ");
        etapa.mostrar();
        System.out.println("Tiempo: " + tiempo);
    }
}
