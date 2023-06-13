import java.util.*;

/**
 * La clase ciclista experimentado es un complemento excluyente de la clase ciclista.
 * Si un ciclista es experimentado, entonces no puede ser novato ni estrella.
 * 
 * Contiene además las operaciones basicas para interactuar con las otras clases
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class CiclistaExperimentado extends Ciclista
{
    private List<Resultado> resultados;

    /**
     * Constructor for objects of class CiclistaExperimentado
     */
    public CiclistaExperimentado(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
       super(nombre, habilidad, energia, equipo);    
       resultados = new ArrayList();
    }
    
        /*Funcionalidad */
    //((habilidad del Ciclista + 4) / 130) * 10
    @Override
    public double calculaDestreza(){
        return (getHabilidad().getHabilidadCiclista() + 4) / 130 * 10;
    }
}