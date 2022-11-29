import java.util.Comparator;

/**
 * Write a description of class BicicletaNameComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaNameCiclistaComparator implements Comparator<Ciclista>{ 
    public int compare(Ciclista c1, Ciclista c2){
        return c1.getBicicleta().getNombre().compareTo(c2.getBicicleta().getNombre());
    }
}

