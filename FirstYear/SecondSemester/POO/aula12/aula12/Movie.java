package aula12;
import java.util.Comparator;
public class Movie{
    private String name;
    private double score;
    private String rating;
    private String genre;
    private int running_time;

    public Movie(String name, double score, String rating, String genre, int running_time) {
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.running_time = running_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunning_time() {
        return running_time;
    }

    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public String toString(){
        return name + "\t" + score + "\t" + rating + "\t" + genre + "\t" + running_time;
    }
    
    public boolean equals(Movie m){
        if((name.equals(m.getName())) && (score == m.getScore()) && (rating.equals(m.getRating())) && (running_time==m.getRunning_time())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return name.hashCode() + (int)score + rating.hashCode() + genre.hashCode() + running_time;
    }
    
    public static Comparator<Movie> MovNameComp= new Comparator<Movie>(){
        public int compare(Movie m1, Movie m2){
            String mov1_name = m1.getName().toUpperCase();
            String mov2_name = m2.getName().toUpperCase();

            return mov1_name.compareTo(mov2_name);
        }
    };

    public static Comparator<Movie> MovScoreComp = new Comparator<Movie>(){
        public int compare(Movie m1, Movie m2){
            double m1_score = m1.getScore();
            double m2_score = m2.getScore();

            return (int) ((m2_score - m1_score)*1000);
        }
    };

    public static Comparator<Movie> MovTimeComp = new Comparator<Movie>(){
        public int compare(Movie m1, Movie m2){
            int m1_time = m1.getRunning_time();
            int m2_time = m2.getRunning_time();

            return (m1_time - m2_time);
        }
    };

}
