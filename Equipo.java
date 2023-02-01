import java.util.*;

/**
 * Cada equipo tiene un nombre, una lista con sus ciclistas activos, otra lista con los ciclistas que han abandonado
 * y una ultima lista con las bicicletas de las que disponen.
 * 
 * Esta clase contiene todas las operaciones necesarias para interactuar con el resto de objetos
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
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
     * Changes the value of the String variable name in a certain Equipo class
     * 
     * @param  String variable to set in Equipo
     * @return     
     */
    public void setNombre(String n){
        this.nombre = n;
    }    
    
    /**
     * Returns the String variable nombre value
     * 
     * @param
     * @return String value
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Adds a new Ciclista element to the ciclistas ArrayList
     * 
     * @param Ciclista variable to add to the ArrayList
     * @return
     */
    public void setCiclista(Ciclista ciclista){
        ciclistas.add(ciclista);
    }
    
    /**
     * Moves a certain Ciclista variable from ciclistas ArrayList to ciclistasA ArrayList
     * 
     * @param Ciclista variable in ciclistas
     * @return
     */
    public void setCiclistaAbandonado(Ciclista ciclistaA){
        borrarCiclista(ciclistaA);
        this.ciclistasA.add(ciclistaA);
    }
    
    /**
     * Adds a new Bicicleta element to the bicicletas ArrayList
     * 
     * @param Bicicleta variable to insert
     * @return
     */
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    /**
     * Removes a certain Ciclista element in ciclistas ArrayList
     * 
     * @param Ciclista variable in ciclistas
     * @return
     */
    public void borrarCiclista(Ciclista ciclista){
        this.ciclistas.remove(ciclista);
    }
    
    /**
     * Removes a certain Ciclista element in ciclistasA ArrayList
     * 
     * @param Ciclista variable in ciclistasA
     * @return
     */
    public void borrarCiclistaAbandonado(Ciclista ciclistaA){
        this.ciclistasA.remove(ciclistaA);
    }
    
    /**
     * Removes a certain Bicicleta element in bicicletas ArrayList
     * 
     * @param Bicicleta variable in bicicletas
     * @return
     */
    public void borrarBicicletas(Bicicleta bicicleta){
        this.bicicletas.remove(bicicleta);
    }
    
    /**
     * 
     */
    public String getCiclistas(){
        String mostrar = "";
        try{
            Iterator<Ciclista> itc = ciclistas.iterator();
            
            while (itc.hasNext()) {
                mostrar += itc.next();
            }
        }catch(NullPointerException e){ }
        return(mostrar);
    }
    
    //Cuenta los ciclistas del equipo sin abandonar
    /**
     * Counts the amount of Ciclista elements in the ciclistas ArrayList
     * 
     * @param
     * @return int number representing the amount of elements in ciclistas
     */
    public int contCiclistas(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        int i = 0;
        
        while (itc.hasNext()) {
            itc.next();
            i++;
        }
        return i;
    }
    
    /**
     * 
     */
    public String getCiclistasAbandonados(){
        String mostrar = "";
        try{
            Iterator<Ciclista> itca = ciclistasA.iterator();
            
            while (itca.hasNext()) {
                mostrar += itca.next();
            }
        }catch(NullPointerException e){ }
        return(mostrar);
    }
    
    /**
     * 
     */
    public String getBicicletas(){
        String mostrar = "";
        try{
            Iterator<Bicicleta> itb = bicicletas.iterator();
            
            while (itb.hasNext()) {
                mostrar += itb.next();
                mostrar += "\n";
            }
        }catch(NullPointerException e){ }
        return(mostrar);
    }
    
    //cuenta los ciclistas del equipo que han abandonado
    /**
     * Returns the amount of elements in ciclistasA ArrayList
     * 
     * @param
     * @return int number representing the amount of elements in ciclistasA
     */
    public int contCiclistasAbandonados(){
        Iterator<Ciclista> itca = ciclistasA.iterator();
        int i = 0;
        
        while (itca.hasNext()) {
            itca.next();
            i++;
        }        
        return i;
    }
    
    /**
     * Shows on screen all the information about Equipo class
     * 
     * @param
     * @return
     */    
    public String toString(){
        Iterator<Ciclista> itc = ciclistas.iterator();
        
        //%%% DSM WOMEN %%% Media Minutos de Ciclistas sin abandonar 0.0 %%%
        
        String mostrar = "%%% " + nombre + " %%% Media Minutos de Ciclistas sin abandonar " + 
                            String.format("%.2f", mediatiempoSinA()) + "%%%";
        mostrar += getCiclistas();
        mostrar += getCiclistasAbandonados();
        mostrar += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
        
        Salida.volcarLinea(mostrar);
        return(mostrar);
        /*Iterator<Bicicleta> itb = bicicletas.iterator();
        try{
            while (itb.hasNext()) {
                itc.next().mostrar();
            }
        }catch(NullPointerException e){ }*/
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        return result;
    }
     
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Etapa other = (Etapa) obj;
        if (other.getNombre() == null) {
            if (other.getNombre() != null)
                return false;
            } else if (!other.getNombre().equals(other.getNombre()))
                return false;
        return true;
    }
    
        /*Funcionalidad */ 
    
    //Ordenar ciclistas segun criterio
    /**
     * Sorts ciclistas ArrayList following a certain criteria
     * 
     * @param int number to choose the way of sorting
     * @return
     */
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
                //ciclistas.sort(reverse, new DestrezaComparator());    //??             
                break;
            case 11:
                ciclistas.sort(new ReverseHabilidadComparator());                 
                break;
        }
    }    

    //Ordenar bicicletas segun criterio
    /**
     * Sorts bicicletas ArrayList following a certain criteria
     * 
     * @param int number to choose the way of sorting
     * @return
     */
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
    /**
     * Calculates the amount of time in total in ciclistas ArrayList
     * 
     * @param
     * @return double variable whichs is the summation of all the times in ciclistas ArrayList
     */
    public double tiempoTotal(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = 0;
        
        while (it.hasNext()) {
            tiempoAc = tiempoAc + it.next().tiempoAcumulado();
        }
        return tiempoAc;
    }
    
    //Calcula la media del tiempo total
    /**
     * Calculates the average time spended by cyclist in the Equipo class
     * 
     * @param
     * @return double variable which is the total time divided by the total elements in ciclistas
     */
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
    /**
     * Calculates the average time spendend by cyclist in the Equipo class who did NOT abandon the stage
     * 
     * @param
     * @return double variable which represents the total amount of time divided by the total amount of cyclist (who did NOT abandon)
     */
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
    /**
     * Sends to a certain Etapa class all the information in ciclistas ArrayList
     * 
     * @param Etapa class to copy the information to
     * @return
     */
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
    /**
     * Updates the information about a certain Ciclista variable 
     * 
     * @param Ciclista variable to update
     * @return
     */
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
    /**
     * Shows on screen the information about stage results and returns those results as a ResultadosCarrera variable
     * 
     * @param Etapa class to recieve the info and boolean variable to know if it ended or not
     * @return ResultadosCarrera variable with all the information printed
     */
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
            Salida.volcarLinea(itc.next() + "\n");
            System.out.println("Velocidad: " + itc.next().getBicicleta().calcularVelocidad(itc.next(), etapa));
            Salida.volcarLinea("Velocidad: " + itc.next().getBicicleta().calcularVelocidad(itc.next(), etapa) + "\n");
            
            tiempo = itc.next().getBicicleta().calculartiempo(itc.next(), etapa);
            r = new Resultado(etapa, tiempo);
            itc.next().setResultado(r);
            
            if(itc.next().getEnergia() > 0){
                System.out.println("Tiempo: " + tiempo);
                Salida.volcarLinea("Tiempo: " + tiempo + "\n");
            } else {
                abandonado = true;
                System.out.println("Energia: " + itc.next().getEnergia()); 
                Salida.volcarLinea("Energia: " + itc.next().getEnergia() + "\n");
                System.out.println("Tiempo: " + tiempo);      
                Salida.volcarLinea("Tiempo: " + tiempo + "\n");
            }
            
            resultadosCarrera = new ResultadosCarrera(itc.next().getNombre(), itc.next().getEnergia(), r, abandonado);
            
            recogerCiclistas(itc.next());
        }
        return resultadosCarrera;
    }
}