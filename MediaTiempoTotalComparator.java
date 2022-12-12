import java.util.Comparator;

/**
 * Compara la media de tiempo entre dos equipos para comprobar el ganador.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
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
