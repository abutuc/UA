import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ex103{

    public static void main(String[] args){
        String frase = "Hello World";
        Set<Character> chars = new HashSet<Character>();
        Map<Character, ArrayList<Integer>> mapping = new HashMap<>();


        for (int i = 0; i < frase.length(); i++){
            if (!(chars.contains(frase.charAt(i)))){
                chars.add(frase.charAt(i));
                mapping.put(frase.charAt(i), new ArrayList<Integer>());
                mapping.get(frase.charAt(i)).add(i);
            }
            else if (chars.contains(frase.charAt(i))){
                mapping.get(frase.charAt(i)).add(i);
            }
        }

        for (Character c: mapping.keySet()){
            System.out.print(c + " --> " + mapping.get(c) + " | ");
        }
        System.out.println();
    }

}