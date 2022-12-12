import java.util.Comparator;

/**
 * Compara los nombres de dos ciclistas en el podio.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class ResultadoPodioComparator implements Comparator<ResultadosCarrera>{ 
    public int compare(ResultadosCarrera r1, ResultadosCarrera r2){
        return r1.getResultado().getEtapa().getNombre().compareTo(r2.getResultado().getEtapa().getNombre());
    }
}