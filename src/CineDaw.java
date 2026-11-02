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

    }

}
