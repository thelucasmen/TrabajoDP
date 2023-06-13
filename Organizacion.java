import java.util.*;

/**
 * La clase organizacion se encarga de gestionar todo el campeonato.
 * Sera la encargada de gestionar las etapas, equipos, participantes, etc...
 * Tambien sera la encargada de gestionar los resultados, clasificaciones por equipos, etc...
 * 
 * La clase esta preparada para acceder al resto de clases y emplear sus operaciones para 
 * gestionar y realizar las funcionalidades previamente mencionadas en funcion de la informacion
 * enviada.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class Organizacion
{
    // instance variables - replace the example below with your own
    private String nombreOrg;
    private List<ResultadosCarrera> podio;
    private Set<Etapa> etapas;
    private Map<String, Equipo> equipos;
    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion(String nombreOrg)
    {
        this.nombreOrg = nombreOrg;
        this.etapas = new TreeSet<Etapa>(new DificultadComparator());
        this.equipos = new TreeMap<String,Equipo>();       
        this.podio = new ArrayList<ResultadosCarrera>();
    }
    
    /**
     * Changes the value of the String variable nombre in Organizacion class
     * 
     * @param String variable to set in Organizacion
     * @return
     */
    public void setNombreOrg(String nombreOrg){
        this.nombreOrg = nombreOrg;
    }    
    
    /**
     * Returns the value of the String variable nombre in Organizacion
     * 
     * @param
     * @return String variable.
     */
    public String getNombreOrg(){
        return nombreOrg;
    }
    
    /**
     * Adds a new ResultadosCarrera element to the podio ArrayList
     * 
     * @param ResultadosCarrera variable to add
     * @return
     */
    public void setPodio(ResultadosCarrera resultadosCarrera){
        this.podio.add(resultadosCarrera);
    }
    
    /**
     * Removes a certain element form the podio ArrayList
     * 
     * @param ResultadosCarrera variable in podio ArrayList
     * @return
     */
    public void borrarPodio(ResultadosCarrera resultadosCarrera){
        this.podio.remove(resultadosCarrera);
    }
    
    /**
     * Adds a new Etapa element to the etapas HashSet
     * 
     * @param Etapa variable to add
     * @return
     */
    public void setEtapas(Etapa etapa){
        this.etapas.add(etapa);
    }
    
    /**
     * Removes a certain Etapa element from the etapas HashSet
     * 
     * @param Etapa variable in HashSet to remove
     * @return
     */
    public void borrarEtapa(Etapa etapa){
        this.etapas.remove(etapa);
    }
    
    /**
     * Adds a new Equipo variable to the equipos HashMap
     * 
     * @param Equipo variable to add
     * @return
     */
    public void setEquipos(Equipo equipo){
        this.equipos.put(equipo.getNombre(), equipo);
    }
    
    /**
     * Removes a certain Equipo variable from the HashMap
     * 
     * @param Equipo variable in HashMap to remove
     * @return
     */
    public void borrarEquipo(Equipo equipo){
        this.equipos.remove(equipo);
    }
    
    //Inscribe los equipos de la lista equipos en la etapa
    /**
     * Adds a new Equipo variable to the equipos HashMap
     * 
     * @param Equipo variable to add
     * @return
     */
    public void inscribirEquipos(Equipo equipo){
        setEquipos(equipo);
    }
    
    //Muestra las etapas y sus equipos, ademas, detecta si el campeonato ha acabado y muestra un resumen del campeonato
    /**
     * The main method in programm. Manages all the operations and information recieved by all the classes and objects and 
     * operates with it. Shows the stages and teams on screen, as well as detecting if the championship is over to show on
     * screen a summary.
     * 
     * @param
     * @return
     */
    public void gestionarCarrera(){  
        String ganador = "Por decidir";
        Etapa etapa = null;
        Equipo equipo = null;
        Equipo equipoGanador = null;
        ResultadosCarrera resultadosCarrera = null;
        String salida = "";
        String aux = "";
        boolean fin = false;
        //int contC = 0;
        int contCA = 0, contE = 0, contCE = 0, contPodio;
        double menorTiempo = 2147483647; //2147483647 es el valor maximo que un int puede guardar, el tiempo del primer equipo siempre sera menor que este valor
        //Ordenar Etapas
        Iterator<Etapa> itE = etapas.iterator();
        //Ordenar Equipos
        List<Equipo> equiposOrdenadas = new ArrayList<Equipo>();
        for(Equipo e : equipos.values()){
            e.ordenarEquipo();
        }
        /*for (String i : equipos.keySet()) {
            equiposOrdenadas.add(equipos.get(i));
        }
        equiposOrdenadas.sort(new NameEqComparator());
        Iterator<Equipo> itEq = equiposOrdenadas.iterator();*/
        
        //ordenarListas();
        if(etapas.size()>0){
            salida += "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
                      "\n||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||" +
                      "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
            while (itE.hasNext()) {
                salida += itE.next() + "\n";
            }
            salida += "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n";
        }
        if(equipos.size()>0){
            salida += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
                      "\n%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%" +
                      "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";            
            
            for ( Equipo e: equipos.values()){
                salida += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
                salida += e;
                if(e.mediatiempoTotal() < menorTiempo){
                    menorTiempo = e.mediatiempoTotal();
                    equipoGanador = e;
                }
            }
            /*while (itEq.hasNext()) {
                equipo = itEq.next();
                salida += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
                salida += equipo;
                if(equipo.mediatiempoTotal() < menorTiempo){
                    menorTiempo = equipo.mediatiempoTotal();
                    equipoGanador = equipo;
                }
            }*/
            
            itE = etapas.iterator();
            salida += "\n********************************************************************************************************\n";
            while (itE.hasNext() && !fin) {
                etapa = itE.next();
                contE++;
                salida += "*** CARRERA<" + contE + "> EN ";
                salida += etapa;
                salida += "***\n"+
                "********************************************************************************************************\n" +
                "********************************************************************************************************\n" +
                "******************************** Ciclistas que van a competir en " + etapa.getNombre() + 
                " *******************************\n" +
                "**********************************************************************************************************\n";
                //itEq = equiposOrdenadas.iterator();
                for(Equipo e : equipos.values()){
                    e.ordenarEquipo();
                    e.enviarCiclistas(etapa);
                }
                salida += etapa.getCiclistas();
                //contC = etapa.getCiclista();
                salida += "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
                podio.clear();
                //podio = etapa.mostrarCiclistas(contC, etapa, podio);   
                salida += etapa.salidaMostrarCiclistas(etapa, podio);
                
                salida += "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                            "+++++++++++++++++ Clasificación final de la carrera en " + etapa.getNombre() + " ++++++++++++++++++\n" +
                            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
                podio.sort(new TiempoPodioComparator());
                Iterator<ResultadosCarrera> itP = podio.iterator();
                contPodio = 0;
                while(itP.hasNext()){
                    resultadosCarrera = itP.next();
                    if(resultadosCarrera.getEnergia() > 0){
                        contPodio++;
                        salida += "@@@ Posición(" + contPodio + "): " + resultadosCarrera.getNombre() + 
                            " - Tiempo: " + String.format("%.2f",resultadosCarrera.getResultado().getTiempo()) + " minutos @@@\n";
                    } else {
                        aux = "¡¡¡ Ha abandonado " + resultadosCarrera.getNombre() + " - Tiempo: " + 
                            String.format("%.2f", resultadosCarrera.getResultado().getTiempo()) + 
                        " - Además ha abandonado para el resto del Campeonato !!!\n";
                    }
                } 
                if(contE < etapas.size()){
                    salida += aux + "\n********************************************************************************************************\n";
                } else {
                    salida += aux;
                }
                
                if(etapa.getCiclista() == contCA || etapa.getCiclista() - contCA == 1) {
                    fin = true;
                }
            }
            
            salida +=           "****************************************************\n" +
                                "**************** FIN DEL CAMPEONATO ****************\n" +
                                "****************************************************\n" +
                                "********** CLASIFICACIÓN FINAL DE CICLISTAS **********\n" +
                               "****************************************************\n";
            
            if(fin) { 
                salida += "Ganador desierto (ningún Ciclista ni equipo ha ganado el campeonato)\n";
            }
            
            etapa.clearCiclista();
            for (Equipo e : equipos.values()){
                equiposOrdenadas.add(e);
                e.enviarTodosCiclistas(etapa);
            }
            
            salida += etapa.mostrarResultadosCiclistas();
            salida +=          "****************************************************\n" +
                               "******** CLASIFICACIÓN FINAL DE EQUIPOS *********\n" +
                               "****************************************************\n";
            contE = 0;
            equiposOrdenadas.sort(new MediaTiempoTotalComparator());
            Iterator<Equipo> itEq = equiposOrdenadas.iterator();
            while (itEq.hasNext()) {
                equipo = itEq.next();
                contE++;
                salida +=          "@@@ Posición(" + contE + ") " + equipo.getNombre() + 
                                   " con " + String.format("%.2f",equipo.mediatiempoSinA()) + " minutos de media @@@\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                                   "%%% " + equipo.getNombre().toUpperCase()/*.charAt(0) + equipo.getNombre().substring(1, equipo.getNombre().length()).toLowerCase() */
                                   + " %%% Media Minutos de Ciclistas sin abandonar " + String.format("%.2f",equipo.mediatiempoSinA()) + " %%%\n\n";  
                salida += equipo.getCiclistas();
                salida += "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n";
            }
        }
        System.out.println(salida);
        Salida.volcarLinea(salida);
    }
}
