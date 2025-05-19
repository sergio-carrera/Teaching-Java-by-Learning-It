# Shape Transformation | Variable Manipulation and Data Types in Java

En la segunta sección del curso, nos dan una introducción breve sobre los tipos de datos en Java y cómo inicializar variables.

Existen 2 categorías de tipos de datos en Java:

## 1. Datos primitivos (primitive data types)
- `boolean`: Representa un valor lógico, verdadero (`true`) o falso (`false`). Ideal para condiciones y banderas lógicas.
- `byte`: Entero de 8 bits. Rango: -128 a 127. Útil cuando se desea ahorrar memoria.
- `short`: Entero de 16 bits. Rango: -32,768 a 32,767.
- `int`: Entero de 32 bits. Es el tipo entero más común.
- `long`: Entero de 64 bits. Se usa para valores numéricos muy grandes.
- `float`: Número decimal de 32 bits. Menor precisión que double. Se declara con una f al final (ej: 3.14f).
- `double`: Número decimal de 64 bits. Mayor precisión para representar valores decimales.
- `char`: Representa un único carácter Unicode, entre comillas simples (ej: 'A').

## 2. Datos de referencia (reference data types)
Los datos de referencia almacenan direcciones de memoria en lugar de los valores directamente. Se usan para representar objetos, arreglos, clases y más.
Algunos ejemplos:
- `String`: Para representar cadenas de texto.
- Arreglos (arrays): `int[]`, `String[]`, etc.
- Clases definidas por el usuario.
- Objetos de bibliotecas estándar como `Scanner`, `Random`, `ArrayList`, etc.

## Wrapper Classes

Los wrapper classes en Java son representaciones en forma de objeto de los tipos primitivos. Esto es útil porque muchas estructuras de datos en Java (como `ArrayList`) requieren objetos en lugar de tipos primitivos.

Cada tipo primitivo tiene su correspondiente wrapper class:

| Primitivo | Wrapper Class |
| --------- | ------------- |
| `int`     | `Integer`     |
| `double`  | `Double`      |
| `char`    | `Character`   |
| `boolean` | `Boolean`     |
| `byte`    | `Byte`        |
| `short`   | `Short`       |
| `long`    | `Long`        |
| `float`   | `Float`       |

Los wrapper classes permiten:

-Tratar los valores primitivos como objetos.
-Usar métodos útiles (como `parseInt`, `toString`, `compareTo`, etc.).
-Utilizarlos en estructuras como ArrayList, HashMap, y otros contenedores de objetos.

### Tabla de tipos de datos en Java:

| Tipo Primitivo | Wrapper Class | Ejemplo de Declaración         | Ejemplo de Uso                              |
| -------------- | ------------- | ------------------------------ | ------------------------------------------- |
| `boolean`      | `Boolean`     | `boolean activo = true;`       | `if (activo) { System.out.println("On"); }` |
| `byte`         | `Byte`        | `byte edad = 25;`              | `System.out.println(edad);`                 |
| `short`        | `Short`       | `short temperatura = 1500;`    | `short s = Short.parseShort("123");`        |
| `int`          | `Integer`     | `int numero = 100;`            | `Integer suma = numero + 10;`               |
| `long`         | `Long`        | `long estrellas = 999999999L;` | `Long l = Long.valueOf(estrellas);`         |
| `float`        | `Float`       | `float pi = 3.14f;`            | `System.out.println(pi * 2);`               |
| `double`       | `Double`      | `double promedio = 89.6;`      | `Double d = Double.parseDouble("23.5");`    |
| `char`         | `Character`   | `char letra = 'A';`            | `Character.isLetter(letra);`                |

### Métodos útiles en Wrapper Classes:

`Integer.parseInt("123")` → Convierte texto a entero.
`Double.toString(3.14)` → Convierte número a string.
`Character.isDigit('5')` → Verifica si el carácter es un dígito.
`Boolean.parseBoolean("true")` → Convierte texto a booleano.

---

## 📌 Ejercicio 1: Shape Transformation - Instrucciones:

Crea un programa que:

1. Solicite al usuario un valor de tipo `double`.
2. Imprima el valor inicial como `double`.
3. Convierta y muestre ese valor en otros tipos primitivos numéricos:
   - `int`
   - `long`
   - `float`
   - `byte`
   - `short`

---

## 📌 Ejercicio 2: Variable Manipulation and Data Types - Instrucciones:

🧱 **No modifiques el código base proporcionado (a menos que se indique lo contrario).** Solo agrega tu solución dentro de la estructura dada.

Crea un programa en Java que:

1. Declare e inicialice variables de tipo:
   - `int`
   - `double`
   - `char`
   - `boolean`
   - `String`
2. Realice operaciones aritméticas básicas con variables numéricas.
3. Demuestre **typecasting** convirtiendo un `double` a `int`.
4. Manipule Strings concatenando frases.
5. Demuestre una operación booleana usando negación (`!`).
