# Relic Quest: El templo viviente

**Autoras:** Valeria Vivour y Elena Rodríguez  
**Ciclo:** Grado Superior en Desarrollo de Aplicaciones Multiplataforma (1.º DAM)  
**Módulo:** Programación · 1.ª evaluación · Curso 2026-2027  
**Repositorio:** [github.com/Valeria-Vi91/RelicQuest](https://github.com/Valeria-Vi91/RelicQuest)

## Descripción

**Relic Quest: El templo viviente** es una aventura conversacional desarrollada en **Java** y ejecutada en **consola**. La protagonista despierta en un templo misterioso, descifra un muro de jeroglíficos y debe superar pruebas para avanzar por dos rutas: el **Lago Hylia** (Templo del Agua) y la **Ciudad de Piedra** (Templo del Fuego).

A lo largo de la partida, las elecciones, el inventario y los puntos de vida influyen en los caminos y en las formas de superar los enfrentamientos. La aventura incluye **18 escenas numeradas, tres finales (bueno, neutral y malo), cuatro combates y tres minijuegos**: jeroglíficos, ahorcado y puzle de fuego.

Entre sus funcionalidades se encuentran la **validación de respuestas**, la **escritura progresiva del texto** (con cuatro velocidades seleccionables), la opción de **mostrar de golpe el texto que se está escribiendo pulsando ENTER**, el **uso automático de una poción al agotarse la vida** y un resumen final de **duración e inventario**.

## Requisitos

- Un **JDK (Java Development Kit)** instalado y configurado. La versión actual del proyecto se ha compilado y ejecutado en pruebas con **OpenJDK 21**; se recomienda utilizar **JDK 21** para reproducir ese entorno.
- **IntelliJ IDEA** (opcional, recomendado para abrir el proyecto completo) **o** una terminal con `javac` y `java` disponibles.
- **No requiere** Maven, Gradle, librerías externas, archivos de datos ni recursos gráficos adicionales. Es un juego **de consola**, sin interfaz gráfica.

## Estructura del proyecto

La estructura recomendada del **ZIP de entrega**, creada desde el proyecto de IntelliJ IDEA, es la siguiente:

```text
relic-quest/
├── src/
│   └── proyecto1/
│       ├── Main.java
│       ├── Juego.java
│       ├── Entrada.java
│       ├── Inventario.java
│       ├── Historia.java
│       ├── Minijuegos.java
│       ├── Combates.java
│       └── Texto.java
├── README.md
├── relic-quest.iml        (opcional: configuración del módulo IntelliJ)
└── presentation/          (opcional: material para la exposición)
```

**Imprescindibles para ejecutar el juego:** los ocho archivos `.java` dentro de `src/proyecto1/`. Este `README.md` explica cómo abrirlos y ejecutarlos. La carpeta `.idea/` contiene ajustes locales de IntelliJ y `out/` contiene archivos compilados: **pueden omitirse del ZIP**, porque son regenerables.

> **Atención a la descarga desde GitHub:** si el repositorio todavía muestra `proyecto1/` **directamente en la raíz**, en vez de `src/proyecto1/`, utiliza las instrucciones alternativas de la sección **«Si el repositorio no contiene `src`»**. El ZIP del proyecto completo y la estructura del repositorio deben revisarse antes de la entrega para confirmar que contienen los mismos **ocho archivos**.

### Función de las ocho clases

| Archivo | Responsabilidad |
| --- | --- |
| `Main.java` | Contiene `public static void main(String[] args)` e inicia el programa. |
| `Juego.java` | Crea y conecta los componentes, controla el bucle de escenas, permite elegir la velocidad del texto y muestra la duración final. |
| `Entrada.java` | Lee y valida las respuestas por teclado, incluso cuando se introducen valores incorrectos. |
| `Inventario.java` | Gestiona vida, objetos, coronas, fragmentos y marcas de acceso; aplica el efecto de las pociones. |
| `Historia.java` | Organiza las escenas, las opciones, el avance por las dos rutas y los tres finales. |
| `Minijuegos.java` | Contiene la matriz de jeroglíficos, el ahorcado y el puzle de fuego. |
| `Combates.java` | Gestiona los cuatro enfrentamientos y las opciones disponibles según el inventario. |
| `Texto.java` | Muestra narraciones palabra a palabra, permite elegir velocidad y saltar el texto en curso con ENTER. |

## Abrir y ejecutar en IntelliJ IDEA

Estas instrucciones corresponden al **ZIP completo** que contiene la carpeta `src`.

1. **Descomprimir** el archivo ZIP en el ordenador.
2. Abrir **IntelliJ IDEA** y seleccionar **File → Open**.
3. Elegir la **carpeta raíz `relic-quest`**, que contiene `src` y `README.md` (no abrir solamente `src` ni `proyecto1`).
4. Si IntelliJ solicita un SDK, configurar un **JDK 21** en **File → Project Structure → Project → SDK**.
5. Comprobar que `src` figura como carpeta de código fuente. Si no aparece marcada, hacer clic derecho en `src` → **Mark Directory as → Sources Root**.
6. En el panel del proyecto, abrir **`src → proyecto1 → Main.java`**.
7. Pulsar el **triángulo verde** junto al método `main` o hacer clic derecho en `Main.java` → **Run 'Main.main()'**.
8. Interactuar con el videojuego en la ventana **Run / Consola**.

## Compilar y ejecutar desde la terminal

No es obligatorio utilizar IntelliJ. Abre la terminal **en la carpeta raíz**, es decir, la que contiene `src`.

**1. Compilar:**

```bash
javac -encoding UTF-8 -d out -sourcepath src src/proyecto1/Main.java
```

**2. Ejecutar:**

```bash
java -cp out proyecto1.Main
```

`-sourcepath src` permite localizar las clases del paquete `proyecto1` (incluida `Texto.java`). La carpeta `out` se utiliza para los archivos compilados y puede generarse al compilar; no es necesario entregarla ya creada.

### Si el repositorio no contiene `src`

Si al **descargar el repositorio desde GitHub** encuentras los archivos bajo `proyecto1/Main.java` (sin una carpeta `src`), abre la terminal en la carpeta que contiene `proyecto1` y usa, en su lugar:

```bash
javac -encoding UTF-8 -d out -sourcepath . proyecto1/Main.java
java -cp out proyecto1.Main
```

Estos comandos corresponden **solo a esa distribución alternativa**. Para abrir el proyecto completo de IntelliJ, se recomienda entregar la estructura habitual `src/proyecto1/` y actualizar GitHub para que coincida.

## Cómo jugar

Al comenzar, el videojuego permite elegir la **velocidad de aparición del texto**: **Lenta**, **Normal**, **Rápida** o **Instantánea**. Después se desarrolla la aventura a través de la consola.

| Situación | Qué introducir |
| --- | --- |
| Menús y decisiones | El **número** correspondiente a una opción disponible (`1`, `2`, etc.). |
| Jeroglíficos | La **palabra** que resulta de descifrar la matriz de símbolos. Se aceptan mayúsculas o minúsculas. |
| Ahorcado | **Una letra** por intento; hay un máximo de seis fallos. |
| Puzle de fuego | El **número** solicitado en cada paso del orden de símbolos. |
| Narración que aparece progresivamente | **ENTER** para mostrar de golpe el resto del texto que se está escribiendo; no es un botón de «continuar a la siguiente escena». |

Cuando se introduce un número fuera de rango, una letra donde se exige un número o una respuesta vacía, el juego muestra un aviso y vuelve a solicitar la entrada.

### Inventario y desenlaces

La protagonista comienza con **3 puntos de vida**. Durante el recorrido puede reunir, entre otros objetos, un **amuleto**, un **mapa**, una **poción de vida**, **fragmentos de agua y fuego**, la **llave de fuego** y las **coronas de ambos elementos**. También pueden activarse mecanismos como la **compuerta de agua** o la **palanca de fuego**. Algunos elementos permiten escoger alternativas de combate más favorables.

- **Final bueno:** se consiguen las dos coronas y los dos fragmentos.
- **Final neutral:** se completa la aventura sin reunir todos los elementos necesarios para el final bueno.
- **Final malo:** se agota la vida y no queda una poción que evite la derrota.

Al finalizar una partida se muestran su **duración** y el **estado final del inventario**.

## Solución de problemas habituales

| Problema | Qué comprobar |
| --- | --- |
| No se encuentra `proyecto1.Main` | Ejecutar desde la **raíz correcta** y usar `java -cp out proyecto1.Main`, no `java Main`. |
| IntelliJ no reconoce el paquete | Verificar que `Main.java` está en `src/proyecto1/` y que `src` está marcada como **Sources Root**. |
| No aparece `javac` | Configurar un JDK y comprobar que sus herramientas están disponibles desde la terminal. |
| Aparece `cannot find symbol` al compilar | Comprobar que están presentes **los ocho archivos**, especialmente `Texto.java`. |
| El texto se muestra demasiado despacio | Elegir **Rápida** o **Instantánea** al inicio. |
| Los acentos se ven mal en la terminal | Revisar la codificación de la consola; el comando de compilación especifica UTF-8. |

## Repositorio del proyecto

El código fuente y la documentación se publican en: **[RelicQuest — GitHub](https://github.com/Valeria-Vi91/RelicQuest)**.

Como parte de los requisitos de entrega, este mismo enlace debe aparecer también **en un comentario de `Main.java`**:

```java
// Repositorio de GitHub: https://github.com/Valeria-Vi91/RelicQuest
```

---

**Relic Quest: El templo viviente** · Valeria Vivour y Elena Rodríguez · 1.º DAM · 2026-2027 comentario informativo en la clase principal Main.java.
