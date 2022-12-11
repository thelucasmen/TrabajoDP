import java.util.Comparator;

/**
 * Write a description of class ReverseEnergyComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseEnergyComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getEnergia() == c2.getEnergia()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.getEnergia() > c2.getEnergia()) {
            return -1;
        } else { 
            return 1;
        }
    }
}