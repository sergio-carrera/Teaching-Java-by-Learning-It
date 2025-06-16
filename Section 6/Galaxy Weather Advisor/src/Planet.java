import java.util.Map;
import java.util.TreeMap;

public class Planet {
    private final String name;
    //TreeMap: Clave = umbral de temperatura, Valor = [consejoVestimenta, precauciones]
    private final TreeMap<Integer, String[]> temperatureAdvice;

    public Planet(String name) {
        this.name = name;
        this.temperatureAdvice = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    //Añade o actualiza un consejo de temperatura
    public void agregarAvisoBasadoEnTemperatura(int temperatureThreshold, String[] advice) {
        this.temperatureAdvice.put(temperatureThreshold, advice);
    }

    //Elimina un consejo de temperatura
    public boolean removerAvisoBasadoEnTemperatura(int temperatureThreshold) {
        return this.temperatureAdvice.remove(temperatureThreshold) != null;
    }

    //Obtiene el consejo adecuado para una temperatura dada
    public String[] obtenerAvisoBasadoEnTemperatura(double currentTemperature) {
        Map.Entry<Integer, String[]> entry = temperatureAdvice.floorEntry((int) currentTemperature);
        if (entry != null) {
            return entry.getValue();
        }
        //Si no se encuentra un umbral menor o igual, proporciona un consejo por defecto
        return new String[]{"No hay datos específicos de vestimenta para esta temperatura.", "Precauciones desconocidas para estas condiciones. Proceda con extrema cautela."};
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planeta: ").append(name).append("\n");
        sb.append("--- Rangos de Temperatura y Consejos ---\n");
        if (temperatureAdvice.isEmpty()) {
            sb.append("No hay rangos de temperatura definidos.\n");
        } else {
            for (Map.Entry<Integer, String[]> entry : temperatureAdvice.entrySet()) {
                sb.append("  Desde ").append(entry.getKey()).append("°C: \n");
                sb.append("    Vestimenta: ").append(entry.getValue()[0]).append("\n");
                sb.append("    Precauciones: ").append(entry.getValue()[1]).append("\n");
            }
        }
        return sb.toString();
    }
}