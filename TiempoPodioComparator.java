import java.util.Comparator;

/**
 * Write a description of class TiempoPodioComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TiempoPodioComparator implements Comparator<ResultadosCarrera>{ 
    public int compare(ResultadosCarrera c1, ResultadosCarrera c2){
        if(c1.getResultado().getTiempo() == c2.getResultado().getTiempo()){
            return 0;
        } else if(c1.getResultado().getTiempo() > c2.getResultado().getTiempo()) {
            return 1;
        } else {
            return -1;
        }
    }
}