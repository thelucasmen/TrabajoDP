import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class Pruebas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Pruebas
{
    private Equipo e1;
    private Equipo e2;
    private List<Ciclista> cs1;
    private List<Bicicleta> bs1;
    private List<Ciclista> csA1;
    private List<Ciclista> cs2;
    private List<Bicicleta> bs2;
    private List<Ciclista> csA2;
    private Etapa et1;
    private Etapa et2;
    private CiclistaNovato c1;
    private CiclistaNovato c2;
    private CiclistaNovato c3;
    private CiclistaNovato c4;
    private Bicicleta b1;
    private Bicicleta b2;    
    private Bicicleta b3;
    private Bicicleta b4;
    
    /**
     * Default constructor for test class Pruebas
     */
    public void Prueba()
    {            
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        cs1 = new ArrayList<Ciclista>();
        bs1 = new ArrayList<Bicicleta>();
        cs2 = new ArrayList<Ciclista>();
        bs2 = new ArrayList<Bicicleta>();
        e1 = new Equipo("ESPAÑA", cs1, bs1);
        e2 = new Equipo("ARGENTINA", cs1, bs1);
        et1 = new Etapa("Barcelona", Dificultad.COMPLEJA, Distancia.LARGA);
        et2 = new Etapa("París", Dificultad.NORMAL, Distancia.CORTA);
        c1 = new CiclistaNovato("Alberto", Habilidad.BUENA, 1400, e1);
        c2 = new CiclistaNovato("Mauricio", Habilidad.BUENA, 2000, e2);
        c3 = new CiclistaNovato("Daniel", Habilidad.NORMAL, 1000, e1);
        c4 = new CiclistaNovato("Mauricio", Habilidad.LENTA, 1200, e2);
        b1 = new Bicicleta("BabolatX100", Peso.PESADA);
        b2 = new Bicicleta("OrbeaWild", Peso.LIGERA);
        b3 = new Bicicleta("BabolatX50", Peso.NORMAL);
        b4 = new Bicicleta("OrbeaWild", Peso.LIGERA);
        e1.setCiclista(c1);
        e1.setCiclista(c3);
        e2.setCiclista(c2);
        e2.setCiclista(c4);
        e1.setBicicleta(b2);
        e1.setBicicleta(b4);
        e2.setBicicleta(b1);
        e2.setBicicleta(b3);
        c1.funcionalidadCiclista(et1, b2.calculartiempo(c1, et1));
        c1.funcionalidadCiclista(et2, b2.calculartiempo(c1, et2));
        c2.funcionalidadCiclista(et1, b1.calculartiempo(c2, et1));
        c2.funcionalidadCiclista(et2, b1.calculartiempo(c2, et2));
        c3.funcionalidadCiclista(et1, b4.calculartiempo(c3, et1));
        c3.funcionalidadCiclista(et2, b4.calculartiempo(c3, et2));
        c4.funcionalidadCiclista(et1, b3.calculartiempo(c4, et1));
        c4.funcionalidadCiclista(et2, b3.calculartiempo(c4, et2));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void CorrerCiclista()
    {
        assertEquals(145.71, b1.calculartiempo(c2, et1), 0.01);
        assertEquals(136.43, b2.calculartiempo(c1, et1), 0.01);
    }

    @Test
    public void PruebaTotalMinutos()
    {
        assertEquals(219.12, c1.tiempoAcumulado(), 0.01);
        assertEquals(234.02, c2.tiempoAcumulado(), 0.01);
    }   

    @Test
    public void PruebaCalcularVelocidad()
    {
        assertEquals(92.64, b1.calcularVelocidad(c2, et1), 0.01);
        assertEquals(98.94, b2.calcularVelocidad(c1, et1), 0.01);
    }

    @Test
    public void PruebaCalcularMinutosEtapa()
    {
        assertEquals(88.31, b1.calculartiempo(c2, et2), 0.01);
        assertEquals(82.68, b2.calculartiempo(c1, et2), 0.01);
    }

    @Test
    public void PruebaMediaMinutosEtapa()
    {
        assertEquals(136.434375,b2.calculartiempo(c1, et1), 0.01);
        assertEquals(82.68749999999999,b2.calculartiempo(c1, et2), 0.01);
        assertEquals(181.91,b4.calculartiempo(c3, et1), 0.01);
        assertEquals(110.25,b4.calculartiempo(c3, et2), 0.01);
        assertEquals(255.64, e1.mediatiempoTotal(), 0.01);
    }

    @Test
    public void PruebaEnviarCiclista()
    {
        //e1.enviarCiclistas(et1);
        assertEquals(225.64, e1.mediatiempoTotal(), 0.01);
    }
}











