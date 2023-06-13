import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CiclistaEstrellaTest {
    //Etapa
        private Etapa etapaS1;        
        private Etapa etapaS2;
    //Equipos
        private Equipo equipo1;
        private Equipo equipo2;
        private Equipo equipo3;
    //Ciclistas
        //CiclistaExperimentado
            private CiclistaEstrella ciclistaEs1;
    //Bicicletas
        private Bicicleta bicicleta1;

    @BeforeEach
    public void setUp() {
        etapaS1 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.CORTA);
        etapaS2 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        equipo1 = new Equipo("Extremadura", 1, 1);
        equipo2 = new Equipo("Argentina", 2, 2);
        equipo3 = new Equipo("Extremadura", 3, 3);
        ciclistaEs1 = new CiclistaEstrella("EstrellaBueno", Habilidad.BUENA, 1400, equipo1);
        bicicleta1 = new Bicicleta("NormalPesada", Peso.PESADA);
    }

    @Test
    public void testSetNombre() {
        String nuevoNombre = "Nuevo Nombre";
        ciclistaEs1.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, ciclistaEs1.getNombre());
    }

    @Test
    public void testSetBicicleta() {
        ciclistaEs1.setBicicleta(bicicleta1);
        assertEquals(bicicleta1, ciclistaEs1.getBicicleta());
    }

    @Test
    public void testSetHabilidad() {
        ciclistaEs1.setHabilidad(Habilidad.LENTA);
        assertEquals(Habilidad.LENTA, ciclistaEs1.getHabilidad());
    }

    @Test
    public void testSetEnergia() {
        ciclistaEs1.setEnergia(75.0);
        assertEquals(75.0, ciclistaEs1.getEnergia(), 0.01);
    }

    @Test
    public void testSetResultado() {
        Resultado resultado = new Resultado(etapaS1, 12.5);
        ciclistaEs1.setResultado(resultado);
        assertTrue(ciclistaEs1.getResultado().contains(resultado.toString()));
    }

    @Test
    public void testGetResultado() {
        Resultado resultado1 = new Resultado(etapaS1, 12.5);
        Resultado resultado2 = new Resultado(etapaS2, 12.5);
        ciclistaEs1.setResultado(resultado1);
        ciclistaEs1.setResultado(resultado2);
        assertTrue(ciclistaEs1.getResultado().contains(resultado1.toString()));
        assertTrue(ciclistaEs1.getResultado().contains(resultado2.toString()));
    }

    @Test
    public void testSetEquipo() {
        ciclistaEs1.setEquipo(equipo1);
        assertEquals(equipo1, ciclistaEs1.getEquipo());
    }

    @Test
    public void testEquals() {
        Ciclista otroCiclista = new CiclistaEstrella("EstrellaBueno", Habilidad.BUENA, 1400, equipo1);
        assertTrue(ciclistaEs1.equals(otroCiclista));
    }

    @Test
    public void testCambiarBici() {
        ciclistaEs1.cambiarBici(bicicleta1);
        assertEquals(bicicleta1, ciclistaEs1.getBicicleta());
    }

    @Test
    public void testAbandonado() {
        // Caso en que el ciclista no ha abandonado
        assertFalse(ciclistaEs1.abandonado());

        // Caso en que el ciclista ha abandonado
        ciclistaEs1.setEnergia(-1);
        assertTrue(ciclistaEs1.abandonado());
    }

    @Test
    public void calculaDestreza() {    
        // Obtener la destreza del ciclista
        double destrezaCalculada = ciclistaEs1.calculaDestreza();
    
        // Verificar que la destreza calculada es igual a la esperada
        assertEquals(1.0, destrezaCalculada, 0.01);
    }
    
    @Test
    public void testFuncionalidadCiclista() {
        // Calcular la popularidad esperada antes de llamar al método
        int popularidadPrevia = ciclistaEs1.getPopularidad();
    
        // Llamar al método funcionalidadCiclista con un tiempo menor a 160
        double tiempoMenor160 = 150.0;
        ciclistaEs1.funcionalidadCiclista(etapaS1, tiempoMenor160);
    
        // Verificar que la popularidad aumente en 4 unidades
        int popularidadEsperadaMenor160 = popularidadPrevia + 4;
        assertEquals(popularidadEsperadaMenor160, ciclistaEs1.getPopularidad());
    
        // Llamar al método funcionalidadCiclista con un tiempo mayor o igual a 160
        double tiempoMayorIgual160 = 170.0;
        ciclistaEs1.funcionalidadCiclista(etapaS1, tiempoMayorIgual160);
    
        // Verificar que la popularidad disminuya en 1 unidad
        int popularidadEsperadaMayorIgual160 = popularidadEsperadaMenor160 - 1;
        assertEquals(popularidadEsperadaMayorIgual160, ciclistaEs1.getPopularidad());
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
        equipo1 = null;
        equipo2 = null;
        equipo3 = null;
        ciclistaEs1 = null;
        bicicleta1 = null;
    }
}