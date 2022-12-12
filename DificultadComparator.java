import java.util.Comparator;

/**
 * Compara la dificultad de dos etapas distintas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class DificultadComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        DistanciaComparator distanciaComparator = new DistanciaComparator();
        if(e1.getDificultad().getDificultadEtapa() == e2.getDificultad().getDificultadEtapa()){
            return distanciaComparator.compare(e1, e2);
        } else if(e1.getDificultad().getDificultadEtapa() > e2.getDificultad().getDificultadEtapa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
