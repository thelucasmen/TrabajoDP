import java.util.Comparator;

/**
 * Compara el tiempo de dos equipos distintos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class BicicletaTimeComparator implements Comparator<Equipo>{ 
    public int compare(Equipo eq1, Equipo eq2){
        if(eq1.tiempoTotal() == eq2.tiempoTotal()){
            return 0;
        } else if(eq1.tiempoTotal() > eq2.tiempoTotal()) {
            return 1;
        } else {
            return -1;
        }
    }
}
