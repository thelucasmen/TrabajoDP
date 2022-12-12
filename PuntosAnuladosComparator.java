import java.util.Comparator;

/**
 * Compara dos ciclistas para comprobar los puntos anulados.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
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