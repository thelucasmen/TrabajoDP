import java.util.Comparator;

/**
 * Compara la destreza de dos ciclistas distintos.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class DestrezaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.calculaDestreza() == c2.calculaDestreza()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.calculaDestreza() > c2.calculaDestreza()) {
            return 1;
        } else {
            return -1;
        }
    }
}
