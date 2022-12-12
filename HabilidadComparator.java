import java.util.Comparator;

/**
 * Compara la habilidad de dos ciclistas distintos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class HabilidadComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getHabilidad().getHabilidadCiclista() == c2.getHabilidad().getHabilidadCiclista()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.getHabilidad().getHabilidadCiclista() > c2.getHabilidad().getHabilidadCiclista()) {
            return 1;
        } else {
            return -1;
        }
    }
}
