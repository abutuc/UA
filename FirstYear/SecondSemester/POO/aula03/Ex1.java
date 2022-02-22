package aula03;

import java.util.Scanner;
import java.lang.Math;
public class Ex1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("notaP: ");
        Double notaP = Math.round(sc.nextFloat() * 10.0) / 10.0;
        System.out.print("notaT: ");
        Double notaT = Math.round(sc.nextFloat() * 10.0) / 10.0;
        System.out.println("notaP: " + notaP + "; notaT: " + notaT + ";");
        if ( (0 <= notaP && notaP <= 20) && (0 <= notaT  && notaT <= 20)){
            if (notaP < 7.0 || notaT < 7.0){
                System.out.println("66 (reprovado por nota mínima)");
            }
            else {
                System.out.println("Nota final: " + Math.round(0.4*notaT + 0.6*notaP));
            }
        }
        else {
            System.out.println("Os valores introduzidos são inválidos.");
        }
        sc.close();
    }
}