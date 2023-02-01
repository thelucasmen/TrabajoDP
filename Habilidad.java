
/**
 * Enumeration class Habilidad - write a description of the enum class here
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez)
 * @version (9.12.22)
 */
public enum Habilidad{
    LENTA("Lenta", 4.0),
    NORMAL("Normal", 6.0),
    BUENA("Buena", 8.0);
    
    private String catHabilidad;
    private double habilidadCiclista;
    
    Habilidad(String catHabilidad, double habilidadCiclista)
    {
        this.catHabilidad = catHabilidad;
        this.habilidadCiclista = habilidadCiclista;
    }
    
    public void setCatHabilidad(String catHabilidad){
        this.catHabilidad = catHabilidad;
    }
    
    public void setHabilidadCiclista(double habilidadCiclista){
        this.habilidadCiclista = habilidadCiclista;
    }
    
    public String getCatHabilidad(){
        return catHabilidad;
    }
    
    public double getHabilidadCiclista(){
        return habilidadCiclista;
    }
    
    public String toString(){
        //Buena (valor:8.0)
        String mostrar = catHabilidad + " (valor:" + habilidadCiclista + ")";
        return(mostrar);
    }
};
