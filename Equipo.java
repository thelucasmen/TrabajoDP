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
        this.ciclistas.add(ciclista);
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
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        System.out.println("Ciclistas: ");
        while (itc.hasNext()) {
            System.out.println(itc.next());
            itc.next().getResultado();
        }
    }
    
    //Cuenta los ciclistas del equipo sin abandonar
    public int contCiclistas(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        int i = 0;
        
        while (itc.hasNext()) {
                i++;
        }
        return i;
    }
    
    public void getCiclistasAbandonados(){
        Iterator<Ciclista> itca = ciclistasA.iterator();
        
        System.out.println("Ciclistas abandonados: ");
        while (itca.hasNext()) {
            System.out.println(itca.next());
            itca.next().getResultado();
        }
    }

    //cuenta los ciclistas del equipo que han abandonado
    public int contCiclistasAbandonados(){
        Iterator<Ciclista> itca = ciclistasA.iterator();
        int i = 0;
        
        while (itca.hasNext()) {
            i++;
        }        
        return i;
    }
    
        /*Funcionalidad */    
    public void mostrar(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        Iterator<Ciclista> itca = ciclistasA.iterator();
        Iterator<Bicicleta> itb = bicicletas.iterator();
        
        System.out.println("Nombre equipo: " + nombre);
        System.out.println("Ciclistas equipo: ");
        if(ciclistas.size()>0){   
            while (itc.hasNext()) {
                itc.next().mostrar();
            }
        } else {
            System.out.println("El equipo no tiene ningún ciclista");
        }
        
        System.out.println("Ciclistas abandonados equipo: ");
        if(ciclistasA.size()>0){
            while (itca.hasNext()) {
                itc.next().mostrar();
                System.out.println("(Abandonado)");
            }
        } else {
            System.out.println("Ningún ciclista del equipo ha abandonado");
        }
        
        System.out.println("Bicicletas del equipo: ");
        if(bicicletas.size()>0){
            while (itb.hasNext()) {
                itc.next().mostrar();
            }
        } else {
            System.out.println("El equipo no posee ninguna bicicleta");
        }
    }
    
    //Ordenar ciclistas segun criterio
    public void ordenarCiclistas(int orden, int criterio){
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
        }
        
        if(orden == 2){
            Collections.sort(ciclistas, Collections.reverseOrder());
        }
    }
    
    //Ordenar ciclistas que han abandonado segun criterio
    public void ordenarCiclistasA(int orden, int criterio){
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
        }
        
        if(orden == 2){
            Collections.sort(ciclistas, Collections.reverseOrder());
        }
    }    

    //Ordenar bicicletas segun criterio
    public void ordenarBicicletas(int orden, int criterio){
            //1.ascendente, 2.descendente
            //1.nombre, 2.peso
        
        switch (criterio){
            case 1:
                bicicletas.sort(new BicicletaNameComparator()); 
                break;
            case 2:               
                bicicletas.sort(new BicicletaPesoComparator());                 
                break;
        }
        
        if(orden == 2){
            Collections.sort(bicicletas, Collections.reverseOrder());
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
            contCiclistas++;
        }
        
        return tiempoAc/contCiclistas;
    }
    
    //Envia a la etapa todos los ciclistas del equipo que no hayan abandonado
    public void enviarCiclistas(Etapa etapa){
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        if(ciclistas.size()>0){   
            while (itc.hasNext()) {
                etapa.setCiclista(itc.next());
            }
        }
    }
    
    //Actualiza los ciclistas despues de la etapa
    public void recogerCiclistas(Ciclista ciclista){
        if(ciclista.getEnergia() > 0){
            borrarCiclista(ciclista);
            setCiclista(ciclista);
        } else {
            borrarCiclistaAbandonado(ciclista);
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
