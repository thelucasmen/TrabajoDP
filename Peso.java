
/**
 * Enumeration class Peso - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Peso{
    LIGERA("LIGERA", 7.35),
    NORMAL("NORMAL", 7.50),
    PESADA("PESADA", 7.85);
    
    private String catPeso;
    private double pesoBici;
    
    Peso(String catPeso, double pesoBici)
    {
        this.catPeso = catPeso;
        this.pesoBici = pesoBici;
    }
    
    public void setCatPeso(String catPeso){
        this.catPeso = catPeso;
    }
    
    public void setPesoBici(double pesoBici){
        this.pesoBici = pesoBici;
    }
    
    public String getCatPeso(){
        return catPeso;
    }
    
    public double getPesoBici(){
        return pesoBici;
    }
    
    public void mostrar(){
        //Pesada (valor: 7.85)
        System.out.print(catPeso + "(valor: " + pesoBici + ")");
    }
};
