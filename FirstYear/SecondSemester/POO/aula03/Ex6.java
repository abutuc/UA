package aula03;

import java.util.Scanner;

public class Ex6 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int ano = -1;
        while (ano <= 0){
            System.out.print("Ano: ");
            ano = sc.nextInt();
        }

        int mes = -1;
        while (!(mes >= 1 && mes <= 12)){
            System.out.print("Mês: ");
            mes = sc.nextInt();
        }
        
        int[] meses = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean isLeap = false;
        if (ano % 4 == 0){
            isLeap = true;
            if (ano % 100 == 0){
                isLeap = false;
                if (ano % 400 == 0){
                    isLeap = true;
                }
            }
        }
        if (isLeap && mes == 2){
            System.out.println("O mês tem 29 dias.");
        }
        else {
            System.out.println("O mês " + mes + " do ano " + ano + " tem " + meses[mes] + " dias.");
        }

        sc.close();
    }
}
