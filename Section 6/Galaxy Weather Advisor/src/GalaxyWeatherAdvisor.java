import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GalaxyWeatherAdvisor {
    private final Map<String, Planet> planetas; //HashMap para almacenar los planetas

    public GalaxyWeatherAdvisor() {
        planetas = new HashMap<>();
        //Para cargar registros predeterminados (imaginemos que más personas han usado la versión de GalaxyWeatherAdvisor de HAL 9000)
        inicializarPlanetasPredeterminados();
    }

    private void inicializarPlanetasPredeterminados() {
        //Tierra
        Planet tierra = new Planet("Tierra");
        tierra.agregarAvisoBasadoEnTemperatura(-10, new String[]{"Abrigo pesado, guantes, gorro.", "Riesgo de hipotermia extrema. Evitar exposición prolongada."});
        tierra.agregarAvisoBasadoEnTemperatura(0, new String[]{"Abrigo, bufanda, gorro.", "Cuidado con el hielo. Posible congelación leve."});
        tierra.agregarAvisoBasadoEnTemperatura(10, new String[]{"Chaqueta ligera, suéter.", "Clima fresco. Disfruta de actividades al aire libre."});
        tierra.agregarAvisoBasadoEnTemperatura(20, new String[]{"Ropa ligera, camiseta.", "Clima templado. Ideal para salir."});
        tierra.agregarAvisoBasadoEnTemperatura(30, new String[]{"Ropa muy ligera, protector solar, sombrero.", "Alto calor. Mantente hidratado y busca sombra."});
        planetas.put(tierra.getName().toLowerCase(), tierra);

        //Marte
        Planet marte = new Planet("Marte");
        marte.agregarAvisoBasadoEnTemperatura(-100, new String[]{"Traje espacial con calefacción avanzada, sistema de soporte vital.", "Temperaturas extremadamente bajas. Despresurización fatal."});
        marte.agregarAvisoBasadoEnTemperatura(-50, new String[]{"Traje espacial con sistema de calefacción.", "Frío intenso. Posible daño en equipos sin protección térmica."});
        marte.agregarAvisoBasadoEnTemperatura(0, new String[]{"Traje espacial avanzado.", "Temperaturas bajo cero. La atmósfera es muy delgada."});
        marte.agregarAvisoBasadoEnTemperatura(10, new String[]{"Traje espacial con refrigeración.", "Posible derretimiento de hielo superficial en ecuador durante verano."});
        planetas.put(marte.getName().toLowerCase(), marte);

        //Venus
        Planet venus = new Planet("Venus");
        venus.agregarAvisoBasadoEnTemperatura(400, new String[]{"Traje de protección térmica extremo, escudo de ácido.", "Condiciones infernales. Lluvia de ácido sulfúrico. Evitar a toda costa."});
        venus.agregarAvisoBasadoEnTemperatura(450, new String[]{"Traje de exploración atmosférica de alta resistencia.", "Presión atmosférica aplastante y calor extremo. Imposible sobrevivir sin equipo especializado."});
        planetas.put(venus.getName().toLowerCase(), venus);

        //Júpiter
        Planet jupiter = new Planet("Júpiter");
        jupiter.agregarAvisoBasadoEnTemperatura(-150, new String[]{"Nave espacial ultra-resistente al calor y la presión.", "Gases hirvientes, tormentas colosales. Solo observación desde órbita segura."});
        planetas.put(jupiter.getName().toLowerCase(), jupiter);
    }

    public void consultarClimaPlanetario(Scanner scanner) {
        System.out.print("Ingrese el nombre del planeta (ej. Tierra, Marte): ");
        String planetName = scanner.nextLine().toLowerCase().trim();

        if (!planetas.containsKey(planetName)) {
            System.out.println("Lo sentimos, no tenemos información climática para '" + planetName + "'. Por favor, intente con otro planeta o añádalo.");
            return;
        }

        Planet planet = planetas.get(planetName);
        System.out.print("Ingrese la temperatura actual en Celsius para " + planet.getName() + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número para la temperatura.");
            scanner.next();
            System.out.print("Ingrese la temperatura actual en Celsius para " + planet.getName() + ": ");
        }
        double temperature = scanner.nextDouble();
        scanner.nextLine();

        String[] advice = planet.obtenerAvisoBasadoEnTemperatura(temperature);
        System.out.println("\n--- Asesoramiento Climático para " + planet.getName() + " a " + temperature + "°C ---");
        System.out.println("Vestimenta: " + advice[0]);
        System.out.println("Precauciones: " + advice[1]);
    }

    public void agregarNuevoPlaneta(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo planeta: ");
        String planetName = scanner.nextLine().toLowerCase().trim();

        if (planetas.containsKey(planetName)) {
            System.out.println("El planeta '" + planetName + "' ya existe. Por favor, use la opción de actualizar.");
            return;
        }

        Planet newPlanet = new Planet(planetName);
        System.out.println("Agregando rangos de temperatura y consejos para " + newPlanet.getName() + ".");
        System.out.println("Puede agregar múltiples rangos. Ingrese 'fin' como temperatura para terminar.");

        while (true) {
            System.out.print("Ingrese el umbral de temperatura en Celsius (ej. -10, 0, 20) o 'fin' para terminar: ");
            String tempInput = scanner.nextLine().trim();

            if (tempInput.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                int threshold = Integer.parseInt(tempInput);
                System.out.print("Ingrese el consejo de vestimenta para " + threshold + "°C y superiores: ");
                String clothingAdvice = scanner.nextLine();
                System.out.print("Ingrese las precauciones para " + threshold + "°C y superiores: ");
                String precautions = scanner.nextLine();
                newPlanet.agregarAvisoBasadoEnTemperatura(threshold, new String[]{clothingAdvice, precautions});
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida para la temperatura. Por favor, ingrese un número entero o 'fin'.");
            }
        }

        planetas.put(newPlanet.getName().toLowerCase(), newPlanet);
        System.out.println("Planeta '" + newPlanet.getName() + "' añadido exitosamente.");
    }

    public void actualizarInfoPlaneta(Scanner scanner) {
        System.out.print("Ingrese el nombre del planeta a actualizar: ");
        String planetName = scanner.nextLine().toLowerCase().trim();

        if (!planetas.containsKey(planetName)) {
            System.out.println("El planeta '" + planetName + "' no existe en nuestra base de datos.");
            return;
        }

        Planet planetToUpdate = planetas.get(planetName);
        System.out.println("Actualizando información para " + planetToUpdate.getName() + ".");
        System.out.println("1. Añadir/Actualizar consejo de temperatura existente.");
        System.out.println("2. Eliminar consejo de temperatura.");
        System.out.print("Seleccione una opción de actualización: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next();
            System.out.print("Seleccione una opción de actualización: ");
        }
        int updateOption = scanner.nextInt();
        scanner.nextLine();

        switch (updateOption) {
            case 1:
                System.out.print("Ingrese el umbral de temperatura a añadir/actualizar (ej. 10): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scanner.next();
                    System.out.print("Ingrese el umbral de temperatura a añadir/actualizar: ");
                }
                int threshold = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese el NUEVO consejo de vestimenta: ");
                String newClothing = scanner.nextLine();
                System.out.print("Ingrese las NUEVAS precauciones: ");
                String newPrecautions = scanner.nextLine();
                planetToUpdate.agregarAvisoBasadoEnTemperatura(threshold, new String[]{newClothing, newPrecautions});
                System.out.println("Consejo de temperatura actualizado/añadido para " + planetToUpdate.getName() + ".");
                break;
            case 2:
                System.out.print("Ingrese el umbral de temperatura a eliminar: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scanner.next();
                    System.out.print("Ingrese el umbral de temperatura a eliminar: ");
                }
                int thresholdToRemove = scanner.nextInt();
                scanner.nextLine();
                if (planetToUpdate.removerAvisoBasadoEnTemperatura(thresholdToRemove)) {
                    System.out.println("Consejo de temperatura para " + thresholdToRemove + "°C eliminado de " + planetToUpdate.getName() + ".");
                } else {
                    System.out.println("No se encontró consejo para " + thresholdToRemove + "°C en " + planetToUpdate.getName() + ".");
                }
                break;
            default:
                System.out.println("Opción de actualización no válida.");
        }
    }

    public void eliminarPlaneta(Scanner scanner) {
        System.out.print("Ingrese el nombre del planeta a eliminar: ");
        String planetName = scanner.nextLine().toLowerCase().trim();

        if (planetas.containsKey(planetName)) {
            planetas.remove(planetName);
            System.out.println("El planeta '" + planetName + "' ha sido eliminado exitosamente.");
        } else {
            System.out.println("El planeta '" + planetName + "' no existe en nuestra base de datos.");
        }
    }

    public void mostrarTodosPlanetas() {
        if (planetas.isEmpty()) {
            System.out.println("No hay planetas registrados en la base de datos.");
            return;
        }
        System.out.println("\n--- Todos los Planetas Registrados ---");
        for (Planet planet : planetas.values()) {
            System.out.println(planet.toString());
            System.out.println("-------------------------------------");
        }
    }
}