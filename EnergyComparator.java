import java.util.Comparator;

/**
 * Write a description of class EnergyComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.getEnergia() == c2.getEnergia()){
            return new NameComparator().compare(c1, c2);
        } else if(c1.getEnergia() > c2.getEnergia()) {
            return 1;
        } else {
            return -1;
        }
    }
}
