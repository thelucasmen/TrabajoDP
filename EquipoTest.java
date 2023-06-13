import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class EquipoTest {
    //Equipos
        private Equipo equipo1;
        private Equipo equipo2;
        private Equipo equipo3;
    //Ciclistas
        //CiclistasNovatos
            private Ciclista ciclistaN1;
            private Ciclista ciclistaN2;
            private Ciclista ciclistaN3;
        //CiclistaExperimentado
            private Ciclista ciclistaE1;
            private Ciclista ciclistaE2;
            private Ciclista ciclistaE3;
        //CiclistaEstrella
            private Ciclista ciclistaEs1;
            private Ciclista ciclistaEs2;
            private Ciclista ciclistaEs3;
    //Bicicletas
        private Bicicleta bicicleta1;
        private Bicicleta bicicleta2;
        private Bicicleta bicicleta3;
        //BicicletaPrototipo
            private Bicicleta bicicletaP1;
            private Bicicleta bicicletaP2;
            private Bicicleta bicicletaP3;
        //BicicletaRapida
            private Bicicleta bicicletaR1;
            private Bicicleta bicicletaR2;
            private Bicicleta bicicletaR3;

    @BeforeEach
    public void setUp() {
        equipo1 = new Equipo("Extremadura", 1, 1);
        equipo2 = new Equipo("Argentina", 2, 2);
        equipo3 = new Equipo("Extremadura", 3, 3);
        ciclistaN1 = new CiclistaNovato("NovatoBueno", Habilidad.BUENA, 1400, equipo1);
        ciclistaN2 = new CiclistaNovato("NovatoLento", Habilidad.LENTA, 2000, equipo1);
        ciclistaN3 = new CiclistaNovato("Novato", Habilidad.NORMAL, 3200, equipo1);
        ciclistaE1 = new CiclistaExperimentado("ExperimentadoBueno", Habilidad.BUENA, 1400, equipo2);
        ciclistaE2 = new CiclistaExperimentado("ExperimentadoLento", Habilidad.LENTA, 2000, equipo2);
        ciclistaE3 = new CiclistaExperimentado("Experimentado", Habilidad.NORMAL, 3200, equipo2);
        ciclistaEs1 = new CiclistaEstrella("EstrellaBueno", Habilidad.BUENA, 1400, equipo1);
        ciclistaEs2 = new CiclistaEstrella("EstrellaLento", Habilidad.LENTA, 2000, equipo2);
        ciclistaEs3 = new CiclistaEstrella("Estrella", Habilidad.NORMAL, 3200, equipo3);
        bicicleta1 = new Bicicleta("NormalPesada", Peso.PESADA);
        bicicleta2 = new Bicicleta("NormalNormal", Peso.NORMAL);
        bicicleta3 = new Bicicleta("NormalLigera", Peso.LIGERA);
        bicicletaP1 = new BicicletaPrototipo("PrototipoPesada", Peso.PESADA);
        bicicletaP2 = new BicicletaPrototipo("PrototipoNormal", Peso.NORMAL);
        bicicletaP3 = new BicicletaPrototipo("PrototipoLigera", Peso.LIGERA);
        bicicletaR1 = new BicicletaRapida("RapidaPesada", Peso.PESADA, 2.0);
        bicicletaR2 = new BicicletaRapida("RapidaNormal", Peso.NORMAL, 2.0);
        bicicletaR3 = new BicicletaRapida("RapidalLigera", Peso.LIGERA, 2.0);
    }

    @Test
    public void testSetNombre() {
        equipo1.setNombre("Nuevo Nombre");
        assertEquals("Nuevo Nombre", equipo1.getNombre());

        equipo2.setNombre("Otro Nombre");
        assertEquals("Otro Nombre", equipo2.getNombre());
    }

    @Test
    public void testSetCiclista() {
        equipo1.limpiarCiclista();
        equipo1.setCiclista(ciclistaN1);
        equipo1.setCiclista(ciclistaN2);
        equipo1.setCiclista(ciclistaN3);
    
        List<Ciclista> ciclistasEquipo1 = new ArrayList<>();
        ciclistasEquipo1.add(ciclistaN1);
        ciclistasEquipo1.add(ciclistaN2);
        ciclistasEquipo1.add(ciclistaN3);
    
        assertEquals(ciclistasEquipo1, equipo1.getListaCiclistas());
    
        equipo2.limpiarCiclista();
        equipo2.setCiclista(ciclistaE1);
        equipo2.setCiclista(ciclistaE2);
        equipo2.setCiclista(ciclistaE3);
    
        List<Ciclista> ciclistasEquipo2 = new ArrayList<>();
        ciclistasEquipo2.add(ciclistaE1);
        ciclistasEquipo2.add(ciclistaE2);
        ciclistasEquipo2.add(ciclistaE3);
    
        assertEquals(ciclistasEquipo2, equipo2.getListaCiclistas());
        
        equipo3.limpiarCiclista();
        equipo3.setCiclista(ciclistaEs1);
        equipo3.setCiclista(ciclistaEs2);
        equipo3.setCiclista(ciclistaEs3);
    
        List<Ciclista> ciclistasEquipo3 = new ArrayList<>();
        ciclistasEquipo3.add(ciclistaEs1);
        ciclistasEquipo3.add(ciclistaEs2);
        ciclistasEquipo3.add(ciclistaEs3);
    
        assertEquals(ciclistasEquipo3, equipo3.getListaCiclistas());
    }

    @Test
    public void testBorrarCiclista() {
        equipo1.setCiclista(ciclistaN1);
        equipo1.setCiclista(ciclistaN2);

        equipo1.borrarCiclista(ciclistaN1);
        assertTrue(equipo1.buscarCiclistas(ciclistaN1));

        equipo2.setCiclista(ciclistaE1);
        equipo2.setCiclista(ciclistaE2);

        equipo2.borrarCiclista(ciclistaE1);
        assertTrue(equipo2.buscarCiclistas(ciclistaE1));
        
        equipo3.setCiclista(ciclistaEs1);
        equipo3.setCiclista(ciclistaEs2);

        equipo3.borrarCiclista(ciclistaEs1);
        assertTrue(equipo3.buscarCiclistas(ciclistaEs1));
    }

    @Test
    public void testSetBicicleta() {
        equipo1.limpiarBicicleta();
        equipo1.setBicicleta(bicicleta1);
        equipo1.setBicicleta(bicicleta2);
        equipo1.setBicicleta(bicicleta3);

        List<Bicicleta> bicicletasEquipo1 = new ArrayList<>();
        bicicletasEquipo1.add(bicicleta1);
        bicicletasEquipo1.add(bicicleta2);
        bicicletasEquipo1.add(bicicleta3);

        assertEquals(bicicletasEquipo1, equipo1.getListaBicicleta());

        equipo2.limpiarBicicleta();
        equipo2.setBicicleta(bicicletaP1);
        equipo2.setBicicleta(bicicletaP2);
        equipo2.setBicicleta(bicicletaP3);

        List<Bicicleta> bicicletasEquipo2 = new ArrayList<>();
        bicicletasEquipo2.add(bicicletaP1);
        bicicletasEquipo2.add(bicicletaP2);
        bicicletasEquipo2.add(bicicletaP3);

        assertEquals(bicicletasEquipo2, equipo2.getListaBicicleta());
        
        equipo3.limpiarBicicleta();
        equipo3.setBicicleta(bicicletaR1);
        equipo3.setBicicleta(bicicletaR2);
        equipo3.setBicicleta(bicicletaR3);

        List<Bicicleta> bicicletasEquipo3 = new ArrayList<>();
        bicicletasEquipo3.add(bicicletaR1);
        bicicletasEquipo3.add(bicicletaR2);
        bicicletasEquipo3.add(bicicletaR3);

        assertEquals(bicicletasEquipo3, equipo3.getListaBicicleta());
    }

    @Test
    public void testBorrarBicicletas() {
        equipo1.setBicicleta(bicicleta1);
        equipo1.setBicicleta(bicicleta2);
    
        equipo1.borrarBicicletas(bicicleta1);
    
        assertTrue(equipo1.buscarBicicletas(bicicleta1));
    
        equipo2.setBicicleta(bicicletaP1);
        equipo2.setBicicleta(bicicletaP2);
    
        equipo2.borrarBicicletas(bicicletaP1);
    
        assertTrue(equipo2.buscarBicicletas(bicicletaP1));
    
        equipo3.setBicicleta(bicicletaR1);
        equipo3.setBicicleta(bicicletaR1);
    
        equipo3.borrarBicicletas(bicicletaR1);
    
        assertTrue(equipo3.buscarBicicletas(bicicletaR1));
    }
    
    @Test
    public void testGetCiclistas() {
        equipo1.setCiclista(ciclistaN1);
        equipo1.setCiclista(ciclistaN2);
        equipo1.setCiclista(ciclistaN3);

        List<Ciclista> ciclistas=equipo1.getListaCiclistas();
        
        assertEquals(3, ciclistas.size());
        assertTrue(ciclistas.contains(ciclistaN1));
        assertTrue(ciclistas.contains(ciclistaN2));
        assertTrue(ciclistas.contains(ciclistaN3));
    }

    @Test
    public void testContCiclistas() {
        equipo2.setCiclista(ciclistaE1);
        equipo2.setCiclista(ciclistaE2);

        assertEquals(2, equipo2.contCiclistas());
    }

    @AfterEach
    public void tearDown() {
        equipo1 = null;
        equipo2 = null;
        equipo3 = null;
        ciclistaN1 = null;
        ciclistaN2 = null;
        ciclistaN3 = null;
        ciclistaE1 = null;
        ciclistaE2 = null;
        ciclistaE3 = null;
        ciclistaEs1 = null;
        ciclistaEs2 = null;
        ciclistaEs3 = null;
        bicicleta1 = null;
        bicicleta2 = null;
        bicicleta3 = null;
        bicicletaP1 = null;
        bicicletaP2 = null;
        bicicletaP3 = null;
        bicicletaR1 = null;
        bicicletaR2 = null;
        bicicletaR3 = null;
    }
}

