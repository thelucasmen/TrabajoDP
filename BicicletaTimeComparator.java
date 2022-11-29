import java.util.Comparator;

/**
 * Write a description of class BicicletaTimeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaTimeComparator implements Comparator<Equipo>{ 
    public int compare(Equipo eq1, Equipo eq2){
        if(eq1.tiempoTotal() == eq2.tiempoTotal()){
            return 0;
        } else if(eq1.tiempoTotal() > eq2.tiempoTotal()) {
            return 1;
        } else {
            return -1;
        }
    }
}
