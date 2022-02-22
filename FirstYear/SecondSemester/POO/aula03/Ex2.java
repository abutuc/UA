package aula03;

import java.util.Scanner;
public class Ex2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();

        for (int i = n; i >= 0; i--){
            System.out.print(i + " ");
        }
        System.out.println();
        sc.close();
    }
}
