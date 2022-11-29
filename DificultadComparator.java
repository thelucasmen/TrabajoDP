import java.util.Comparator;

/**
 * Write a description of class NameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DificultadComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        if(e1.getDificultad().getDificultadEtapa() == e2.getDificultad().getDificultadEtapa()){
            return 0;
        } else if(e1.getDificultad().getDificultadEtapa() > e2.getDificultad().getDificultadEtapa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
