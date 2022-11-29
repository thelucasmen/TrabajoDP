import java.util.Comparator;

/**
 * Write a description of class BicicletaPesoComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaPesoComparator implements Comparator<Bicicleta>{ 
    public int compare(Bicicleta b1, Bicicleta b2){
        return b1.getPeso().compareTo(b2.getPeso());
    }
}
