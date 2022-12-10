import java.util.Comparator;

/**
 * Write a description of class BicicletaPesoComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

