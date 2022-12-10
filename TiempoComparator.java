import java.util.Comparator;

/**
 * Write a description of class TiempoComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiempoComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.tiempoAcumulado() == c2.tiempoAcumulado()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.tiempoAcumulado() > c2.tiempoAcumulado()) {
            return 1;
        } else {
            return -1;
        }
    }
}