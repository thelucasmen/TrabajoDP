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
    public Equipo(String nombre, List<Ciclista> ciclistas, List<Ciclista> ciclistasA, List<Bicicleta> bicicletas)
    {    
        this.nombre = nombre;
        this.ciclistas = new ArrayList<Ciclista>();
        this.ciclistasA = new ArrayList<Ciclista>();
        this.bicicletas = new ArrayList<Bicicleta>();
    }   

    public Equipo(String nombre, List<Ciclista> ciclistas, List<Bicicleta> bicicletas)
    {    
        this.nombre = nombre;
        this.ciclistas = new ArrayList<Ciclista>();
        this.ciclistasA = new ArrayList<Ciclista>();
        this.bicicletas = new ArrayList<Bicicleta>();
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
        ciclistas.add(ciclista);
    }
    
    public void setCiclistaAbandonado(Ciclista ciclistaA){
        borrarCiclista(ciclistaA);
        this.ciclistasA.add(ciclistaA);
    }
    
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    public void borrarCiclista(Ciclista ciclista){
        this.ciclistas.remove(ciclista);
    }
    
    public void borrarCiclistaAbandonado(Ciclista ciclistaA){
        this.ciclistasA.remove(ciclistaA);
    }
    
    public void borrarBicicletas(Bicicleta bicicleta){
        this.bicicletas.remove(bicicleta);
    }
    
    public void getCiclistas(){
        try{
            Iterator<Ciclista> itc = ciclistas.iterator();
            
            while (itc.hasNext()) {
                itc.next().mostrar();
            }
        }catch(NullPointerException e){ }
    }
    
    //Cuenta los ciclistas del equipo sin abandonar
    public int contCiclistas(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        int i = 0;
        
        while (itc.hasNext()) {
            itc.next();
            i++;
        }
        return i;
    }
    
    public void getCiclistasAbandonados(){
        try{
            Iterator<Ciclista> itca = ciclistasA.iterator();
            
            while (itca.hasNext()) {
                itca.next().mostrar();
            }
        }catch(NullPointerException e){ }
    }

    public void getBicicletas(){
        try{
            Iterator<Bicicleta> itb = bicicletas.iterator();
            
            while (itb.hasNext()) {
                itb.next().mostrar();
                System.out.print("\n");
            }
        }catch(NullPointerException e){ }
    }
    
    //cuenta los ciclistas del equipo que han abandonado
    public int contCiclistasAbandonados(){
        Iterator<Ciclista> itca = ciclistasA.iterator();
        int i = 0;
        
        while (itca.hasNext()) {
            itca.next();
            i++;
        }        
        return i;
    }
    
        /*Funcionalidad */    
    public void mostrar(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        //%%% DSM WOMEN %%% Media Minutos de Ciclistas sin abandonar 0.0 %%%
        
        System.out.println("%%% " + nombre + " %%% Media Minutos de Ciclistas sin abandonar " + 
                            String.format("%.2f", mediatiempoSinA()) + "%%%");
        getCiclistas();
        getCiclistasAbandonados();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        /*Iterator<Bicicleta> itb = bicicletas.iterator();
        try{
            while (itb.hasNext()) {
                itc.next().mostrar();
            }
        }catch(NullPointerException e){ }*/
    }
    
    //Ordenar ciclistas segun criterio
    public void ordenarCiclistas(int criterio){
            //1.ascendente, 2.descendente
            //1.nombre, 2.bicicleta, 3.energia, 4.tiempoAcumulado(), 5.calculaDestreza(), 6.habilidad
        
        switch (criterio){
            case 1:
                ciclistas.sort(new NameComparator());
                break;
            case 2:
                ciclistas.sort(new BicicletaNameCiclistaComparator()); 
                ciclistas.sort(new BicicletaPesoCiclistaComparator());               
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
            case 6:
                ciclistas.sort(new HabilidadComparator());                 
                break;
            case 7:
                ciclistas.sort(new ReverseNameComparator());
                break;
            case 8:
                ciclistas.sort(new ReverseEnergyComparator());                 
                break;
            case 9:
                ciclistas.sort(new ReverseTiempoComparator());                 
                break;
            case 10:
                ciclistas.sort(new ReverseDestrezaComparator());                 
                break;
            case 11:
                ciclistas.sort(new ReverseHabilidadComparator());                 
                break;
        }
    }    

    //Ordenar bicicletas segun criterio
    public void ordenarBicicletas(int criterio){
            //descendente
            //1.nombre, 2.peso, 3.nombre descendente, 4.peso descendente
        
        switch (criterio){
            case 1:
                bicicletas.sort(new BicicletaNameComparator()); 
                break;
            case 2:               
                bicicletas.sort(new BicicletaPesoComparator());                 
                break;
            case 3:
                bicicletas.sort(new ReversedBicicletaNameComparator()); 
                break;
            case 4:               
                bicicletas.sort(new ReversedBicicletaPesoComparator());                 
                break;
        }
    }  
    
    //Suma total de tiempo de los ciclistas
    public double tiempoTotal(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = 0;
        
        while (it.hasNext()) {
            tiempoAc = tiempoAc + it.next().tiempoAcumulado();
        }
        return tiempoAc;
    }
    
    //Calcula la media del tiempo total
    public double mediatiempoTotal(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = tiempoTotal();
        int contCiclistas = 0;
        
        while (it.hasNext()) {
            it.next();
            contCiclistas++;
        }
        
        return tiempoAc/contCiclistas;
    }
    
    //Calcula la media del tiempo de los ciclistas sin abandonar
    public double mediatiempoSinA(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = 0;
        int contCiclistas = 0;
        Ciclista ciclista;
        while (it.hasNext()) {
            ciclista = it.next();
            if(ciclista.getEnergia() > 0){
                tiempoAc = tiempoAc + ciclista.tiempoAcumulado();
                contCiclistas++;
            }
        }
        
        return tiempoAc/contCiclistas;
    }
    
    //Envia a la etapa todos los ciclistas del equipo que no hayan abandonado
    public void enviarCiclistas(Etapa etapa){        
        try{  
            Iterator<Ciclista> itc = ciclistas.iterator();
            Iterator<Bicicleta> itb = bicicletas.iterator();
            Ciclista ciclista;
            Bicicleta bicicleta;
            int cont = 0;
            while (itb.hasNext() && itc.hasNext()) {
                ciclista = itc.next();
                bicicleta = itb.next();
                ciclista.setBicicleta(bicicleta);
            }
               
            itc = ciclistas.iterator();
            while (itc.hasNext()) {
                ciclista = itc.next();
                etapa.setCiclista(ciclista);
            }
        } catch(NullPointerException e){ }
    }
    
    //Actualiza los ciclistas despues de la etapa
    public void recogerCiclistas(Ciclista ciclista){
        if(ciclista.getEnergia() > 0){
            borrarCiclista(ciclista);
            setCiclista(ciclista);
        } else {
            borrarCiclista(ciclista);
            setCiclistaAbandonado(ciclista);
        }
    }
    
    //Se encarga de mostrar los datos del equipo durante la etapa
    public ResultadosCarrera CaracterísticasCiclistas(Etapa etapa, boolean fin){
        Iterator<Ciclista> itc = ciclistas.iterator();
        double tiempo;
        boolean abandonado = false;
        Resultado r = null;
        ResultadosCarrera resultadosCarrera = null;
        
        getCiclistas();
        System.out.println("Ciclistas: ");
        while (itc.hasNext()) {
            System.out.println(itc.next());
            System.out.println("Velocidad: " + itc.next().getBicicleta().calcularVelocidad(itc.next(), etapa));
            
            tiempo = itc.next().getBicicleta().calculartiempo(itc.next(), etapa);
            r = new Resultado(etapa, tiempo);
            itc.next().setResultado(r);
            
            if(itc.next().getEnergia() > 0){
                System.out.println("Tiempo: " + tiempo);
            } else {
                abandonado = true;
                System.out.println("Energia: " + itc.next().getEnergia());  
                System.out.println("Tiempo: " + tiempo);                
            }
            
            resultadosCarrera = new ResultadosCarrera(itc.next().getNombre(), itc.next().getEnergia(), r, abandonado);
            
            recogerCiclistas(itc.next());
        }
        return resultadosCarrera;
    }
}
