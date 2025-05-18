public class Lista {
    public Nodo inicio;
    public Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    private int comparar(Food a, Food b) {
        if (a.weekNum != b.weekNum) {
            return a.weekNum - b.weekNum;
        } else {
            return  a.dayOfWeekNum - b.dayOfWeekNum;
        }
    }

    public void insertarOrdenadamente(Food dato) {
        try {
            Nodo actual = new Nodo(dato);

            //Insertar valor si es el primero de la lista
            if (estaVacia()) {
                inicio = fin = actual;
                return;
            }

            //Insertar valor si esta antes del primero de la lista
            if (comparar(dato, inicio.dato) < 0) {
                actual.siguiente = inicio;
                inicio = actual;
                return;
            }

            //Mover un puntero temporal para definir el campo de ingreso del nuevo dato
            Nodo temporal = inicio;
            while (temporal.siguiente != null && comparar(dato, temporal.siguiente.dato) >= 0) {
                temporal = temporal.siguiente;
            }

            /*
            Una vez que el puntero temporal marque el campo específico para ingresar el nuevo nodo, lo que hay que hacer
            es definir que el nuevo nodo apunte al nodo que está delante del nodo que queremos reemplazar, mientras que
            el nodo que queremos mover para atrás, ahora apuntará al nuevo nodo.

            Nodo1(weekInt = 1, dayOfWeek = 2) -> Nodo2(weekInt = 1, dayOfWeek = 5)
            Queremos insertar a: Nodo3(weekInt = 1, dayOfWeek = 3)

            Primero, con 'actual.siguiente = temporal.siguiente;'
            Lo que hacemos es que la lista pase a estar así:

            Nodo1(weekInt = 1, dayOfWeek = 2) ->
                                                Nodo2(weekInt = 1, dayOfWeek = 5)
            Nodo3(weekInt = 1, dayOfWeek = 3) ->

            Y lo que hacemos con 'temporal.siguiente = actual;' es que el Nodo1 apunte al nuevo Nodo3 para volver al
            formato de la lista:

            Nodo1(weekInt = 1, dayOfWeek = 2) -> Nodo3(weekInt = 1, dayOfWeek = 3) -> Nodo2(weekInt = 1, dayOfWeek = 5)
            */
            actual.siguiente = temporal.siguiente;
            temporal.siguiente = actual;

            //En caso de que se inserte al final
            if (actual.siguiente == null) {
                fin = actual;
            }

            System.out.println("Se ha ingresado correctamente el dato para la semana " + dato.weekNum + " y día " + dato.dayOfWeekNum);
        } catch (Exception e) {
            System.out.println("Error en el metodo de insertarOrdenadamente: " + e.toString());
        }
    }

    public void mostrar() {
        try {
            if (estaVacia()) {
                System.out.println("Todavia no se han ingresado valores");
            } else {
                Nodo temporal;
                temporal = inicio;
                while (temporal != null) {
                    System.out.println(temporal.dato.toString());
                    temporal = temporal.siguiente;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error en el metodo mostrar: " + ex.toString());
        }
    }

    public void suma() {
        try {
            if (estaVacia()) {
                System.out.println("No hay comidas registradas para realizar la suma total de calorias");
            } else {
                double suma = 0;
                Nodo temporal;
                temporal = inicio;
                while (temporal != null) {
                    suma += temporal.dato.calories;
                    temporal = temporal.siguiente;
                }
                System.out.println("La suma total de calorias de todas las comidas es: " + suma);
            }
        } catch (Exception ex) {
            System.out.println("Error en el metodo mostrar: " + ex.toString());
        }
    }

}
