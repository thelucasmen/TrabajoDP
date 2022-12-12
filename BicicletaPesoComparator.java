import java.util.Comparator;

/**
 * Compara el peso de dos bicicletas distintas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez FernandezMarcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class BicicletaPesoComparator implements Comparator<Bicicleta>{ 
    public int compare(Bicicleta b1, Bicicleta b2){
        if(b1.getPeso().getPesoBici() == b2.getPeso().getPesoBici()) {
            return b1.getNombre().compareTo(b2.getNombre());    
        } else if(b1.getPeso().getPesoBici() > b2.getPeso().getPesoBici()) {
            return 1;
        } else {
            return -1;
        }
    }
}
