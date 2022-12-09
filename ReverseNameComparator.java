import java.util.Comparator;

/**
 * Write a description of class ReverseNameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseNameComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getNombre() == c2.getNombre()){
            return 0;
        } else if(c1.getNombre() > c2.getNombre()) {
            return -1;
        } else {
            return 1;
        }
    }
}