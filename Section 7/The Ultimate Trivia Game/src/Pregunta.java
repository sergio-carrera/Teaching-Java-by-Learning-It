import enums.Categoria;
import enums.Dificultad;

import java.util.Map;

public class Pregunta {

    private String enunciado;
    private Map<Integer, String> opciones;
    private int respuestaCorrecta;
    private Categoria categoria;
    private Dificultad dificultad;
    private boolean haSidoRespondida;
    private int haSidoRespondidaCorrectamente;

    public Pregunta(String enunciado,
                    Map<Integer, String> opciones,
                    int respuestaCorrecta,
                    Categoria categoria,
                    Dificultad dificultad,
                    boolean haSidoRespondida,
                    int haSidoRespondidaCorrectamente) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.categoria = categoria;
        this.dificultad = dificultad;
        this.haSidoRespondida = haSidoRespondida;
        this.haSidoRespondidaCorrectamente = haSidoRespondidaCorrectamente;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Map<Integer, String> getOpciones() {
        return opciones;
    }

    public void setOpciones(Map<Integer, String> opciones) {
        this.opciones = opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isHaSidoRespondida() {
        return haSidoRespondida;
    }

    public void setHaSidoRespondida(boolean haSidoRespondida) {
        this.haSidoRespondida = haSidoRespondida;
    }

    public int getHaSidoRespondidaCorrectamente() {
        return haSidoRespondidaCorrectamente;
    }

    public void setHaSidoRespondidaCorrectamente(int getHaSidoRespondidaCorrectamente) {
        this.haSidoRespondidaCorrectamente = getHaSidoRespondidaCorrectamente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("enums.Dificultad de pregunta: ").append(this.getDificultad()).append("\n"); //enums.Dificultad
        sb.append("Pregunta acerca de ").append(this.getCategoria()).append("\n"); //Categoría
        sb.append(this.getEnunciado()).append("\n"); //Enunciad
        for (Map.Entry<Integer, String> entry : this.getOpciones().entrySet()) { //Opciones
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
