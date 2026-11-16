package proyecto1;

public class Historia {

    public static final int FIN = -1;
    private static final int FINAL_MALO = 900;
    private static final int FINAL_NEUTRAL = 901;
    private static final int FINAL_BUENO = 902;

    private final Entrada entrada;
    private final Inventario inventario;
    private final Minijuegos minijuegos;
    private final Combates combates;
    private final Texto texto;

    public Historia(Entrada entrada, Inventario inventario, Minijuegos minijuegos, Combates combates, Texto texto) {
        this.texto = texto;
        this.entrada = entrada;
        this.inventario = inventario;
        this.minijuegos = minijuegos;
        this.combates = combates;
    }

    public int ejecutarEscena(int escena) {
        texto.reiniciarSalto(); // cada escena empieza con el texto lento otra vez
        switch (escena) {
            case 1: return escena1();
            case 2: return escena2();
            case 3: return escena3();
            case 4: return escena4();
            case 5: return escena5();
            case 6: return escena6();
            case 7: return escena7();
            case 8: return escena8();
            case 9: return escena9();
            case 10: return escena10();
            case 40: return escena40();
            case 50: return escena50();
            case 51: return escena51();
            case 52: return escena52();
            case 53: return escena53();
            case 54: return escena54();
            case 55: return escena55();
            case 56: return escena56();
            case FINAL_MALO: return finalMalo();
            case FINAL_NEUTRAL: return finalNeutral();
            case FINAL_BUENO: return finalBueno();
            default:
                texto.escribir("Escena desconocida. Fin del juego.");
                return FIN;
        }
    }

    private int escena1() {
        System.out.println("\n--- Escena 1: Despertar en el templo ---");
        texto.escribir("Te despiertas sobre una losa fría. La sala es enorme, iluminada por una luz azul.");
        texto.escribir("Frente a ti, un muro lleno de jeroglíficos.\n");

        int opcion = entrada.elegir(new String[]{"Explorar la sala.", "Examinar los jeroglíficos."});
        return (opcion == 1) ? 2 : 3;
    }

    private int escena2() {
        System.out.println("\n--- Escena 2: Exploración de la sala ---");
        texto.escribir("Encuentras restos de expediciones antiguas.");
        texto.escribir("Bajo una losa suelta, hallas un compartimento con un amuleto de piedra.");
        inventario.obtenerAmuleto();
        texto.escribir("Has obtenido el AMULETO DE PIEDRA.\n");

        entrada.elegir(new String[]{"Volver al muro de jeroglíficos.", "Seguir explorando (no hay nada más)."});
        return 3;
    }

    private int escena3() {
        System.out.println("\n--- Escena 3: Muro de jeroglíficos ---");
        texto.escribir("Los símbolos forman una cuadrícula. Debes descifrarla para abrir la puerta.");
        minijuegos.jeroglificos();
        inventario.obtenerMapa();
        texto.escribir("Tras la puerta encuentras un MAPA DEL TEMPLO.\n");

        int opcion = entrada.elegir(new String[]{"Ir al Lago Hylia.", "Ir a la Ciudad de Piedra."});
        return (opcion == 1) ? 4 : 40;
    }

    private int escena4() {
        System.out.println("\n--- Escena 4: Camino hacia el Lago Hylia ---");
        texto.escribir("El aire se vuelve húmedo. El pasillo se inclina ligeramente hacia abajo.");

        String[] opciones;
        if (inventario.tieneMapa()) {
            texto.escribir("Gracias al mapa, ves marcas en el suelo que indican un posible atajo.\n");
            opciones = new String[]{"Seguir el camino normal.", "Tomar el atajo marcado por el mapa."};
        } else {
            opciones = new String[]{"Seguir el camino normal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 5 : 6;
    }

    private int escena5() {
        System.out.println("\n--- Escena 5: Entrada al templo de agua ---");
        texto.escribir("Un templo blanco emerge del agua. Una estatua de serpiente acuática sostiene una corona vacía.");
        texto.escribir("El ambiente es frío y silencioso.\n");

        String[] opciones;
        if (inventario.tieneMapa()) {
            opciones = new String[]{"Entrar por la puerta principal.", "Buscar una entrada lateral (visible gracias al mapa)."};
        } else {
            opciones = new String[]{"Entrar por la puerta principal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 7 : 6;
    }

    private int escena6() {
        System.out.println("\n--- Escena 6: Entrada lateral al templo de agua ---");
        texto.escribir("Encuentras una compuerta oculta que controla el flujo del agua dentro del templo.");
        texto.escribir("Podría ser útil más adelante.");
        inventario.descubrirCompuerta();
        texto.escribir("Has descubierto la COMPUERTA DEL AGUA.");
        return 7;
    }

    private int escena7() {
        System.out.println("\n--- Escena 7: Guardián de las Mareas ---");
        boolean vivo = combates.guardianDeLasMareas();
        return vivo ? 8 : FINAL_MALO;
    }

    private int escena8() {
        System.out.println("\n--- Escena 8: Ahorcado de las Profundidades ---");
        texto.escribir("Una voz resuena en tu mente: 'Adivina la palabra o el agua te consumirá.'");

        if (minijuegos.ahorcado()) {
            texto.escribir("¡Has adivinado la palabra!");
            texto.escribir("Un cofre se abre y encuentras una POCIÓN DE VIDA.");
            inventario.obtenerPocion();
        } else {
            texto.escribir("El agua sube rápidamente y te golpea con fuerza.");
            if (!inventario.perderVida()) {
                return FINAL_MALO;
            }
        }
        return 9;
    }

    private int escena9() {
        System.out.println("\n--- Escena 9: Cofres del templo de agua ---");
        texto.escribir("Llegas a una sala iluminada por cristales azules. Hay varios cofres antiguos.");

        if (!inventario.tienePocion()) {
            texto.escribir("Encuentras una poción de vida dentro de un cofre.");
            inventario.obtenerPocion();
        } else {
            texto.escribir("Los demás cofres están vacíos: ya tienes tu poción.");
        }
        if (!inventario.tieneFragmentoAgua()) {
            texto.escribir("En un cofre con símbolos acuáticos encuentras un FRAGMENTO DE CORONA (agua).");
            inventario.obtenerFragmentoAgua();
        }
        inventario.mostrarMochila();
        texto.escribir("\nTe preparas para avanzar hacia la cámara principal del templo.");
        return 10;
    }

    private int escena10() {
        System.out.println("\n--- Escena 10: Señor de las Corrientes ---");
        boolean vivo = combates.senorDeLasCorrientes();
        if (!vivo) {
            return FINAL_MALO;
        }
        texto.escribir("\nEl Señor de las Corrientes desaparece en una explosión de luz azul.");
        texto.escribir("La estatua de la serpiente se ilumina y revela la Corona de Agua.");
        inventario.obtenerCoronaAgua();
        texto.escribir("Has obtenido la CORONA DE AGUA.");
        return 40; // el camino continúa hacia la Ciudad de Piedra
    }

    private int escena40() {
        System.out.println("\n--- Escena 40: Camino hacia la Ciudad de Piedra ---");
        texto.escribir("El aire se vuelve caliente. El pasillo vibra ligeramente por el calor.");

        String[] opciones;
        if (inventario.tieneMapa()) {
            texto.escribir("Gracias al mapa, ves un acceso lateral oculto entre las rocas.\n");
            opciones = new String[]{"Seguir el camino normal.", "Tomar el acceso lateral."};
        } else {
            opciones = new String[]{"Seguir el camino normal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 50 : 51;
    }

    private int escena50() {
        System.out.println("\n--- Escena 50: Entrada al templo de fuego ---");
        texto.escribir("Una fortaleza de roca negra se alza ante ti, rodeada de braseros encendidos.");
        texto.escribir("El calor es intenso y el aire vibra como si el templo respirara.\n");

        String[] opciones;
        if (inventario.tieneMapa()) {
            opciones = new String[]{"Entrar por la puerta principal.", "Buscar un acceso secundario (visible gracias al mapa)."};
        } else {
            opciones = new String[]{"Entrar por la puerta principal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 52 : 51;
    }

    private int escena51() {
        System.out.println("\n--- Escena 51: Entrada lateral del templo de fuego ---");
        texto.escribir("Siguiendo las marcas del mapa, encuentras una grieta entre las rocas.");
        texto.escribir("Dentro, descubres una palanca antigua conectada a los mecanismos del templo.");
        inventario.descubrirPalanca();
        texto.escribir("Has descubierto la PALANCA DEL FUEGO.");
        return 52;
    }

    private int escena52() {
        System.out.println("\n--- Escena 52: Centinela de Brasas ---");
        boolean vivo = combates.centinelaDeBrasas();
        if (!vivo) {
            return FINAL_MALO;
        }
        texto.escribir("\nEl Centinela de Brasas cae hecho cenizas.");
        texto.escribir("Puedes avanzar hacia el corazón del templo.");
        return 53;
    }

    private int escena53() {
        System.out.println("\n--- Escena 53: El Altar de las Llamas ---");
        texto.escribir("Llegas a una sala circular rodeada de lava.");

        if (minijuegos.puzzleFuego()) {
            inventario.obtenerLlaveFuego();
            texto.escribir("\nEl altar comienza a brillar. Las llamas se apartan y revelan una llave antigua.");
            texto.escribir("Has obtenido la LLAVE DE FUEGO.");
        } else {
            texto.escribir("\nEl altar se vuelve rojo brillante. Una explosión de calor recorre la habitación.");
            if (!inventario.perderVida()) {
                return FINAL_MALO;
            }
            texto.escribir("Consigues escapar... pero el altar queda sin resolver.");
        }
        return 54;
    }

    private int escena54() {
        System.out.println("\n--- Escena 54: Cámara de los Tesoros Ardientes ---");
        texto.escribir("Llegas a una sala iluminada por lava. Varias columnas rodean dos cofres ornamentados.");

        if (!inventario.tieneFragmentoFuego()) {
            texto.escribir("\nAbres el cofre principal.");
            texto.escribir("Dentro encuentras un fragmento brillante de una antigua corona.");
            inventario.obtenerFragmentoFuego();
            texto.escribir("Has obtenido el FRAGMENTO DE LA CORONA DE FUEGO.");
        }
        if (!inventario.tienePocion()) {
            texto.escribir("En el segundo cofre hay una POCIÓN DE VIDA.");
            inventario.obtenerPocion();
        }
        inventario.mostrarMochila();
        texto.escribir("\nAl fondo aparece una enorme puerta de piedra.");
        texto.escribir("Detrás de ella te espera el Señor de las Llamas.\n");

        entrada.elegir(new String[]{"Avanzar hacia la cámara final."});
        return 55;
    }

    private int escena55() {
        System.out.println("\n--- Escena 55: Señor de las Llamas ---");
        boolean vivo = combates.senorDeLasLlamas();
        if (!vivo) {
            return FINAL_MALO;
        }
        texto.escribir("\nEl jefe se desvanece lentamente.");
        texto.escribir("En el centro de la sala aparece una corona rodeada de fuego dorado.");
        inventario.obtenerCoronaFuego();
        texto.escribir("Has obtenido la CORONA DE FUEGO.");
        return 56;
    }

    private int escena56() {
        System.out.println("\n--- Escena 56: El Corazón del Templo Viviente ---");
        texto.escribir("Con la Corona de Fuego en tus manos, el templo entero comienza a vibrar.");
        texto.escribir("Las paredes se iluminan con símbolos antiguos.");

        if (inventario.tieneCoronaAgua() && inventario.tieneCoronaFuego()
                && inventario.tieneFragmentoAgua() && inventario.tieneFragmentoFuego()) {
            texto.escribir("\nLas dos coronas reaccionan entre sí.");
            texto.escribir("Los fragmentos se unen y forman un artefacto ancestral.");
            texto.escribir("El templo te reconoce como su nuevo guardián.");
            return FINAL_BUENO;
        }
        texto.escribir("\nEl templo te permite abandonar sus dominios.");
        texto.escribir("Has sobrevivido, pero aún quedan misterios sin descubrir.");
        return FINAL_NEUTRAL;
    }

    private int finalMalo() {
        System.out.println("\n=== FINAL MALO ===");
        texto.escribir("Tus fuerzas te abandonan.");
        texto.escribir("El templo viviente reclama una nueva víctima.");
        texto.escribir("La oscuridad lo envuelve todo.");
        return FIN;
    }

    private int finalNeutral() {
        System.out.println("\n=== FINAL NEUTRAL ===");
        texto.escribir("Consigues escapar del templo.");
        texto.escribir("Has sobrevivido y obtenido parte de su poder.");
        texto.escribir("Aun así, muchos secretos permanecerán ocultos.");
        return FIN;
    }

    private int finalBueno() {
        System.out.println("\n=== FINAL BUENO ===");
        texto.escribir("Las coronas se fusionan en la Corona del Templo Viviente.");
        texto.escribir("El agua y el fuego obedecen tu voluntad.");
        texto.escribir("Te conviertes en el nuevo guardián del templo.");
        texto.escribir("Tu leyenda será recordada para siempre.");
        return FIN;
    }

}