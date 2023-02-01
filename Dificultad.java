
/**
 * Enumeration class Dificultad - write a description of the enum class here
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez)
 * @version (9.12.22)
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
    
    public String toString(){
        //Sencilla (valor:0.9)
        String mostrar = catDificultad + "(valor:" + dificultadEtapa + ")";
        Salida.volcarLinea(catDificultad + "(valor:" + dificultadEtapa + ")" + "\n");
        return(mostrar);
    }
};
