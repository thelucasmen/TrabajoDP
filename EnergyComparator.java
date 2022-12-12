import java.util.Comparator;

/**
 * Compara la energia de dos ciclistas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class EnergyComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getEnergia() == c2.getEnergia()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.getEnergia() > c2.getEnergia()) {
            return 1;
        } else { 
            return -1;
        }
    }
}
