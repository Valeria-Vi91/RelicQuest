package proyecto1;

import java.util.Random;

public class Minijuegos {

    private final Entrada entrada;
    private final Texto texto;
    private final Random azar = new Random();

    public Minijuegos(Entrada entrada, Texto texto) {
        this.entrada = entrada;
        this.texto = texto;
    }

    // ------------------------------------------------------------------
    // MINIJUEGO 1: jeroglíficos (usa una MATRIZ, o array bidimensional)
    // ------------------------------------------------------------------
    public void jeroglificos() {
        char[][] muro = {
                {'@', '#', '@'},
                {'$', '@', '%'},
                {'&', '*', '+'}
        };
        char[] simbolos = {'@', '#', '$', '%', '&', '*', '+'};
        char[] letras   = {'E', 'L', 'M', 'N', 'T', 'O', 'S'};

        texto.escribir("\nEl muro es una cuadrícula de símbolos:\n");
        for (int fila = 0; fila < muro.length; fila++) {
            System.out.print("      ");
            for (int col = 0; col < muro[fila].length; col++) {
                System.out.print(muro[fila][col] + "  ");
            }
            System.out.println();
        }
        texto.escribir("\nA su lado hay una leyenda grabada en la piedra:");
        for (int i = 0; i < simbolos.length; i++) {
            System.out.println("   " + simbolos[i] + " = " + letras[i]);
        }
        texto.escribir("\nLee la cuadrícula fila a fila, de izquierda a derecha.");

        // La respuesta correcta se calcula recorriendo la matriz
        StringBuilder clave = new StringBuilder();
        for (int fila = 0; fila < muro.length; fila++) {
            for (int col = 0; col < muro[fila].length; col++) {
                clave.append(traducir(muro[fila][col], simbolos, letras));
            }
        }

        boolean resuelto = false;
        while (!resuelto) {
            String respuesta = entrada.leerTexto("Escribe la palabra clave: ");
            if (respuesta.equalsIgnoreCase(clave.toString())) {
                resuelto = true;
            } else {
                System.out.println("Los símbolos no reaccionan. Prueba otra vez.");
            }
        }
        texto.escribir("¡El muro tiembla y una puerta gigantesca se abre!");
    }

    private char traducir(char simbolo, char[] simbolos, char[] letras) {
        for (int i = 0; i < simbolos.length; i++) {
            if (simbolos[i] == simbolo) {
                return letras[i];
            }
        }
        return '?';
    }

    // ------------------------------------------------------------------
    // MINIJUEGO 2: ahorcado
    // ------------------------------------------------------------------
    public boolean ahorcado() {
        String[] palabras = {"AGUA", "CORONA", "TEMPLO", "RELIC", "MAREA"};
        String secreta = palabras[azar.nextInt(palabras.length)];

        char[] progreso = new char[secreta.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        String usadas = "";
        int fallos = 0;
        int maxFallos = 6;

        while (contiene(progreso, '_') && fallos < maxFallos) {
            System.out.println("\nPalabra: " + new String(progreso));
            System.out.println("Letras usadas: " + usadas + " | Fallos: " + fallos + "/" + maxFallos);
            char letra = entrada.leerLetra();

            if (usadas.indexOf(letra) >= 0) {
                System.out.println("Esa letra ya la has probado.");
                continue;
            }
            usadas += letra;

            boolean acierto = false;
            for (int i = 0; i < secreta.length(); i++) {
                if (secreta.charAt(i) == letra) {
                    progreso[i] = letra;
                    acierto = true;
                }
            }
            if (!acierto) {
                fallos++;
                System.out.println("Letra incorrecta.");
            }
        }
        System.out.println("\nLa palabra era: " + secreta);
        return fallos < maxFallos;
    }

    private boolean contiene(char[] array, char buscado) {
        for (char c : array) {
            if (c == buscado) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------
    // MINIJUEGO 3: puzzle del altar de fuego
    // ------------------------------------------------------------------
    public boolean puzzleFuego() {
        texto.escribir("\nEn el centro hay un altar con tres símbolos grabados:");
        System.out.println("   1. Agua");
        System.out.println("   2. Piedra");
        System.out.println("   3. Fuego");
        texto.escribir("\nUna inscripción dice:");
        texto.escribir("\"El origen sostiene el mundo,");
        texto.escribir("el mundo alimenta la llama.\"");
        texto.escribir("\nDebes introducir el orden correcto de los símbolos.");

        int primero = entrada.leerOpcion("Primer símbolo", 1, 3);
        int segundo = entrada.leerOpcion("Segundo símbolo", 1, 3);
        int tercero = entrada.leerOpcion("Tercer símbolo", 1, 3);

        return primero == 1 && segundo == 2 && tercero == 3;
    }
}