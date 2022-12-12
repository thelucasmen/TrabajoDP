import java.util.Comparator;

/**
 * Compara dos bicicletas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class ReversedBicicletaNameComparator implements Comparator<Bicicleta>{ 
    public int compare(Bicicleta b1, Bicicleta b2){
        return -b1.getNombre().compareTo(b2.getNombre());
    }
}