import java.util.Comparator;

/**
 * Write a description of class DistanciaComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanciaComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        if(e1.getDistancia() == e2.getDistancia()){
            return new DistanciaComparator().compare(e1, e2);
        } else if(e1.getDistancia() > e2.getDistancia()) {
            return 1;
        } else {
            return -1;
        }
    }
}
