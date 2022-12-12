import java.util.Comparator;

/**
 * Compara el peso de las bicicletas de dos ciclitas distintos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class BicicletaPesoCiclistaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getBicicleta().getPeso().getPesoBici() == c2.getBicicleta().getPeso().getPesoBici()) {
            return c1.getBicicleta().getNombre().compareTo(c2.getBicicleta().getNombre());
        } else if(c1.getBicicleta().getPeso().getPesoBici() > c2.getBicicleta().getPeso().getPesoBici()) {
            return 1;
        } else {
            return -1;
        }
    }
}

