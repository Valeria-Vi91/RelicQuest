Relic Quest: El templo viviente

Autoras: Valeria Vivour y Elena Redríguez
Ciclo formativo: C.F.G.S. Desarrollo de Aplicaciones Multiplataforma (DAM)
Módulo: Programación · 1.ª evaluación · Curso 2026-2027
Repositorio de GitHub: https://github.com/Valeria-Vi91/RelicQuest

1. Descripción del proyecto

Relic Quest: El templo viviente es un videojuego de aventura conversacional desarrollado en Java, cuya interacción se realiza mediante la consola. La protagonista despierta en un templo misterioso y debe explorar, interpretar pistas, superar pruebas y tomar decisiones para avanzar en la historia.

La aventura se divide en dos rutas principales: Lago Hylia (templo de agua) y Ciudad de Piedra (templo de fuego). Las decisiones, los objetos disponibles y el estado de la protagonista condicionan ciertas opciones, los enfrentamientos y el desenlace. El juego contempla tres posibles finales: bueno, neutral y malo.

2. Requisitos para ejecutar el videojuego

• Tener instalado un JDK (Java Development Kit) que permita compilar y ejecutar programas Java.
• Disponer de IntelliJ IDEA (opción recomendada) o de una terminal con los comandos javac y java disponibles.
• No se necesitan bibliotecas externas adicionales para las clases Java del juego.

> **Importante:** este es un juego **de consola**, no una aplicación con interfaz gráfica. La partida se desarrolla leyendo los mensajes y escribiendo las opciones que se solicitan.

3. Estructura del proyecto

El videojuego se ha desarrollado como un proyecto de IntelliJ IDEA denominado relic-quest. La carpeta que debe abrirse como proyecto es la carpeta completa, no solamente el paquete proyecto1.

```text
relic-quest/
├── .idea/                 # Configuración del proyecto en IntelliJ IDEA
├── out/                   # Archivos compilados generados por el entorno
├── presentation/          # Material de presentación del proyecto
├── src/                   # Código fuente Java
│   └── proyecto1/         # Paquete Java del videojuego
│       ├── Main.java
│       ├── Juego.java
│       ├── Entrada.java
│       ├── Inventario.java
│       ├── Historia.java
│       ├── Minijuegos.java
│       └── Combates.java
└── README.md              # Instrucciones de apertura y ejecución
```

La carpeta src/proyecto1 es la que contiene las siete clases Java. Las carpetas .idea y out corresponden, respectivamente, a la configuración del entorno y a los archivos generados durante la compilación; no es necesario modificarlas manualmente para jugar.

Función de las clases

|Clase            |Función principal                                                         |
|-----------------|--------------------------------------------------------------------------|
|`Main.java`      |Contiene el método `main()` y arranca el programa.                        |
|`Juego.java`     |Coordina el inicio y el desarrollo general de la partida.                 |
|`Entrada.java`   |Recoge y valida las opciones introducidas por el jugador.                 |
|`Inventario.java`|Gestiona objetos, vida y variables de estado.                             |
|`Historia.java`  |Contiene las escenas, rutas, decisiones y finales.                        |
|`Minijuegos.java`|Implementa pruebas como los jeroglíficos, el ahorcado y el puzle de fuego.|
|`Combates.java`  |Gestiona los enfrentamientos y las decisiones de combate.                 |

4. Cómo abrir y jugar con IntelliJ IDEA (recomendado)

1. Descargar o descomprimir el proyecto completo. La carpeta principal puede llamarse relic-quest o, al descargarla de GitHub, RelicQuest-main; lo importante es que contenga la subcarpeta src.
2. Abrir IntelliJ IDEA.
3. Seleccionar File → Open (Archivo → Abrir) y elegir la carpeta principal del proyecto (por ejemplo, relic-quest), no la carpeta src ni la carpeta proyecto1.
4. Esperar a que IntelliJ cargue el proyecto. Si solicita configurar un Project SDK, seleccionar un JDK instalado.
5. En el panel de archivos, abrir src → proyecto1 → Main.java.
6. Ejecutar el método principal mediante el triángulo verde junto a main(), o haciendo clic derecho sobre Main.java y eligiendo Run ‘Main.main()’.
7. La aventura comenzará en la ventana Run / Consola del entorno. Seguir las indicaciones y escribir las respuestas cuando se soliciten.

Si IntelliJ no encuentra el código fuente automáticamente, comprobar que la carpeta src esté marcada como Sources Root (raíz de código fuente).

5. Alternativa: compilar y ejecutar desde la terminal

Esta opción permite jugar sin IntelliJ IDEA, siempre que haya un JDK instalado.

1. Abrir una terminal situada en la carpeta raíz del proyecto, es decir, la carpeta que contiene src, independientemente de cómo se llame.
2. Compilar desde allí con el siguiente comando:
  ```bash
javac -encoding UTF-8 -d out -sourcepath src src/proyecto1/Main.java
```
3. Iniciar el juego con:
  ```bash
java -cp out proyecto1.Main
```
4. Leer el texto de cada escena, introducir las opciones por teclado y pulsar Intro para continuar.

Nota: si la carpeta out no está incluida, crear una carpeta vacía con ese nombre antes de compilar. El comando genera allí los archivos .class necesarios. Ambos comandos deben ejecutarse desde la raíz del proyecto, no desde src/proyecto1.

6. Cómo jugar

Al iniciar el programa se presenta la primera escena de la historia. El jugador debe leer las descripciones y elegir una de las opciones numéricas que aparecen en pantalla. A lo largo de la aventura podrá encontrar objetos, acceder a rutas condicionadas por el inventario y resolver minijuegos y combates.

Algunas elecciones pueden hacer perder vida, desbloquear recompensas o conducir a uno de los tres finales. En los apartados que soliciten respuestas o soluciones a acertijos, deben seguirse las instrucciones mostradas en la consola.

7. Enlace al repositorio

El código y la documentación publicada del proyecto se encuentran en:

https://github.com/Valeria-Vi91/RelicQuest

Este enlace también figura como comentario informativo en la clase principal Main.java.
