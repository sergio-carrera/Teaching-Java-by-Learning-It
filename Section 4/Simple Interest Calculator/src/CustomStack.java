import java.util.Stack;

public class CustomStack<Double> extends Stack<Double> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            if (i == 0) {
                sb.append("Anno: " + elementAt(i).toString() + "\n");
            } else if (i == 1) {
                sb.append("Mes: " + elementAt(i).toString() + "\n");
            } else if (i == 2) {
                sb.append("Monto: " + elementAt(i).toString() + "\n");
            } else if (i == 3) {
                sb.append("Rate: " + elementAt(i).toString() + "\n");
            } else if (i == 4) {
                sb.append("Tiempo: " + elementAt(i).toString() + "\n");
            } else if (i == 5) {
                sb.append("Interes simple: " + elementAt(i).toString() + "\n");
            }
        }
        return sb.toString();
    }
}
