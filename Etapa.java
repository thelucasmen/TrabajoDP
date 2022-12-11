import java.util.*;

/**
 * 
 * Cada etapa está compuesta por un nombre, una distancia y una dificultad.
 * Las operaciones en esta clase son las básicas para poder interactuar con
 * otras clases. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
    private Dificultad dificultad;
    private Distancia distancia;
    private String nombre;
    private List<Ciclista> ciclistas;
    

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(String nombre, Dificultad dificultad, Distancia distancia)
    {
        // initialise instance variables
        this.dificultad = dificultad;
        this.distancia = distancia;
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public Dificultad getDificultad(){        
        return dificultad;    
    }  
    
    public Distancia getDistancia(){      
        return distancia;        
    }
    
    public String getNombre(){       
        return nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public void setDistancia(Distancia d){
        this.distancia = d;
    }
    
    public void setDificultad(Dificultad diff){
        this.dificultad = diff;
    }
    
    public void setCiclista(Ciclista ciclista){
        ciclistas.add(ciclista);
    }
    
    public int getCiclista(){
        int contador = 0;
        try{
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                itC.next().mostrar();
                contador++;
            }
        }catch(NullPointerException e){ }
        return contador;
    }
    
    public void mostrar()
    {
        //<etapa:sencilla intermedia> <dificultad:Sencilla (valor:0.9)> <distancia:Intermedia (valor:200.0)>
        System.out.print("<etapa:" + nombre + "> <dificultad:");
        dificultad.mostrar(); 
        System.out.print("> <distancia:");
        distancia.mostrar();
        System.out.println(">"); 
    }
    
    //Recorre el listado de ciclistas y sus bicicletas
    public List<ResultadosCarrera> mostrarCiclistas(int contC, Etapa etapa, List<ResultadosCarrera> podio){
        int contCE = 0;
        Ciclista ciclista = null;
        ResultadosCarrera resultadosCarrera = null;
        Resultado resultado = null;
        double tiempo = 0;
        double energiaPrevia = 0;
        try{
            ciclistas.sort(new ReverseNameComparator());
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                contCE++;
                System.out.print("@@@ ciclista " + contCE + " de " + contC + "\n");
                ciclista = itC.next();
                ciclista.mostrar();
                System.out.print("Con bicicleta\n");
                ciclista.getBicicleta().mostrar();
                tiempo = ciclista.getBicicleta().calculartiempo(ciclista, etapa);
                energiaPrevia = ciclista.getEnergia();
                ciclista.funcionalidadCiclista(etapa, tiempo);
                System.out.printf("en etapa " + etapa.getNombre() + "\n" +
                    "+++ Con estas condiciones el ciclista " + ciclista.getNombre() + " con la bicicleta " + 
                    ciclista.getBicicleta().getNombre() + " alcanza una velocidad de " + 
                    String.format("%.2f",ciclista.getBicicleta().calcularVelocidad(ciclista, etapa)) + " km/hora \n+++\n+++\n" +
                    "+++ " + ciclista.getNombre() + " termina la etapa en " + String.format("%.2f",tiempo) + " minutos +++\n");
                if(!ciclista.abandonado()){
                    System.out.printf("+++ La energía del ciclista " + ciclista.getNombre() + " tras la carrera es " + 
                        String.format("%.2f",ciclista.getEnergia()) + " +++\n" + "@@@\n");
                } else {
                    System.out.printf("¡¡¡ El ciclista " + ciclista.getNombre() + " se quedó sin energia a falta de " + 
                        String.format("%.2f",tiempo) + " minutos para terminar !!!\n" +
                	"¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + 
                	String.format("%.2f",energiaPrevia) + " minutos !!!\n" +
                	"+++ La ener   gía del ciclista " + ciclista.getNombre() + " tras la carrera es " + 
                	String.format("%.2f",ciclista.getEnergia()) + " +++");
                }
                if(ciclista.esEstrella()){
                    ciclista.SerPopular(tiempo);
                }
                resultado = new Resultado(etapa, tiempo);
                ciclista.setResultado(new Resultado(etapa, tiempo));
                resultadosCarrera = new ResultadosCarrera(ciclista.getNombre(), ciclista.getEnergia(), resultado, ciclista.abandonado());
                podio.add(resultadosCarrera);
            }
        }catch(NullPointerException e){ }
        return podio;
    }

    //Recorre el listado de ciclistas muestras sus resultados en las diferentes etapas
    public void mostrarResultadosCiclistas(){
        Ciclista ciclista;
        int cont = 0;
        try{
            ciclistas.sort(new TiempoComparator());
            Iterator<Ciclista> itC = ciclistas.iterator();
            while (itC.hasNext()) {
                ciclista = itC.next();
                cont++;
                System.out.println("@@@ Posición(" + cont + "): " + ciclista.getNombre() + 
                " - Tiempo Total: " + String.format("%.2f",ciclista.tiempoAcumulado()) + " @@@");
                ciclista.getResultado();
                System.out.print("\n");
            }
        }catch(NullPointerException e){ }
    }
}