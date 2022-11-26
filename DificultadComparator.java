import java.util.Comparator;

/**
 * Write a description of class NameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DificultadComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        if(e1.getDificultad() == e2.getDificultad()){
            return new DificultadComparator().compare(e1, e2);
        } else if(e1.getDificultad() > e2.getDificultad()) {
            return 1;
        } else {
            return -1;
        }
    }
}
