import java.util.Stack;

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
                    if (actual == inicio && actual == fin) {
                        inicio = fin = null;
                        break;
                    } else if (actual == inicio) {
                        inicio = inicio.siguiente;
                        actual = inicio;
                        continue;
                    } else if (actual == fin) {
                        anterior.siguiente = null;
                        fin = anterior;
                        break;
                    } else {
                        anterior.siguiente = actual.siguiente;
                        actual = actual.siguiente;
                        continue;
                    }
                }
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
