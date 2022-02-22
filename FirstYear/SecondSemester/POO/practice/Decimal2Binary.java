import java.util.Scanner;
public class Decimal2Binary {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Decimal number: ");
        int decimal = sc.nextInt();
        String binary = "";
        String rev_bin = "";
        if (decimal == 0) binary = "0";
        while (decimal != 0) {
            if (decimal % 2 == 0){
                binary += "0";
            }

            else {
                binary += "1";
            }

            decimal /= 2;
        }
        for (int i = binary.length()-1; i >= 0; i--){
            rev_bin += binary.charAt(i);
        }
        System.out.println("Binary: " + rev_bin);
        sc.close();
    }
}
