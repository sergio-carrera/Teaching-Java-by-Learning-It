import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista l = new Lista();
        System.out.println("Bienvenido al Calorie counter pro!");
        int opc = 0;
        do {
            System.out.println("1. Ingresar dato");
            System.out.println("2. Consultar todos los datos");
            System.out.println("3. Consultar suma total de las calorias");
            System.out.println("4. Salir del programa");
            System.out.print("Ingresa una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese el nombre de la comida: ");
                    String foodName = sc.nextLine();
                    System.out.print("Ingresa las calorias de la comida: ");
                    double calories = sc.nextDouble();
                    System.out.print("Ingresa el numero de la semana del mes: ");
                    int weekNum = sc.nextInt();
                    System.out.print("Ingresa el dia de la semana: ");
                    int dayOfWeekNum = sc.nextInt();
                    Food dato = new Food(foodName, calories, weekNum, dayOfWeekNum);
                    l.insertarOrdenadamente(dato);
                    break;
                case 2:
                    l.mostrar();
                    break;
                case 3:
                    l.suma();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }

        } while (opc != 4);
    }
}