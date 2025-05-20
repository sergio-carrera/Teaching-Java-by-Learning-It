# Simple Interest Calculator

En este ejercicio se construye un programa llamado Simple Interest Calculator en Java modificado con base a mis intereses y lo que solicita originalmente la cuarta sección del curso 60 Days of Java : The Complete Java Masterclass. 
El programa permite al usuario calcular el interés simple y añadir dicho cálculo a una lista enlazada, eliminar un cálculo, consultar por los cálculos en una fecha determinada y consultar por el historial de todos los cálculos.

---

## 📌 Instrucciones originales del ejercicio

Escribe un programa en Java que:
- Solicite al usuario: monto principal, tasa de interés anual y tiempo en años.
- Calcule el interés simple usando la fórmula:  
   `SI = (P × R × T) / 100`
- Muestre el resultado en consola.

---

## 🔧 Versión personalizada haciendo uso de una lista enlazada

- Se integró un **menú interactivo** con `do-while`, permitiendo:
  - Calcular interés simple (y registrar el cálculo)
  - Eliminar un cálculo específico
  - Consultar cálculos por fecha (año y mes)
  - Mostrar el historial completo de cálculos
- Se implementó una **lista enlazada simple** que almacena nodos cuyo dato es un **`CustomStack<Double>`**, una pila extendida con método `toString()` personalizado.
- Cada cálculo se registra en el `CustomStack` con la siguiente estructura:
  - Año
  - Mes
  - Monto
  - Tasa de interés
  - Tiempo (años)
  - Interés simple calculado

---

## 🧩 Clase `CustomStack<Double>`
```java
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size(); i++) {
        if (i == 0) sb.append("Año: ").append(elementAt(i)).append("\n");
        else if (i == 1) sb.append("Mes: ").append(elementAt(i)).append("\n");
        else if (i == 2) sb.append("Monto: ").append(elementAt(i)).append("\n");
        else if (i == 3) sb.append("Tasa de interés: ").append(elementAt(i)).append("\n");
        else if (i == 4) sb.append("Tiempo: ").append(elementAt(i)).append("\n");
        else if (i == 5) sb.append("Interés simple: ").append(elementAt(i)).append("\n");
    }
    return sb.toString();
}
```
Básicamente, cada cálculo almacenado en el CustomStacj siempre tendrá el mismo orden, es por eso que itero sobre el `size` del CustomStack para ir armando en orden el `StringBuilder` (año (i=0), mes (i=1), monto (i=2), tasa de interés (i=3), tiempo (i=4), interes (i=5)).

### 🪜 Estructura de la lista

Cada Nodo contiene:
- Un objeto CustomStack<Double> llamado dato, que básicamente es una clase personalizada que se extiende de Stack.
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

- `void calcular()`: Calcula el interés simple, muestra el resultado y lo registra en la lista enlazada.
```java
public void calcular(double anno, double mes, double monto, double rate, double tiempo) {
        try {
            //Cálculo del interés
            double interes = (monto * rate * tiempo) / 100;
            //Inserción en la lista enlazada
            CustomStack<Double> dato = new CustomStack<Double>();
            dato.push(anno);
            dato.push(mes);
            dato.push(monto);
            dato.push(rate);
            dato.push(tiempo);
            dato.push(interes);
            System.out.println("El interes simple es: " + interes + "\n");
            insertar(dato);
        } catch (Exception e) {
            System.out.println("Error en el método 'calcular': " + e.toString());
        }
    }
```

- `void insertar()`: Inserta un nodo al final de la lista.
```java
public void insertar(CustomStack<Double> dato) {
        try {
            Nodo actual = new Nodo(dato);
            if (estaVacia()) {
                inicio = fin = actual;
            } else {
                fin.siguiente = actual;
                actual.siguiente = null;
                fin = actual;
            }
            System.out.println("Se ha insertado correctamente el registro en la lista");
        } catch (Exception e) {
            System.out.println("Error en el método 'insertar': " + e.toString());
        }
    }
```
Este método se llama dentro del método `calcular()` en donde se arma el `CustomStack<Double> dato` que se ocupa para insertar al final de la lista enlazada.
El puntero siguiente del último nodo pasa a apuntar al nuevo nodo (actual), el puntero siguiente del nodo actual apunta a null y el puntero de final de la lista apunta al nuevo puntero (actual)

- `void eliminar(...)`: Busca y elimina un nodo que coincida exactamente con los argumentos del método.
```java
    public void eliminar(double anno, double mes, double monto, double rate, double tiempo, double interes) {
        try {
            if (estaVacia()) {
                System.out.println("La lista está vacía, no hay nada para eliminar");
                return;
            }

            CustomStack<Double> dato = new CustomStack<>();
            dato.push(anno);
            dato.push(mes);
            dato.push(monto);
            dato.push(rate);
            dato.push(tiempo);
            dato.push(interes);

            Nodo anterior = null;
            Nodo actual = inicio;

            while (actual != null) {
                if (actual.dato.equals(dato)) {
                    //En caso de que el nodo a eliminar sea el primero y único en la lista
                    if (actual == inicio && actual == fin) {
                        inicio = fin = null;
                        break;
                    //En caso de que el nodo a eliminar sea el primero pero no el único en la lista
                    } else if (actual == inicio) {
                        /*El nodo 'inicio' pasa a apuntar al nodo que estaba siendo apuntado por el nodo que estaba siendo
                        apuntado por el nodo 'inicio' (al segundo de la lista)*/
                        inicio = inicio.siguiente;
                        /*El nodo actual (con el que se recorre el bucle) ahora apunta al siguiente
                        nodo (que sería el segundo de la lista y el inicio de la misma)*/
                        actual = inicio;
                        /*Se continúa con el bucle para seguir buscando algún nodo que cumpla con los
                        argumentos (actual.dato.equals(dato)) para ser eliminado. Así que salto directamente al inicio
                        de la siguiente iteración del bucle, omitiendo cualquier código que venga después dentro del mismo ciclo*/
                        continue;
                    //En caso de que el nodo a eliminar sea el último en la lista
                    } else if (actual == fin) {
                        /*Si el nodo a eliminar es el final de la lista, entonces el nodo anterior apuntará a null para
                        que el Garbage Collector de Java elimine al nodo final que no está siendo referenciado.*/
                        anterior.siguiente = null;
                        //Y el nuevo fin de la lista apuntará al nodo anterior.
                        fin = anterior;
                        //Como ya no hay más nodos para seguir recorriendo la lista, entonces es necesario salirse del bucle.
                        break;
                    //En caso de que el nodo a eliminar esté en medio de la lista
                    } else {
                        /*Siendo este el último caso (else), lo que hacemos es que el puntero siguiente del nodo anterior, apunte
                        al nodo que estaba siendo apuntado por el nodo actual. Y como el nodo actual no será referenciado/apuntado por
                        ningún puntero, entonces será eliminado por el Garbage Collector de Java*/
                        anterior.siguiente = actual.siguiente;
                        //Es necesario actualizar al nodo actual por el nodo siguiente para seguir recorriendo la lista.
                        actual = actual.siguiente;
                        /*Se continúa con el bucle para seguir buscando algún nodo que cumpla con los
                        argumentos (actual.dato.equals(dato)) para ser eliminado. Así que salto directamente al inicio
                        de la siguiente iteración del bucle, omitiendo cualquier código que venga después dentro del mismo ciclo*/
                        continue;
                    }
                }
                /*En caso de que "actual.dato.equals(dato)" sea falso, lo que habría que hacer es actualizar el anterior para que sea el actual, y
                el actual para que sea el siguiente.*/
                anterior = actual;
                actual = actual.siguiente;
            }

           System.out.println("Se ha eliminado el registro correctamente");

        } catch (Exception e) {
            System.out.println("Error en el método 'eliminar': " + e.toString());
        }
    }
```

- `void consultar()`: Muestra todos los cálculos registrados en el año y mes especificados.
```java
public void consultar(double anno, double mes) {
        try {
            if (estaVacia()) {
                System.out.println("La lista esta vacia, no hay nada para mostrar");
            }else {
                boolean habia = false;
                Nodo temporal = inicio;
                while (temporal != null) {
                    if (temporal.dato.search(anno) > 0 && temporal.dato.search(mes) > 0) {
                        System.out.println(temporal.dato.toString());
                        habia = true;
                    }
                    temporal = temporal.siguiente;
                }
                if (!habia) {
                    System.out.println("No hay ningun registro con ese anno y mes");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el método 'consultar': " + e.toString());
        }
    }
```
Haciendo uso del método `.search()` de las pilas en Java, puedo saber si el valor que estoy recorriendo en el bucle tiene el año y el mes registrado (ya que `.search()` devuelve -1 (<0) si no encuentra la posición del valor en la pila).

- `void consultar()`: Muestra todo el historial de cálculos registrados.
```java
public void mostrar() {
        try {
            if (estaVacia()) {
                System.out.println("La lista esta vacia, no hay nada para mostrar");
            } else {
                Nodo temporal = inicio;
                while (temporal != null) {
                    System.out.println(temporal.dato.toString());
                    temporal = temporal.siguiente;
                }

            }
        } catch (Exception e) {
            System.out.println("Error en el método 'mostrar': " + e.toString());
        }
    }
```
Hago uso del método @Override `toString()` de la clase CustomStack para imprimir formateadamente cada registro.

---

A manera de resumen, esta versión personalizada del ejercicio Simple Interest Calculator combina estructuras de datos como listas enlazadas, manipulación de clases personalizadas (como CustomStack) y lógica condicional para llevar un control detallado y ordenado de los cálculos de interés simple por fecha.
Me pareció una excelente oportunidad para practicar la lógica detrás de las listas enlazadas. Tanto así, que preparé otros ejercicios relacionados con listas enlazadas en secciones posteriores (●'◡'●).
Próximamente con listas enlazadas: Linked List and Stack challenge ╰(*°▽°*)╯
