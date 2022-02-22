import Q5.Book;

public class Q5 {
    public static void main(String[] args){

        Book books[] = new Book[10];
        books[0] = new Book("Turismo em Aveiro", 1980);
        books[1] = new Book("Javaland", 2019, "1234-756");
        books[2] = new Book("Mau tempo na ria");
        books[3] = books[0];

        for (int i = 0; i<4; i++)
            System.out.println(books[i]);

        System.out.println(books[0].getTitle().toUpperCase());
        books[0].setISBN("9875-1234");
        System.out.println(books[0].getISBN());
        books[2] = null;
        for (int i=0; i<books.length; i++)
            System.out.println(i+ ": " + (books[i] != null ? books[i].getTitle(): "--- Posição vazia"));
    }
}


// Resultado 1
// Book| Turismo em Aveiro | 1980 | 
// Book| Javaland | 2019 | 1234-756
// Book| Mau tempo na ria | |
// Book| Turismo em Aveiro | 1980 | 


// Resultado 2
// TURISMO EM AVEIRO


// Resultado 3
// 0: Turismo em Aveiro
// 1: Javaland
// 2: --- Posição vazia
// 3: Turismo em Aveiro
// 4: --- Posição vazia
// 5: --- Posição vazia
// 6: --- Posição vazia
// 7: --- Posição vazia
// 8: --- Posição vazia
// 9: ---Posição vazia