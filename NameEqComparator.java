import java.util.Comparator;

/**
 * Compara el nombre de dos equipos distintos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class NameEqComparator implements Comparator<Equipo>{ 
    public int compare(Equipo eq1, Equipo eq2){
        return eq1.getNombre().compareTo(eq1.getNombre());
    }
}
