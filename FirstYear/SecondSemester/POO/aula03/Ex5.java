package aula03;

import java.util.Scanner;

public class Ex5 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double investimento = -1;
        while ((investimento < 0) || (investimento%1000 != 0)){
            System.out.print("Introduza o montante investido: ");
            investimento = sc.nextDouble();
        }

        double taxa = -1;
        while (!(taxa < 5 && taxa > 0)){
            System.out.print("Introduza a taxa de juro mensal: ");
            taxa = sc.nextDouble();
        }
        
        System.out.println("Investimento: " + investimento + "; Taxa de Juro: " + taxa + "%");

        for (int i = 1; i <= 12; i++){
            investimento += investimento * (taxa/100);
             System.out.printf("Mês %4d: %.2f € \n",i, investimento);
        }
        sc.close();
    }
}
