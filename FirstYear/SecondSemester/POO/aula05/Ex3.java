import java.util.Scanner;

import aula05.Livro;
import aula05.Utilizador;

public class Ex3 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Utilizador[] utilizadores = new Utilizador[100];
        int users_indice = 0; 
        Livro[] livros = new Livro[100];
        int livros_indice = 0;
        int option = 0;
        while (option != 8){
            System.out.println("1 - inscrever utilizador");
            System.out.println("2 - remover utilizador");
            System.out.println("3 - imprimir lista de utilizadores");
            System.out.println("4 - registar um novo livro");
            System.out.println("5 - imprimir lista de livros");
            System.out.println("6 - emprestar");
            System.out.println("7 - devolver");
            System.out.println("8 - sair");

            System.out.print("Operação: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Número Mecanográfico: ");
                    int nMec = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    while (utilizadores[users_indice] != null){
                        users_indice++;
                    }

                    utilizadores[users_indice] = new Utilizador(nome, nMec, curso);
                    users_indice++;
                    break;
                
                case 2:
                    System.out.print("nMec: ");
                    nMec = sc.nextInt(); 
                    for (int i = 0; i < utilizadores.length; i++){
                        if (utilizadores[i] == null){
                            continue;
                        }
                        
                        if (utilizadores[i].getNmec() == nMec){
                            utilizadores[i] = null;
                            users_indice = i;
                            break;
                        }
                    }
                    break;
                
                case 3:
                    for (int i = 0; i < utilizadores.length; i++){
                        if (utilizadores[i] != null){
                            System.out.println(utilizadores[i]);
                        }
                    }
                    break;
                
                case 4:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String titulo = sc.nextLine();

                    System.out.print("Tipo de Empréstimo (responder só em caso de CONDICIONAL): ");
                    String  tipoEmprestimo = sc.nextLine();
                    while (livros[livros_indice] != null){
                        livros_indice++;
                    }
                    if (tipoEmprestimo.equals("")){
                        livros[livros_indice] = new Livro(titulo);
                    }
                    else if (tipoEmprestimo.equals("CONDICIONAL")){
                        livros[livros_indice] = new Livro(titulo, tipoEmprestimo);
                    }
                    livros_indice++;
                    
                    break;
                
                case 5:
                    for (int i = 0; i < livros.length; i++){
                        if (livros[i] != null){
                            System.out.println(livros[i]);
                        }
                    }
                    break;
                
                case 6:
                    System.out.print("Nmec: ");
                    nMec = sc.nextInt();
                    int user_books = 0;
                    Utilizador user = null;
                    for (int f = 0; f < utilizadores.length; f++){
                        if ((utilizadores[f] != null) && (utilizadores[f].getNmec() == nMec)){
                            user = utilizadores[f];
                        }
                    }
                    if (user == null){
                        System.out.println("Esse nMec não se encontra registado no sistema.");
                    }
                    else {
                        int[] livros_user = user.getLivros();
                        for (int s = 0; s < livros_user.length; s++){
                            if (livros_user[s] != 0){
                                    user_books++;
                                }
                            }
                        System.out.println("Pode requisitar os seguintes livros:");
                        int counter = 0;
                        for (int i = 0; i < livros.length; i++){
                            if ((livros[i] != null) && (livros[i].getRequisitado() == false) && (livros[i].getTipoEmprestimo() == "NORMAL") && (user_books < 3)){
                                System.out.println(livros[i]);
                                counter++;
                            }
                        }
                        if (counter == 0){
                            System.out.println("Neste momento não há livros disponíveis ou já tem neste momento 3 livros requisitados.");
                        }
                        else {
                            System.out.print("ID do livro que deseja requisitar: ");
                            int chosen_book = sc.nextInt();
                            for (int d = 0; d < livros.length; d++){
                                if ((livros[d] != null) && (livros[d].getId() == chosen_book)){
                                    livros[d].emprestarLivro();
                                    user.requisitarLivro(chosen_book);
                                }
                            }
                        }
                    }   
                    break;
                
                case 7: 
                    System.out.print("Nmec: ");
                    nMec = sc.nextInt();

                    Utilizador user1 = null;
                    for (int f = 0; f < utilizadores.length; f++){
                        if ((utilizadores[f] != null) && (utilizadores[f].getNmec() == nMec)){
                            user1 = utilizadores[f];
                        }
                    }
                    if (user1 == null){
                        System.out.println("Esse nMec não se encontra registado no sistema.");
                    }
                    else {
                        System.out.println("Neste momento tem estes livros requisitados: ");
                        int[] livros_user1 = user1.getLivros();
                        for (int s = 0; s < livros_user1.length; s++){
                            if (livros_user1[s] != 0){
                                    System.out.println(livros_user1[s]);
                                }
                            }
                        
                        System.out.print("ID do livro a devolver: ");
                        int id_livro = sc.nextInt();
                        boolean id_livro_confirmed = false;
                        for (int r = 0; r < livros_user1.length; r++){
                            if (livros_user1[r] == id_livro){
                                id_livro_confirmed = true;
                            }
                        }

                        for (int l = 0; l < livros.length; l++){
                            if ((livros[l] != null) && (livros[l].getId() == id_livro) && id_livro_confirmed){
                                livros[l].devolverLivro();
                                user1.devolverLivro(id_livro);
                            }
                        }
                    }
                    break;


            }   
        }
        sc.close();
    }

}
