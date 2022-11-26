import java.util.Comparator;

/**
 * Write a description of class ResultadoPodioComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultadoPodioComparator implements Comparator<ResultadosCarrera>{ 
    public int compare(ResultadosCarrera r1, ResultadosCarrera r2){
        if(r1.getResultado().getTiempo() == r2.getResultado().getTiempo()){
            return new ResultadoPodioComparator().compare(r1, r2);
        } else if(r1.getResultado().getTiempo() > r2.getResultado().getTiempo()) {
            return 1;
        } else {
            return -1;
        }
    }
}