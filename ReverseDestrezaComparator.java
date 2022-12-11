import java.util.Comparator;

/**
 * Write a description of class ReverseDestrezaComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseDestrezaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.calculaDestreza() == c2.calculaDestreza()){
            return c1.getNombre().compareTo(c2.getNombre());
        } else if(c1.calculaDestreza() > c2.calculaDestreza()) {
            return -1;
        } else {
            return 1;
        }
    }
}
