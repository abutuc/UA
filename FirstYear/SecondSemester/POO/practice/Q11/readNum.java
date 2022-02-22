package Q11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readNum {
    public static void main(String[] args){
        try{
        Scanner sc = new Scanner(new File("practice/Q11/numbers.txt"));
        List<Integer> inteiros = new ArrayList<>();
        int sum = 0;
        int max;
        int min;
        while(sc.hasNextLine()){
           String[] l_content = sc.nextLine().split("\\s+");
           for(int i = 0; i<l_content.length; i++){
                if(l_content[i].equals("")){
                    continue;
                }
                inteiros.add(Integer.parseInt(l_content[i]));

                sum += Integer.parseInt(l_content[i]);
           } 
        }
        max = inteiros.get(0);
        min = inteiros.get(0);
        for (int f: inteiros){
            if(f > max){
                max = f;
            }
            if (f < min){
                min = f;
            }
        }
        System.out.println(inteiros);
        System.out.println(sum/inteiros.size());
        System.out.println(max);
        System.out.println(min);
        sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("O ficheiro nao existe.");
            System.exit(0);
        }
    } 
}
