package aula13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<Student>();
    try {
        Scanner sc = new Scanner(new File("aula13/notas.txt"));
        while(sc.hasNextLine()){
            String[] l_content = sc.nextLine().split("\\s+");
            if(l_content[0].equals("*")){
                continue;
            }
            if (l_content.length == 6){
                students.add(new Student(Integer.parseInt(l_content[0]), l_content[1] + " " + l_content[2], Double.parseDouble(l_content[3]), Double.parseDouble(l_content[4]), Double.parseDouble(l_content[5]), (int) ((Double.parseDouble(l_content[3])*0.3) + (Double.parseDouble(l_content[4])*0.2) + (Double.parseDouble(l_content[5]) * 0.5))));
            }
            else if (l_content.length == 5){
                students.add(new Student(Integer.parseInt(l_content[0]), l_content[1] + " " + l_content[2], Double.parseDouble(l_content[3]), Double.parseDouble(l_content[4])));
            }
            else if (l_content.length == 4){
                students.add(new Student(Integer.parseInt(l_content[0]), l_content[1] + " " + l_content[2], Double.parseDouble(l_content[3])));
            }
            else if (l_content.length ==3){
                students.add(new Student(Integer.parseInt(l_content[0]), l_content[1] + " " + l_content[2]));
            }
        }  
        sc.close();
    } catch (FileNotFoundException e) {
        System.out.println("O ficheiro não existe.");
        System.exit(0);
    }
    try {
        
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        PrintWriter out = new PrintWriter(new File("aula13/Results.txt"));
        for (int i=0; i<21; i++){
            mp.put(i, 0);
        }
        for (Student stu: students){
                mp.put(stu.getNotaFinal(), mp.get(stu.getNotaFinal())+1);
        }
        
        for (Integer i: mp.keySet()){
            out.println(i + " : " + mp.get(i));
        }
        out.close();

    } catch (FileNotFoundException e) {
        System.out.println("Ficheiro não existe.");
    }
}
}
