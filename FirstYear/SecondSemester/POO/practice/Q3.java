import java.util.Scanner;

public class Q3 {
    
    public static void main(String[] args){
        //printWarning("Olá, isto está a funcionar.");
        //System.out.println(MultTwoAndSquare(3));
        //System.out.println(returnBigger(4, 6));
        //System.out.println(returnBigger(6, 4));
        //System.out.println(returnBigger(4, 4));
        //System.out.println(readInt());
        //System.out.println(readDoubleBetweenZeroTen());
        //System.out.println(countZOccurences("ZZZOZZZ"));
        //System.out.println(countZOccurences("ZZzOzZZ"));
        //System.out.println(countZOccurences(""));
        //System.out.println(countZOccurences(" "));
    }

    public static void printWarning(String message){
        System.out.println("Aviso!! " + message);
    }

    public static double MultTwoAndSquare(double x){
        return Math.pow(x, 2)*2;
    }

    public static double returnBigger(double a, double b){
        double bigger = a;
        if (b > bigger){
            bigger = b;
        }
        return bigger;
    }

    public static int readInt(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer:");
        int x = sc.nextInt();
        sc.close();
        return x;
    }

    public static double readDoubleBetweenZeroTen(){
        Scanner sc = new Scanner(System.in);
        double x = -1;
        while (!(0<=x && x<=10)){
            System.out.print("Enter a real number between 0 and 10: ");
            x = sc.nextDouble();
        }
        sc.close();
        return x;
    }

    public static int countZOccurences(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c: chars){
            if (c=='Z'){
                count++;
            }
        }
        return count;
    }
}
