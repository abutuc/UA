package aula03;

import java.util.Scanner;

public class Ex4 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        double first = sc.nextDouble();
        double max = first;
        double min = first;
        double sum = first;
        double count = 1;
        double last = 0;

        while (first != last) {
            System.out.print("Enter number: ");
            last = sc.nextDouble();
            
            if (last > max){
                max = last;
            }
            
            if (last < min){
                min = last;
            }
            sum += last;
            count += 1;
        }

        System.out.printf("Max: %.1f ; Min: %.1f; Média: %.2f ; Total Lidos: %.1f \n", max, min, sum / count, count);
        sc.close();
    }
}
