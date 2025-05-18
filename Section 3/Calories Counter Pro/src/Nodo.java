public class Nodo {
    public Nodo siguiente;
    public Food dato;

    public Nodo(Food dato) {
        this.siguiente = null;
        this.dato = dato;
    }
}
