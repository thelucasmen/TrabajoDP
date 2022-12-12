import java.util.Comparator;

/**
 * Compara los nombres de dos etapas distintas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class NameEComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        return e1.getNombre().compareTo(e1.getNombre());
    }
}
