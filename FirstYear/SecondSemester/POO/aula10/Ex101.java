import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Ex101 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, String> termos = new HashMap<>();

        String resposta = "";
        String termo;
        String description;

        while (!(resposta.toLowerCase().equals("n"))){
            System.out.print("Termo: ");
            termo = sc.nextLine();

            System.out.print("Descrição: ");
            description = sc.nextLine();

            termos.put(termo, description);
            System.out.print("Continuar [(S)im ou (N)ão]: ");
            resposta = sc.nextLine().toLowerCase();
        }

        for (String term: termos.keySet()){
            System.out.println(term + " --> " + termos.get(term));
        }
        sc.close();
    }
}