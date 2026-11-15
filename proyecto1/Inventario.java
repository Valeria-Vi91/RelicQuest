package proyecto1;

public class Inventario {

    private int vida = 3;

    private boolean amuleto = false;
    private boolean mapa = false;
    private boolean pocionVida = false;
    private boolean fragmentoAgua = false;
    private boolean fragmentoFuego = false;
    private boolean llaveFuego = false;
    private boolean coronaAgua = false;
    private boolean coronaFuego = false;

    private boolean compuertaAgua = false;
    private boolean palancaFuego = false;

    public boolean tieneAmuleto()        { return amuleto; }
    public boolean tieneMapa()           { return mapa; }
    public boolean tienePocion()         { return pocionVida; }
    public boolean tieneFragmentoAgua()  { return fragmentoAgua; }
    public boolean tieneFragmentoFuego() { return fragmentoFuego; }
    public boolean tieneLlaveFuego()     { return llaveFuego; }
    public boolean tieneCoronaAgua()     { return coronaAgua; }
    public boolean tieneCoronaFuego()    { return coronaFuego; }
    public boolean conoceCompuerta()     { return compuertaAgua; }
    public boolean conocePalanca()       { return palancaFuego; }

    public void obtenerAmuleto()        { amuleto = true; }
    public void obtenerMapa()           { mapa = true; }
    public void obtenerPocion()         { pocionVida = true; }
    public void obtenerFragmentoAgua()  { fragmentoAgua = true; }
    public void obtenerFragmentoFuego() { fragmentoFuego = true; }
    public void obtenerLlaveFuego()     { llaveFuego = true; }
    public void obtenerCoronaAgua()     { coronaAgua = true; }
    public void obtenerCoronaFuego()    { coronaFuego = true; }
    public void descubrirCompuerta()    { compuertaAgua = true; }
    public void descubrirPalanca()      { palancaFuego = true; }

    public int getVida() { return vida; }

    public boolean perderVida() {
        return perderVida(1);
    }

    public boolean perderVida(int cantidad) {
        vida -= cantidad;
        System.out.println("Pierdes " + cantidad +  " punto(s) de vida. Vida actual: " + Math.max(vida, 0));
        if (vida <= 0 && pocionVida) {
            pocionVida = false;
            vida = 1;
            System.out.println("¡Bebes tu poción de vida justo a tiempo! Vuelves a tener 1 punto de vida.");
        }
        return vida > 0;
    }

    public void mostrarMochila() {
        System.out.println("\n[Vida: " + vida + "]");
        System.out.println("[Mochila] Amuleto: " + si(amuleto) + " | Mapa: " + si(mapa)
                + " | Poción: " + si(pocionVida) + " | Fragmento agua: " + si(fragmentoAgua)
                + " | Fragmento fuego: " + si(fragmentoFuego)
                + " | Corona agua: " + si(coronaAgua) + " | Corona fuego: " + si(coronaFuego));
    }

    private String si(boolean valor) {
        return valor ? "sí" : "no";
    }
}
