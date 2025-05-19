_¿Realmente lo quieres? ¿O solo quieres que otros vean que lo tienes?_

# Displaying Text with Java and Escape Sequences

Este es el primer proyecto del repositorio Teaching Java by Learning It, una introducción creativa al uso de `System.out.print`, `System.out.println` y secuencias de escape en Java.
En lugar de limitarse al típico "Hola Mundo", este ejercicio explora cómo darle vida a la consola con arte ASCII, interacción con el usuario y un efecto visual llamado efecto espejo.
Es proyecto forma parte de la primera sección del curso 60 Days of Java : The Complete Java Masterclass.

---

## 📌 Instrucciones originales del ejercicio
Crear un programa en Java que:

1. Solicite al usuario un mensaje.
2. Lo imprima usando tanto `System.out.println()` como `System.out.print()` para demostrar su diferencia.
3. Muestre un mensaje adicional que use secuencias de escape como \n y \" para incluir formato especial (nuevas líneas y comillas).

El programa debe:

1. Usar `Scanner` para capturar la entrada del usuario.
2. Usar ambos métodos de salida (`print` y `println`).
3. Usar correctamente secuencias de escape para formatear el texto.

---

## 📌 Modificación del ejercicio:
Añado a la mesa ciertas complejidades, tales como:

1. Imprimir la siguiente imagen en arte ASCII usando `print` y secuencias de escape.
   ![imagen](Section%201/Displaying%20Text%20with%20Java%20and%20Escape%20Sequences/imgs/section1_img1.jpg)
3. Aprovechar la pregunta de la imagen para capturar la respuesta del usuario.
4. Guardar la respuesta usando `Scanner`.
5. Imprimir la respuesta usando `println` y `print`.
6. Revertir el arte ASCII con un efecto espejo.

Consideraciones del nuevo reto:

1. Se debe invertir horizontalmente (efecto espejo) el arte ASCII, reconstruyendo las frases significativas para que que sean legibles.

---

## 🚀 ¿Qué se puede aprender con este ejercicio?

- Cómo imprimir texto con formato en consola.
- Cómo usar `System.out.print` vs. `System.out.println`.
- Uso de secuencias de escape para mejorar la visualización.
- Cómo solicitar y manejar entradas del usuario con `Scanner`.
- Cómo invertir strings manualmente. Sin utilizar el método `.reverse()` de un `StringBuilder` o `StringBuffer`. 
- Cómo usar `HashMap` para mapear versiones invertidas de oraciones y restaurarlas al reflejarlas.
- Cómo trabajar con arrays para representar líneas de arte ASCII.
