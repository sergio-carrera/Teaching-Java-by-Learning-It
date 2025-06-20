import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador.inicializarPreguntas();
        Scanner sc = new Scanner(System.in);
        int vidas = 2;
        int opc;
        int i = 0;
        int j = 0;
        int x = -1;
        boolean gameOver = false;

        Mensaje.mensajeBienvenida();

        while (i < Controlador.preguntas.size()) {
            if (x == -1) {
                if (!Controlador.preguntas.get(i).isHaSidoRespondida()) {
                    System.out.println(Controlador.preguntas.get(i).toString());
                    System.out.println("Digita la opcion correcta: ");
                    try {
                        opc = sc.nextInt();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    if (Controlador.validarRespuesta(Controlador.preguntas.get(i), opc)) {

                        Controlador.preguntas.get(i).setHaSidoRespondida(true);
                        Controlador.preguntas.get(i).setHaSidoRespondidaCorrectamente(1);

                        Mensaje.mensajeRespuestaCorrecta();
                        Mensaje.mensajeSiguientePregunta();

                        x = -1;
                        i++;

                    } else {
                        if (vidas > 0) {
                            vidas--;

                            Controlador.preguntas.get(i).setHaSidoRespondida(true);
                            Controlador.preguntas.get(i).setHaSidoRespondidaCorrectamente(2);

                            Mensaje.mensajePerdidaVida();
                            Mensaje.mensajeSiguientePregunta();

                            x = Controlador.complicarPregunta(j, i);
                            j++;
                            i++;

                        } else {
                            gameOver = true;
                            break;
                        }
                    }
                } else {
                    i++;
                }
            } else {
                System.out.println(Controlador.preguntas.get(x).toString());
                System.out.println("Digita la opcion correcta: ");
                try {
                    opc = sc.nextInt();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (Controlador.validarRespuesta(Controlador.preguntas.get(x), opc)) {

                    Controlador.preguntas.get(x).setHaSidoRespondida(true);
                    Controlador.preguntas.get(x).setHaSidoRespondidaCorrectamente(1);

                    Mensaje.mensajeRespuestaCorrecta();
                    Mensaje.mensajeSiguientePregunta();

                    x = -1;
                } else {
                    if (vidas > 0) {

                        vidas--;
                        Controlador.preguntas.get(x).setHaSidoRespondida(true);
                        Controlador.preguntas.get(x).setHaSidoRespondidaCorrectamente(2);

                        Mensaje.mensajePerdidaVida();
                        Mensaje.mensajeSiguientePregunta();

                        x = -1;

                    } else {
                        gameOver = true;
                        break;
                    }
                }
            }
        }
        sc.close();
        if (gameOver) {
            Mensaje.mensajeFinDeJuego();
        } else {
            Mensaje.mensajeVictoria();
        }
        Mensaje.mensajeResultados(Controlador.preguntas);
    }
}