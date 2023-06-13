import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class BicicletaTest {
    //Etapa
        private Etapa etapaS1;
        private Etapa etapaS2;
        private Etapa etapaS3;
        private Etapa etapaN1;
        private Etapa etapaN2;
        private Etapa etapaN3;
        private Etapa etapaC1;
        private Etapa etapaC2;
        private Etapa etapaC3;
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
        etapaS1 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.CORTA);
        etapaS2 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        etapaS3 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.LARGA);
        etapaN1 = new Etapa("Stage", Dificultad.NORMAL, Distancia.CORTA);
        etapaN2 = new Etapa("Stage", Dificultad.NORMAL, Distancia.INTERMEDIA);
        etapaN3 = new Etapa("Stage", Dificultad.NORMAL, Distancia.LARGA);
        etapaC1 = new Etapa("Stage", Dificultad.COMPLEJA, Distancia.CORTA);
        etapaC2 = new Etapa("Stage", Dificultad.COMPLEJA, Distancia.INTERMEDIA);
        etapaC3 = new Etapa("Stage", Dificultad.COMPLEJA, Distancia.LARGA);
        equipo1 = new Equipo("España", 1, 1);
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
        bicicleta1.setNombre("New Name");
        assertEquals("New Name", bicicleta1.getNombre());
        
        bicicletaP1.setNombre("New Name");
        assertEquals("New Name", bicicletaP1.getNombre());
        
        bicicletaR1.setNombre("New Name");
        assertEquals("New Name", bicicletaR1.getNombre());
    }

    @Test
    public void testSetPeso() {
        bicicleta1.setPeso(Peso.NORMAL);
        assertEquals(Peso.NORMAL, bicicleta1.getPeso());
        
        bicicletaP1.setPeso(Peso.LIGERA);
        assertEquals(Peso.LIGERA, bicicletaP1.getPeso());
        
        bicicletaR2.setPeso(Peso.PESADA);
        assertEquals(Peso.PESADA, bicicletaR1.getPeso());
    }

    @Test
    public void testGetNombre() {
        assertEquals("NormalPesada", bicicleta1.getNombre());
        assertEquals("PrototipoPesada", bicicletaP1.getNombre());
        assertEquals("RapidaPesada", bicicletaR1.getNombre());
    }

    @Test
    public void testGetPeso() {
        assertEquals(Peso.PESADA, bicicleta1.getPeso());
        assertEquals(Peso.PESADA, bicicletaP1.getPeso());
        assertEquals(Peso.PESADA, bicicletaR1.getPeso());
    }

    @Test
    public void testEquals() {
        Bicicleta bicicleta1Rep = new Bicicleta("NormalPesada", Peso.PESADA);
        assertTrue(bicicleta1.equals(bicicleta1Rep));
        assertFalse(bicicleta1.equals(bicicletaR2));
    }

    @Test
    public void testCalcularVelocidad() {
        assertEquals(113.234253362, bicicleta1.calcularVelocidad(ciclistaN1, etapaS1), 0.0001);
        assertEquals(101.910828025, bicicleta1.calcularVelocidad(ciclistaN1, etapaN1), 0.0001);
        assertEquals(92.6462072959, bicicleta1.calcularVelocidad(ciclistaN1, etapaC1), 0.0001);
        assertEquals(56.61712668082095, bicicleta1.calcularVelocidad(ciclistaN2, etapaS1), 0.0001);
        assertEquals(50.955414012738856, bicicleta1.calcularVelocidad(ciclistaN2, etapaN1), 0.0001);
        assertEquals(46.323103647944414, bicicleta1.calcularVelocidad(ciclistaN2, etapaC1), 0.0001);
        assertEquals(84.92569002123143, bicicleta1.calcularVelocidad(ciclistaN3, etapaS1), 0.0001);
        assertEquals(76.43312101910828, bicicleta1.calcularVelocidad(ciclistaN3, etapaN1), 0.0001);
        assertEquals(69.4846554719166, bicicleta1.calcularVelocidad(ciclistaN3, etapaC1), 0.0001);
        
        assertEquals(118.51851851851852, bicicleta2.calcularVelocidad(ciclistaN1, etapaS1), 0.0001);
        assertEquals(106.66666666666667, bicicleta2.calcularVelocidad(ciclistaN1, etapaN1), 0.0001);
        assertEquals(96.96969696969697, bicicleta2.calcularVelocidad(ciclistaN1, etapaC1), 0.0001);
        assertEquals(59.25925925925926, bicicleta2.calcularVelocidad(ciclistaN2, etapaS1), 0.0001);
        assertEquals(53.333333333333336, bicicleta2.calcularVelocidad(ciclistaN2, etapaN1), 0.0001);
        assertEquals(48.484848484848484, bicicleta2.calcularVelocidad(ciclistaN2, etapaC1), 0.0001);
        assertEquals(88.88888888888889, bicicleta2.calcularVelocidad(ciclistaN3, etapaS1), 0.0001);
        assertEquals(80.00000000000000, bicicleta2.calcularVelocidad(ciclistaN3, etapaN1), 0.0001);
        assertEquals(72.72727272727273, bicicleta2.calcularVelocidad(ciclistaN3, etapaC1), 0.0001);
        
        assertEquals(120.93726379440665, bicicleta3.calcularVelocidad(ciclistaN1, etapaS1), 0.0001);
        assertEquals(108.843537414966, bicicleta3.calcularVelocidad(ciclistaN1, etapaN1), 0.0001);
        assertEquals(98.9486703772418, bicicleta3.calcularVelocidad(ciclistaN1, etapaC1), 0.0001);
        assertEquals(60.46863189720332, bicicleta3.calcularVelocidad(ciclistaN2, etapaS1), 0.0001);
        assertEquals(54.421768707483, bicicleta3.calcularVelocidad(ciclistaN2, etapaN1), 0.0001);
        assertEquals(49.4743351886209, bicicleta3.calcularVelocidad(ciclistaN2, etapaC1), 0.0001);
        assertEquals(90.70294784580499, bicicleta3.calcularVelocidad(ciclistaN3, etapaS1), 0.0001);
        assertEquals(81.63265306122449, bicicleta3.calcularVelocidad(ciclistaN3, etapaN1), 0.0001);
        assertEquals(74.21150278293135, bicicleta3.calcularVelocidad(ciclistaN3, etapaC1), 0.0001);
    }

    @Test
    public void testCalculartiempo() {
        //BICICLETA NORMAL
        assertEquals(79.48124999999999, bicicleta1.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(105.975, bicicleta1.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(119.22187499999998, bicicleta1.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(75.9375, bicicleta2.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(101.25, bicicleta2.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(113.90625, bicicleta2.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(74.41875, bicicleta3.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(99.22500000000001, bicicleta3.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(111.62812500000001, bicicleta3.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        //BICICLETA PROTOTIPO
        assertEquals(1.5896249999999998, bicicletaP1.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(2.1195, bicicletaP1.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(2.3844374999999998, bicicletaP1.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(1.51875, bicicletaP2.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(2.025, bicicletaP2.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(2.278125, bicicletaP2.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(1.4883750000000002, bicicletaP3.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(1.9845000000000002, bicicletaP3.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(2.2325625000000002, bicicletaP3.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        //BICICLETA RAPIDA
        assertEquals(78.10177735742448, bicicletaR1.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(104.13570314323265, bicicletaR1.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(117.15266603613674, bicicletaR1.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(74.67732022126613, bicicletaR2.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(99.56976029502151, bicicletaR2.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(112.0159803318992, bicicletaR2.calculartiempo(ciclistaN1, etapaS3), 0.0001);
        
        assertEquals(73.20807151728293, bicicletaR3.calculartiempo(ciclistaN1, etapaS1), 0.0001);
        assertEquals(97.61076202304392, bicicletaR3.calculartiempo(ciclistaN1, etapaS2), 0.0001);
        assertEquals(109.8121072759244, bicicletaR3.calculartiempo(ciclistaN1, etapaS3), 0.0001);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        etapaS1 = null;
        etapaS2 = null;
        etapaS3 = null;
        etapaN1 = null;
        etapaN2 = null;
        etapaN3 = null;
        etapaC1 = null;
        etapaC2 = null;
        etapaC3 = null;
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
