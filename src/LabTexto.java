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
                    System.out.print("Escribe una frase: ");
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
                case 2:
                    //Cifrado César
                    System.out.println("Texto: ");
                    String texto = sc.nextLine();

                    int desplazamiento = 0;
                    //Bucle para pedir el desplazamiento hasta que sea un número válido
                    while (true) {
                        System.out.print("Desplazamiento: ");
                        try{
                            desplazamiento = Integer.parseInt(sc.nextLine());
                            break;
                        }catch(NumberFormatException e){
                            System.out.println("El desplazamiento debe ser un número entero. ");
                        }
                    }

                    //Ajustar el desplazamiento para que soporte negativos y mayores de 26.
                    desplazamiento = (desplazamiento % letras_alfabeto + letras_alfabeto) % letras_alfabeto;

                    String cifrado = "";
                    for (int i = 0; i < texto.length(); i++) {
                        char c = texto.charAt(i);
                        //Aritmética de char y casting para mayus y minus
                        if (c >= 'A' && c <= 'Z') {
                            cifrado += (char) ('A' + (c - 'A'+ desplazamiento) % letras_alfabeto);
                        }else  if (c >= 'a' && c <= 'z') {
                            cifrado += (char) ('a' + (c - 'a'+ desplazamiento) % letras_alfabeto);
                        }else {
                            cifrado = cifrado + c;
                        }
                    }
                    System.out.println("Cifrado: " + cifrado);
                    break;
                case 3 :
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String contras = sc.nextLine();

                    //Booleanos independientes
                    boolean tieneLongitud = contras.length() >= min_longitud_contraseña;
                    boolean tieneMayus = false;
                    boolean tieneDigito = false;

                    for (int i = 0; i < contras.length(); i++) {
                        char c = contras.charAt(i);
                        if (c >= 'A' && c <= 'Z') tieneMayus = true;
                        if (c >= '0' && c <= '9') tieneDigito = true;
                    }
                    //El indexOf devuelve -1 si no encuentra el usuario dentro de la contraseña
                    boolean noTieneUsuario = contras.toLowerCase().indexOf(usuario.toLowerCase()) == -1;

                    //Mouestra si cumple las reglas
                    System.out.println(tieneLongitud ? "[OK]" : "[--]" + " Al menos 8 caracteres");
                    System.out.println(tieneMayus ? "[OK]" : "[--]" + " Una mayúscula");
                    System.out.println(tieneDigito ? "[OK]" : "[--]" + " Un digito");
                    System.out.println(noTieneUsuario ? "[OK]" : "[--]" + " No tiene usuario");

                    //Contar reglas superadas
                    int puntos = (tieneLongitud ? 1 : 0) + (tieneMayus ? 1 : 0) + (tieneDigito ? 1 : 0);
                    //Encadenar para el nivel
                    String nivel = (puntos == 4) ? "FUERTE" : ((puntos >= 2) ? "MEDIA" : "DÉBIL");
                    System.out.println("Nivel: " + nivel + " (" + puntos + "/4");
                    break;
                case 0 :
                    System.out.println("Abandonado el LabTexto ...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 0);
        sc.close();
    }

}
