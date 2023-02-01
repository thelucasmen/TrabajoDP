
/**
 * Enumeration class Peso - write a description of the enum class here
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez)
 * @version (9.12.22)
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
    
    public String toString(){
        //Pesada (valor: 7.85)
        String mostrar = catPeso + "(valor: " + pesoBici + ")";
        return(mostrar);
    }
};
