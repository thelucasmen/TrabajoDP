import java.util.Comparator;

/**
 * Compara los tiempos de dos ciclistas en el podio.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class TiempoPodioComparator implements Comparator<ResultadosCarrera>{ 
    public int compare(ResultadosCarrera c1, ResultadosCarrera c2){
        if(c1.getResultado().getTiempo() == c2.getResultado().getTiempo()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.getResultado().getTiempo() > c2.getResultado().getTiempo()) {
            return 1;
        } else {
            return -1;
        }
    }
}