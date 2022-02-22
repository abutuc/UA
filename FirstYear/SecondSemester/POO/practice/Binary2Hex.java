import java.util.Scanner;
import java.lang.Math;
public class Binary2Hex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Binary Number: ");
        String binary = sc.nextLine();
        String f_binary = "";
        int sum = 0;
        String hex = "";
        String[] translation = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

        for (int i = 0; i <= binary.length()%4 + 1; i++){
            f_binary += "0";
        }
        f_binary += binary;
        System.out.println(f_binary);
        for (int f = 0; f < f_binary.length(); f += 4){
            String quart = f_binary.substring(f, f+4);
            String n_quart = "";
            for (int v = 3; v >= 0; v--){
                n_quart += quart.charAt(v);
            }
            
            for (int c = 0; c < 4; c++){
                sum += Math.pow(2,c) * Integer.parseInt(String.valueOf(n_quart.charAt(c)));
            }
            hex += translation[sum];
            sum = 0;
        }
        System.out.println("Hexadecimal Number: " + hex);
        sc.close();
    }
}
