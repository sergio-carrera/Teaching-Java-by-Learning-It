import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("                    @@@                         @/*@@@%/                        \n");
        System.out.print("           @@,                 ,@@.         @(                  @# .            \n");
        System.out.print("        .@@*                       @      @ *                         ,@@       \n");
        System.out.print("         @@                         &      &                        &&..        \n");
        System.out.print("         @@                         &      &                        &&..        \n");
        System.out.print("      ,@..      do you             @  @    @ %@       or do you         @       \n");
        System.out.print("         @       actually         @ ,(.   @#*.         want other     @@#@      \n");
        System.out.print("      #&          want             %**,   @ @           people to       @       \n");
        System.out.print("        &          it?       &,@  @  @       @ &         see that      #&@#     \n");
        System.out.print("        @                         &         @             you have     @.       \n");
        System.out.print("      /#,@                         ,(      @                it?       @@&@      \n");
        System.out.print("         &                       @(          #.                      .@/        \n");
        System.out.print("       (, &@                    @@            @#,                   %           \n");
        System.out.print("          @                    .@              %                     %          \n");
        System.out.print("        @,                     *%              @*                      @        \n");
        System.out.print("     .@.               *#                              @.                @,     \n");
        System.out.print("                      @.                                 @                      \n");
        System.out.print("                   .@                                      &                    \n");

        System.out.println("Responde la pregunta:");
        String respuesta = sc.nextLine();

        System.out.println("Esta es tu respuesta usando println:");
        System.out.println(respuesta);

        System.out.print("Esta es tu respuesta usando print: ");
        System.out.print(respuesta);

        System.out.println("\n\n¿Estas preparado para el efecto espejo?");
        System.out.println("Hola, \"agente de la vida y el destino!\"\nBienvenido al efecto espejo 1.\nComencemos!");

        //Se crea un arreglo de tipo String para almacenar cada línea de la imagen
        String[] imagen = {
                "                    @@@                         @/*@@@%/                        ",
                "           @@,                 ,@@.         @(                  @# .            ",
                "        .@@*                       @      @ *                         ,@@       ",
                "         @@                         &      &                        &&..        ",
                "         @@                         &      &                        &&..        ",
                "      ,@..      do you             @  @    @ %@       or do you         @       ",
                "         @       actually         @ ,(.   @#*.         want other     @@#@      ",
                "      #&          want             %**,   @ @           people to       @       ",
                "        &          it?       &,@  @  @       @ &         see that      #&@#     ",
                "        @                         &         @             you have     @.       ",
                "      /#,@                         ,(      @                it?       @@&@      ",
                "         &                       @(          #.                      .@/        ",
                "       (, &@                    @@            @#,                   %           ",
                "          @                    .@              %                     %          ",
                "        @,                     *%              @*                      @        ",
                "     .@.               *#                              @.                @,     ",
                "                      @.                                 @                      ",
                "                   .@                                      &                    "
        };

        /*
        Se crea un arreglo de tipo String para guardar las oraciones de la imagen para luego darles vuelta una vez que
        la imagen se revierte en efecto espejo (ya que las oraciones también se revertirían)
        */
        String[] oraciones = {
                "do you",
                "or do you",
                "actually",
                "want other",
                "want",
                "people to",
                "it?",
                "see that",
                "you have"
        };

        /*
        En este caso, decidí usar un HashMap para guardar cada oración revertida y asociarla con su oración respectiva
        (clave, valor)
        */
        Map<String, String> oracionesInvertidasMap = new HashMap<>();
        for (String oracion : oraciones) {
            //Utilizo el metodo de revertir oración para colocar dicha oración revertida en el apartado de clave del HashMap
            oracionesInvertidasMap.put(revertir(oracion), oracion);
        }

        //Recorro cada línea del arreglo "imagen"
        for (String linea : imagen) {
            /*
            Ahora creo una variable String que guarda la línea revertida con ayuda del metodo "revertir" para ir ajustándolo
            si es necesario (si tiene alguna oración invertida que ocupe ser reemplazada por una oración original)
            */
            String lineaArreglada = revertir(linea);
            //Itero sobre cada entrada del HashMap para arreglar la variable "lineaArreglada"
            for (Map.Entry<String,String> entrada : oracionesInvertidasMap.entrySet()) {
                /*
                Variable de la oración invertida que me permite obtener el valor clave que siempre será la
                oración invertida (oracionesInvertidasMap.put(revertir(oracion), oracion))
                */
                String oracionInvertida = entrada.getKey();
                /*
                Variable de oración original que me permite obtener el valor clave que siempre será la oración original
                (oracionesInvertidasMap.put(revertir(oracion), oracion))
                */
                String oracionOriginal = entrada.getValue();
                /*
                Con esta variable obtengo el índice de la línea revertida en caso de que haya una oración invertida, y si
                no la hay, entonces se devuelve un -1 y no se entra al bucle while que reconstruye la línea para reemplazar
                la oración invertida por la original
                */
                int index = lineaArreglada.indexOf(oracionInvertida);
                while (index != -1) {
                    //Construyo la nueva línea reemplazando solo la aparición encontrada
                    lineaArreglada = lineaArreglada.substring(0, index)
                            + oracionOriginal
                            + lineaArreglada.substring(index + oracionInvertida.length());
                    /*
                    Busco la siguiente ocurrencia después del último reemplazo (y si no la hay, entonces devuelve -1
                    y se deja de ejecutar el bucle while)
                    */
                    index = lineaArreglada.indexOf(oracionInvertida, index + oracionOriginal.length());
                }
            }
            //Imprimo la línea arreglada usando println para ir imprimiendo el arreglo "imagen" en el orden respectivo
            System.out.println(lineaArreglada);
        }
    }

    //Metodo que revierte y devuelve un String
    public static String revertir(String s) {
        //Convierto "s" en un arreglo de caracteres
        char[] chars = s.toCharArray();
        //Defino un arreglo para revertir el arreglo "chars" basándome en el tamaño de "chars"
        char[] revertido = new char[chars.length];
        //Recorro cada valor del arreglo "chars" ingresando mediante el índice
        for (int i = 0; i < chars.length; i++) {
            //En el arreglo "revertido", añado de izquierda a derecha los valores de derecha a izquierda del arreglo "chars"
            revertido[i] = chars[chars.length - 1 - i];
        }
        //Devuelvo un String del arreglo "revertido"
        return new String(revertido);
    }
}