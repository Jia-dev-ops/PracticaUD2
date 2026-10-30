public class CineDaw {
    static void main(String[] args) {
        int Filas = 6;
        int ButacasFila = 8;

        char LIBRE = '-';
        char OCUPADO = 'x';

        int PrecioInfantil = 500;
        int PrecioGeneral = 650;
        int PrecioAdulto = 600;

        String sala = "";

        for (int i = 0; i <= Filas * ButacasFila; i++) {
            sala  = sala + LIBRE;
        }
        System.out.println(sala);
    }

}
