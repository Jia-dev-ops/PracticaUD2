/**
 * Programa para calcular múltiplos de 3
 * @author Jiahong
 */

import java.util.Scanner;
public class MultiplosTres {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número N: ");
        int n = entrada.nextInt();
        int suma = 0, cantidad = 0;
        //Primer cambio pasar de 1 < n a 1 <= n
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                suma += i;
                cantidad++;
            }
        }
        //Segundo cambio añadir un if para evitar la división por 0
        if (cantidad > 0){
            //Tercer cambio, añadir un double antes en la división
        double media = (double) suma / cantidad;
        System.out.println("Múltiplos de 3 entre 1 y " + n + ": " + cantidad);
        System.out.println("Suma: " + suma + " | Media: " + media);
        }else{
            System.out.println("Si no hay múltiplos, no se puede calcular la suma ni la media.");
        }

        entrada.close();
    }
}

