import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa CineDaw: App o programa para gestionar la taquilla de un cine.
 * @author Jiahong
 */

public class CineDaw {

        //Cantidad de Filas y Butacas por fila
        final static int Filas = 6;
        final static int ButacasFila = 8;

        //Definir como caracter libre y ocupado con un "-" y una "x"
        final static char LIBRE = '-';
        final static char OCUPADO = 'x';

        //Precios en centimos
        final static int PrecioInfantil = 500;
        final static int PrecioGeneral = 850;
        final static int PrecioAnciano = 600;
        final static int ExtraFinde = 150;
        final static double DescMierc = 0.30;



    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Generamos la sala vacía con un bucle
        String sala = "";
        for (int i = 0; i < Filas * ButacasFila; i++) {
            sala = sala + LIBRE;
        }
        int entradasVend = 0;
        int recaudaciónTotal = 0;
        int opcion = -1;

        //Menú de elección del usuario
        final String MENU = """
                =====CineDaw=====
                1. Ver sala
                2. Comprar entrada
                3. Estadísticas
                0. Salir
                Elige una opción: """;

        //Inicio del bucle del programa
        do {
            System.out.println(MENU);
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                //Switch para las opción del menú según lo que escriba el usuario
                switch (opcion) {
                    case 1:
                        //La primera opción: Ver la sala del cine
                        System.out.println("   PANTALLA");
                        System.out.println("  1234  5678");
                        for (char f = 'A'; f <= 'F'; f++) {
                            System.out.print(f + " ");
                            for (int b = 1; b <= ButacasFila; b++) {
                                int pos = (f - 'A') * ButacasFila + (b - 1);
                                System.out.print(sala.charAt(pos));
                                if (b == 4) {
                                    System.out.print("  "); //pasillo del medio
                                }
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        //La segunda opción: Comprar la entrada
                        if (sala.indexOf(LIBRE) == -1) { //comprueba si la sala esta completa
                            System.out.println("La sala está completa");
                            break; //Sale del case 2
                        }
                        //Pide fila para validar
                        char fila = ' ';
                        while (true) {
                            System.out.print("Fila (A-F): ");
                            String inputFila = sc.nextLine().trim().toUpperCase();
                            if (inputFila.length() == 1 && inputFila.charAt(0) >= 'A' && inputFila.charAt(0) <= 'F') {
                                fila = inputFila.charAt(0);
                                break; //Si existe la fila y no está ocupada de sale del while
                            }
                            System.out.println("Fila no válida. Tiene que ser una letra de la A a la F, vuelve a escribir un número");
                        }


                        int butaca = 0;
                        do {
                            System.out.print("Butaca (1-8): ");
                            try {
                                butaca = sc.nextInt();
                                sc.nextLine();
                                if (butaca < 1 || butaca > 8) System.out.println("Número fuera del rango, vuelve a escribir uno");
                            } catch (InputMismatchException e) {
                                System.out.println("Tienes que introducir un número válido, vuelve a escribir uno");
                                sc.nextLine();
                                butaca = 0;
                            }
                        } while (butaca < 1 || butaca > 8);
                        int posicion = (fila - 'A') * ButacasFila + (butaca - 1);
                        if (sala.charAt(posicion) == 'x') {
                            System.out.println("La butaca ya esta ocupada");
                            break;
                        }
                        System.out.print("Edad del espectador: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        int PrecioBase = PrecioGeneral;
                        String tipoTarfica = "General";
                        if (edad < 12) {
                            PrecioBase = PrecioInfantil;
                            tipoTarfica = "Infantil";
                        } else if (edad >= 65) {
                            PrecioBase = PrecioAnciano;
                            tipoTarfica = "Anciano";
                        }
                        System.out.println("Indica el día de la semana (1 = Lunes, 2 = Martes, 3 = Miércoles, 4 = Jueves, 5 = Viernes, 6 = Sábado y 7 = Domingo");
                        int diaSemana = sc.nextInt();
                        sc.nextLine();

                        int PrecioFinal = PrecioBase;
                        //Dependiendo del día sera un caso distinto
                        switch (diaSemana) {
                            case 3:
                                PrecioFinal = (int) Math.round(PrecioFinal * (1 - DescMierc));
                                break;
                            case 6:
                            case 7:
                                PrecioFinal = PrecioFinal + ExtraFinde;
                                break;
                            case 1:
                            case 2:
                            case 4:
                            case 5:
                            default:
                                break;
                        }
                        //Definimos el precio en euros y centimos, ya que inicialmente estabamos con precios en centimos
                        int euros = PrecioFinal / 100;
                        int centimos = PrecioFinal % 100;
                        String centimosStr = (centimos < 10) ? "0" + centimos : String.valueOf(centimos);

                        System.out.println("Tarifa: " + tipoTarfica);
                        System.out.println("Total a pagar; " + euros + "," + centimos + " €");

                        sala = sala.substring(0, posicion) + OCUPADO + sala.substring(posicion + 1);
                        entradasVend++;
                        recaudaciónTotal = recaudaciónTotal + PrecioFinal;
                        System.out.println("Entrada vendida: fila " + fila + ", butaca " + butaca + ".");
                        break; //Se cierra el case 2

                    case 3:
                        //La opción 3: Calcula las estadísticas de los precios
                        int butacas_ocupadas = 0;
                        int butacas_libres = 0;

                        for (int i = 0; i < sala.length(); i++) {
                            if (sala.charAt(i) == LIBRE){
                                butacas_libres++;
                                continue;
                            }
                            butacas_ocupadas++;
                        }
                        //Calcula el porcentaje con 2 decimales
                        double porcentaje = (double) butacas_ocupadas / sala.length() * 100;
                        porcentaje = Math.round(porcentaje * 100) / 100;

                        String textoEntrada = (entradasVend == 1) ? "1 entrada" : entradasVend + "entradas";
                        int recEuros = recaudaciónTotal/100;
                        int recCentimos = recaudaciónTotal%100;
                        String recCentimosStr = (recCentimos < 10) ? "0" + recCentimos : String.valueOf(recCentimos);

                        System.out.println("Entradas vendidas: " + textoEntrada);
                        System.out.println( "Recaudación: " + recEuros + "," + recCentimosStr + " €.");
                        System.out.println("Butacas ocupadas : " + butacas_ocupadas + " libres " + butacas_libres);
                        System.out.println("Ocupación: " + porcentaje + "%.");
                        break;

                    case 0:
                        //Caso 0: Salimos del programa
                        System.out.println("Abandonando el programa ...");
                        System.out.println("Total de entradas vendidas en la sesión: " + entradasVend + ".");
                        break;

                    default:
                        System.out.println("Opción no válida ");
                }//Se cierra el switch de las opciones

            } catch (InputMismatchException e) {
                //Si un usuario escribe texto en el menú en vez de un número le va a dar error
                System.out.println("Opción no válida ");
                sc.nextLine(); //Limpia el buffer
            }
        }while (opcion != 0); //Se cierra el bucle del menú
        sc.close();
    }//Se cierra el main aquí
}//Se cierra la clase
