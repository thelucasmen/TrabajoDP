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
    private List<Bicicleta> bicicletas;
    private List<Ciclista> ciclistasAbandonado;
    private int ordenC;
    private int ordenB;
    
    /**
     * Constructor for objects of class Equipo
     */ 
    
    public Equipo(String nombre, int c, int b)
    {    
        this.nombre = nombre;
        this.ciclistas = new ArrayList<Ciclista>();
        this.bicicletas = new ArrayList<Bicicleta>();
        this.ordenC = c;
        this.ordenB = b;
        ArrayList<Ciclista> ciclistasAbandonado = new ArrayList<Ciclista>();
    }
        
    /**
     * Changes the value of the String variable name in a certain Equipo class
     * 
     * @param  String variable to set in Equipo   
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }    
    
    /**
     * Returns the String variable nombre value
     * 
     * @return String value
     */
    public String getNombre(){
        return nombre;    
    }
    
    /**
     * Adds a new Ciclista element to the ciclistas ArrayList
     * 
     * @param Ciclista variable to add to the ArrayList
     */
    public void setCiclista(Ciclista ciclista){
        ciclistas.add(ciclista);
    }
    
    /**
     * Adds a new Bicicleta element to the bicicletas ArrayList
     * 
     * @param Bicicleta variable to insert
     */
    public void setBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    /**
     * Removes a certain Ciclista element in ciclistas ArrayList
     * 
     * @param Ciclista variable in ciclistas
     */
    public void borrarCiclista(Ciclista ciclista){
        this.ciclistas.remove(ciclista);
    }
    
    /**
     * Removes a certain Bicicleta element in bicicletas ArrayList
     * 
     * @param Bicicleta variable in bicicletas
     */
    public void borrarBicicletas(Bicicleta bicicleta){
        this.bicicletas.remove(bicicleta);
    }
    
    /**
     * Changes the value of the int variable ordenC in a certain Equipo class
     * 
     * @param  int variable to set in Equipo   
     */
    public void setOrdenC(int c){
        this.ordenC = c;
    }
    
    /**
     * Changes the value of the int variable ordenB in a certain Equipo class
     * 
     * @param int variable to set in Equipo
     */
    public void setOrdenB(int b){
        this.ordenB = b;
    }
    
    /**
     * Returns the int variable ordenC value
     * 
     * @return int value
     */
    public int getOrdenC(){
        return ordenC;
    }
    
    /**
     * Returns the String variable ordenB value
     * 
     * @return int value
     */
    public int getOrdenB(){
        return ordenB;
    }
    
    /**
     * 
     * @param boolean variable
     * @return String mostrar
     */
    public String getCiclistas(){
        String mostrar = "";
        Ciclista c, cAux = null;
        Iterator<Ciclista> itc = ciclistas.iterator();
        while (itc.hasNext()) {
            c = itc.next();
            if(!c.abandonado()){
                mostrar += c + "\n";
            }else{
                cAux = c;
            }
        }
        if(cAux != null){
            mostrar += cAux + "\n";
        }
        return mostrar;
    }
    
    /**
     * Devuelve la lista de ciclistas (Esta clase solo se usa para las pruebas)
     * 
     * @return List<Ciclista> ciclistas
     */
    public List<Ciclista> getListaCiclistas(){
        return ciclistas;
    }
    
    /**
     * Removes all Ciclista element in ciclistas ArrayList
     * 
     * @param Ciclista variable in ciclistas
     */
    public void limpiarCiclista(){
        this.ciclistas.clear();
    }
    
    /**
     * Removes all Bicicleta element in ciclistas ArrayList
     * 
     * @param Bicicleta variable in bicicletas
     */
    public void limpiarBicicleta(){
        this.bicicletas.clear();
    }
    
    /**
     * Devuelve la lista de bicicletas (Esta clase solo se usa para las pruebas)
     * 
     * @return List<Bicicleta> bicicletas
     */
    public List<Bicicleta> getListaBicicleta(){
        return bicicletas;
    }
    
    /**
     * Busca si existe un ciclista (Esta clase solo se usa para las pruebas)
     * 
     * @param Ciclista c
     * @return boolean existe
     */
    public boolean buscarCiclistas(Ciclista c){
        boolean existe = false;
        if(ciclistas.contains(c)){
            existe = true;
        }
        return existe;
    }
    
    /**
     * Busca si existe una bicicleta (Esta clase solo se usa para las pruebas)
     * 
     * @param Bicicleta b
     * @return boolean existe
     */
    public boolean buscarBicicletas(Bicicleta b){
        boolean existe = false;
        if(bicicletas.contains(b)){
            existe = true;
        }
        return existe;
    }
    
    //Cuenta los ciclistas del equipo sin abandonar
    /**
     * Counts the amount of Ciclista elements in the ciclistas ArrayList
     * 
     * @return int number representing the amount of elements in ciclistas
     */
    public int contCiclistas(){
        return ciclistas.size();
    }
    
    /**
     * 
     * @return String mostrar
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
    
    /**
     * Shows on screen all the information about Equipo class
     * 
     * @return String mostrar
     */    
    public String toString(){
        
        //%%% DSM WOMEN %%% Media Minutos de Ciclistas sin abandonar 0.0 %%%
        
        String mostrar = "%%% " + nombre.toUpperCase() + " %%% Media Minutos de Ciclistas sin abandonar " + 
                            String.format("%.2f", mediatiempoSinA()) + "%%%\n\n";
                            
        mostrar += getCiclistas();
        mostrar += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
            
        return mostrar;
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
        Equipo other = (Equipo) obj;
        if (other.getNombre() == null) {
            if (other.getNombre() != null)
                return false;
            } else if (!other.getNombre().equals(other.getNombre()))
                return false;
        return true;
    }
    
        /*Funcionalidad */ 
    /**
     * Sorts equipo 
     */
    public void ordenarEquipo(){
        ordenarCiclistas(getOrdenC());
        ordenarBicicletas(getOrdenB());        
    }  
        
    //Ordenar ciclistas segun criterio
    /**
     * Sorts ciclistas ArrayList following a certain criteria
     * 
     * @param int number to choose the way of sorting
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
                Collections.sort(ciclistas, Collections.reverseOrder(new NameComparator()));
                break;
            case 8:                
                Collections.sort(ciclistas, Collections.reverseOrder(new EnergyComparator()));
                break;
            case 9: 
                Collections.sort(ciclistas, Collections.reverseOrder(new TiempoComparator()));
                break;
            case 10:
                Collections.sort(ciclistas, Collections.reverseOrder(new DestrezaComparator()));            
                break;
            case 11:
                Collections.sort(ciclistas, Collections.reverseOrder(new HabilidadComparator()));       
                break;
        }
    }    

    //Ordenar bicicletas segun criterio
    /**
     * Sorts bicicletas ArrayList following a certain criteria
     * 
     * @param int number to choose the way of sorting
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
                Collections.sort(bicicletas, Collections.reverseOrder(new BicicletaNameComparator()));  
                break;
            case 4:               
                Collections.sort(bicicletas, Collections.reverseOrder(new BicicletaPesoComparator()));                 
                break;
        }
    }  
    
    //Suma total de tiempo de los ciclistas
    /**
     * Calculates the amount of time in total in ciclistas ArrayList
     * 
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
     * @return double variable which represents the total amount of time divided by the total amount of cyclist (who did NOT abandon)
     */
    public double mediatiempoSinA(){
        Iterator<Ciclista> it = ciclistas.iterator();
        double tiempoAc = 0;
        int contCiclistas = 0;
        Ciclista ciclista;
        while (it.hasNext()) {
            ciclista = it.next();
            String nombre = ciclista.getNombre();
            double energia = ciclista.getEnergia();
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
     * @return String salida
     */
    public String enviarCiclistas(Etapa etapa){   
        String salida = "";
        try{  
            Iterator<Ciclista> itc = ciclistas.iterator();
            Iterator<Bicicleta> itb = bicicletas.iterator();
            Ciclista ciclista;
            Bicicleta bicicleta, bicicletaAux;
            int cont = 0;
            
            while (itb.hasNext() && itc.hasNext()) {
                ciclista = itc.next();
                if(!ciclista.abandonado()){
                    bicicleta = itb.next();
                    ciclista.setBicicleta(bicicleta);
                    etapa.setCiclista(ciclista);    
                }  
            }
                   
            /*itc = ciclistas.iterator();
            while (itc.hasNext()) {
                ciclista = itc.next();
                etapa.setCiclista(ciclista);
                    //salida += ciclista + "\n";
            }*/
        } catch(NullPointerException e){ }
        return salida;
    }
    
    //Envia a la etapa todos los ciclistas del equipo que no hayan abandonado
    /**
     * Sends to a certain Etapa class all the information in ciclistas ArrayList
     * 
     * @param Etapa class to copy the information to
     */
    public void enviarTodosCiclistas(Etapa etapa){   
        try{  
            Iterator<Ciclista> itcA;
            Iterator<Ciclista> itc = ciclistas.iterator();
            Ciclista ciclista;
            
            while (itc.hasNext()) {
                ciclista = itc.next();
                etapa.setCiclista(ciclista); 
            }  
            
            itcA = ciclistasAbandonado.iterator();
            while (itcA.hasNext()) {
                ciclista = itcA.next();
                etapa.setCiclista(ciclista); 
            } 
        } catch(NullPointerException e){ }
    }
    
    //Actualiza los ciclistas despues de la etapa
    /**
     * Updates the information about a certain Ciclista variable 
     * 
     * @param Ciclista variable to update
     */
    public void recogerCiclistas(Ciclista ciclista){
        borrarCiclista(ciclista);
        if(ciclista.abandonado()){
            ciclistasAbandonado.add(ciclista);
        } else {
            setCiclista(ciclista);            
        }
    }
}