import java.util.Comparator;

/**
 * Write a description of class DestrezaComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DestrezaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        if(c1.calculaDestreza() == c2.calculaDestreza()){
            return 0;
        } else if(c1.calculaDestreza() > c2.calculaDestreza()) {
            return 1;
        } else {
            return -1;
        }
    }
}
