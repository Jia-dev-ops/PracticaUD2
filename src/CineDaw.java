import java.sql.SQLOutput;
import java.util.Scanner;

public class CineDaw {

        //Cantidad de Filas y Butacas por fila
        final static int Filas = 6;
        final static int ButacasFila = 8;

        //Definir como caracter libre y ocupado con un "-" y una "x"
        final static char LIBRE = '-';
        final static char OCUPADO = 'x';

        //Precios en centimos
        final static int PrecioInfantil = 500;
        final static int PrecioGeneral = 650;
        final static int PrecioAdulto = 600;
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

        final String MENU = """
                =====CineDaw=====
                1. Ver sala
                2. Comprar entrada
                3. Estadísticas
                0. Salir
                Elige una opción: """;

        do {
            System.out.println(MENU);
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        //Ver la sala
                        System.out.println("  1 2 3 4  5 6 7 8");
                        for (char f = 'A'; f <= 'F'; f++) {
                            System.out.println(f + " ");
                            for(int b = 1; b <= ButacasFila; b++) {
                                int pos = (f - 'A') * ButacasFila + (b - 1);
                                System.out.println(sala.charAt(pos));
                                if (b == 4) System.out.println("  "); //pasillo del medio
                            }
                            System.out.println();
                        }
                        break;
                }
            }
        }

    }

}
