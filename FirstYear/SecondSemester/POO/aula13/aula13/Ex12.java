package aula13;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
public class Ex12{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("aula13/qdv.txt"));
            double sum = 0;
            int n = 0;
            Set<String> localidades = new HashSet<String>();
            Map<String, ArrayList<Double>> mp = new HashMap<String, ArrayList<Double>>();
            while(sc.hasNextLine()){
                String[] l_content = sc.nextLine().split("\\s");
                if (l_content[0].equals("#")){
                    continue;
                }
                Double num = Double.parseDouble(l_content[1].replace(",", "."));
                String localidade = l_content[0];
                sum += num;
                n += 1;
                localidades.add(localidade);
                if(mp.get(localidade) != null){
                    mp.get(localidade).add(num);
                }
                else{
                    mp.put(localidade, new ArrayList<Double>());
                    mp.get(localidade).add(num);
                }
            }
            // alinea 1
            double media = Math.round((sum/n)*100.0)/100.0;
            System.out.println("Média dos valores da segunda coluna: " + media);

            // alinea 2
            System.out.println("As localidades presentes na primeira coluna são: " + localidades);

            // alinea 3
            for (String l: mp.keySet()){
                Double sum2 = 0.0;
                ArrayList<Double> doubles = mp.get(l);
                for (Double d: doubles){
                    sum2 += d;
                }
                System.out.println(l + "| NºValores: " + mp.get(l).size() + "| Média Valores: " +  Math.round((sum2/mp.get(l).size())*100.0)/100.0);
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("O ficheiro não existe.");
            System.exit(0);
        }
    }
}