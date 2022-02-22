import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionTester {
    public static void main(String[] args) {
        ArrayList<Integer> dims = new ArrayList<Integer>();
        double[] deltas;
        String[] deltass = {"Add" , "Search", "Remove"};
        String s = "";
        dims.add(1000);
        dims.add(5000);
        dims.add(10000);
        dims.add(20000);
        dims.add(40000);
        dims.add(100000);

        for (Integer dim: dims){
            Collection<Integer> col = new TreeSet<>();
            System.out.println("------------------------------------------");
            deltas = checkPerformance(col, dim);
            for (int i = 0; i < deltas.length; i++){

                s += deltass[i] + ": " + deltas[i] + "ms\n";
            }
            System.out.println("Dim: " + dim);
            System.out.print(s);
            s = "";
            System.out.println("------------------------------------------");
            }
    }
    private static double[] checkPerformance(Collection<Integer> col, int DIM) { 
        double start, stop, delta;
        double deltaAdd, deltaSearch, deltaRemove;
    // Add
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ ) 
            col.add( i );
        stop = System.nanoTime(); // clock snapshot after 
        delta = (stop-start)/1e6; // convert to milliseconds 
        deltaAdd = delta; 
        // Search
        start = System.nanoTime(); // clock snapshot before 
        for(int i=0; i<DIM; i++ ) {
            int n = (int) (Math.random()*DIM); 
            if (!col.contains(n))
                System.out.println("Not found???"+n); }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop-start)/1e6; // convert nanoseconds to milliseconds 
        deltaSearch = delta;
        // Remove
        start = System.nanoTime(); // clock snapshot 
        Iterator<Integer> iterator = col.iterator(); 
        while (iterator.hasNext()) {
        iterator.next();
        iterator.remove(); }
        stop = System.nanoTime(); // clock snapshot
        delta = (stop-start)/1e6; // convert nanoseconds to milliseconds 
        deltaRemove = delta;

        double[] deltas = {deltaAdd, deltaSearch, deltaRemove};
        return deltas;
        }
    }


/*

5000: Add to ArrayList took 0.749424ms
5000: Search to ArrayList took 21.590395ms
0: Remove from ArrayList took 2.174897ms


5000: Add to LinkedList took 0.80802ms
5000: Search to LinkedList took 31.19971ms
0: Remove from LinkedList took 1.094898ms


5000: Add to HashSet took 0.743812ms
5000: Search to HashSet took 1.641672ms
0: Remove from HashSet took 1.443708ms


5000: Add to TreeSet took 4.103887ms
5000: Search to TreeSet took 2.789073ms
0: Remove from TreeSet took 3.525424ms


Mais rápido para ADD: HashSet, apesar de que Array List fica um pouco atrás;

Mais rápido para SEARCH: HashSet e em segundo TreeSet

Mais rápido para REMOVE: LinkedList e em segundo HashSet

*/