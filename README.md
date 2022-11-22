# DP
 
Etapa --> TERMINADA
    nombre
    dificultad
    distancia
    
    mostrar()
    
Bicicleta --> TERMINADA
    nombre
    peso (enum)
    LIGERA (7.35) | NORMAL (7.50) | PESADA (7.85)
    
    mostrar()
    calcularVelocidad()
        habilidad*100/(peso*dificultad)
    calculartiempo()
        distancia/velocidad*60

BicicletaRapida --> TERMINADA
    igual que bicicleta
    +velocidadExtra

    +calcularVelocidad()
        habilidad*100/(peso*dificultad)+velocidadExtra

BicicletaPrototipo --> TERMINADA
    igual que bicicleta

    +
    calculartiempo()
        distancia/velocidad*60*destreza
        
Ciclista --> TERMINADA
    nombre
    bicicleta
    habilidad (enum)
    energia
    resultados
    equipo
    
    mostrar()
    cambiarBici()
        para cambiar la bicicleta
    abandonado()
        comprueba si el ciclista ha abandonado
    mostrarResultados()
        muestra resultados de cualquier etapa
    mostrarEtapas()
        numero de etapas comenzadas, terminadas y tiempo acumulado, etapas abandonadas
    funcionalidadCiclista()
        guarda en resultados el tiempo
    calcularDestreza() --> herencia
        CiclistaNovato:
            destreza = ((habilidad del Ciclista + 2) / 120) * 10;
        CiclistaExperimentado:
            destreza = ((habilidad del Ciclista + 4) / 130) * 10;
        CiclistaEstrella:
            +popularidad
            
            +SerPopular()
            destreza = (((habilidad del Ciclista + 6) / 140) * 10;

Equipo
    nombre
    ciclistas
    ciclistasAbandonado
    bicicletas
    
    mostrar()
    ordenarCiclistas()
        ordenar ciclistas segun criterio(?)
    tiempoTotal()
        suma total de tiempo de los ciclistas 
    enviarCiclistas()
        que no hayan abandonado
        
Organizacion
    etapas
    equipos
    ciclistasCarrera
    
    inscribirEquipos()
    gestionarCarrera()
        mucho texto
    celebracionEtapa()
        extenso relato