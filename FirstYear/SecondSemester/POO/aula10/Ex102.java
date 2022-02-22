import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Ex102 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Map<String, ArrayList<String>> termos = new TreeMap<>();

    String resposta = "";
    String resposta_d = "";
    String termo;
    ArrayList<ArrayList<String>> descriptions = new ArrayList<ArrayList<String>>();;
    String description;
    int count = 0;

    while (!(resposta.toLowerCase().equals("n"))){
        System.out.print("Termo: ");
        termo = sc.nextLine();

        while (!(resposta_d.toLowerCase().equals("n"))){
            descriptions.add(new ArrayList<String>());
            System.out.print("Descrição: ");
            description = sc.nextLine();
            descriptions.get(count).add(description);
            System.out.print("Continuar a adicionar descrições[(S)im ou (N)ão]: ");
            resposta_d = sc.nextLine().toLowerCase();
        }
        resposta_d = "";
        termos.put(termo, descriptions.get(count));
        count++;
        System.out.print("Continuar a adicionar termos [(S)im ou (N)ão]: ");
        resposta = sc.nextLine().toLowerCase();
    }

    for (String term: termos.keySet()){
        System.out.println(term + " --> " + termos.get(term));
    }

    System.out.println(randomDes(termos, "Poop"));
    sc.close();
    }

    public static String randomDes(Map<String, ArrayList<String>> termos,  String termo){
        ArrayList<String> description = termos.get(termo);
        int randomNum = ThreadLocalRandom.current().nextInt(0, description.size());
        return description.get(randomNum);
    }
}
