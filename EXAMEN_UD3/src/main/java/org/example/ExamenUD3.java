package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ExamenUD3 {
    public void examenUD3() {

        //Creo un random y un Scanner que voy a necesitar después.
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        //Doy la bienvenida
        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");

        //Aquí calculo el número de bolas que voy a sacar
        int num_bolas = random.nextInt(10, 40);

        //Esto es una variable auxiliar que usaré para comprobar si se están repitiendo
        int random1;

        //Estas variables las uso para calcular los resultados tanto del bingo como de las líneas
        int aciertos_l1 = 0;
        int aciertos_l2 = 0;
        int aciertos_l3 = 0;

        //Esta es la entrada de las filas
        String carton_string = "";

        Integer[] bolas = new Integer[num_bolas]; //Esto es un vector con las bolas que saco, Integer porque usaré un AsList
        String[] carton_fila = new String[3]; //Esto es para crear un vector con los datos que introduce el usuario
        int[][] carton = new int[3][3]; //Esto es una matriz con el cartón completo

        boolean error = true; //Esta variable me servirá para controlar la entrada

        for (int i = 0; i < bolas.length; i++) { //Aquí calculo las bolas, es un for con un do-while dentro que comprueba si la bola está en el vector, si está lo vuelve a calcular

            do {
                random1 = random.nextInt(90) + 1;
            } while (Arrays.asList(bolas).contains(random1));

            bolas[i] = random1; //Si no está repetida, la añado al vector

        }

        System.out.println(num_bolas + " bolas extraidas hasta ahora: "); //Imprimo las bolas
        System.out.println(Arrays.toString(bolas));

        System.out.println();
        System.out.println("** Introduce los datos de tu cartón **");

        //Esto es la entrada de las filas por el usuario, con un matches compruebo que el formato y con un if
        //compruebo si los números están en el rango, seguro que se puede comprobar con el matches pero no me
        //acordaba y lo he hecho así por tiempo.

        for (int i = 0; i < carton.length; i++) {  //Este hace que se repita el bucle según las filas de la matriz

            while (error) {
                System.out.println("Fila " + (i + 1));
                carton_string = entrada.nextLine();


                //Dentro de este if compruebo primero el formato y después si los números están en rango con un for
                if (carton_string.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")) {
                    error = false;

//                    carton_string = carton_string.trim();
                    carton_fila = carton_string.split("-");

                    for (int j = 0; j < carton_fila.length; j++) {
                        if (Integer.parseInt(carton_fila[i])>90 || Integer.parseInt(carton_fila[i])<1){
                            System.out.println("ERROR. Los números deben estar entre 1 y 90.");
                            error=true;
                            break;
                            //Si algún número no está en el rango error=true y break para salir del for
                        }
                    }

                } else { //Este else salta si el formato no es válido
                    System.out.println("ERROR. La entrada introducida no es válida. (3 numeros separados por guiones).");
                }
            }

            error = true;

            //Si ha ido bien introduzco los datos en la matriz
            for (int j = 0; j < carton[0].length; j++) {
                carton[i][j] = Integer.parseInt(carton_fila[j]);
            }

        }

        //Aquí muestro los datos del cartón con un for
        System.out.println();
        System.out.println("Datos del cartón introducido: ");

        for (int[] filas : carton) {
            for (int columnas : filas) {
                System.out.print(columnas + " ");
            }
            System.out.println();
        }

        //Esta parte comprueba los aciertos de cada línea recorriendo toda la matriz, cada if para una línea
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[0].length; j++) {
                if (Arrays.asList(bolas).contains(carton[i][j]) && i == 0) {
                    aciertos_l1++;
                }
                if (Arrays.asList(bolas).contains(carton[i][j]) && i == 1) {
                    aciertos_l2++;
                }
                if (Arrays.asList(bolas).contains(carton[i][j]) && i == 2) {
                    aciertos_l3++;
                }
            }
        }

        //Aquí imprimo los premios

        System.out.println();
        System.out.println("PREMIOS:");
        System.out.println();

        //Si hay 3 aciertos en cada linea, hay bingo
        if (aciertos_l1 == 3 && aciertos_l2 == 3 && aciertos_l3 == 3) {
            System.out.println("HAY BINGO!!");
        } else {
            System.out.println("No hay BINGO.");
        }

        //A partir de aquí compruebo cada linea
        if (aciertos_l1 == 3) {
            System.out.println("Linea 1: CORRECTA!!");
        } else {
            System.out.println("Linea 1: NO");
        }

        if (aciertos_l2 == 3) {
            System.out.println("Linea 2: CORRECTA!!");
        } else {
            System.out.println("Linea 2: NO");
        }

        if (aciertos_l3 == 3) {
            System.out.println("Linea 3: CORRECTA!!");
        } else {
            System.out.println("Linea 3: NO");
        }
    }
}




























