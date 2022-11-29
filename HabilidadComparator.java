import java.util.Comparator;

/**
 * Write a description of class HabilidadComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HabilidadComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getHabilidad().getHabilidadCiclista() == c2.getHabilidad().getHabilidadCiclista()){
            return 0;
        } else if(c1.getHabilidad().getHabilidadCiclista() > c2.getHabilidad().getHabilidadCiclista()) {
            return 1;
        } else {
            return -1;
        }
    }
}
