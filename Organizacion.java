import java.util.*;

/**
 * Write a description of class Organizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public void setNombreOrg(String nombreOrg){
        this.nombreOrg = nombreOrg;
    }    
    
    public String getNombreOrg(){
        return nombreOrg;
    }

    public void setPodio(ResultadosCarrera resultadosCarrera){
        this.podio.add(resultadosCarrera);
    }
    
    public void borrarPodio(ResultadosCarrera resultadosCarrera){
        this.podio.remove(resultadosCarrera);
    }
    
    public void setEtapas(Etapa etapa){
        this.etapas.add(etapa);
    }
    
    public void borrarEtapa(Etapa etapa){
        this.etapas.remove(etapa);
    }
    
    public void setEquipos(Equipo equipo){
        this.equipos.put(equipo.getNombre(), equipo);
    }
    
    public void borrarEquipo(Equipo equipo){
        this.equipos.remove(equipo);
    }
    
    public void setCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.add(ciclista);
    }
    
    public void borrarCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.remove(ciclista);
    }
    
    //Inscribe los equipos de la lista equipos en la etapa
    public void inscribirEquipos(Equipo equipo){
        setEquipos(equipo);
    }
    
    //Muestra las etapas y sus equipos, ademas, detecta si el campeonato ha acabado y muestra un resumen del campeonato
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
            while (itE.hasNext()) {
                itE.next().mostrar();
            }
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        }
        if(equipos.size()>0){
            System.out.println( 
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +
            "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
            );
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
            while (itE.hasNext() && !fin) {
                etapa = itE.next();
                contE++;
                System.out.print("*** CARRERA<" + contE + "> EN ");
                etapa.mostrar();
                System.out.print("***\n"+
                "********************************************************************************************************\n" +
                "********************************************************************************************************\n" +
                "******************************** Ciclistas que van a competir en " + etapa.getNombre() + 
                " *******************************\n" +
                "**********************************************************************************************************\n");
                itEq = equiposOrdenadas.iterator();
                while (itEq.hasNext()) {
                    equipo = itEq.next();
                    equipo.enviarCiclistas(etapa);
                }
                contC = etapa.getCiclista();
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                podio.clear();
                podio = etapa.mostrarCiclistas(contC, etapa, podio);     
                
                System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                                 "+++++++++++++++++ Clasificación final de la " + etapa.getNombre() + " ++++++++++++++++++\n" +
                                 "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                podio.sort(new TiempoPodioComparator());
                Iterator<ResultadosCarrera> itP = podio.iterator();
                contPodio = 0;
                while(itP.hasNext()){
                    resultadosCarrera = itP.next();
                    if(resultadosCarrera.getEnergia() > 0){
                        contPodio++;
                        System.out.println("@@@ Posición(" + contPodio + "): " + resultadosCarrera.getNombre() + 
                            " - Tiempo: " + String.format("%.2f",resultadosCarrera.getResultado().getTiempo()) + " minutos @@@");
                    } else {
                        System.out.println("¡¡¡ Ha abandonado " + resultadosCarrera.getNombre() + " - Tiempo: " + 
                            String.format("%.2f", resultadosCarrera.getResultado().getTiempo()) + 
                        " - Además ha abandonado para el resto del Campeonato !!!");
                    }
                }                   
                System.out.print("\n");
                if(contC == contCA || contC - contCA == 1) {
                    fin = true;
                }
            }
            
            System.out.println("****************************************************\n" +
                                "**************** FIN DEL CAMPEONATO ****************\n" +
                                "****************************************************\n" +
                                "********** CLASIFICACIÓN FINAL DE CICLISTAS **********\n" +
                               "****************************************************");
            
            if(fin) { 
                System.out.println("Ganador desierto (ningún Ciclista ni equipo ha ganado el campeonato)");
            }
            etapa.mostrarResultadosCiclistas();
            System.out.println("****************************************************\n" +
                               "******** CLASIFICACIÓN FINAL DE EQUIPOS *********\n" +
                               "****************************************************");
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
                equipo.getCiclistas();
                System.out.print("\n");
            }
        }
    }
}
