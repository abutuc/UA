import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import aula12.Movie;

public class Ex122 {
    public static void main(String[] args){
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Set<String> genres = new HashSet<String>();
        try {
            Scanner sc = new Scanner(new File("aula12/movies.txt"));
            sc.nextLine();
            while (sc.hasNext()){
                String[] l_content = sc.nextLine().split("\t");
                movies.add(new Movie(l_content[0], Double.parseDouble(l_content[1]), l_content[2], l_content[3], Integer.parseInt(l_content[4])));
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("O ficheiro introduzido não existe.");
            System.exit(1);
        }

        Collections.sort(movies, Movie.MovNameComp);
        System.out.println("Listagem ordenada pelo nome do filme");
        System.out.println("---------------------------------");
        for (Movie m: movies){
            System.out.println(m);
        }
        System.out.println("---------------------------------");

        Collections.sort(movies, Movie.MovScoreComp);
        System.out.println("\nListagem por ordem descrescente do score do filme");
        System.out.println("---------------------------------");
        for (Movie m: movies){
            System.out.println(m);
        }
        System.out.println("---------------------------------");

        Collections.sort(movies, Movie.MovTimeComp);
        System.out.println("\nListagem por ordem crescente do 'running time' do filme");
        System.out.println("---------------------------------");
        for (Movie m: movies){
            System.out.println(m);
        }
        System.out.println("---------------------------------");

        for (Movie m: movies){
            genres.add(m.getGenre());
        }

        for (String g: genres){
            System.out.println(g);
        }

        try {
            PrintWriter out = new PrintWriter(new File("aula12/myselection.txt"));
            out.println("name   score   rating  genre   running time");
            for (Movie m: movies){
                if (m.getScore() > 60 && m.getGenre().equals("comedy")){
                    out.println(m.toString());
                }
            }
            out.close();
        }
        catch (FileNotFoundException e){
            System.out.println("O ficheiro não existe.");
            System.exit(1);
        }
    }
}