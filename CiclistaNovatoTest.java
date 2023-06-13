import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CiclistaNovatoTest {
    //Etapa
        private Etapa etapaS1;        
        private Etapa etapaS2;
    //Equipos
        private Equipo equipo1;
        private Equipo equipo2;
        private Equipo equipo3;
    //Ciclistas
        //CiclistasNovatos
            private Ciclista ciclistaN1;
    //Bicicletas
        private Bicicleta bicicleta1;

    @BeforeEach
    public void setUp() {
        etapaS1 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.CORTA);
        etapaS2 = new Etapa("Stage", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        equipo1 = new Equipo("Extremadura", 1, 1);
        equipo2 = new Equipo("Argentina", 2, 2);
        equipo3 = new Equipo("Extremadura", 3, 3);
        ciclistaN1 = new CiclistaNovato("NovatoBueno", Habilidad.BUENA, 1400, equipo1);
        bicicleta1 = new Bicicleta("NormalPesada", Peso.PESADA);
    }

    @Test
    public void testSetNombre() {
        String nuevoNombre = "Nuevo Nombre";
        ciclistaN1.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, ciclistaN1.getNombre());
    }

    @Test
    public void testSetBicicleta() {
        ciclistaN1.setBicicleta(bicicleta1);
        assertEquals(bicicleta1, ciclistaN1.getBicicleta());
    }

    @Test
    public void testSetHabilidad() {
        ciclistaN1.setHabilidad(Habilidad.LENTA);
        assertEquals(Habilidad.LENTA, ciclistaN1.getHabilidad());
    }

    @Test
    public void testSetEnergia() {
        ciclistaN1.setEnergia(75.0);
        assertEquals(75.0, ciclistaN1.getEnergia(), 0.01);
    }

    @Test
    public void testSetResultado() {
        Resultado resultado = new Resultado(etapaS1, 12.5);
        ciclistaN1.setResultado(resultado);
        assertTrue(ciclistaN1.getResultado().contains(resultado.toString()));
    }

    @Test
    public void testGetResultado() {
        Resultado resultado1 = new Resultado(etapaS1, 12.5);
        Resultado resultado2 = new Resultado(etapaS2, 12.5);
        ciclistaN1.setResultado(resultado1);
        ciclistaN1.setResultado(resultado2);
        assertTrue(ciclistaN1.getResultado().contains(resultado1.toString()));
        assertTrue(ciclistaN1.getResultado().contains(resultado2.toString()));
    }

    @Test
    public void testSetEquipo() {
        ciclistaN1.setEquipo(equipo1);
        assertEquals(equipo1, ciclistaN1.getEquipo());
    }

    @Test
    public void testEquals() {
        Ciclista otroCiclista = new CiclistaNovato("NovatoBueno", Habilidad.BUENA, 1400, equipo1);
        assertTrue(ciclistaN1.equals(otroCiclista));
    }

    @Test
    public void testCambiarBici() {
        ciclistaN1.cambiarBici(bicicleta1);
        assertEquals(bicicleta1, ciclistaN1.getBicicleta());
    }

    @Test
    public void testAbandonado() {
        // Caso en que el ciclista no ha abandonado
        assertFalse(ciclistaN1.abandonado());

        // Caso en que el ciclista ha abandonado
        ciclistaN1.setEnergia(-1);
        assertTrue(ciclistaN1.abandonado());
    }

    @Test
    public void calculaDestreza() {    
        // Obtener la destreza del ciclista
        double destrezaCalculada = ciclistaN1.calculaDestreza();
    
        // Verificar que la destreza calculada es igual a la esperada
        assertEquals(0.8333333333333333, destrezaCalculada, 0.01);
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
        ciclistaN1 = null;
        bicicleta1 = null;
    }
}
