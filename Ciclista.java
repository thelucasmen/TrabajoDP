import java.util.*;
/**
 * La clase ciclista es una superClase de la que heredan CiclistaNovato, CiclistaExperimentado y CiclistaEstrella.
 * 
 * Contiene además las operaciones basicas para interactuar con las otras clases
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
abstract class Ciclista implements CiclistaInterfaz
{
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List resultados;
    private Equipo equipo;

    /**
     * Constructor for objects of class Ciclista
     */
    public Ciclista(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    { 
       this.nombre = nombre;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;          
       resultados = new ArrayList();
    }
    
    /**
     * Changes the value of the String variable nombre in Ciclista class
     * 
     * @param String variable to set in Ciclista
     */
    public void setNombre(String n){
        this.nombre = n;
    }
    
    /**
     * Changes the value of the Bicicleta variable in Ciclista class
     * 
     * @param Bicicleta variable to set in Ciclista
     */
    public void setBicicleta(Bicicleta b){
        this.bicicleta = b;
    }
    
    /**
     * Changes the value of the Habilidad variable in Ciclista class
     * 
     * @param Habilidad variable to set in Ciclista
     */
    public void setHabilidad(Habilidad h){
        this.habilidad = h;
    }
    
    /**
     * Changes the value of the double variable energia in Ciclista class
     * 
     * @param double variable to set in Ciclista
     */
    public void setEnergia(double e){
        this.energia = e;
    }
    
    /**
     * Changes the value of the Resultado variable in Ciclista class
     * 
     * @param Resultado variable to add in CiclistaArrayList
     */
    public void setResultado(Resultado r){
        resultados.add(r);   
    }
    
    /**
     * Returns the value of the Resultado variable in Ciclista class
     * 
     * @return Resultado variable
     */
    public String getResultado(){ 
        String salida = "";
            Iterator<Resultado> it = resultados.iterator();     
            while(it.hasNext()) {
               salida += it.next() + "\n";
            }   
        return salida;
    }
    
    /**
     * Changes the value of the Equipo variable in Ciclista class
     * 
     * @param Equipo variable to set in Ciclista
     */
    public void setEquipo(Equipo e){
        this.equipo = e;
    }
    
    /**
     * Returns the value of the String variable nombre in Ciclista class
     * 
     * @return String variable
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Returns the value of the Bicicleta variable in Ciclista class
     * 
     * @return Bicicleta variable
     */
    public Bicicleta getBicicleta(){
        return bicicleta;
    }
    
    /**
     * Returns the value of the Habilidad variable in Ciclista class
     * 
     * @return Habilidad variable
     */
    public Habilidad getHabilidad(){
        return habilidad;
    }
    
    /**
     * Returns the value of the double variable energia in Ciclista class
     * 
     * @return double variable
     */
    public double getEnergia(){
        return energia;
    }
    
    
    /**
     * Returns the value of the Equipo variable in Ciclistaclass
     * 
     * @return Equipo variable
     */
    public Equipo getEquipo(){
        return equipo;
    }
    
    /**
     * Shows on screen all information about Ciclista class
     * 
     */
    public String toString()
    {
        //<CiclistaExperimentado:LABOUS> <energía: 1150.0> <habilidad:Buena (valor:8.0)> <tiempo acumulado sin abandonar: 0.0> <abandonado:false>
        String mostrar = "<" + getClass().getName() + ": " + nombre + "> <energía: " + String.format("%.2f", energia) + "> <habilidad:";
        mostrar += habilidad;
        if(abandonado()){
            mostrar += "> <tiempo acumulado sin abandonar: " + String.format("%.2f",puntosAnulados()) + 
                         "> <abandonado: " + abandonado() + ">"; 
        } else {
            mostrar += "> <tiempo acumulado sin abandonar: " + String.format("%.2f",tiempoAcumulado()) + 
                         "> <abandonado: " + abandonado() + ">"; 
        }
        
        return(mostrar);
    }
    
   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        return result;
    }
     
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ciclista other = (Ciclista) obj;
        if (other.getNombre() == null) {
            if (other.getNombre() != null)
                return false;
            } else if (!other.getNombre().equals(other.getNombre()))
                return false;
        return true;
    }
    
        /*Funcionalidad */
    //Cambiar la bicicleta
    /**
     * Changes the value of the Bicicleta variable in CiclistaNovato class
     * 
     * @param Bicicleta variable to set in CiclistaNovato
     * @return
     */

    public void cambiarBici(Bicicleta bicicleta){
        setBicicleta(bicicleta);
    }
    
    //Comprueba si el ciclista ha abandonado
    /**
     * Sets the value of the boolean variable abandonado depending on the energia variable.
     * 
     * @return if energia's value is less than 0, returns true, else is false
     */
    public boolean abandonado(){
        if (energia <= 0){
            return true;
        } else{
            return false;
        }
    }
    
    //Muestra resultados de cualquier etapa
    /**
     * Shows  and returns the results of a certain stage
     * 
     * @param Etapa variable to search for results
     * @return Resultado variable of the desired Etapa class in ArrayList
     */
    public double mostrarResultados(){
        Resultado r = null;
        double tiempo = 0; 
        Iterator<Resultado> it = resultados.iterator();  
        
        while (it.hasNext()) {
            r = it.next();
            if(r.getTiempo() > 0){
                tiempo = r.getTiempo();
            }
        }
        return tiempo;
    }
    
    //Devuelve el numro de etapas
    /**
     * Returns the amount of Etapa variables in ArrayList
     * 
     * @return int variable representing the amount of stages
     */
    public int numeroEtapas(){
        return resultados.size();
    }
    
    //Devuelve el tiempo total acumulado entre los resultados
    /**
     * Returns the sum of the time during different stages
     * 
     * @return double variable which is the sum of all the times scored by the cyclist.
     */
    public double tiempoAcumulado(){
        double tiempo = 0.0;
        Resultado resultado;
            Iterator<Resultado> it = resultados.iterator();
            while (it.hasNext()) {
                resultado = it.next();
                if(!abandonado()){
                    tiempo = tiempo + resultado.getTiempo();
                } else {
                    tiempo = getEnergia();
                }
            }
        return tiempo;
    }
    
    //Devuelve el total de puntos anulados de un ciclista que ha abandonado
    /**
     * Returns the amount of cancelled points of a cyclist that DID abandon.
     * 
     * @return double variable which is the total time minus the energy.
     */
    public double puntosAnulados(){
        double tiempo = 0.0;
        Resultado resultado;
            Iterator<Resultado> it = resultados.iterator();
            while (it.hasNext()) {
                resultado = it.next();
                tiempo = tiempo + resultado.getTiempo();
            }
            tiempo = tiempo - getEnergia();
        return tiempo;
    }
    
    //Muestra por pantalla las etapas abandonadas
    /**
     * Returns the name of the stage where the cyclist abandoned.
     * 
     * @return String variable.
     */
    public String abandonada(){
        Iterator<Resultado> it = resultados.iterator();
        String stringAbandonadas = "";
        
        while (it.hasNext()) {
            if(it.next().getTiempo() <= 0){
                stringAbandonadas += "/n/t" + it.next();
            }
        }
        return stringAbandonadas;
    }
                       
    //Guarda en resultados el tiempo        tiempo=bicicleta.calculartiempo(ciclista,etapa);
    /**
     * Saves in resultados ArrayList the time used by the cyclist in a certain stage
     * and calculates the energy left.
     * 
     * @param Etapa variable and double variable
     */
    public void funcionalidadCiclista(Etapa e, double tiempo){
        Resultado r = null;
        setEnergia(energia - tiempo);
        //r = new Resultado(e, energia - tiempo);
        if(getEnergia() >= 0){
            r = new Resultado(e, tiempo);
        } else {
            r = new Resultado(e, energia);
        }   
        //resultados.add(r);
    }
    
    /**
     * Prepare a String for the specific ciclista.
     * 
     * @param tiempo and energiaPrevia variables double  
     * @return String variable.
     * 
     */
    public String salidaFinalCiclista(double tiempo, double energiaPrevia){
        String salida = "";
        if(!abandonado()){
            salida += "+++ " + getNombre() + " termina la etapa en " + String.format("%.2f",tiempo) + " minutos +++\n" +
            "+++ La energía del ciclista " + getNombre() + " tras la carrera es " + 
            String.format("%.2f",getEnergia()) + " +++\n" + "@@@\n";
        } else {
            salida += "¡¡¡ El ciclista " + getNombre() + " se quedó sin energia a falta de " + 
                String.format("%.2f",getEnergia()*(-1)) + " minutos para terminar !!!\n" +
                "¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + 
                String.format("%.2f",energiaPrevia) + " minutos !!!\n" +
                "+++ La energía del ciclista " + getNombre() + " tras la carrera es " + 
                String.format("%.2f",getEnergia()) + " +++\n@@@\n";
        }
        return salida;
    }
    
    //((habilidad del Ciclista + 2) / 120) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 2) / 120 * 10;
    }
}
