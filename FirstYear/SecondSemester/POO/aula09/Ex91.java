import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import aula06.Data;
import aula06.Pessoa;

public class Ex91 {
    

    public static void main(String[] args) { 
        ArrayList<Integer> c1 = new ArrayList<>(); 
        for (int i = 10; i <= 100; i+=10)
            c1.add(i);
        System.out.println("Size: " + c1.size()); 
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));
        ArrayList<String> c2 = new ArrayList<>(); c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva"); 
        System.out.println(c2); 
        Collections.sort(c2); 
        System.out.println(c2); 
        c2.remove("Frio"); 
        c2.remove(0); 
        System.out.println(c2);

        c2.add("Vento");
        System.out.println(c2.indexOf("Vento"));
        System.out.println(c2.lastIndexOf("Vento"));
        c2.set(1, "Intruder");
        System.out.println(c2);
        System.out.println(c2.subList(1, c2.size()));


        Set<Pessoa> c3 = new HashSet<>();

        c3.add(new Pessoa("André", 1111, new Data(4, 8, 2002)));
        c3.add(new Pessoa("Manel", 2222, new Data(5, 9, 2003)));
        c3.add(new Pessoa("José", 3333, new Data(6, 10, 2004)));
        c3.add(new Pessoa("Alberto", 4444, new Data(7, 11, 2005)));
        c3.add(new Pessoa("Daniel", 5555, new Data(8, 12, 2006)));
        c3.add(new Pessoa("Daniel", 5555, new Data(8, 12, 2006))); // ao adicionar este objeto cujos argumentos e conteúdos já se encontram presentes no conjunto, o conjunto como esperado não retira os "objetos" duplicados, pois de facto os objetos com o mesmo conteúdo têm referências diferentes.

        Iterator<Pessoa> i = c3.iterator();

        while (i.hasNext()) {
          System.out.println(i.next()); // a ordem de impressão não é a mesma de que a inserseção.
        }

        Set<Data> c4 = new TreeSet<>();

        c4.add(new Data(1,2,2002));
        c4.add(new Data(2,3,2003));
        c4.add(new Data(3,4,2004));
        c4.add(new Data(4,5,2005));
        c4.add(new Data(5,6,2006));

        for (Data d: c4){
          System.out.println(d);
       }
    }
}