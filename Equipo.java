import java.util.*;

/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo 
{
    // instance variables - replace the example below with your own
    private String nombre;
    private List<Ciclista> ciclistas;
    private List<Ciclista> ciclistasA;
    private List<Bicicleta> bicicletas;
    
    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre)
    {    
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasA = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();
    }   

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setNombre(String n){
        this.nombre = n;
    }    
    
    public String getNombre(){
        return nombre;
    }
    
    public void setCiclista(Ciclista ciclista){
        this.ciclistas.add(ciclista);
    }
    
    public void setCiclistaAbandonado(Ciclista ciclistaA){
        this.ciclistasA.add(ciclistaA);
    }
    
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    //cambiar borrar x borrar con iterator
    public void borrarCiclista(int i){
        if(i>=0 && i<ciclistas.size()){
            ciclistas.remove(i);
        } else {
            System.out.println("El número elegido es mayor que la cantidad de ciclistas");
        }
    }
    
    public void borrarCiclistaAbandonado(int i){
        if(i>=0 && i<ciclistasA.size()){
            ciclistasA.remove(i);
        } else {
            System.out.println("El número elegido es mayor que la cantidad de ciclistas que han abandonado");
        }
    }
    
    public void borrarBicicletas(int i){
        if(i>=0 && i<bicicletas.size()){
            bicicletas.remove(i);
        } else {
            System.out.println("El número elegido es mayor que la cantidad de bicicletas");
        }
    }
    
    /*public Ciclista getCiclista(int i){
        //si el i elegido es mas grande que el numero de ciclistas devuelve un ciclista null 
        Ciclista ciclista = null;
        if(i>=0 && i<ciclistas.size()){
            ciclista = ciclistas.get(i);
        } else {
            System.out.println("El número elegido es mayor que la cantidad de ciclistas");
        }
        return ciclista;
    }*/
    
        /*Funcionalidad */    
    public void mostrar(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        Iterator<Ciclista> itca = ciclistasA.iterator();
        Iterator<Bicicleta> itb = bicicletas.iterator();
        
        System.out.println("Nombre equipo: " + nombre);
        if(ciclistas.size()>0){   
            while (itc.hasNext()) {
                itc.next().mostrar();
            }
        } else {
            System.out.println("El equipo no tiene ningún ciclista");
        }
        
        if(ciclistasA.size()>0){
            while (itca.hasNext()) {
                itc.next().mostrar();
            }
        } else {
            System.out.println("Ningún ciclista del equipo ha abandonado");
        }
        
        if(bicicletas.size()>0){
            while (itb.hasNext()) {
                itc.next().mostrar();
            }
        } else {
            System.out.println("El equipo no posee ninguna bicicleta");
        }
    }
    
    public void ordenarCiclistas(int orden, int criterio){
        List<Ciclista> ciclistasOrdenados = new ArrayList<Ciclista>();
        Iterator<Ciclista> it = ciclistas.iterator();
            //1.ascendente, 2.descendente
            //1.nombre, 2.bicicleta, 3.energia, 4.tiempoAcumulado(), 5.calculaDestreza()
        
        switch (criterio){
            case 1:
                ciclistas.sort(new NameComparator());
                break;
            case 2:
                ciclistas.sort(new BicicletaPesoComparator());
                ciclistas.sort(new BicicletaNameComparator());                
                break;
            case 3:
                ciclistas.sort(new EnergyComparator());                 
                break;
            case 4:
                ciclistas.sort(new TiempoComparator());                 
                break;
            case 5:
                ciclistas.sort(new DestrezaComparator());                 
                break;
        }
        
        if(orden == 2){
            Collections.sort(ciclistas, Collections.reverseOrder());
        }
    }
    
    public double tiempoTotal(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = 0;
        
        while (it.hasNext()) {
            tiempoAc = tiempoAc + it.next().tiempoAcumulado();
        }
        return tiempoAc;
    }
    
    public void enviarCiclistas(Etapa etapa){
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        if(ciclistas.size()>0){   
            while (itc.hasNext()) {
                etapa.setCiclista(itc.next());
            }
        }
    }
}
