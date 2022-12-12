import java.util.Comparator;

/**
 * Compara dos nombres de dos ciclistas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class NameComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return c1.getNombre().compareTo(c2.getNombre());
    }
}


