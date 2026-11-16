package proyecto1;

public class Juego {

    private final Entrada entrada;
    private final Inventario inventario;
    private final Minijuegos minijuegos;
    private final Combates combates;
    private final Historia historia;
    private final Texto texto;

    public Juego() {
        entrada = new Entrada();
        inventario = new Inventario();
        texto = new Texto();
        minijuegos = new Minijuegos(entrada, texto);
        combates = new Combates(entrada, inventario, texto);
        historia = new Historia(entrada, inventario, minijuegos, combates, texto);
    }

    public void iniciar() {
        long inicio = System.currentTimeMillis();

        System.out.println("=== RELIC QUEST: EL TEMPLO VIVIENTE ===");
        elegirVelocidadTexto();

        int escenaActual = 1;
        while (escenaActual != Historia.FIN) {
            escenaActual = historia.ejecutarEscena(escenaActual);
        }

        long segundos = (System.currentTimeMillis() - inicio) / 1000;
        System.out.println("\nTu aventura ha durado " + segundos / 60 + " min " + segundos % 60 + " s.");
        inventario.mostrarMochila();

        entrada.cerrar();
    }

    private void elegirVelocidadTexto() {
        String[] nombres = {"Lenta", "Normal", "Rápida", "Instantánea"};
        int[] retardos = {300, 180, 80, 0};   // milisegundos entre palabras

        System.out.println("\nTIP: mientras el texto se escribe, pulsa ENTER para mostrarlo entero.");
        int opcion = entrada.elegir("Velocidad del texto:", nombres);
        texto.setVelocidad(retardos[opcion - 1]);
    }
}