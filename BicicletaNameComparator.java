import java.util.Comparator;

/**
 * Write a description of class BicicletaNameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaNameComparator implements Comparator<Bicicleta>{ 
    public int compare(Bicicleta b1, Bicicleta b2){
        return b1.getNombre().compareTo(b2.getNombre());
    }
}
