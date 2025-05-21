public class Lista {
    public Nodo inicio;
    public Nodo fin;

    public Lista () {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return  false;
        }
    }

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
}
