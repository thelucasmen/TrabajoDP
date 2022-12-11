# DP
NOMBRES: Marcos Acedo Mejías
    Daniel Barrantes Pulido
    Lucas Méndez Fernández
    
Clase main: CiclismoDemo

Github: https://github.com/thelucasmen/TrabajoDP.git

<---------Funcionalidad--------->
1. Clase Etapa
2. Clase Bicicleta
3. Clase Ciclista
4. Clase Equipo
5. Clase Organizacion
6. Clases Comparators
7. Clases Funcionalidad

1.
Clase: Etapa
    Variables:
        nombre
        dificultad (enum)
            SENCILLA(0.9) | NORMAL(1.0) | PESADA(1.1);
        distancia (enum)
            CORTA(150) | INTERMEDIA (200) | LARGA(225);
        Lista de ciclistas que participan en la etapa
    
    Metodos:
        Setter y Getters
        mostrar()
        mostrarCiclistas() --> Recorre el listado de ciclistas y sus bicicletas de la etapa
        mostrarResultadosCiclistas() -->
 
2.
Clase: Bicicleta
    Variables:
        nombre
        peso (enum)
            LIGERA (7.35) | NORMAL (7.50) | PESADA (7.85)
    
    Metodos:
        Setter y Getters
        mostrar()
        calcularVelocidad() --> habilidad*100/(peso*dificultad)
        calculartiempo() --> distancia/velocidad*60

    Herencia:
        Clase heredada: BicicletaRapida
            Variables:
                +velocidadExtra
            
            Metodos:
                Setter y Getters
                +calcularVelocidad() --> habilidad*100/(peso*dificultad)+velocidadExtra

        Clase heredada: BicicletaPrototipo
            Metodos:
                +calculartiempo() --> distancia/velocidad*60*destreza

3.
Clase: Ciclista
    Variables:
        nombre
        bicicleta
        energia
        equipo
        habilidad --> enum(catHabilidad[categoria], habilidadCiclista[numero habilidad]
            LENTA("LENTA", 4.0),
            NORMAL("NORMAL", 6.0),
            PESADA("BUENA", 8.0);
        resultados --> Clase
            Variables:
                Etapa
                Tiempo
    
    Metodos:
        Setter y Getters
        mostrar()
        cambiarBici() --> cambiar la bicicleta
        abandonado() --> comprueba si el ciclista ha abandonado
        mostrarResultados() --> muestra resultados de cualquier etapa
        numeroEtapas() --> devuelve el numro de etapas
        tiempoAcumulado() --> devuelve el tiempo total acumulado entre los resultados
        puntosAnulados() --> devuelve el total de puntos anulados de un ciclista que ha abandonado
        etapasTerminadas() --> numero de etapas terminadas
        abandonada() --> muestra por pantalla las etapas abandonadas
        mostrarEtapas() --> numero de etapas comenzadas, terminadas y tiempo acumulado, etapas abandonadas
        funcionalidadCiclista() --> guarda en resultados el tiempo
        esEstrella() --> Devuelve un booleano que indica si el ciclista es estrella o no
        calcularDestreza() --> herencia
            CiclistaNovato:
                Metodos:
                    destreza = ((habilidad del Ciclista + 2) / 120) * 10;
            CiclistaExperimentado:
                Metodos:
                    destreza = ((habilidad del Ciclista + 4) / 130) * 10;
            CiclistaEstrella:
                Variables:
                    +popularidad
                Metodos:
                    +SerPopular() --> suma o resta popularidad segun el tiempo
                    destreza = (((habilidad del Ciclista + 6) / 140) * 10;

4.
Clase: Equipo
    Variables:
        nombre
        ciclistas --> lista
        ciclistasAbandonado --> lista
        bicicletas --> lista
        
    Metodos:
        Setter y Getters
        metodos para borrar de las tres listas
        contCiclistas() --> cuenta los ciclistas del equipo sin abandonar
        contCiclistasAbandonados() --> cuenta los ciclistas del equipo que han abandonado
        mostrar()
        ordenarCiclistas() --> ordenar ciclistas segun criterio
        ordenarBicicletas() --> ordenar bicicletas segun criterio
        tiempoTotal() --> suma total de tiempo de los ciclistas
        mediatiempoSinA --> calcula la media del tiempo de los ciclistas sin abandonar
        mediatiempoTotal() --> calcula la media del tiempo total
        enviarCiclistas() --> envia a la etapa todos los ciclistas del equipo que no hayan abandonado
        recogerCiclistas() --> actualiza los ciclistas despues de la etapa
        CaracterísticasCiclistas() --> se encarga de mostrar los datos del equipo durante la etapa
  
5.
Clase: Organizacion
    Variables:
        nombreOrg
        List<ResultadosCarrera> podio --> Lista que almacena el podio de la etapa
        List<Etapa> etapas
        List<Equipo> equipos
        List<Ciclista> ciclistasCarrera
    
    Metodos:
        Setter y Getters
        metodos para borrar de las cuatro listas
        mostrar()
        inscribirEquipos() --> inscribe los equipos de la lista equipos en la etapa
        gestionarCarrera() --> detecta si el campeonato ha acabado y muestra un resumen del campeonato
  
6.
Clases: Comparator --> Ordenan listas segun un criterio
    Etapa
    - Dificultad
    - Distancia
    - Nombre etapa
    
    Equipo
    - Nombre equipo
    - Tiempo total
    - Media del tiempo total
    
    Ciclista
    - Nombre ciclista
    - Tiempo acumulado entre resultados
    - Energia
    - NombreBicicleta
    - Destreza
    - Peso bicicleta
    - Puntos anulados
    
    ResultadosCarrera
    - Tiempo etapa

7.
Clases: Funcionalidad
    Clase: CiclismoDemo (main)
    Clase: DatosCampeonatoAbandonosFinal --> Prueba una carrera con abandonos
    Clase: DatosCampeonatoCompleto --> Prueba una carrera sin abandonos