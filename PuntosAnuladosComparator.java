import java.util.Comparator;

/**
 * Write a description of class PuntosAnuladosComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntosAnuladosComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.puntosAnulados() == c2.puntosAnulados()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.puntosAnulados() > c2.puntosAnulados()) {
            return 1;
        } else {
            return -1;
        }
    }
}