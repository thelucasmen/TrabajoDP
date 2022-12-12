import java.util.Comparator;

/**
 * Compara el nombre de dos bicicletas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class BicicletaNameCiclistaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return c1.getBicicleta().getNombre().compareTo(c2.getBicicleta().getNombre());
    }
}

