import java.util.Scanner;

/**
 * Programa LabTexto: Un laboratorio de análisis y cifrado de texto.
 */
public class LabTexto {
    //Constantes del enunciado
    final static int min_longitud_contraseña = 8;
    final static int letras_alfabeto = 26;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        //Menu guardado como un bloque
        final String MENU = """
                ====LaTexto====
                1. Analizar frase
                2. Cifrado César
                3. Validar contraseña
                0. salir
                Elige una opción:\s""";

        do {
            System.out.print(MENU);
            //Leemos todo como texto

            String inputOpcion = sc.nextLine();

            try{
                //Convertir texto a número
                opcion = Integer.parseInt(inputOpcion);
            }catch(NumberFormatException e){
                //Si el usuario escribe letras, mostrara este error
                System.out.println("Opción no válida: \"" +  inputOpcion + "\"");
                continue; //Vuelbe al inicio del bucle do
            }
        }
    }

}
