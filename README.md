Relic Quest: El templo viviente

Autoras: Valeria Vivour y Elena Redríguez
Ciclo: C.F.G.S. Desarrollo de Aplicaciones Multiplataforma
Asignatura: Programación · Primera evaluación · Curso 2026-2027

Descripción

Relic Quest es una aventura conversacional desarrollada en Java para consola. La protagonista despierta en un templo misterioso, explora sus salas, resuelve jeroglíficos y elige entre dos rutas: el Lago Hylia (templo de agua) y la Ciudad de Piedra (templo de fuego). Sus decisiones y los objetos que reúne influyen en los retos y en el desenlace de la historia.

El juego incluye inventario, puntos de vida, decisiones condicionadas, un ahorcado, un puzle de símbolos, combates y tres finales posibles: bueno, neutral y malo.

Requisitos

• Java Development Kit (JDK) instalado, con los comandos java y javac disponibles.
• Terminal o consola de comandos.
• No se necesitan librerías externas.

Archivos del proyecto

Los archivos Java están organizados en el paquete proyecto1:

• Main.java: punto de entrada del programa.
• Juego.java: coordinación general y ciclo de escenas.
• Entrada.java: lectura y validación de respuestas.
• Inventario.java: vida, objetos y variables de estado.
• Historia.java: escenas, decisiones y finales.
• Minijuegos.java: jeroglíficos, ahorcado y puzle de fuego.
• Combates.java: enfrentamientos y opciones de combate.

Cómo compilar y ejecutar

1. Descomprime el archivo ZIP, de manera que exista una carpeta llamada proyecto1 con los siete archivos .java.
2. Abre una terminal en la carpeta que contiene proyecto1 (no dentro de la carpeta proyecto1).
3. Compila los archivos:
  ```bash
javac proyecto1/*.java
```
4. Ejecuta el juego:
  ```bash
java proyecto1.Main
```
5. Sigue las instrucciones que aparecen en consola. Para elegir una opción, escribe el número indicado y pulsa Intro.

En Windows, si la terminal no expande el asterisco (*), se pueden enumerar los siete archivos .java en el comando javac.

Cómo jugar

La aventura empieza en el templo viviente. Explora, lee las pistas, elige entre las rutas disponibles y aprovecha los objetos que encuentres. Los minijuegos se resuelven escribiendo respuestas en consola. Algunas opciones aparecen solo si se cumplen determinadas condiciones del inventario.

Repositorio del proyecto

Enlace de GitHub: PENDIENTE_DE_AÑADIR_URL_REAL

Antes de la entrega, sustituir el texto anterior por la URL real del repositorio público creado en GitHub. Incorporar la misma URL en un comentario al comienzo de Main.java, según lo indicado en el enunciado del proyecto.
