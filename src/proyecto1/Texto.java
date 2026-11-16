package proyecto1;

import java.io.IOException;

public class Texto {

    private int msPorPalabra;
    private boolean saltando = false;

    public Texto() {
        this(180);
    }

    public Texto(int msPorPalabra) {
        this.msPorPalabra = msPorPalabra;
    }

    public void setVelocidad(int msPorPalabra) {
        this.msPorPalabra = msPorPalabra;
    }

    public void reiniciarSalto() {
        saltando = false;
    }

    public void escribir(String texto) {
        escribir(texto, msPorPalabra);
    }

    public void escribir(String texto, int retardo) {
        if (saltando || retardo <= 0) {
            System.out.println(texto);
            return;
        }

        String[] palabras = texto.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            if (hayEnterPendiente()) {
                saltando = true;
                for (int j = i; j < palabras.length; j++) {
                    System.out.print(palabras[j]);
                    if (j < palabras.length - 1) {
                        System.out.print(" ");
                    }
                }
                break;
            }

            System.out.print(palabras[i]);
            if (i < palabras.length - 1) {
                System.out.print(" ");
            }
            System.out.flush();
            pausa(retardo);
        }
        System.out.println();
    }

    private boolean hayEnterPendiente() {
        try {
            if (System.in.available() > 0) {
                while (System.in.available() > 0) {
                    System.in.read();
                }
                return true;
            }
        }  catch (IOException e) {

        }
        return false;
    }

    private void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
