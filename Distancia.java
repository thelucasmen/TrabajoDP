
/**
 * Enumeration class Distancia - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Distancia{
    CORTA("CORTA", 150.0),
    INTERMEDIA("INTERMEDIA", 200.0),
    LARGA("LARGA", 225.0);
    
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
    
    public void mostrar()    {
        //Intermedia (valor:200.0)
        System.out.print(catDistancia + "(valor:" + distanciaEtapa + ")");
    }
};
