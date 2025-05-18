import java.util.Stack;

public class Nodo {
    public Nodo siguiente;
    public CustomStack<Double> dato;

    public Nodo (CustomStack<Double> dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
