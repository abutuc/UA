package aula03;
import java.util.Scanner;
public class Ex8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double notas[][] = new double[16][2];
        double nota_final = 0;
        for (int l = 0; l <= 15; l++){
            for (int c = 0; c <= 1; c++){
                notas[l][c] = (Math.random()*20);
            }
        }
        System.out.printf("%20s%20s%20s \n", "NotaT", "NotaP", "Pauta");
        for (int l = 0; l <= 15; l++){
            if ( notas[l][0] < 7.0 || notas[l][1] < 7.0){
                nota_final = 66;
            }
            else {
                nota_final = 0.4*notas[l][0] + 0.6*notas[l][1];
            }

            System.out.printf("%20.1f%20.1f%20d \n", notas[l][0], notas[l][1], Math.round(nota_final));
        }
        sc.close();
    }
}
