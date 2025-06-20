import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import enums.Dificultad;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controlador {
    public static List<Pregunta> preguntas = new ArrayList<>();

    public static void inicializarPreguntas() {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader("preguntas.json");
            Type preguntaListType = new TypeToken<List<Pregunta>>() {
            }.getType();
            preguntas = gson.fromJson(reader, preguntaListType);
            reader.close();
            Collections.shuffle(preguntas);

            System.out.println("Se cargaron " + preguntas.size() + " preguntas correctamente.");
        } catch (Exception e) {
            System.err.println("Error al cargar preguntas: " + e.getMessage());
        }
    }

    public static boolean validarRespuesta(Pregunta pregunta, Integer respuesta) {
        return pregunta.getRespuestaCorrecta() == respuesta;
    }

    public static int complicarPregunta(int j, int i) {
        int c = j;

        while (c < Controlador.preguntas.size()) {
            if (Controlador.preguntas.get(c) != Controlador.preguntas.get(i)) {
                if (!Controlador.preguntas.get(c).isHaSidoRespondida()) {
                    if (Controlador.preguntas.get(c).getCategoria() == Controlador.preguntas.get(i).getCategoria()) {
                        if (Controlador.preguntas.get(c).getDificultad() == Dificultad.DIFICIL) {
                            return c;
                        }
                    }
                }
            }
            c++;
        }

        c = j;

        while (c < Controlador.preguntas.size()) {
            if (Controlador.preguntas.get(c) != Controlador.preguntas.get(i)) {
                if (!Controlador.preguntas.get(c).isHaSidoRespondida()) {
                    if (Controlador.preguntas.get(c).getCategoria() == Controlador.preguntas.get(i).getCategoria()) {
                        if (Controlador.preguntas.get(c).getDificultad() == Dificultad.NORMAL) {
                            return c;
                        }
                    }
                }
            }
            c++;
        }

        c = j;

        while (c < Controlador.preguntas.size()) {
            if (Controlador.preguntas.get(c) != Controlador.preguntas.get(i)) {
                if (!Controlador.preguntas.get(c).isHaSidoRespondida()) {
                    if (Controlador.preguntas.get(c).getCategoria() == Controlador.preguntas.get(i).getCategoria()) {
                        if (Controlador.preguntas.get(c).getDificultad() == Dificultad.FACIL) {
                            return c;
                        }
                    }
                }
            }
            c++;
        }

        return -1;
    }
}
