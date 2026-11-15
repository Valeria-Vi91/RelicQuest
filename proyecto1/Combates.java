package proyecto1;

import java.util.Arrays;

public class Combates {

    private static final int ATACAR = 1;
    private static final int ESPECIAL_A = 2;
    private static final int ESPECIAL_B = 3;

    private final Entrada entrada;
    private final Inventario inventario;

    public Combates(Entrada entrada, Inventario inventario) {
        this.entrada = entrada;
        this.inventario = inventario;
    }

    public boolean guardianDeLasMareas() {
        System.out.println("Una figura hecha de agua emerge bloqueando el paso.");
        System.out.println("Sus ojos brillan con un tono azul intenso. Parece dispuesto a impedir tu avance.\n");

        int eleccion = menu("Usar el amuleto de piadra",  inventario.tieneAmuleto(),
                "Usar la compuerta para desviar el agua", inventario.conoceCompuerta());

        if (eleccion == ATACAR) {
            return golpeDirecto("Atacas directamente. el Guardián te golpea con una ola poderosa.");
        } else if (eleccion == ESPECIAL_A) {
            System.out.println("El amuleto brilla y el Guardián retrocede debilitado.");
            System.out.println("Puedes avanzar sin daño.");
        } else {
            System.out.println("Abres la compuerta y el agua se desvía.");
            System.out.println("El Guardián pierde fuerza y desaparece.");
        }
        return true;
        }

        public boolean seniorDeLasCorrientes() {
            System.out.println("La cámara principal se ilumina con un resplandor azul.");
            System.out.println("Una figura gigantesca hecha de agua pura se alza frente a ti.");
            System.out.println("Su voz retumba: 'Demuestra tu dominio sobre el agua.'\n");

            int eleccion = menu("Usar el amuleto junto con el fragmento de corona",
                    inventario.tieneAmuleto() && inventario.tieneFragmentoAgua(), "Usar las estructuras del templo para desviar el flujo de agua",
                    inventario.conoceCompuerta());
            if (eleccion == ATACAR) {
                return golpeDirecto("Atacas directamente, pero el Señor de las Corrientes te golpean con una ola masiva.");
            } else if (eleccion == ESPECIAL_A) {
                System.out.println("El amuleto y el fragmento brillan juntos.");
                System.out.println("El Señor de las Corrientes se inclina ante tu poder. Lo derrotas sin sufrir daño.");
            } else {
                System.out.println("Manipulas las estructuras del templo.");
                System.out.println("El flujo del agua cambia y debilita al Señor de las Corrientes.");
            }
            return true;
        }

    public boolean centinelaDeBrasas() {
        System.out.println("Una figura de roca incandescente se levanta frente a ti.");
        System.out.println("Sus grietas brillan como lava viva. El Centinela de Brasas te bloquea el camino.\n");

        int eleccion = menu("Usar la Corona de Agua para enfriar su núcleo", inventario.tieneCoronaAgua(),
                "Activar los mecanismos del templo con la palanca del fuego", inventario.conocePalanca());

        if (eleccion == ATACAR) {
            return golpeDirecto("Atacas directamente, pero el Centinela te golpea con un puño de lava ardiente.");
        } else if (eleccion == ESPECIAL_A) {
            System.out.println("La Corona de Agua libera un torrente helado.");
            System.out.println("El Centinela se enfría, sus grietas se apagan y cae debilitado.");
        } else {
            System.out.println("Activas la palanca del fuego.");
            System.out.println("Las paredes se mueven y liberan chorros de vapor. El Centinela se desmorona.");
        }
        return true;
    }

    public boolean senorDeLasLlamas() {
        System.out.println("La enorme puerta se abre lentamente.");
        System.out.println("Ante ti aparece una criatura formada por fuego y roca fundida.");
        System.out.println("\"Solo quien domine el templo viviente merece la Corona de Fuego.\"\n");

        int eleccion = menu("Utilizar la Corona de Agua", inventario.tieneCoronaAgua(),
                "Utilizar el Amuleto de Piedra y el Fragmento de Corona",
                inventario.tieneAmuleto() && inventario.tieneFragmentoFuego());

        if (eleccion == ATACAR) {
            return golpeDirecto("Te lanzas al combate. Las llamas te alcanzan antes de que puedas acercarte.");
        } else if (eleccion == ESPECIAL_A) {
            System.out.println("La Corona de Agua libera una poderosa corriente.");
            System.out.println("Las llamas del jefe se apagan. El Señor de las Llamas pierde gran parte de su poder.");
        } else {
            System.out.println("El amuleto y el fragmento reaccionan entre sí.");
            System.out.println("Una energía ancestral envuelve la sala. El Señor de las Llamas cae derrotado.");
        }
        return true;
    }

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

    private boolean golpeDirecto(String texto) {
        System.out.println(texto);
        return inventario.perderVida();
    }

}

