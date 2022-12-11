import java.util.Comparator;

/**
 * Write a description of class NameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DificultadComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        DistanciaComparator distanciaComparator = new DistanciaComparator();
        if(e1.getDificultad().getDificultadEtapa() == e2.getDificultad().getDificultadEtapa()){
            return distanciaComparator.compare(e1, e2);
        } else if(e1.getDificultad().getDificultadEtapa() > e2.getDificultad().getDificultadEtapa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
