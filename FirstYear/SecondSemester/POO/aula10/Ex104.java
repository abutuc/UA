import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Ex104 {
    public static void main(String[] args) throws FileNotFoundException{
        Set<String> words = new HashSet<String>();
        ArrayList<String> clean = new ArrayList<String>();
        Scanner input = new Scanner(new FileReader("aula10/words.txt")); while (input.hasNext()) {
        String word = input.next();
        if (word.strip().length() > 2) {
            words.add(word.strip());
        }
    }
    for (String word: words){
        if (word.matches("[a-zA-Z]+")){
            clean.add(word);
        }
    }
    
    words.clear();
    for (String cln: clean){
        words.add(cln);
    }
    System.out.println(words);

    for (String word: words){
        if(word.endsWith("s")){
            System.out.println(word);
        }
    }

    }
} 