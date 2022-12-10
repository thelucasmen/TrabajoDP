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
    private List<Etapa> etapas;
    private int criterioOrdenEtapas; //1.dificultad, 2.distancia, 3.nombre, 4.dificultad(desc), 5.distancia(desc) o 6.nombre(desc) 
    private List<Equipo> equipos;
    private int criterioOrdenEquipos; //1.nombre, 2.tiempoTotal(), 3.nombre(desc), 4.tiempoTotal()(desc)
    private List<Ciclista> ciclistasCarrera;
    private int criterioOrdenCiclistas; //1.nombre, 2.bicicleta, 3.energia, 4.tiempoAcumulado(), 5.calculaDestreza(), 
                                        //6.nombre(desc), 7.bicicleta(desc), 8.energia(desc), 9.tiempoAcumulado()(desc), 10.calculaDestreza()(desc)
    
    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion(String nombreOrg, List<Etapa> etapas, int criterioOrdenEtapas, List<Equipo> equipos, int criterioOrdenEquipos, List<Ciclista> ciclistasCarrera, int criterioOrdenCiclistas)
    {
        this.nombreOrg = nombreOrg;
        
        this.etapas = new ArrayList<Etapa>();
            this.criterioOrdenEtapas = criterioOrdenEtapas;
            
        this.equipos = new ArrayList<Equipo>();
            this.criterioOrdenEquipos = criterioOrdenEquipos;
            
        this.ciclistasCarrera = new ArrayList<Ciclista>();
            this.criterioOrdenCiclistas = criterioOrdenCiclistas;
        
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
    
    public void setCriterioOrdenEtapas(int criterioOrdenEtapas){
        this.criterioOrdenEtapas = criterioOrdenEtapas;
    }
    
    public int getCriterioOrdenEtapas(){
        return criterioOrdenEtapas;
    }
    
    public void setEquipos(Equipo equipo){
        this.equipos.add(equipo);
    }
    
    public void borrarEquipo(Equipo equipo){
        this.equipos.remove(equipo);
    }
    
    public void setCriterioOrdenEquipos(int criterioOrdenEquipos){
        this.criterioOrdenEquipos = criterioOrdenEquipos;
    }
    
    public int getCriterioOrdenEquipos(){
        return criterioOrdenEquipos;
    }
    
    public void setCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.add(ciclista);
    }
    
    public void borrarCiclistasCarrera(Ciclista ciclista){
        this.ciclistasCarrera.remove(ciclista);
    }
    
    public void setCriterioOrdenCiclistas(int criterioOrdenCiclistas){
        this.criterioOrdenCiclistas = criterioOrdenCiclistas;
    }
    
    public int getCriterioOrdenCiclistas(){
        return criterioOrdenCiclistas;
    }
    
    public void mostrar()
    {
        Iterator<Etapa> itE = etapas.iterator();
        Iterator<Equipo> itEq = equipos.iterator();
        Iterator<Ciclista> itCC = ciclistasCarrera.iterator();
        
        System.out.println("Nombre organizacion: " + nombreOrg);
        System.out.println("Etapas: ");
        if(etapas.size()>0){   
            while (itE.hasNext()) {
                itE.next().mostrar();
            }
        } else {
            System.out.println("No hay etapas");
        }
        
        System.out.println("Equipos: ");
        if(equipos.size()>0){
            while (itEq.hasNext()) {
                itEq.next().mostrar();
            }
        } else {
            System.out.println("No hay equipos");
        }
        
        System.out.println("Ciclistas en la carrera: ");
        if(ciclistasCarrera.size()>0){
            while (itCC.hasNext()) {
                itCC.next().mostrar();
            }
        } else {
            System.out.println("No hay ciclistas");
        }
    }
    
    //Ordena las listas segun los criterios
    public void ordenarListas(){
        //etapas
            if(criterioOrdenCiclistas == 1 || criterioOrdenCiclistas == 4){
                //1.dificultad o 4.dificultad(desc)
                etapas.sort(new DificultadComparator());
            } else if(criterioOrdenCiclistas == 2 || criterioOrdenCiclistas == 5){ 
                //2.distancia o 5.distancia(desc) 
                etapas.sort(new DistanciaComparator()); 
            } else if(criterioOrdenCiclistas == 3 || criterioOrdenCiclistas == 6){
                //3.nombre o 6.nombre(desc) 
                etapas.sort(new NameEComparator()); 
            } 
            
            if(criterioOrdenCiclistas > 4){
                Collections.sort(ciclistasCarrera, Collections.reverseOrder());
            }
            
        //equipos 
            if(criterioOrdenCiclistas == 1 || criterioOrdenCiclistas == 3){
                //1.nombre o 3.nombre(desc)
                equipos.sort(new NameEqComparator());
            } else if(criterioOrdenCiclistas == 2 || criterioOrdenCiclistas == 4){ 
                //2.tiempoTotal() o 4.tiempoTotal()(desc) 
                equipos.sort(new BicicletaTimeComparator());
            }
            
            if(criterioOrdenCiclistas > 3){
                Collections.sort(ciclistasCarrera, Collections.reverseOrder());
            }
            
        //ciclistasCarrera
            if(criterioOrdenCiclistas == 1 || criterioOrdenCiclistas == 6){
                //1.nombre o 6.nombre(desc)
                ciclistasCarrera.sort(new NameComparator());
            } else if(criterioOrdenCiclistas == 2 || criterioOrdenCiclistas == 7){ 
                //2.bicicleta o 7.bicicleta(desc) 
                ciclistasCarrera.sort(new BicicletaPesoCiclistaComparator());
                ciclistasCarrera.sort(new BicicletaNameCiclistaComparator()); 
            } else if(criterioOrdenCiclistas == 3 || criterioOrdenCiclistas == 8){
                //3.energia o 8.energia(desc) 
                ciclistasCarrera.sort(new EnergyComparator()); 
            } else if(criterioOrdenCiclistas == 4 || criterioOrdenCiclistas == 9){
                //4.tiempoAcumulado() o 9.tiempoAcumulado()(desc)
                ciclistasCarrera.sort(new TiempoComparator()); 
            } else if(criterioOrdenCiclistas == 5 || criterioOrdenCiclistas == 10){
                //5.calculaDestreza() o 10.calculaDestreza()(desc)
                ciclistasCarrera.sort(new DestrezaComparator()); 
            }
            
            if(criterioOrdenCiclistas > 5){
                Collections.sort(ciclistasCarrera, Collections.reverseOrder());
            }
    }
    
    //Inscribe los equipos de la lista equipos en la etapa
    public void inscribirEquipos(Equipo equipo){
        setEquipos(equipo);
        ordenarListas();
    }
    
    //Muestra las etapas y sus equipos, ademas, detecta si el campeonato ha acabado y muestra un resumen del campeonato
    public Equipo gestionarCarrera(){
        Iterator<Etapa> itE = etapas.iterator();
        Iterator<Equipo> itEq = equipos.iterator();
        String ganador = "Por decidir";
        Etapa etapa = null;
        Equipo equipoGanador = null;
        Equipo equipo = null;
        ResultadosCarrera resultadosCarrera = null;
        boolean fin = false;
        int contC = 0, contCA = 0, contE = 0, contCE = 0, contPodio;
        double menorTiempo = 2147483647; //2147483647 es el valor maximo que un int puede guardar, el tiempo del primer equipo siempre sera menor que este valor
        
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
            
            itE = etapas.iterator();
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
                itEq = equipos.iterator();
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
                    contPodio++;
                    resultadosCarrera = itP.next();
                    System.out.println("@@@ Posición(" + contPodio + "): " + resultadosCarrera.getNombre() + 
                    " - Tiempo: " + String.format("%.2f",resultadosCarrera.getResultado().getTiempo()) + " minutos @@@");
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
            celebracionEtapa(true);
                    
                if(contC == contCA || contC - contCA == 1) { 
                    System.out.println("Ganador desierto (ningún Ciclista ni equipo ha ganado el campeonato)");
                } else {
                    itEq = equipos.iterator();
                    //En todos los casos se mostrará como resumen final del campeonato
                    while (itEq.hasNext()) {
                        //MOSTRAR CICLISTAS
                        equipo = itEq.next();
                        equipo.ordenarCiclistas(1, 2);
                        equipo.ordenarCiclistas(4, 1);
                        equipo.getCiclistas();
                        
                        //MOSTRAR CICLISTAS ABANDONADOS
                        equipo.ordenarCiclistasA(1, 2);
                        equipo.ordenarCiclistasA(4, 1);
                        equipo.getCiclistasAbandonados();
                        
                        //EQUIPOS CON CICLISTAS SIN ABANDONAR
                        if(equipo.contCiclistasAbandonados() == 0){
                            equipos.sort(new NameEqComparator());
                            Collections.sort(ciclistasCarrera, Collections.reverseOrder());
                            equipos.sort(new BicicletaTimeComparator());
                            System.out.println("Nombre del equipo: " + equipo.getNombre());
                            System.out.println("Tiempo total: " + equipo.tiempoTotal());
                            System.out.println("Numero de ciclistas: " + equipo.contCiclistas() + "Numero de ciclistas abandonados: " + equipo.contCiclistasAbandonados());
                        }
                        
                        //EQUIPOS CON TODOS LOS CICLISTAS ABANDONADOS
                        if(equipo.contCiclistasAbandonados() == equipo.contCiclistas() ){
                            equipos.sort(new NameEqComparator());
                            System.out.println("Nombre del equipo: " + equipo.getNombre());
                            System.out.println("Numero de ciclistas abandonados: " + equipo.contCiclistasAbandonados() + "Ciclistas abandonados: ");
                            equipo.getCiclistasAbandonados();
                        }
                    }
                    ordenarListas();
                }
            }
        
        return equipoGanador;
    }
    
    //Muestra los resultados del campeonato
    public void celebracionEtapa(boolean fin){
        Iterator<Equipo> itEq = equipos.iterator();
        Iterator<Etapa> itE = etapas.iterator();
        Iterator<ResultadosCarrera> itP = podio.iterator();
        ResultadosCarrera resultadosCarrera;
        
        while (itE.hasNext()) {
            while (itEq.hasNext()) {
                itEq.next().enviarCiclistas(itE.next());
            }
            
            if(itEq.next().contCiclistas() > 1 && itEq.next().contCiclistasAbandonados() != itEq.next().contCiclistas()){
                itEq.next().ordenarCiclistasA(1, 1);
                itEq.next().ordenarCiclistasA(4, 2);
                resultadosCarrera = itEq.next().CaracterísticasCiclistas(itE.next(), fin);
                setPodio(resultadosCarrera);
            }
            
            
            podio.sort(new ResultadoPodioComparator());
            System.out.println("Resultados carrera: ");
            while (itP.hasNext()) {
                if(!itP.next().getAbandonado()){
                    itP.next().mostrar();
                }  
            }
            System.out.println("Resultados carrera (abandonados): ");
            while (itP.hasNext()) {
                if(itP.next().getAbandonado()){
                    itP.next().mostrar();
                }  
            }
        }
    }
}
