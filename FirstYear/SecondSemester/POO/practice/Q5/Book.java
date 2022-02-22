package Q5;

public class Book {
    private String title;
    private int pubYear;
    private String isbn;

    public Book(String title, int pubYear, String isbn){
        this.title = title;
        this.pubYear = pubYear;
        this.isbn = isbn;
    }

    public Book(String title, int pubyear){
        this.title = title;
        this.pubYear = pubyear;
        this.isbn = "";
    }

    public Book(String title){
        this.title = title;
        this.pubYear = 0;
        this.isbn = "";
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
    public int getPubYear() {
        return pubYear;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    public String getISBN() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book| " + title + " | " + pubYear + " | " + isbn;
    }

    public boolean equals(Book b){
        if(title.equals(b.getTitle()) && pubYear==b.getPubYear() && isbn.equals(b.getISBN())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return title.hashCode() + pubYear + isbn.hashCode();
    }
}
