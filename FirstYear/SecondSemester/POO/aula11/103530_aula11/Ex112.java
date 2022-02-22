import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import aula11.Voo;

public class Ex112 {
    public static void main(String[] args) throws IOException{
        Scanner sc1 = new Scanner(new File("aula11/aula11_code/voos.txt"));
        ArrayList<Voo> voos1 = new ArrayList<Voo>();
        
        int counter = 0;
        while(sc1.hasNextLine()){
            if (counter == 0){
                sc1.nextLine();
                counter++;
                continue;
            }
            String[] l_content = sc1.nextLine().strip().split("\t");
            String hora = l_content[0];
            String[] voo = l_content[1].split(" ");
            String empresa;
            String id;
            if (voo.length > 1){
                empresa = l_content[1].split(" ")[0];
                id = l_content[1].split(" ")[1]; 
            }
            else if (voo.length == 1){
                empresa = "NR";
                id = l_content[1].split(" ")[0]; 
            }
            else{
                empresa = "NR";
                id = "NR";
            }
            
            String origem = l_content[2];
            String atraso;
            if (l_content.length > 3){
                atraso = l_content[3];
            }
            else {
                atraso = " ";
            }

            voos1.add(new Voo(hora, empresa, id, origem, atraso));
            }        
        sc1.close();


        Scanner sc2 = new Scanner(new File("aula11/aula11_code/companhias.txt"));
        Map<String, String> companhias = new HashMap<String, String>();

        while(sc2.hasNextLine()){
            String[] line_content = sc2.nextLine().split("\t");
            companhias.put(line_content[0], line_content[1]);
            }

        sc2.close();
        //printTable(voos1, companhias);
        //writeTable(voos1, companhias);
        //AtrasoMedio(voos1);
        TotalChegadas(voos1);
    }


    public static void printTable(ArrayList<Voo> voos, Map<String, String> companhias){
        System.out.printf("%s%20s%30s%25s%20s%30s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
        for (Voo v: voos){
            String hora = v.getHora();
            String voo = v.getEmpresa() + " " + v.getId();
            String empresa = companhias.get(v.getEmpresa());
            if (empresa == null){
                empresa = "NR";
            }
            String origem = v.getOrigem();
            String atraso = v.getAtraso();
            String obs = "";
            if (!atraso.equals(" ")){
                int h = Integer.parseInt(hora.split(":")[0]);
                int m = Integer.parseInt(hora.split(":")[1]);

                int h_a = Integer.parseInt(atraso.split(":")[0]);
                int h_m = Integer.parseInt(atraso.split(":")[1]);

                int h_obs = h + h_a;
                if (h_obs >= 24){
                    h_obs = h_obs - 24;
                }

                int m_obs = m + h_m;
                if (m_obs >= 60){
                    m_obs = m_obs - 60;
                    h_obs++;
                }
                obs = String.format("Previsto: %2d:%02d", h_obs, m_obs);
            }
            System.out.printf("%s%20s%30s%25s%20s%30s\n",hora, voo, empresa, origem, atraso, obs);
        }
    }

    public static void writeTable(ArrayList<Voo> voos, Map<String, String> companhias) throws IOException{
        PrintWriter out = new PrintWriter(new File("aula11/Infopublico.txt"));
        out.printf("%s%20s%30s%25s%20s%30s\n", "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
        for (Voo v: voos){
            String hora = v.getHora();
            String voo = v.getEmpresa() + " " + v.getId();
            String empresa = companhias.get(v.getEmpresa());
            if (empresa == null){
                empresa = "NR";
            }
            String origem = v.getOrigem();
            String atraso = v.getAtraso();
            String obs = "";
            if (!atraso.equals(" ")){
                int h = Integer.parseInt(hora.split(":")[0]);
                int m = Integer.parseInt(hora.split(":")[1]);

                int h_a = Integer.parseInt(atraso.split(":")[0]);
                int h_m = Integer.parseInt(atraso.split(":")[1]);

                int h_obs = h + h_a;
                if (h_obs >= 24){
                    h_obs = h_obs - 24;
                }

                int m_obs = m + h_m;
                if (m_obs >= 60){
                    m_obs = m_obs - 60;
                    h_obs++;
                }
                obs = String.format("Previsto: %2d:%02d", h_obs, m_obs);
            }
            out.printf("%s%20s%30s%25s%20s%30s\n",hora, voo, empresa, origem, atraso, obs);
        }
        out.close();
    }

    public static void AtrasoMedio(ArrayList<Voo> voos){
        Map<String, ArrayList<Integer>> companhias_reg = new HashMap<String, ArrayList<Integer>>();
        for (Voo v: voos){
            String empresa = v.getEmpresa();
            if (v.getAtraso() != " "){
                int atraso_value = Integer.parseInt(v.getAtraso().split(":")[0])*60 + Integer.parseInt(v.getAtraso().split(":")[1]);
            if (companhias_reg.containsKey(empresa)){
                companhias_reg.get(empresa).add(atraso_value);
            }
            else{
                companhias_reg.put(empresa, new ArrayList<Integer>());
                companhias_reg.get(empresa).add(atraso_value);
            }
            }
        }
        Map<String, Integer> companhias_med = new HashMap<String, Integer>();
        for (String reg: companhias_reg.keySet()){
            Integer sum = 0;
            for (Integer atraso: companhias_reg.get(reg)){
                sum += atraso;
            }
            companhias_med.put(reg, sum/companhias_reg.get(reg).size());
        }
        ArrayList<Integer> atrasos = new ArrayList<Integer>();
        for (String comp: companhias_med.keySet()){
            atrasos.add(companhias_med.get(comp));
        }
        Collections.sort(atrasos);
        Map<String, Integer> companhias_med_ordered = new LinkedHashMap<String, Integer>();
        for (Integer atraso: atrasos){
            for (String c: companhias_med.keySet()){
                if(companhias_med.get(c) == atraso && !companhias_med_ordered.containsKey(c)){
                    companhias_med_ordered.put(c, atraso);
                }
            }
        }  
        System.out.printf("%s%15s\n", "Companhia", "Atraso Médio");
        for (String companhia: companhias_med_ordered.keySet()){
            System.out.printf("%s%15s\n", companhia, companhias_med_ordered.get(companhia));
        }
    }

    public static void TotalChegadas(ArrayList<Voo> voos) throws IOException{
        PrintWriter out = new PrintWriter(new File("aula11/cidades.txt"));
        Set<String> cidades = new HashSet<String>();
        for (Voo v: voos){
            cidades.add(v.getOrigem());
        }
        
        Map<String, Integer> cidades_count = new HashMap<String, Integer>();

        for (Voo v: voos){
            if(cidades_count.containsKey(v.getOrigem())){
                cidades_count.put(v.getOrigem(), cidades_count.get(v.getOrigem())+1);
            }
            else{
                cidades_count.put(v.getOrigem(), 1);
            }
        }
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for (String cid: cidades_count.keySet()){
            counts.add(cidades_count.get(cid));
        }
        Collections.sort(counts, Collections.reverseOrder());
        Map<String, Integer> ordered_cidades = new LinkedHashMap<String,Integer>();
        for(Integer n: counts){
            for (String cid: cidades_count.keySet()){
                if(cidades_count.get(cid) == n && !ordered_cidades.containsKey(cid)){
                    ordered_cidades.put(cid, n);
                }
            }
        }
        out.printf("%20s%15s\n", "Origem", "Voos");
        for (String oc: ordered_cidades.keySet()){
            out.printf("%20s%15s\n", oc, ordered_cidades.get(oc));
        }
        out.close();
    }
}
