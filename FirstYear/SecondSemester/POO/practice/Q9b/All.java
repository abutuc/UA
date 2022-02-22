package Q9b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class All {
    public static void main(String[] args){
        //System.out.printf("%10.5f\n",Math.PI);

        List<Integer> integers = new LinkedList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);

        //System.out.println(integers);
        //System.out.println(comprimento(2, 5));
        System.out.println(getPrimesBetween(3, 19));
        double[] doubles = generateRandomNums(5, 2, 10);
        for(double f: doubles){
            System.out.println(f);
        }

    }

    public static double comprimento(double a, double v){
        return Math.pow(v, 2)*((2*v));
    }

    public static List<Integer> getPrimesBetween(int a, int b){
        List<Integer> primes = new ArrayList<Integer>();
        if (a == 1){
            a+=1;
        }
        for(Integer i=2; i<=b; i++){
            primes.add(i);
        }
        List<Integer> primes2 = new ArrayList<Integer>();
        primes2.addAll(primes);
        for (Integer f: primes){
            for (Integer s: primes){
                if (f == s){
                    continue;
                }
                if (f%s==0){
                    primes2.remove(f);
                    break;
                }
            }
        }
        return primes2;
    }

    public static double[] generateRandomNums(int n, int a, int b){
        double[] doubles = new double[n];
        for (int i = 0; i<n; i++){
            doubles[i] = ThreadLocalRandom.current().nextDouble(a, b);
        }
        return doubles;
    }


}


/*

List<String> ruas;
Map<Integer,String> dias_semana;
Map<String, List<String>> enderecos;
*/