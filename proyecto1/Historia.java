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

    public Historia(Entrada entrada, Inventario inventario, Minijuegos minijuegos, Combates combates) {
        this.entrada = entrada;
        this.inventario = inventario;
        this.minijuegos = minijuegos;
        this.combates = combates;
    }

    public int ejecutarEscena(int escena) {
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
                System.out.println("Escena desconocida. Fin del juego.");
                return FIN;
        }
    }

    private int escena1() {
        System.out.println("\n--- Escena 1: Despertar en el templo ---");
        System.out.println("Te despiertas sobre una losa fría. La sala es enorme, iluminada por una luz azul.");
        System.out.println("Frente a ti, un muro lleno de jeroglíficos.\n");

        int opcion = entrada.elegir(new String[]{"Explorar la sala.", "examinar los jeroglíficos."});
        return (opcion == 1) ? 2 : 3;
    }

    private int escena2() {
        System.out.println("\n--- \\n\");Escena 2: Exploración de la sala ---");
        System.out.println("Encuentras restos de expediciones antiguas.");
        System.out.println("Bajo una losa suelta, hallas un compartimento con un amuleto de piedra.");
        inventario.obtenerAmuleto();
        System.out.println("Has obtenido el AMULETO DE PIEDRA.\n");

        entrada.elegir(new String[]{"Volver al muro de jeroglificos.", "Seguir explorando (no hay nada más."});
        return 3;
    }

    private int escena3() {
        System.out.println("\n--- Escena 3: Muro de jeroglíficos ---");
        System.out.println("Los símbolos forman una cuadrícula. Debes descifrarla para abrir la puerta.");
        minijuegos.jeroglificos();
        inventario.obtenerMapa();
        System.out.println("Tras la puerta encuentras un MAPA DEL TEMPLO.\n");

        int opcion = entrada.elegir(new String[]{"Ir al Lago Hylia.", "Ir al la Ciudad de Piedra."});
        return (opcion == 1) ? 4: 40;
    }

    private int escena4() {
        System.out.println("\n--- Escena 4: Camino hacia el Lago Hylia ---");
        System.out.println("El aire se vuelve húmedo. El pasillo se inclina ligeramente hacia abajo.");

        String[] opciones;
        if (inventario.tieneMapa()) {
            opciones = new String[]{"Entrar por la puerta principal.", "Buscar una entrada lateral (visible gracias al mapa)."};
        } else {
            opciones = new String[]{"Entrar por la puerta principal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 7: 6;
    }

    private int escena5() {
        System.out.println("\n--- Escena 5: Entrada al templo de agua ---");
        System.out.println("Un templo blanco emerge del agua. Una estatua de serpiente acuática sostiene una corona vacía.");
        System.out.println("El ambiente es frío y silencioso.\n");

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
        System.out.println("Encuentras una compuerta oculta que controla el flujo del agua dentro del templo.");
        System.out.println("Podría ser útil más adelante.");
        inventario.descubrirCompuerta();
        System.out.println("Has descubierto la COMPUERTA DEL AGUA.");
        return 7;
    }

    private int escena7() {
        System.out.println("\n--- Escena 7: Guardián de las Mareas ---");
        boolean vivo = combates.guardianDeLasMareas();
        return vivo ? 8 : FINAL_MALO;
    }

    private int escena8() {
        System.out.println("\n--- Escena 8: Ahorcado de las Profundidades ---");
        System.out.println("Una voz resuena en tu mente: 'Adivina la palabra o el agua te consumirá.'");

        if (minijuegos.ahorcado()) {
            System.out.println("¡Has adivinado la palabra!");
            System.out.println("Un cofre se abre y encuentras una POCIÓN DE VIDA.");
            inventario.obtenerPocion();
        } else {
            System.out.println("El agua sube rápidamente y te golpea con fuerza.");
            if (!inventario.perderVida()) {
                return FINAL_MALO;
            }
        }
        return 9;
    }

    private int escena9() {
        System.out.println("\n--- Escena 9: Cofres del templo de agua ---");
        System.out.println("Lllega a una sla iluminada por crditales azules. Hay varios cofres antiguos.");

        if (!inventario.tieneFragmentoAgua()) {
            System.out.println("En un cofre con símbolos acuáticos encuentras un FRAGMENTO DE CORONA (agua).");
            inventario.obtenerFragmentoAgua();
        }
        inventario.mostrarMochila();
        System.out.println("\nTe preparas para avanzar hacia la cámara principal del templo.");
        return 10;
    }

    private int escena10() {
        System.out.println("\n--- Escena 10: Señor de las Corrietes ---");
        boolean vivo = combates.seniorDeLasCorrientes();
        if (!vivo) {
            return FINAL_MALO;
        }
        System.out.println("\nEl Señor de las Corrientes desaparece en una explosión de luz azul.");
        System.out.println("La estatua de la serpiente se ilumina y revela la Corona de Agua.");
        inventario.obtenerCoronaAgua();
        System.out.println("Has obtenido la CORONA DE AGUA.");
        return 40;
    }

    private int escena40() {
        System.out.println("\n--- Escena 40: Camino hacia la Ciudad de Piedra ---");
        System.out.println("El aire se vuelve caliente. El pasillo vibra ligeramente por el calor.");

        String[] opciones;
        if (inventario.tieneMapa()) {
            System.out.println("Gracias al mapa, ves un acceso lateral oculto entre las rocas.\n");
            opciones = new String[]{"Seguir al camino normal.", "Tomar el acceso lateral."};
        } else {
            opciones = new String[]{"Seguir el camino noraml."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 50: 51;
    }

    private int escena50() {
        System.out.println("\n--- Escena 50: Entrada al templo de fuego ---");
        System.out.println("Una fortaleza de roca negra se alza ante ti, rodeada de braseros encendidos.");
        System.out.println("El calor es intenso y el aire vibra como si el templo respirara.\n");

        String[] opciones;
        if (inventario.tieneMapa()) {
            opciones = new String[]{"Entrar por la puerta principal.", "Buscar un acceso secundario (visible gracias al mapa)."};
        } else {
            opciones = new String[]{"Entrar por la puerta principal."};
        }
        int opcion = entrada.elegir(opciones);
        return (opcion == 1) ? 52: 51;
    }

    private int escena51() {
        System.out.println("\n--- Escena 51: Entrada lateral del templo de fuego ---");
        System.out.println("Siguiendo las marcas del mapa, encuentras una grieta entre las rocas.");
        System.out.println("Dentro, descubres una palanca antigua conectada a los mecanismos del templo.");
        inventario.descubrirPalanca();
        System.out.println("Has descubierto la PALANCA DEL FUEGO.");
        return 52;
    }

    private int escena52() {
        System.out.println("\n--- Escena 52: Centinela de Brasas ---");
        boolean vivo = combates.centinelaDeBrasas();
        if (!vivo) {
            return FINAL_MALO;
        }
        System.out.println("\nEl Centinela de Brasas cae hecho cenizas.");
        System.out.println("Puedes avanzar hacia el corazón del templo.");
        return 53;
    }

    private int escena53() {
        System.out.println("\n--- Escena 53: El Altar de las Llamas ---");
        System.out.println("Llegas a una sala circular rodeada de lava.");

        if (minijuegos.puzzleFuego()) {
            inventario.obtenerLlaveFuego();
            System.out.println("\nEl altar comienza a brillar. Las llamas se apartan y revelan una llave antigua.");
            System.out.println("Has obtenido la LLAVE DE FUEGO.");
        } else {
            System.out.println("\nEl altar se vuelve rojo brillante. Una explosión de calor recorre la habitación.");
            if (!inventario.perderVida()) {
                return FINAL_MALO;
            }
            System.out.println("Consigues escapar... pero el altar queda sin resolver.");
        }
        return 54;
    }

    private int escena54() {
        System.out.println("\n--- Escena 54: Cámara de los Tesoros Ardientes ---");
        System.out.println("Llegas a una sala iluminada por lava. Varias columnas rodean dos cofres ornamentados.");

        if (!inventario.tieneFragmentoFuego()) {
            System.out.println("\nAbres el cofre principal.");
            System.out.println("Dentro encuentras un fragmento brillante de una antigua corona.");
            inventario.obtenerFragmentoFuego();
            System.out.println("Has obtenido el FRAGMENTO DE LA CORONA DE FUEGO.");
        }
        if (!inventario.tienePocion()) {
            System.out.println("En el segundo cofre hay una POCIÓN DE VIDA.");
            inventario.obtenerPocion();
        }
        inventario.mostrarMochila();
        System.out.println("\nAl fondo aparece una enorme puerta de piedra.");
        System.out.println("Detrás de ella te espera el Señor de las Llamas.\n");

        entrada.elegir(new String[]{"Avanzar hacia la cámara final."});
        return 55;
    }

    private int escena55() {
        System.out.println("\n--- Escena 55: Señor de las Llamas ---");
        boolean vivo = combates.senorDeLasLlamas();
        if (!vivo) {
            return FINAL_MALO;
        }
        System.out.println("\nEl jefe se desvanece lentamente.");
        System.out.println("En el centro de la sala aparece una corona rodeada de fuego dorado.");
        inventario.obtenerCoronaFuego();
        System.out.println("Has obtenido la CORONA DE FUEGO.");
        return 56;
    }

    private int escena56() {
        System.out.println("\n--- Escena 56: El Corazón del Templo Viviente ---");
        System.out.println("Con la Corona de Fuego en tus manos, el templo entero comienza a vibrar.");
        System.out.println("Las paredes se iluminan con símbolos antiguos.");

        if (inventario.tieneCoronaAgua() && inventario.tieneCoronaFuego()
                && inventario.tieneFragmentoAgua() && inventario.tieneFragmentoFuego()) {
            System.out.println("\nLas dos coronas reaccionan entre sí.");
            System.out.println("Los fragmentos se unen y forman un artefacto ancestral.");
            System.out.println("El templo te reconoce como su nuevo guardián.");
            return FINAL_BUENO;
        }
        System.out.println("\nEl templo te permite abandonar sus dominios.");
        System.out.println("Has sobrevivido, pero aún quedan misterios sin descubrir.");
        return FINAL_NEUTRAL;
    }

    // ---------------- FINALES ----------------

    private int finalMalo() {
        System.out.println("\n=== FINAL MALO ===");
        System.out.println("Tus fuerzas te abandonan.");
        System.out.println("El templo viviente reclama una nueva víctima.");
        System.out.println("La oscuridad lo envuelve todo.");
        return FIN;
    }

    private int finalNeutral() {
        System.out.println("\n=== FINAL NEUTRAL ===");
        System.out.println("Consigues escapar del templo.");
        System.out.println("Has sobrevivido y obtenido parte de su poder.");
        System.out.println("Aun así, muchos secretos permanecerán ocultos.");
        return FIN;
    }

    private int finalBueno() {
        System.out.println("\n=== FINAL BUENO ===");
        System.out.println("Las coronas se fusionan en la Corona del Templo Viviente.");
        System.out.println("El agua y el fuego obedecen tu voluntad.");
        System.out.println("Te conviertes en el nuevo guardián del templo.");
        System.out.println("Tu leyenda será recordada para siempre.");
        return FIN;
    }
}


