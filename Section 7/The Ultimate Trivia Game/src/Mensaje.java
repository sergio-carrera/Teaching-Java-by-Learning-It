import java.util.List;

public class Mensaje {

    static void mensajeBienvenida() {
        System.out.println("Bienvenido a la trivia que decidira tu conocimiento en las siguiente áreas: ");
        System.out.println("1 - Programacion");
        System.out.println("2 - Filosofia");
        System.out.println("3 - Ajedrez");
        System.out.println("4 - Lies of P");
        System.out.println("¡Comencemos!\n");
    }

    static void mensajeFinDeJuego() {
        System.out.println("\nEl juego se ha finalizado. No lo has logrado :c");
    }

    static void mensajeVictoria() {
        System.out.println("\nHas completado el juego exitosamente :D");
    }

    static void mensajeSiguientePregunta() {
        System.out.println("Avanzando a la siguiente pregunta...\n");
    }

    static void mensajePerdidaVida() {
        System.out.println("\nHas perdido una vida <:O\n");
    }

    static void mensajeRespuestaCorrecta() {
        System.out.println("\n¡Respuesta correcta!\n");
    }

    static void mensajeResultados(List<Pregunta> preguntas) {

        System.out.println("\nResumen de resultados: ");
        for (Pregunta p : preguntas) {
            System.out.println(p.getEnunciado());
            System.out.println("Respuesta: " + p.getRespuestaCorrecta());
            if (p.getHaSidoRespondidaCorrectamente() == 1) {
                System.out.println("Respondida correctamente ✅");
            } else {
                System.out.println("Respondida incorrectamente ❌");
            }
            System.out.println();
        }

    }
}
