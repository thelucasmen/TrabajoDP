import java.util.Comparator;

/**
 * Write a description of class NameEqComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameEqComparator implements Comparator<Equipo>{ 
    public int compare(Equipo eq1, Equipo eq2){
        return eq1.getNombre().compareTo(eq1.getNombre());
    }
}
