
/**
 * Enumeration class Dificultad - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Dificultad{
    SENCILLA("SENCILLA", 0.9),
    NORMAL("NORMAL", 1.0),
    COMPLEJA("COMPLEJA", 1.1);
    
    private String catDificultad;
    private double dificultadEtapa;
    
    Dificultad(String catDificultad, double dificultadEtapa)
    {
        this.catDificultad = catDificultad;
        this.dificultadEtapa = dificultadEtapa;
    }
    
    public void setCatDificultad(String catDificultad){
        this.catDificultad = catDificultad;
    }
    
    public void setDificultadEtapa(double dificultadEtapa){
        this.dificultadEtapa = dificultadEtapa;
    }
    
    public String getCatDificultad(){
        return catDificultad;
    }
    
    public double getDificultadEtapa(){
        return dificultadEtapa;
    }
    
    public void mostrar()    {
        System.out.println(catDificultad + "(" + dificultadEtapa + ")");
    }
};
