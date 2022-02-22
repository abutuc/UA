package aula02;

import java.util.Scanner;

public class Ex5b {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Quandos percursos realizou? ");
        int percursos = sc.nextInt();
        double tempo = 0;
        double dist = 0;
        for (int i = 1; i <= percursos; i++ ){
            System.out.printf("v%d = ", i);
            double v = sc.nextDouble();

            System.out.printf("d%d = ", i);
            double d = sc.nextDouble();

            tempo += d/v;
            dist += d;
        }

        double vm = dist / tempo;
        System.out.printf("Velocidade média final: %.2f \n", vm);

        sc.close();
    }
}
