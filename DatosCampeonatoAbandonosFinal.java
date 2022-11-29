import java.util.*;
public class DatosCampeonatoAbandonosFinal
{
    
    public DatosCampeonatoAbandonosFinal(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETANDOSE TODAS LAS CARRERAS PERO CON ABANDONOS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
    private void initData(Organizacion organizacion)
    {
        /**************ETAPA**************/
        //constructor de etapas pide ( String nombre, Dificultad dificultad, Distancia distancia)
        Etapa etapa1 = new Etapa("sencilla larga",Dificultad.SENCILLA,Distancia.LARGA);
        Etapa etapa2 = new Etapa("compleja intermedia", Dificultad.COMPLEJA, Distancia.INTERMEDIA);
        Etapa etapa3 = new Etapa("normal intermedia", Dificultad.NORMAL,Distancia.INTERMEDIA);
        Etapa etapa4 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        Etapa etapa5 = new Etapa("compleja larga", Dificultad.COMPLEJA, Distancia.LARGA);
        Etapa etapa6 = new Etapa("normal larga",Dificultad.NORMAL, Distancia.LARGA);
        
        /**************ORGANIZACION(EQUIPO)**************/ 
        organizacion.setEtapas(etapa1);
        organizacion.setEtapas(etapa2);
        organizacion.setEtapas(etapa3);
        organizacion.setEtapas(etapa4);
        organizacion.setEtapas(etapa5);
        organizacion.setEtapas(etapa6);
        
        /**************EQUIPO**************/        
        List<Ciclista> ciclistas = new ArrayList<Ciclista>();
        List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
        
        //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        Equipo movistarWomen = new Equipo("Movistar Women", ciclistas, bicicletas);
            //ciclistas comparados ascendentemente por habilidad (si iguales por nombre)
            movistarWomen.ordenarCiclistasA(1, 1);
            movistarWomen.ordenarCiclistasA(1, 6);
            //bicicletas comparadas ascendentemente por peso (si iguales por nombre)
            movistarWomen.ordenarBicicletas(1, 1);
            movistarWomen.ordenarBicicletas(1, 2);
            
        Equipo dSMWomen= new Equipo("DSM Women", ciclistas, bicicletas );
            //ciclistas comparados ascendentemente por energía (si iguales por nombre)
            dSMWomen.ordenarCiclistasA(1, 1);
            dSMWomen.ordenarCiclistasA(1, 3);
            //bicicletas comparadas ascendentemente por peso (si iguales por nombre)
            movistarWomen.ordenarBicicletas(1, 1);
            movistarWomen.ordenarBicicletas(1, 2);
            
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women", ciclistas, bicicletas);
            //ciclistas comparados descendentemente por habilidad (si iguales por nombre)
            trekSegafredoWomen.ordenarCiclistasA(1, 1);
            trekSegafredoWomen.ordenarCiclistasA(2, 6);
            //bicicletas comparadas descendentemente por peso (si iguales por nombre)
            movistarWomen.ordenarBicicletas(1, 1);
            movistarWomen.ordenarBicicletas(2, 2);
            
        /**************ORGANIZACION(EQUIPO)**************/ 
        organizacion.inscribirEquipos(movistarWomen);
        organizacion.inscribirEquipos(trekSegafredoWomen);
        organizacion.inscribirEquipos(dSMWomen);
                
        /**************BICICLETA**************/ 
        //constructor de bicicletas pide ( String nombre, Peso peso)
            //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
            dSMWomen.setBicicleta(new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15",Peso.LIGERA, 0.3)); 
            dSMWomen.setBicicleta(new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",Peso.NORMAL));
            dSMWomen.setBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",Peso.PESADA));
            
            //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
            dSMWomen.setCiclistaAbandonado(new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, dSMWomen));
            dSMWomen.setCiclistaAbandonado(new CiclistaEstrella("LIPPERT", Habilidad.LENTA, 1160, dSMWomen));
            dSMWomen.setCiclistaAbandonado(new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, dSMWomen));
     
        //constructor de bicicletas pide ( String nombre, Peso peso)
            //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
            trekSegafredoWomen.setBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",Peso.LIGERA));
            trekSegafredoWomen.setBicicleta(new BicicletaRapida("TREK Emonda SLR 9 eTap",Peso.NORMAL, 0.5));
            trekSegafredoWomen.setBicicleta(new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",Peso.PESADA));
            
            //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
            trekSegafredoWomen.setCiclistaAbandonado(new CiclistaEstrella("BALSAMO", Habilidad.LENTA,1180, trekSegafredoWomen));
            trekSegafredoWomen.setCiclistaAbandonado(new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL,1175, trekSegafredoWomen));
            trekSegafredoWomen.setCiclistaAbandonado(new CiclistaNovato("CORDON-RAGOT", Habilidad.BUENA, 1120, trekSegafredoWomen));
        
        //constructor de bicicletas pide ( String nombre, Peso peso)
            //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
            movistarWomen.setBicicleta(new BicicletaRapida("CANYON Ultimate CFR eTap",Peso.LIGERA, 0.4));
            movistarWomen.setBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",Peso.NORMAL));
            movistarWomen.setBicicleta(new BicicletaPrototipo("CANYON Endurace CF SLX 9 Di2",Peso.PESADA));
            
            //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
            movistarWomen.setCiclistaAbandonado(new CiclistaEstrella("VAN VLEUTEN", Habilidad.BUENA,1200, movistarWomen));
            movistarWomen.setCiclistaAbandonado(new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL,1145, movistarWomen));
            movistarWomen.setCiclistaAbandonado(new CiclistaNovato("SIERRA", Habilidad.LENTA, 1110, movistarWomen));  
    }
}
