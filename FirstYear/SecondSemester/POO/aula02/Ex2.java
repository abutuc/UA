package aula02;

import java.util.Scanner;
public class Ex2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = celsius * 1.8 + 32;
        System.out.println(celsius + "C is " + fahrenheit + "F");
        sc.close();
    }
}
