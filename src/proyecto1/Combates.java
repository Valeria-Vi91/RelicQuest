package proyecto1;

import java.util.Arrays;


public class Combates {

    private static final int ATACAR = 1;
    private static final int ESPECIAL_A = 2;
    private static final int ESPECIAL_B = 3;

    private final Entrada entrada;
    private final Inventario inventario;
    private final Texto texto;

    public Combates(Entrada entrada, Inventario inventario, Texto texto) {
        this.texto = texto;
        this.entrada = entrada;
        this.inventario = inventario;
    }

    public boolean guardianDeLasMareas() {
        texto.escribir("Una figura hecha de agua emerge bloqueando el paso.");
        texto.escribir("Sus ojos brillan con un tono azul intenso. Parece dispuesto a impedir tu avance.\n");

        int eleccion = menu("Usar el amuleto de piedra", inventario.tieneAmuleto(),
                "Usar la compuerta para desviar el agua", inventario.conoceCompuerta());

        if (eleccion == ATACAR) {
            return golpeDirecto("Atacas directamente. El Guardián te golpea con una ola poderosa.");
        } else if (eleccion == ESPECIAL_A) {
            texto.escribir("El amuleto brilla y el Guardián retrocede debilitado.");
            texto.escribir("Puedes avanzar sin daño.");
        } else {
            texto.escribir("Abres la compuerta y el agua se desvía.");
            texto.escribir("El Guardián pierde fuerza y desaparece.");
        }
        return true;
    }

    public boolean senorDeLasCorrientes() {
        texto.escribir("La cámara principal se ilumina con un resplandor azul.");
        texto.escribir("Una figura gigantesca hecha de agua pura se alza frente a ti.");
        texto.escribir("Su voz retumba: 'Demuestra tu dominio sobre el agua.'\n");

        int eleccion = menu("Usar el amuleto junto con el fragmento de corona",
                inventario.tieneAmuleto() && inventario.tieneFragmentoAgua(),
                "Usar las estructuras del templo para desviar el flujo del agua",
                inventario.conoceCompuerta());

        if (eleccion == ATACAR) {
            return golpeDirecto("Atacas directamente, pero el Señor de las Corrientes te golpea con una ola masiva.");
        } else if (eleccion == ESPECIAL_A) {
            texto.escribir("El amuleto y el fragmento brillan juntos.");
            texto.escribir("El Señor de las Corrientes se inclina ante tu poder. Lo derrotas sin sufrir daño.");
        } else {
            texto.escribir("Manipulas las estructuras del templo.");
            texto.escribir("El flujo del agua cambia y debilita al Señor de las Corrientes.");
        }
        return true;
    }

    public boolean centinelaDeBrasas() {
        texto.escribir("Una figura de roca incandescente se levanta frente a ti.");
        texto.escribir("Sus grietas brillan como lava viva. El Centinela de Brasas te bloquea el camino.\n");

        int eleccion = menu("Usar la Corona de Agua para enfriar su núcleo", inventario.tieneCoronaAgua(),
                "Activar los mecanismos del templo con la palanca del fuego", inventario.conocePalanca());

        if (eleccion == ATACAR) {
            return golpeDirecto("Atacas directamente, pero el Centinela te golpea con un puño de lava ardiente.");
        } else if (eleccion == ESPECIAL_A) {
            texto.escribir("La Corona de Agua libera un torrente helado.");
            texto.escribir("El Centinela se enfría, sus grietas se apagan y cae debilitado.");
        } else {
            texto.escribir("Activas la palanca del fuego.");
            texto.escribir("Las paredes se mueven y liberan chorros de vapor. El Centinela se desmorona.");
        }
        return true;
    }

    public boolean senorDeLasLlamas() {
        texto.escribir("La enorme puerta se abre lentamente.");
        texto.escribir("Ante ti aparece una criatura formada por fuego y roca fundida.");
        texto.escribir("\"Solo quien domine el templo viviente merece la Corona de Fuego.\"\n");

        int eleccion = menu("Utilizar la Corona de Agua", inventario.tieneCoronaAgua(),
                "Utilizar el Amuleto de Piedra y el Fragmento de Corona",
                inventario.tieneAmuleto() && inventario.tieneFragmentoFuego());

        if (eleccion == ATACAR) {
            return golpeDirecto("Te lanzas al combate. Las llamas te alcanzan antes de que puedas acercarte.");
        } else if (eleccion == ESPECIAL_A) {
            texto.escribir("La Corona de Agua libera una poderosa corriente.");
            texto.escribir("Las llamas del jefe se apagan. El Señor de las Llamas pierde gran parte de su poder.");
        } else {
            texto.escribir("El amuleto y el fragmento reaccionan entre sí.");
            texto.escribir("Una energía ancestral envuelve la sala. El Señor de las Llamas cae derrotado.");
        }
        return true;
    }

    /**
     * Construye el menú del combate. "Atacar" siempre sale; las otras dos
     * opciones solo salen si el jugador las tiene disponibles.
     * Devuelve ATACAR, ESPECIAL_A o ESPECIAL_B (no el número que se pulsó,
     * porque los números cambian según las opciones disponibles).
     */
    private int menu(String textoA, boolean hayA, String textoB, boolean hayB) {
        String[] textos = new String[3];
        int[] codigos = new int[3];
        int n = 0;

        textos[n] = "Atacar directamente.";
        codigos[n] = ATACAR;
        n++;
        if (hayA) {
            textos[n] = textoA + ".";
            codigos[n] = ESPECIAL_A;
            n++;
        }
        if (hayB) {
            textos[n] = textoB + ".";
            codigos[n] = ESPECIAL_B;
            n++;
        }
        int elegido = entrada.elegir("¿Cómo quieres enfrentarlo?", Arrays.copyOf(textos, n));
        return codigos[elegido - 1];
    }

    private boolean golpeDirecto(String mensaje) {
        texto.escribir(mensaje);
        return inventario.perderVida();
    }
}