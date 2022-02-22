import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex121 {
  
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("aula12/texto.txt"));
        Map<String, Integer> mp = new HashMap<String, Integer>();
        
        while(sc.hasNextLine()){
            String[] l_content = sc.nextLine().split("[\\\t\n.,:'‘’;?!-*{}=+&/()\\[\\]”“\"\' ]+");
            for (String word: l_content){
                word = word.toLowerCase();
                if (mp.containsKey(word)){
                    mp.put(word, mp.get(word)+1);
                }
                else{
                    mp.put(word, 1);
                }
            }
        }
        int total_palavras = 0;
        for (String k: mp.keySet()){
            total_palavras += mp.get(k);
        }
        
        System.out.println("Número Total de Palavras: " + total_palavras);
        System.out.println("Número de Diferentes Palavras: " + mp.keySet().size());
    }
}
