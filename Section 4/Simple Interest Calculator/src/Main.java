import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("Bienvenido al calculador de interes simple");
            System.out.println("1. Calculo de interes simple");
            System.out.println("2. Eliminar un calculo");
            System.out.println("3. Consultar por fechas");
            System.out.println("4. Historial de calculos");
            System.out.println("5. Salir del programa");
            System.out.print("Digita una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    //Calcular y luego insertar
                    System.out.print("Inserta el anno en que se empiezan a generar intereses: ");
                    double anno = sc.nextDouble();
                    System.out.print("Inserta el mes en que se empiezan a generar intereses: ");
                    double mes = sc.nextDouble();
                    System.out.print("Inserta el monto principal: ");
                    double monto = sc.nextDouble();
                    System.out.print("Inserta el interes anual: ");
                    double rate = sc.nextDouble();
                    System.out.print("Inserta el periodo de tiempo (en annos): ");
                    double tiempo = sc.nextDouble();
                    l.calcular(anno, mes, monto, rate, tiempo);
                    break;
                case 2:
                    //Eliminar
                    System.out.print("Inserta el anno del registro a eliminar: ");
                    double annoD = sc.nextDouble();
                    System.out.print("Inserta el mes del registro a eliminar: ");
                    double mesD = sc.nextDouble();
                    System.out.print("Inserta el monto principal del registro a eliminar: ");
                    double montoD = sc.nextDouble();
                    System.out.print("Inserta el interes anual del registro a eliminar: ");
                    double rateD = sc.nextDouble();
                    System.out.print("Inserta el periodo de tiempo (en annos) del registro a eliminar: ");
                    double tiempoD = sc.nextDouble();
                    System.out.print("Inserta el interes simple del registro a eliminar: ");
                    double interesD = sc.nextDouble();
                    l.eliminar(annoD, mesD, montoD, rateD, tiempoD, interesD);
                    break;
                case 3:
                    //Consultar
                    System.out.print("Digita el anno a consultar: ");
                    double annoC = sc.nextDouble();
                    System.out.print("Digita el mes a consultar: ");
                    double mesC = sc.nextDouble();
                    l.consultar(annoC, mesC);
                    break;
                case 4:
                    //Mostrar
                    l.mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
                    break;
            }
        } while (opc != 5);
    }
}