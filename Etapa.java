import java.util.*;

/**
 * 
 * Cada etapa está compuesta por un nombre, una distancia y una dificultad.
 * Las operaciones en esta clase son las básicas para poder interactuar con
 * otras clases. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
    private Dificultad dificultad;
    private Distancia distancia;
    private String nombre;
    private String salida;
    private List<Ciclista> ciclistas;
    

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(String nombre, Dificultad dificultad, Distancia distancia)
    {
        // initialise instance variables
        this.dificultad = dificultad;
        this.distancia = distancia;
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
    }
    
    /**
     * Returns the value of the Dificultad atribute in Etapa class
     * 
     * @return     Dificultad variable
     */
    
    public Dificultad getDificultad(){        
        return dificultad;    
    }  
    
    /**
     * Returns the value of the distancia atribute in Etapa class
     * 
     * @return     Distancia variable
     */
    public Distancia getDistancia(){      
        return distancia;        
    }
    
    /**
     * Returns the value of the nombre atribute in Etapa class
     * 
     * @return     String variable
     */
    public String getNombre(){       
        return nombre;
    }
    
    /**
     * Changes the value of the String variable nombre in Etapa class
     * 
     * @param String variable to set value
     */
    public void setNombre(String n){
        this.nombre = n;
    }
    
    /**
     * Changes the value of the Distancia variable distancia in Etapa class
     * 
     * @param Distancia variable to set value
     */
    public void setDistancia(Distancia d){
        this.distancia = d;
    }
    
    /**
     * Changes the value of the Dificultad variable dificultad in Etapa class
     * 
     * @param Dificultad variable to set value
     */
    public void setDificultad(Dificultad diff){
        this.dificultad = diff;
    }
    
    /**
     * Adds a new Ciclista variable to the ciclistas ArrayList
     * 
     * @param Ciclista variable to add to the list
     */
    public void setCiclista(Ciclista ciclista){
        ciclistas.add(ciclista);
    }
    
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    /**
     * Clears ciclistas ArrayList
     */
=======
>>>>>>> b3c236459597ee84208d99bd9088c0c9605094e0
>>>>>>> Stashed changes
    public void clearCiclista(){
        ciclistas.clear();
    }
    
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    /**
     * Returns the number of elements in ciclistas ArrayList
     * 
     * @return int variable
     */
=======
>>>>>>> b3c236459597ee84208d99bd9088c0c9605094e0
>>>>>>> Stashed changes
    public int getCiclista(){
        /*int contador = 0;
        try{
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                if(!itC.next().abandonado()){
                    contador++;
                }
            }
        }catch(NullPointerException e){ }*/
        return ciclistas.size();
    }
       
    public String getCiclistas(){
        String salida = "";
        Ciclista ciclista;
        Collections.sort(ciclistas, Collections.reverseOrder(new NameComparator()));
        Collections.sort(ciclistas, Collections.reverseOrder(new TiempoComparator()));
        try{
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {  
                ciclista = itC.next();
                if(!ciclista.abandonado()){
                    salida += ciclista + "\n";
                }
            }
        }catch(NullPointerException e){ }
        return salida;
    }
    
    public String toString()
    {
        //<etapa:sencilla intermedia> <dificultad:Sencilla (valor:0.9)> <distancia:Intermedia (valor:200.0)>
        String mostrar = "<etapa:" + nombre + "> <dificultad:";
        mostrar += dificultad; 
        mostrar += "> <distancia:";
        mostrar += distancia;
        mostrar += ">"; 
        return(mostrar);
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
    
    /**
     * Shows on screen the results of every ciclista in the arrayList
     * 
     * @param int variable contC to keep track of the amount of ciclistas
     */
        /*Funcionalidad */ 
    
    //Recorre el listado de ciclistas y sus bicicletas
    public String salidaMostrarCiclistas(Etapa etapa, List<ResultadosCarrera> podio){
        int contCE = 0;
        Ciclista ciclista = null;
        ResultadosCarrera resultadosCarrera = null;
        Resultado resultado = null;
        double tiempo = 0;
        double energiaPrevia = 0;
        String salida = "";
        try{
            Collections.sort(ciclistas, Collections.reverseOrder(new NameComparator()));
            Collections.sort(ciclistas, Collections.reverseOrder(new TiempoComparator()));
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                ciclista = itC.next();
                if(!ciclista.abandonado()){
                    contCE++;
                    salida += "@@@ ciclista " + contCE + " de " + getCiclista() + "\n";
                    salida += ciclista + " con bicicleta\n";
                    salida += ciclista.getBicicleta();
                    tiempo = ciclista.getBicicleta().calculartiempo(ciclista, etapa);
                    energiaPrevia = ciclista.getEnergia(); 
                    ciclista.funcionalidadCiclista(etapa, tiempo);
                    salida += "en etapa " + etapa.getNombre() + "\n" +
                        "+++ Con estas condiciones el ciclista " + ciclista.getNombre() + " con la bicicleta " + 
                        ciclista.getBicicleta().getNombre() + " alcanza una velocidad de " + 
                        String.format("%.2f",ciclista.getBicicleta().calcularVelocidad(ciclista, etapa)) + " km/hora +++ \n";
                    if(!ciclista.abandonado()){
                        salida += "+++ " + ciclista.getNombre() + " termina la etapa en " + String.format("%.2f",tiempo) + " minutos +++\n" +
                            "+++ La energía del ciclista " + ciclista.getNombre() + " tras la carrera es " + 
                            String.format("%.2f",ciclista.getEnergia()) + " +++\n" + "@@@\n";
                    } else {
                        salida += "¡¡¡ El ciclista " + ciclista.getNombre() + " se quedó sin energia a falta de " + 
                            String.format("%.2f",ciclista.getEnergia()*(-1)) + " minutos para terminar !!!\n" +
                        "¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + 
                        String.format("%.2f",energiaPrevia) + " minutos !!!\n" +
                        "+++ La energía del ciclista " + ciclista.getNombre() + " tras la carrera es " + 
                        String.format("%.2f",ciclista.getEnergia()) + " +++\n@@@\n";
                    }
                    if(ciclista.getClass().getName().equals("CiclistaEstrella")){
                        salida += ciclista.SerPopular(tiempo);
                    }
                    
                    if(!ciclista.abandonado()){
                        resultado = new Resultado(etapa, tiempo);
                    } else {
                        resultado = new Resultado(etapa, ciclista.getEnergia());
                    }
                    ciclista.setResultado(resultado);
                    resultadosCarrera = new ResultadosCarrera(ciclista.getNombre(), ciclista.getEnergia(), resultado, ciclista.abandonado());
                    podio.add(resultadosCarrera);
                }
            }
        }catch(NullPointerException e){ }
        return salida;
    }
    
    //Recorre el listado de ciclistas muestras sus resultados en las diferentes etapas
    /**
     * Shows on screen the results of the ciclistas in ciclistas arrayList
     * 
     * @return String salida
     */
    public String mostrarResultadosCiclistas(){
        Ciclista ciclista;
        String salida = "";
        int contC = 0, contCA = 0, cont = 0;
        
        try{
            ciclistas.sort(new TiempoComparator());
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                ciclista = itC.next();
                if(!ciclista.abandonado()){
                    contC++;
                    salida += "@@@ Posición(" + contC + "): " + ciclista.getNombre() + 
                    " - Tiempo Total: " + String.format("%.2f",ciclista.tiempoAcumulado()) + " @@@\n";
                    salida += ciclista.getResultado();
                    salida += "\n";
                } else {
                    contCA++;
                }
            }
            
            if(contCA > 0){
                salida += "****************************************************\n" +
                          "************** CICLISTAS QUE ABANDONARON **************\n" +
                          "****************************************************\n";
            ciclistas.sort(new PuntosAnuladosComparator());            
            itC = ciclistas.iterator();
                while (itC.hasNext()){ //&& cont < ciclistas.size()-1) {
                    cont++;
                    ciclista = itC.next();
                    if(ciclista.abandonado()){
                        salida += "--- ciclista Abandonado: " + ciclista.getNombre() + " - Puntos Totales Anulados: " +
                        String.format("%.2f",ciclista.puntosAnulados()) + "---\n";
                        salida += ciclista.getResultado();
                        salida += "\n";
                    }
                }
            }
        }catch(NullPointerException e){ }    
        return salida;
    }
}