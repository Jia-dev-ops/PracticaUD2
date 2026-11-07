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
                continue; //Vuelve al inicio del bucle do
            }
            switch (opcion) {
                case 1:
                    //Analiza la frase
                    System.out.println("Escribe una frase: ");
                    String frase = sc.nextLine().trim();

                    int palabras = 0, vocales= 0, mayusculas = 0, digitos = 0;
                    if (frase.length() > 0){
                        palabras = 1; //si hay texto, hay una palabra como mínimo
                    }
                    for (int i = 0; i < frase.length(); i++) {
                        char c = frase.charAt(i);

                        //cuenta las palabras con espacios
                        if (c >= ' ' && i + 1 < frase.length() && frase.charAt(i + 1) != ' ') {
                            palabras++;
                        }
                        //Contar mayusc y minusc
                        if (c >= 'A' && c <= 'Z') mayusculas++;
                        if (c >= '0' && c <= '9') digitos++;

                        //Contamos las vocales
                        char cMin  = Character.toLowerCase(c);
                        if (cMin == 'a' || cMin == 'e' || cMin == 'i' || cMin == 'o'  || cMin == 'u') {
                            vocales++;
                        }
                    }
                    //Comprobamos si es palíndromo
                    String fraseLimpia = frase.replace(" ", "").toLowerCase();
                    boolean esPalindromo = true;
                    int izq = 0;
                    int der = fraseLimpia.length() - 1;

                    while (izq < der) {
                        if (fraseLimpia.charAt(izq) != fraseLimpia.charAt(der)) {
                            esPalindromo = false;
                        }
                        izq++;
                        der--;
                    }
                    System.out.printf("Caracteres: " + frase.length());
                    System.out.println("Palabras: " + palabras);
                    System.out.println("Vocales: " + vocales + "Mayúsculas: " + mayusculas + "Digitos: " + digitos);
                    if(frase.length() > 0) {
                        System.out.println(esPalindromo ? "Es un palíndromo." : "No es un palíndromo");
                    }
                    break;
            }
        }
    }

}
