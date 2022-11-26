import java.util.Comparator;

/**
 * Write a description of class NameEComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameEComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        return e1.getNombre().compareTo(e1.getNombre());
    }
}
