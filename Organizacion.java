
/**
 * Write a description of class Organizacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Organizacion
{
    // instance variables - replace the example below with your own
    
    private Ciclista ciclista;
    private Etapa etapa;
    private Equipo equipo;
    
    /**
     * Constructor for objects of class Organizacion
     */
    public Organizacion(Etapa etapa, Equipo equipo, Ciclista ciclista)
    {
        setEtapas(etapa);
        setEquipos(equipo);
        setCiclistas(ciclista);
    }

    public void setEtapas(Etapa etapa){
        this.etapa = etapa;
    }
    
    public Etapa getEtapas(){
        return etapa;
    }
    
    public void setEquipos(Equipo equipo){
        this.equipo = equipo;
    }
    
    public Equipo getEquipos(){
        return equipo;
    }
    
    public void setCiclistas(Ciclista ciclista){
        this.ciclista = ciclista;
    }

    public Ciclista getCiclistas(){
        return ciclista;
    }
    
     public void mostrar()
    {
        etapa.mostrar();
        equipo.mostrar();
        ciclista.mostrar();
    }
}
