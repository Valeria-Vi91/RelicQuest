package proyecto1;

public class Juego {

    private final Entrada entrada;
    private final Inventario inventario;
    private final Minijuegos minijuegos;
    private final Combates combates;
    private final Historia historia;

    public Juego() {
        entrada = new Entrada();
        inventario = new Inventario();
        minijuegos = new Minijuegos(entrada);
        combates = new Combates(entrada, inventario);
        historia = new Historia(entrada, inventario, minijuegos, combates);
    }

    public void iniciar() {
        long inicio = System.currentTimeMillis();

        System.out.println("=== RELIC QUEST: EL TEMPLO VIVIENTE ===");

        int escenaActual = 1;
        while (escenaActual != Historia.FIN) {
            escenaActual = historia.ejecutarEscena(escenaActual);
        }

        long segundos = (System.currentTimeMillis() - inicio) / 1000;
        System.out.println("\nTu aventura ha durado " + segundos / 60 + " min " + segundos % 60 + " s.");
        inventario.mostrarMochila();

        entrada.cerrar();
    }
}
