import java.util.*;

/**
 * Write a description of class CiclistaNovato here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaNovato implements Ciclista
{
   // instance variables - replace the example below with your own
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List resultados;
    private Equipo equipo;

    /**
     * Constructor for objects of class Ciclista
     */
    public CiclistaNovato(String nombre, Bicicleta bicicleta, Habilidad habilidad, double energia, Map<Etapa, Resultado> resultado, Equipo equipo)
    {
       this.nombre = nombre;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;
       resultados = new ArrayList();
    }
    
    public CiclistaNovato(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       this.nombre = nombre;
       this.habilidad = habilidad;
       this.energia = energia;
       this.equipo = equipo;       
       resultados = new ArrayList();
    }

    public void setNombre(String n){
        this.nombre = n;
    }
    
    public void setBicicleta(Bicicleta b){
        this.bicicleta = b;
    }
    
    public void setHabilidad(Habilidad h){
        this.habilidad = h;
    }
    
    public void setEnergia(double e){
        this.energia = e;
    }
        
    public void setResultado(Resultado r){
        resultados.add(r);   
    }
    
    public void getResultado(){ 
        try{
            Iterator<Resultado> it = resultados.iterator();   
            while(it.hasNext()) {
                it.next().mostrar();
                it.next();
            }   
        }catch(NullPointerException e){ }
    }
    
    
    public void setEquipo(Equipo e){
        this.equipo = e;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Bicicleta getBicicleta(){
        return bicicleta;
    }
    
    public Habilidad getHabilidad(){
        return habilidad;
    }
    
    public double getEnergia(){
        return energia;
    }
    
    public Equipo getEquipo(){
        return equipo;
    }
    
        /*Funcionalidad */
    //Cambiar la bicicleta
    public void cambiarBici(Bicicleta bicicleta){
        setBicicleta(bicicleta);
    }
    
    //Comprueba si el ciclista ha abandonado
    public boolean abandonado(){
        if (energia <= 0){
            return true;
        } else{
            return false;
        }
    }
    
    //Muestra resultados de cualquier etapa
    public Resultado mostrarResultados(Etapa e){
        //Busca una etapa concreta dentro del Array y devuelve la información del resultado de esa etapa, si no, devuelve null.
        Resultado aux = null;
        boolean enc = false;
        int i = 0; 
        Iterator<Resultado> it = resultados.iterator();  
        
        while (it.hasNext() && !enc) {
            aux = it.next();
            enc = true;
        }
        return aux;
    }
    
    //Devuelve el numro de etapas
    public int numeroEtapas(){
        return resultados.size();
    }
    
    //Devuelve el tiempo total acumulado entre los resultados
    public double tiempoAcumulado(){
        double tiempo = 0.0;
        Resultado resultado;
        try{
            Iterator<Resultado> it = resultados.iterator();
            while (it.hasNext()) {
                resultado = it.next();
                if(!abandonado()){
                    tiempo = tiempo + resultado.getTiempo();
                } else {
                    tiempo = getEnergia();
                }
            }
        }catch(NullPointerException e){ }
        return tiempo;
    }
    
    //Numero de etapas terminadas
    public int etapasTerminadas(){
        int cont = 0;
        Iterator<Resultado> it = resultados.iterator();
        
        while (it.hasNext()) {
            if(it.next().getTiempo() > 0){
                cont++;
            }
        }
        return cont;
        
    }
    
    //Muestra por pantalla las etapas abandonadas
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
    
    //Numero de etapas comenzadas, terminadas y tiempo acumulado, etapas abandonadas
    public String mostrarEtapas(){
        return "Etapas comenzadas:" + numeroEtapas() 
                    + "/nTiempo acumulado en etapas terminadas: " + tiempoAcumulado() 
                    + "/nEtapas terminadas:" + etapasTerminadas() 
                    + "/nEtapas abandonadas:" + abandonada();
    }
                       
    //Guarda en resultados el tiempo        tiempo=bicicleta.calculartiempo(ciclista,etapa);
    public void funcionalidadCiclista(Etapa e, double tiempo){
        Resultado r = null;
        Bicicleta b = getBicicleta();
        setEnergia(energia - tiempo);
        //r = new Resultado(e, energia - tiempo);
        if(getEnergia() != 0){
            r = new Resultado(e, tiempo);
        } else {
            r = new Resultado(e, energia - tiempo);
        }   
        resultados.add(r);
    }

    public void mostrar()
    {
        //<CiclistaExperimentado:LABOUS> <energía: 1150.0> <habilidad:Buena (valor:8.0)> <tiempo acumulado sin abandonar: 0.0> <abandonado:false>
        System.out.print("<CiclistaNovato: " + nombre + "> <energía: " + String.format("%.2f", energia) + "> <habilidad:");
        habilidad.mostrar(); 
        System.out.print("> <tiempo acumulado sin abandonar: " + String.format("%.2f",tiempoAcumulado()) + 
                         ">\n<abandonado:" + abandonado() + ">\n");                
    }
    
    //Suma o resta popularidad segun el tiempo
    public void SerPopular(double tiempo){ }
    
    //((habilidad del Ciclista + 2) / 120) * 10
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 2) / 120 * 10;
    }
    
    //Devuelve un booleano que indica si el ciclista es estrella o no
    public boolean esEstrella(){
        return false;
    }
}
