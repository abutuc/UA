import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex111 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("aula11/aula11_code/major.txt"));
        Map<String, Map<String, Integer>> mp = new HashMap<String, Map<String, Integer>>();
        ArrayList<String> words = new ArrayList<String>();

        while(sc.hasNextLine()){
            String[] split = sc.nextLine().split("[\\\t\n.,:'‘’;?!-*{}=+&/()\\[\\]”“\"\' ]+");
            for (int i = 0; i < split.length; i++){
                if (split[i].length() >= 3){
                    words.add(split[i]);
                }
            }
        }
        for (int f = 0; f < words.size()-1; f++){
            if (mp.containsKey(words.get(f))){
                if (mp.get(words.get(f)).containsKey(words.get(f+1))){
                    Integer value = mp.get(words.get(f)).get(words.get(f+1));
                    value++;
                    mp.get(words.get(f)).put(words.get(f+1), value);
                }
                else{
                       mp.get(words.get(f)).put(words.get(f+1), 1);
                    }
                }
            else{
                mp.put(words.get(f), new HashMap<String, Integer>());
                mp.get(words.get(f)).put(words.get(f+1), 1);
            }
        }

        for (String m: mp.keySet()){
            System.out.println(m + " : " +  mp.get(m));
        }
        sc.close();
        }
    }
