
/**
 * Enumeration class Distancia - write a description of the enum class here
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez)
 * @version (9.12.22)
 */
public enum Distancia{
    CORTA("Corta", 150.0),
    INTERMEDIA("Intermedia", 200.0),
    LARGA("Larga", 225.0);
    
    private String catDistancia;
    private double distanciaEtapa;
    
    Distancia(String catDistancia, double distanciaEtapa)
    {
        this.catDistancia = catDistancia;
        this.distanciaEtapa = distanciaEtapa;
    }
    
    public void setCatDistancia(String catDistancia){
        this.catDistancia = catDistancia;
    }
    
    public void setDistanciaEtapa(double distanciaEtapa){
        this.distanciaEtapa = distanciaEtapa;
    }
    
    public String getCatDistancia(){
        return catDistancia;
    }
    
    public double getDistanciaEtapa(){
        return distanciaEtapa;
    }
    
    public String toString(){
        //Intermedia (valor:200.0)
        String mostrar = catDistancia + " (valor:" + distanciaEtapa + ")";
        return(mostrar);
    }
};
