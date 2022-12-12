import java.util.Comparator;

/**
 * Compara los nombres de dos ciclistas de forma inversa.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class ReverseNameComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return -c1.getNombre().compareTo(c2.getNombre());
    }
}