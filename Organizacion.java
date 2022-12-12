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
    private HashSet<Etapa> etapas;
    private HashMap<String, Equipo> equipos;
    private List<Ciclista> ciclistasCarrera;
    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion(String nombreOrg, HashSet<Etapa> etapas, HashMap<String, Equipo> equipos, List<Ciclista> ciclistasCarrera)
    {
        this.nombreOrg = nombreOrg;
        this.etapas = new HashSet<Etapa>();
        this.equipos = new HashMap<String,Equipo>();           
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        
        podio = new ArrayList<ResultadosCarrera>();
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
    
    /**
     * Adds a new Ciclista element to the ciclistas ArrayList
     * 
     * @param Ciclista variable to add
     * @return
     */
    public void setCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.add(ciclista);
    }
    
    /**
     * Removes a certain Ciclista element from ciclistas ArrayList
     * 
     * @param Ciclista element in ArrayList to remove
     * @return
     */
    public void borrarCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.remove(ciclista);
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
        boolean fin = false;
        int contC = 0, contCA = 0, contE = 0, contCE = 0, contPodio;
        double menorTiempo = 2147483647; //2147483647 es el valor maximo que un int puede guardar, el tiempo del primer equipo siempre sera menor que este valor
        //Ordenar Etapas
        List<Etapa> etapasOrdenadas = new ArrayList<Etapa>(etapas);
        etapasOrdenadas.sort(new DificultadComparator());
        Iterator<Etapa> itE = etapasOrdenadas.iterator();
        //Ordenar Equipos
        List<Equipo> equiposOrdenadas = new ArrayList<Equipo>();
        for (String i : equipos.keySet()) {
          equiposOrdenadas.add(equipos.get(i));
        }
        equiposOrdenadas.sort(new NameEqComparator());
        Iterator<Equipo> itEq = equiposOrdenadas.iterator();
        
        //ordenarListas();
        if(etapas.size()>0){
            System.out.println(
            "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
            "\n||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||" +
            "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
            );
            Salida.volcarLinea("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" +
            "\n||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||" +
            "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+"\n");
            while (itE.hasNext()) {
                itE.next().mostrar();
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Salida.volcarLinea("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + "\n");
        }
        if(equipos.size()>0){
            System.out.println( 
            "\n%%%%%%%%%%%%%%%%%%%%%%%%     %%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
            );
            Salida.volcarLinea(
            "\n%%%%%%%%%%%%%%%%%%%%%%%%     %%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + "\n");
            while (itEq.hasNext()) {
                equipo = itEq.next();
                equipo.mostrar();
                if(equipo.mediatiempoTotal() < menorTiempo){
                    menorTiempo = equipo.mediatiempoTotal();
                    equipoGanador = equipo;
                }
            }
            
            itE = etapasOrdenadas.iterator();
            System.out.println("********************************************************************************************************");
            Salida.volcarLinea("********************************************************************************************************" + "\n");
            while (itE.hasNext() && !fin) {
                etapa = itE.next();
                contE++;
                System.out.print("*** CARRERA<" + contE + "> EN ");
                Salida.volcarLinea("*** CARRERA<" + contE + "> EN " + "\n");
                etapa.mostrar();
                System.out.print("***\n"+
                "********************************************************************************************************\n" +
                "********************************************************************************************************\n" +
                "******************************** Ciclistas que van a competir en " + etapa.getNombre() + 
                " *******************************\n" +
                "**********************************************************************************************************\n");
                Salida.volcarLinea("***\n"+
                "********************************************************************************************************\n" +
                "********************************************************************************************************\n" +
                "******************************** Ciclistas que van a competir en " + etapa.getNombre() + 
                " *******************************\n" +
                "**********************************************************************************************************\n" +
                "\n");
                itEq = equiposOrdenadas.iterator();
                while (itEq.hasNext()) {
                    equipo = itEq.next();
                    equipo.enviarCiclistas(etapa);
                }
                contC = etapa.getCiclista();
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                Salida.volcarLinea("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" + "\n");
                podio.clear();
                podio = etapa.mostrarCiclistas(contC, etapa, podio);     
                
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                                 "+++++++++++++++++ Clasificación final de la " + etapa.getNombre() + " ++++++++++++++++++\n" +
                                 "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                Salida.volcarLinea("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                                 "+++++++++++++++++ Clasificación final de la " + etapa.getNombre() + " ++++++++++++++++++\n" +
                                 "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" + "\n");
                podio.sort(new TiempoPodioComparator());
                Iterator<ResultadosCarrera> itP = podio.iterator();
                contPodio = 0;
                while(itP.hasNext()){
                    resultadosCarrera = itP.next();
                    if(resultadosCarrera.getEnergia() > 0){
                        contPodio++;
                        System.out.println("@@@ Posición(" + contPodio + "): " + resultadosCarrera.getNombre() + 
                            " - Tiempo: " + String.format("%.2f",resultadosCarrera.getResultado().getTiempo()) + " minutos @@@");
                        Salida.volcarLinea("@@@ Posición(" + contPodio + "): " + resultadosCarrera.getNombre() + 
                            " - Tiempo: " + String.format("%.2f",resultadosCarrera.getResultado().getTiempo()) + " minutos @@@" + "\n");
                    } else {
                        System.out.println("¡¡¡ Ha abandonado " + resultadosCarrera.getNombre() + " - Tiempo: " + 
                            String.format("%.2f", resultadosCarrera.getResultado().getTiempo()) + 
                        " - Además ha abandonado para el resto del Campeonato !!!");
                        Salida.volcarLinea("¡¡¡ Ha abandonado " + resultadosCarrera.getNombre() + " - Tiempo: " + 
                            String.format("%.2f", resultadosCarrera.getResultado().getTiempo()) + 
                        " - Además ha abandonado para el resto del Campeonato !!!" + "\n");
                    }
                }                   
                System.out.print("\n");
                Salida.volcarLinea("\n" + "\n");
                if(contC == contCA || contC - contCA == 1) {
                    fin = true;
                }
            }
            
            System.out.println("****************************************************\n" +
                                "**************** FIN DEL CAMPEONATO ****************\n" +
                                "****************************************************\n" +
                                "********** CLASIFICACIÓN FINAL DE CICLISTAS **********\n" +
                               "****************************************************");
            Salida.volcarLinea("****************************************************\n" +
                                "**************** FIN DEL CAMPEONATO ****************\n" +
                                "****************************************************\n" +
                                "********** CLASIFICACIÓN FINAL DE CICLISTAS **********\n" +
                               "****************************************************" + "\n");
            
            if(fin) { 
                System.out.println("Ganador desierto (ningún Ciclista ni equipo ha ganado el campeonato)");
                Salida.volcarLinea("Ganador desierto (ningún Ciclista ni equipo ha ganado el campeonato)" + "\n");
            }
            etapa.mostrarResultadosCiclistas();
            System.out.println("****************************************************\n" +
                               "******** CLASIFICACIÓN FINAL DE EQUIPOS *********\n" +
                               "****************************************************");
            Salida.volcarLinea("****************************************************\n" +
                               "******** CLASIFICACIÓN FINAL DE EQUIPOS *********\n" +
                               "****************************************************" + "\n");
            contE = 0;
            equiposOrdenadas.sort(new MediaTiempoTotalComparator());
            itEq = equiposOrdenadas.iterator();
            while (itEq.hasNext()) {
                equipo = itEq.next();
                contE++;
                System.out.println("@@@ Posición(" + contE + ") " + equipo.getNombre() + 
                                   " con " + String.format("%.2f",equipo.mediatiempoSinA()) + " minutos de media @@@\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                                   "%%% " + equipo.getNombre() + " %%% Media Minutos de Ciclistas sin abandonar " + 
                                   String.format("%.2f",equipo.mediatiempoSinA()) + " %%%");  
                Salida.volcarLinea("@@@ Posición(" + contE + ") " + equipo.getNombre() + 
                                   " con " + String.format("%.2f",equipo.mediatiempoSinA()) + " minutos de media @@@\n" +
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                                   "%%% " + equipo.getNombre() + " %%% Media Minutos de Ciclistas sin abandonar " + 
                                   String.format("%.2f",equipo.mediatiempoSinA()) + " %%%" + "\n");
                equipo.getCiclistas();
                System.out.print("\n");
                Salida.volcarLinea("\n" + "\n");
            }
        }
    }
}
