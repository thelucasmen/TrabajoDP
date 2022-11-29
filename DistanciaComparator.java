import java.util.Comparator;

/**
 * Write a description of class DistanciaComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanciaComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        if(e1.getDistancia().getDistanciaEtapa() == e2.getDistancia().getDistanciaEtapa()){
            return 0;
        } else if(e1.getDistancia().getDistanciaEtapa() > e2.getDistancia().getDistanciaEtapa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
