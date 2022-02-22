package Q11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
    public static void main(String[] args) {
        try{
        Scanner input = new Scanner(new File("words.txt")); //** while (input.hasNextLine())
        System.out.println(input.nextLine());
        input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("O ficheiro existe.");
        }
    }
}