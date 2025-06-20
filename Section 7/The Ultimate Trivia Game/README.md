# The Ultimate Trivia Game

La idea nació con la intención de crear un sistema de trivia que combine diferentes niveles de dificultad, categorías variadas, y que permita practicar la lógica orientada a objetos, estructuras condicionales y el manejo de 
listas dinámicas en Java. 

---

## 📌 Objetivo original (modificado a partir de ejercicios básicos)

Crea un programa en Java que:

- Haga preguntas de selección múltiple al usuario.
- Valide si la respuesta ingresada es correcta.
- Lleve control del puntaje o vidas del jugador.
- Finalice el juego cuando se completen las preguntas o se agoten las vidas.

## 🚀 Desafíos añadidos

- Cargar preguntas dinámicamente desde un archivo JSON.
- Clasificar preguntas por categoría y dificultad.
- Implementar una lógica que aumente la dificultad si el usuario responde incorrectamente.
- Mostrar al final un resumen detallado de las respuestas.
- Aplicar principios de diseño limpio, clases separadas y uso de estructuras como List, Map, Enum, etc.

---

## 🧩 Lógica personalizada y funcionalidades

La trivia se compone de preguntas almacenadas en un archivo JSON, las cuales son desordenadas al inicio para garantizar una experiencia distinta cada vez.
Cada pregunta tiene los siguientes atributos:

```java
String enunciado;
Map<Integer, String> opciones;
int respuestaCorrecta;
Categoria categoria;
Dificultad dificultad;
boolean haSidoRespondida;
int haSidoRespondidaCorrectamente; //1 = correcta, 2 = incorrecta, 0 = todavía no se responde
```

## 🧠 Mecánica del juego

- El jugador inicia con 3 vidas.
- Si responde bien, avanza a la siguiente pregunta.
- Si responde mal, pierde una vida y el juego busca una pregunta más difícil de la misma categoría.
- El juego termina cuando se responden todas las preguntas o cuando se pierden todas las vidas.
- Al final se muestra un resumen con todas las preguntas y su resultado.

---

## ⚙️ Clases principales y su función:

- `Main`: Es la clase principal que orquesta el flujo del juego. Gestiona las vidas del jugador, controla la interacción con las preguntas a través de un bucle principal y maneja la lógica de avance o fin del juego.

- `Controlador`: Contiene la lógica central del juego. Se encarga de:
  - `inicializarPreguntas()`: Carga las preguntas desde el archivo preguntas.json utilizando la librería Gson y las mezcla aleatoriamente.
  - `validarRespuesta(Pregunta pregunta, Integer respuesta)`: Verifica si la respuesta proporcionada por el usuario es correcta para una pregunta dada.
  - `complicarPregunta(int j, int i)`: Implementa la lógica para buscar una pregunta más difícil de la misma categoría después de una respuesta incorrecta. Prioriza preguntas difíciles, luego normales y finalmente fáciles dentro de la misma categoría.

- `Pregunta`: Modela una pregunta individual. Sus atributos incluyen:
  - `enunciado`: El texto de la pregunta.
  - `opciones`: Un Map que asocia números de opción con sus respectivos textos.
  - `respuestaCorrecta`: El número de la opción correcta.
  - `categoria`: La categoría a la que pertenece la pregunta (e.g., Programación, Filosofía).
  - `dificultad`: El nivel de dificultad de la pregunta (e.g., FÁCIL, NORMAL, DIFÍCIL).
  - `haSidoRespondida`: Un booleano que indica si la pregunta ya fue intentada.
  - `haSidoRespondidaCorrectamente`: Un entero (1 para correcta, 2 para incorrecta) para el resumen final.
  - Cuenta con un método `toString()` sobrescrito para una presentación clara de la pregunta y sus opciones.

- `Mensaje`: Una clase utilitaria con métodos estáticos para mostrar mensajes al usuario en la consola, incluyendo la bienvenida, mensajes de victoria/derrota, notificaciones de pérdida de vida, y el resumen de resultados.

---

## 📚 Enums utilizados

Se implementaron enumeraciones para categorizar y definir el nivel de dificultad de cada pregunta:

```java
public enum Categoria {
    PROGRAMACION,
    FILOSOFIA,
    AJEDREZ,
    LIES_OF_P
}
```

```java
public enum Dificultad {
    FACIL,
    NORMAL,
    DIFICIL
}
```

---

## 🧠 Ejemplo de una pregunta en el archivo JSON

```json
{
  "enunciado": "¿Cuál es el valor de una variable int sin inicializar en Java?",
  "opciones": {
    "1": "0",
    "2": "null",
    "3": "1",
    "4": "Depende del compilador"
  },
  "respuestaCorrecta": 1,
  "categoria": "PROGRAMACION",
  "dificultad": "NORMAL",
  "haSidoRespondida": false,
  "haSidoRespondidaCorrectamente": 0
}
```

---

Veo un gran potencial para desarrollar una especie de creador de quizzes dinámico y sencillo que se pueda ejecutar de manera local, tanto en la computadora como en el celular. 
Esto permitiría a cualquier usuario generar sus propias trivias personalizadas con facilidad, ampliando significativamente la utilidad y la interactividad de la base de este juego. (●'◡'●) (quizás enn un futuro lo haga)

