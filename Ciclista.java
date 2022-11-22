import java.util.*;

/**
 * Write a description of class Ciclista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ciclista
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Bicicleta bicicleta;
    private Habilidad habilidad;
    private double energia;
    private List<Resultado> resultados;
    private Equipo equipo;

    /**
     * Constructor for objects of class Ciclista
     */
    public Ciclista(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.energia = energia;
        this.resultados = new ArrayList<Resultado>();
        this.equipo = equipo;
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
        
    public void anadirResultado(Resultado r){
        resultados.add(r);   
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
        
    public void mostrar()
    {
        System.out.println("Nombre ciclista: " + nombre);
        System.out.println("Energia: " + energia);
        System.out.println("Habilidad: ");
        habilidad.mostrar(); 
        System.out.println("Bicicleta: ");
        bicicleta.mostrar();
        for (Resultado resultado: resultados){
            resultado.mostrar();
        }
        
    }
    
        /*Funcionalidad */
    public void cambiarBici(Bicicleta bicicleta){
        setBicicleta(bicicleta);
    }
    
    public boolean abandonado(){
        if (energia <= 0){
            return true;
        } else{
            return false;
        }
    }
    
    public Resultado mostrarResultados(Etapa e){
        //Busca una etapa concreta dentro del Array y devuelve la información del resultado de esa etapa, si no, devuelve null.
        Resultado aux = null;
        boolean enc = false;
        int i = 0;       
        Iterator<Resultado> it = resultados.iterator();
        
        while (it.hasNext() && !enc) {
            if (it.next().getEtapa() == e){
                aux = it.next();
                enc = true;
            }
            i++;
        }
        if(enc==true)
            return aux;
        else
            return null;
    }
    
    public int numeroEtapas(){
        return resultados.size();
    }
    
    public double tiempoAcumulado(){
        double tiempo = 0;
        for (Resultado aux: resultados){
            if(aux.getTiempo() > 0){
                tiempo = tiempo + aux.getTiempo();
            }
        }
        return tiempo;
    }
    
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
    
    public String abandonada(){
        Iterator<Resultado> it = resultados.iterator();
        String stringAbandonadas = "";
        while (it.hasNext()) {
            if(it.next().getTiempo() <= 0){
                stringAbandonadas += "/n/t" + it.next().getEtapa();
            }
        }
        return stringAbandonadas;
    }
    
    public String mostrarEtapas(){
        return "Etapas comenzadas:" + numeroEtapas() 
                    + "/nTiempo acumulado en etapas terminadas: " + tiempoAcumulado() 
                    + "/nEtapas terminadas:" + etapasTerminadas() 
                    + "/nEtapas abandonadas:" + abandonada();
    }
                       
                                                //tiempo=bicicleta.calculartiempo(ciclista,etapa);
    public void funcionalidadCiclista(Etapa e, double tiempo){
        Resultado r;
        Bicicleta b = getBicicleta();
        if(getEnergia() != 0){
            r = new Resultado(e, tiempo);
            setEnergia(tiempo/60);
        } else {
            r = new Resultado(e, energia - tiempo);
        }
        r.setEtapa(e);
        resultados.add(r);
    }
    
    public double calculaDestreza(){
        return 1;
    }
}
