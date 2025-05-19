# Calories Counter Pro

En este ejercicio se conmstruye un programa llamado Calorie Counter Pro en Java modificado con base a mis intereses. 
El programa permite al usuario ingresar alimentos junto a su valor calórico, calcular la ingesta total y mostrar un resumen de los alimentos usando una lista enlazada como estructura de datos de cada resgistro.

---

## 📌 Instrucciones originales del ejercicio

- Crea un programa en Java que:
- Solicite al usuario el nombre de tres alimentos.
- Pida las calorías correspondientes a cada uno.
- Calcule la suma total de calorías.
- Muestre un resumen de los alimentos con sus respectivas calorías.

### 🚀 Desafíos Extra

- Permitir más de tres alimentos (usar bucles).
- Mejorar formato de salida usando printf().
- Agregar recomendaciones según el total de calorías.
- Almacenar registros de varios días/semanas.

---

## 🔧 Versión personalizada haciendo uso de una lista enlazada

Se implementó un menú interactivo utilizando do-while, que permite:
- Ingresar alimentos con sus calorías en un orden basado en la semana y día de semana.
- Consultar todos los registros.
- Calcular la suma total de calorías.
- Se utilizó una lista enlazada para almacenar objetos de tipo Food con los atributos:
```java
String foodName;
double calories;
int weekNum;
int dayOfWeekNum;
```
- Con un método sobrescrito toString() para mostrar los datos:
```java
return "Food Name: " + foodName + "\n" + "Calories: " + calories + "\n" + "Week: " + weekNum + "\n" + "Day of Week: " + dayOfWeekNum + "\n";
```

### 🪜 Estructura de la lista
Cada Nodo contiene:
- Un objeto Food llamado dato.
- Un puntero siguiente.
La lista posee dos punteros principales: inicio y fin.

### 🧐 Métodos implementados en la lista
- `boolean estaVacia()`: Determina si la lista está vacía.
```java
public boolean estaVacia() {
    return inicio == null;
}
```
Verifica si el nodo inicio está en null. Si es así, no hay elementos.

- `void insertarOrdenadamente(Food dato)`: Inserta el nuevo alimento en orden, según semana y día.
```java
public void insertarOrdenadamente(Food dato) {
    Nodo actual = new Nodo(dato);

    if (estaVacia()) {
        inicio = fin = actual;
        return;
    }

    if (comparar(dato, inicio.dato) < 0) {
        actual.siguiente = inicio;
        inicio = actual;
        return;
    }

    Nodo temporal = inicio;
    while (temporal.siguiente != null && comparar(dato, temporal.siguiente.dato) >= 0) {
        temporal = temporal.siguiente;
    }

    actual.siguiente = temporal.siguiente;
    temporal.siguiente = actual;

    if (actual.siguiente == null) {
        fin = actual;
    }
}
```
Este método inserta el nuevo nodo en el lugar correcto para mantener el orden por semana y día. Si va al inicio o al final, actualiza los punteros inicio o fin.
Utilizo el método `comparar(Food a, Food b)` para obtener la ubicación correcta para insertar el nuevo nodo de manera ordenada.

- `int comparar(Food a, Food b)`: Compara dos objetos Food para definir su orden.
```java
private int comparar(Food a, Food b) {
    if (a.weekNum != b.weekNum) {
        return a.weekNum - b.weekNum;
    } else {
        return a.dayOfWeekNum - b.dayOfWeekNum;
    }
}
```
Primero compara por semana. Si es igual, compara por día.

- `int comparar(Food a, Food b)`: Compara dos objetos Food para definir su orden.
```java
private int comparar(Food a, Food b) {
    if (a.weekNum != b.weekNum) {
        return a.weekNum - b.weekNum;
    } else {
        return a.dayOfWeekNum - b.dayOfWeekNum;
    }
}
```
Primero compara por semana. Si es igual, compara por día.

- `void mostrar()`: Muestra todos los alimentos registrados.
```java
public void mostrar() {
    if (estaVacia()) {
        System.out.println("Todavía no se han ingresado valores");
    } else {
        Nodo temporal = inicio;
        while (temporal != null) {
            System.out.println(temporal.dato.toString());
            temporal = temporal.siguiente;
        }
    }
}
```
Recorre la lista enlazada e imprime cada Food usando su método toString() que con anterioridad cambiamos con @Override.

- `void suma()`: Suma el total de calorías registradas.
```java
public void suma() {
    if (estaVacia()) {
        System.out.println("No hay comidas registradas para realizar la suma total de calorías");
    } else {
        double suma = 0;
        Nodo temporal = inicio;
        while (temporal != null) {
            suma += temporal.dato.calories;
            temporal = temporal.siguiente;
        }
        System.out.println("La suma total de calorías es: " + suma);
    }
}
```
 Recorre la lista sumando el atributo calories de cada objeto Food e imprime el valor de la variable de la suma total de dichas calorias.

---

A manera de resumen, esta versión personalizada del ejercicio Calories Counter Pro, combina estructuras de datos (listas enlazadas), manipulación de clases personalizadas (Food) y lógica de ordenamiento para llevar un control detallado y ordenado de la ingesta calórica por día y semana.
Me pareció una buena idea practicar la lógica de las listas enlazadas. Tanto así, que preparé otros ejercicios con listas enlazadas en secciones posteriores (●'◡'●).
