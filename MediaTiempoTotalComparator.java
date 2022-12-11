import java.util.Comparator;

/**
 * Write a description of class MediaTiempoTotalComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediaTiempoTotalComparator implements Comparator<Equipo>{ 
    public int compare(Equipo e1, Equipo e2){
        if(e1.mediatiempoTotal() == e2.mediatiempoTotal()){
            return e1.getNombre().compareTo(e2.getNombre());
        } else if(e1.mediatiempoTotal() > e2.mediatiempoTotal()) {
            return 1;
        } else {
            return -1;
        }
    }
}
