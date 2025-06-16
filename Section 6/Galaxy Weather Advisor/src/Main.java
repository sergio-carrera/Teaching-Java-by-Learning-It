import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GalaxyWeatherAdvisor advisor = new GalaxyWeatherAdvisor();
        int opc;

        do {
            System.out.println("\n--- HAL 9000: Galaxy Weather Advisor ---");
            System.out.println("1. Consultar clima planetario");
            System.out.println("2. Añadir nuevo planeta");
            System.out.println("3. Actualizar información de planeta");
            System.out.println("4. Eliminar planeta");
            System.out.println("5. Mostrar todos los planetas");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                sc.next();
                System.out.print("Seleccione una opción: ");
            }
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    advisor.consultarClimaPlanetario(sc);
                    break;
                case 2:
                    advisor.agregarNuevoPlaneta(sc);
                    break;
                case 3:
                    advisor.actualizarInfoPlaneta(sc);
                    break;
                case 4:
                    advisor.eliminarPlaneta(sc);
                    break;
                case 5:
                    advisor.mostrarTodosPlanetas();
                    break;
                case 6:
                    System.out.println("Cerrando Galaxy Weather Advisor. ¡HAL 9000 te desea un viaje seguro >:D!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opc != 6);
        sc.close();
    }
}