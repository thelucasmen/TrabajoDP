import java.util.Comparator;

/**
 * Write a description of class NameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseNameComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return -c1.getNombre().compareTo(c2.getNombre());
    }
}