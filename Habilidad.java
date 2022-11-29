
/**
 * Enumeration class Habilidad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Habilidad{
    LENTA("LENTA", 4.0),
    NORMAL("NORMAL", 6.0),
    BUENA("BUENA", 8.0);
    
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
    
    public void mostrar()    {
        System.out.println(catHabilidad + "(" + habilidadCiclista + ")");
    }
};
