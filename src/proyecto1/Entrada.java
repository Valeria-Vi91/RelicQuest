package proyecto1;

import java.util.Scanner;

public class Entrada {

    private final Scanner sc = new Scanner(System.in);


    public int leerOpcion(int min, int max) {
        return leerOpcion("Elige una opción", min, max);
    }

    public int leerOpcion(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje + " (" + min + "-" + max + "): ");
            String linea = leerLinea();
            try {
                int opcion = Integer.parseInt(linea.trim());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                }
                System.out.println("Número fuera de rango.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes introducir un número.");
            }
        }
    }

    public int elegir(String[] opciones) {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        return leerOpcion(1, opciones.length);
    }

    public int elegir(String pregunta, String[] opciones) {
        System.out.println(pregunta);
        return elegir(opciones);
    }

    public char leerLetra() {
        while (true) {
            System.out.print("Introduce una letra: ");
            String texto = leerLinea().trim().toUpperCase();
            if (texto.length() == 1 && Character.isLetter(texto.charAt(0))) {
                return texto.charAt(0);
            }
            System.out.println("Debes introducir una sola letra.");
        }
    }

     public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return leerLinea().trim();
    }

    private String leerLinea() {
        if (!sc.hasNextLine()) { // por si se cierra la consola (Ctrl+D)
            System.out.println("\nNo hay más entrada. Fin del juego.");
            System.exit(0);
        }
        return sc.nextLine();
    }

    public void cerrar() {
        sc.close();
    }
}