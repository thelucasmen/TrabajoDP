import java.util.Comparator;

/**
 * Write a description of class BicicletaPesoComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaPesoCiclistaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return c1.getBicicleta().getPeso().compareTo(c2.getBicicleta().getPeso());
    }
}


