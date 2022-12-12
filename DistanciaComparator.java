import java.util.Comparator;

/**
 * Compara la distancia de dos etapas distintas.
 * 
 * @author (Marcos Acedo Mejias, Daniel Barrantes Pulido, Lucas Mendez Fernandez) 
 * @version (9.12.22)
 */
public class DistanciaComparator implements Comparator<Etapa>{ 
    public int compare(Etapa e1, Etapa e2){
        if(e1.getDistancia().getDistanciaEtapa() == e2.getDistancia().getDistanciaEtapa()){
            return e1.getNombre().compareTo(e2.getNombre());
        } else if(e1.getDistancia().getDistanciaEtapa() > e2.getDistancia().getDistanciaEtapa()) {
            return 1;
        } else {
            return -1;
        }
    }
}
