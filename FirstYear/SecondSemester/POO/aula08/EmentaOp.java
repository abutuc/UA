import java.util.ArrayList;
import java.util.Scanner;

import aula08.Carne;
import aula08.Cereal;
import aula08.Ementa;
import aula08.Legume;
import aula08.Peixe;
import aula08.Prato;
import aula08.TipoPeixe;
import aula08.VariedadeCarne;
import aula08.Alimento;

public class EmentaOp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Ementa ementa = new Ementa("Ementa", "Casa Butuc");
        String[] variedades = {"VACA", "PORCO", "PERU", "FRANGO","OUTRA"};
        String variedades_s = "";
        for (int i = 1; i <= variedades.length; i++){
            variedades_s += i + " - " + variedades[i-1] + "\n";
        }

        String[] tipos = {"CONGELADO", "FRESCO"};
        String tipos_s = "";
        for (int i = 1; i <= tipos.length; i++){
            tipos_s += i + " - " + tipos[i-1] + "\n";
        }

        int opcao = 0;
        int opcao1 = 0;
        int opcao2 = 0;

        ArrayList<Alimento> ingredientes = new ArrayList<Alimento>();
        ArrayList<Prato> pratos = new ArrayList<Prato>();
        while (opcao != 4){
            System.out.println("Operações Disponívels");
            System.out.println("1 - Ingrediente");
            System.out.println("2 - Prato");
            System.out.println("3 - Ementa");
            System.out.println("4 - Exit");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao){
                case 1: 
                    System.out.println("-------------------------------------");
                    System.out.println(" *** Ingrediente ***");
                    System.out.println("Operações Disponíveis: ");
                    System.out.println("1 - Adicionar Carne");
                    System.out.println("2 - Adicionar Peixe");
                    System.out.println("3 - Adicionar Cereal");
                    System.out.println("4 - Adicionar Legume");
                    System.out.println("5 - Voltar");
                    System.out.print("Opção: ");
                    opcao1 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao1){
                        case 1:
                            System.out.println("-------------------------------------");
                            System.out.println(" *** Carne ***");
                            VariedadeCarne variedadeCarne;
                            System.out.println("Escolha uma variedade: ");
                            System.out.println(variedades_s);
                            System.out.print("Opção: ");
                            opcao2 = sc.nextInt();
                            sc.nextLine();
                            switch(opcao2){
                                case 1:
                                    variedadeCarne = VariedadeCarne.VACA;
                                    break;
                                case 2:
                                    variedadeCarne = VariedadeCarne.PORCO;
                                    break;
                                case 3:
                                    variedadeCarne = VariedadeCarne.PERU;
                                    break;
                                case 4:
                                    variedadeCarne = VariedadeCarne.FRANGO;
                                    break;
                                case 5:
                                    variedadeCarne = VariedadeCarne.OUTRA;
                                    break;
                                default:
                                    variedadeCarne = VariedadeCarne.OUTRA;
                            }

                            double calorias;
                            System.out.print("Calorias: ");
                            calorias = sc.nextDouble();
                            sc.nextLine();

                            double peso;
                            System.out.print("Peso: ");
                            peso = sc.nextDouble();
                            sc.nextLine();

                            double proteinas;
                            System.out.print("Proteínas: ");
                            proteinas = sc.nextDouble();
                            sc.nextLine();

                            ingredientes.add(new Carne(proteinas, calorias, peso, variedadeCarne));
                            System.out.println("A adicionar ingrediente...");
                            System.out.println("Ingrediente " + ingredientes.get(ingredientes.size()-1) + "| adicionado com sucesso!\n");

                            break;
                        
                        case 2:
                            System.out.println("-------------------------------------");
                            System.out.println(" *** Peixe ***");
                            TipoPeixe tipoPeixe;
                            System.out.println("Escolha um tipo: ");
                            System.out.println(tipos_s);
                            System.out.print("Opção: ");
                            opcao2 = sc.nextInt();
                            sc.nextLine();
                            switch(opcao2){
                                case 1:
                                    tipoPeixe = TipoPeixe.CONGELADO;
                                    break;
                                case 2:
                                    tipoPeixe = TipoPeixe.FRESCO;
                                    break;
                                default:
                                    tipoPeixe = TipoPeixe.DESCONHECIDO;
                            }
                            System.out.print("Calorias: ");
                            calorias = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Peso: ");
                            peso = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Proteínas: ");
                            proteinas = sc.nextDouble();
                            sc.nextLine();

                            ingredientes.add(new Peixe(proteinas, calorias, peso, tipoPeixe));
                            System.out.println("A adicionar ingrediente...");
                            System.out.println("Ingrediente " + ingredientes.get(ingredientes.size()-1) + "| adicionado com sucesso!\n");
                            break;
                        case 3:
                            System.out.println("-------------------------------------");
                            System.out.println(" *** Cereal ***");

                            String nome;
                            System.out.print("Nome: ");
                            nome = sc.nextLine();

                            System.out.print("Calorias: ");
                            calorias = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Peso: ");
                            peso = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Proteínas: ");
                            proteinas = sc.nextDouble();
                            sc.nextLine();

                            ingredientes.add(new Cereal(proteinas, calorias, peso, nome));
                            System.out.println("A adicionar ingrediente...");
                            System.out.println("Ingrediente " + ingredientes.get(ingredientes.size()-1) + "| adicionado com sucesso!\n");
                            break;
                        
                        case 4:
                            System.out.println("-------------------------------------");
                            System.out.println(" *** Legume ***");

                            System.out.print("Nome: ");
                            nome = sc.nextLine();

                            System.out.print("Calorias: ");
                            calorias = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Peso: ");
                            peso = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Proteínas: ");
                            proteinas = sc.nextDouble();
                            sc.nextLine();

                            ingredientes.add(new Legume(proteinas, calorias, peso, nome));
                            System.out.println("A adicionar ingrediente...");
                            System.out.println("Ingrediente " + ingredientes.get(ingredientes.size()-1) + "| adicionado com sucesso!\n");
                            break;
                        case 5:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");
                            break;

                        default:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");
                    }
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println(" *** Prato ***");
                    System.out.println("Operações Disponíveis: ");
                    System.out.println("1 - Criar Prato");
                    System.out.println("2 - Apagar Prato");
                    System.out.println("3 - Selecionar Prato");
                    System.out.println("4 - Voltar");
                    System.out.print("Opção: ");
                    opcao1 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao1){
                        case 1:
                            String nome;
                            System.out.print("Nome do Prato: ");
                            nome = sc.nextLine();
                            pratos.add(new Prato(nome));
                            System.out.println("Prato " + pratos.get(pratos.size()-1)  + " criado com sucesso!");
                            System.out.println("Deseja introduzir algum ingrediente? (S ou N)");
                            System.out.print("Resposta: ");
                            String resposta = sc.nextLine().toUpperCase();
                            String resposta1;
                            if (resposta.equals("S") && ingredientes.size() != 0){
                                boolean trigger = true;
                                int ingrediente_escolhido;
                                int count = 1;
                                while (trigger){
                                    System.out.println("Escolha um ingrediente para adicionar.");
                                    if (count != 0){
                                        count = 0;
                                        for (int i = 0; i < ingredientes.size(); i++){
                                            if (!(pratos.get(pratos.size()-1).getAlimentos().contains(ingredientes.get(i)))){
                                                System.out.println(i+1 + " - " + ingredientes.get(i));
                                                count += 1;
                                            }
                                        }
                                        System.out.print("Ingrediente escolhido: ");
                                        ingrediente_escolhido = sc.nextInt();
                                        sc.nextLine();
                                        if ((0 <= ingrediente_escolhido) && (ingrediente_escolhido <= ingredientes.size())){
                                            pratos.get(pratos.size()-1).addAlimento(ingredientes.get(ingrediente_escolhido-1));
                                            System.out.println("Ingrediente " + ingredientes.get(ingrediente_escolhido-1) + " adicionado com sucesso ao prato " + pratos.get(pratos.size()-1).getNome() + "!");
                                            count -= 1;
                                            System.out.println("Deseja adicionar mais algum ingrediente? (S ou N)");
                                            System.out.print("Resposta: ");
                                            resposta1 = sc.nextLine().toUpperCase();
                                            if (resposta1.equals("N")){
                                                trigger = false;
                                                System.out.println("-------------------------------------\n");
                                            }
                                        }
                                        else{
                                            System.out.println("Introduziu um número não tabelado.");
                                            System.out.println("-------------------------------------\n");
                                            trigger = false;
                                        }
                                    }
                                    else{
                                        System.out.println("Não se encontram disponíveis Ingredientes para colocar no Prato, adicione mais ingredientes.");
                                        System.out.println("-------------------------------------\n");
                                        trigger = false;
                                    }
                                }                       
                            }
                            else if (resposta.equals("N")){
                                System.out.println("-------------------------------------\n");
                            }
                            else{
                                System.out.println("Não se encontram disponíveis Ingredientes para colocar no Prato, adicione mais ingredientes.");
                                System.out.println("-------------------------------------\n");
                            }
                            break;
                        case 2:
                            System.out.println("Pratos Criados:");
                            String s = "";
                            for (int i = 0; i < pratos.size(); i++){
                                s += i + 1 + " - " + pratos.get(i).getNome() + "\n";
                            }
                            System.out.println(s);
                            System.out.print("Apagar: ");
                            opcao2 = sc.nextInt() - 1;
                            sc.nextLine();
                            Prato prato_removido = pratos.get(opcao2);
                            pratos.remove(opcao2);
                            System.out.println("Prato " + prato_removido.getNome() + " removido com sucesso.");
                            break;
                        case 3:
                            System.out.println("Pratos Criados:");
                            s = "";
                            for (int i = 0; i < pratos.size(); i++){
                                s += i + 1 + " - " + pratos.get(i).getNome() + "\n";
                            }
                            System.out.println(s);

                            System.out.print("Selecionar: ");
                            opcao2 = sc.nextInt() - 1;
                            sc.nextLine();
                            System.out.println("Prato Selecionado: " + pratos.get(opcao2));
                            System.out.println("Deseja adicionar ou remover um ingrediente? A ou R");
                            System.out.print("Opção: ");
                            resposta1 = sc.nextLine().toUpperCase();
                            switch(resposta1){
                                case "A":
                                    if (ingredientes.size() != 0){
                                        boolean trigger = true;
                                        int ingrediente_escolhido;
                                        int count = 1;
                                        while (trigger){
                                            if (count != 0){
                                                    count = 0;
                                                    for (int i = 0; i < ingredientes.size(); i++){
                                                        if (!(pratos.get(pratos.size()-1).getAlimentos().contains(ingredientes.get(i)))){
                                                            System.out.println(i+1 + " - " + ingredientes.get(i));
                                                            count += 1;
                                                        }
                                                    }
                                                    if (count != 0){
                                                        System.out.println("Escolha um ingrediente para adicionar.");
                                                        System.out.print("Ingrediente escolhido: ");
                                                        ingrediente_escolhido = sc.nextInt();
                                                        sc.nextLine();
                                                        if ((0 <= ingrediente_escolhido) && (ingrediente_escolhido <= ingredientes.size())){
                                                            pratos.get(opcao2).addAlimento(ingredientes.get(ingrediente_escolhido-1));
                                                            System.out.println("Ingrediente " + ingredientes.get(ingrediente_escolhido-1) + " adicionado com sucesso ao prato " + pratos.get(opcao2).getNome() + "!");
                                                            count -= 1;
                                                            System.out.println("Deseja adicionar mais algum ingrediente? (S ou N)");
                                                            System.out.print("Resposta: ");
                                                            resposta1 = sc.nextLine().toUpperCase();
                                                            if (resposta1.equals("N")){
                                                                trigger = false;
                                                            }
                                                        }
                                                        else{
                                                            System.out.println("Introduziu um número não tabelado.");
                                                            System.out.println("-------------------------------------\n");
                                                            trigger = false;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("Não se encontram disponíveis Ingredientes para colocar no Prato, adicione mais ingredientes.");
                                                        System.out.println("-------------------------------------\n");
                                                        trigger = false;   
                                                    }
                                            }
                                            else{
                                                System.out.println("Não se encontram disponíveis Ingredientes para colocar no Prato, adicione mais ingredientes.");
                                                System.out.println("-------------------------------------\n");
                                                trigger = false;
                                            }
                                        }  
                                    }
                                    else{
                                        System.out.println("Não se encontram disponíveis Ingredientes para colocar no Prato, adicione mais ingredientes.");
                                        System.out.println("-------------------------------------\n");
                                    }
                                    break;
                                case "R":
                                    if (ingredientes.size() != 0){
                                        boolean trigger = true;
                                        int ingrediente_escolhido;
                                        int count = 1;
                                        while (trigger){
                                            if (count != 0){
                                                count = 0;
                                                for (int i = 0; i < ingredientes.size(); i++){
                                                    if ((pratos.get(pratos.size()-1).getAlimentos().contains(ingredientes.get(i)))){
                                                        System.out.println(i+1 + " - " + ingredientes.get(i));
                                                        count += 1;
                                                    }
                                                }
                                                if (count != 0){
                                                    System.out.println("Escolha um ingrediente para remover.");
                                                    System.out.print("Ingrediente escolhido: ");
                                                    ingrediente_escolhido = sc.nextInt();
                                                    sc.nextLine();
                                                    if ((0 <= ingrediente_escolhido) && (ingrediente_escolhido <= ingredientes.size())){
                                                        pratos.get(opcao2).removeAlimento(ingredientes.get(ingrediente_escolhido-1));
                                                        System.out.println("Ingrediente " + ingredientes.get(ingrediente_escolhido-1) + " removido com sucesso do prato " + pratos.get(opcao2).getNome() + "!");
                                                        count -= 1;
                                                        System.out.println("Deseja adicionar remover mais algum ingrediente? (S ou N)");
                                                        System.out.print("Resposta: ");
                                                        resposta1 = sc.nextLine().toUpperCase();
                                                        if (resposta1.equals("N")){
                                                            trigger = false;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("Introduziu um número não tabelado.");
                                                        System.out.println("-------------------------------------\n");
                                                        trigger = false;
                                                    }
                                                }
                                                else{
                                                    System.out.println("Não se encontram disponíveis Ingredientes para remover do Prato, adicione mais ingredientes.");
                                                    System.out.println("-------------------------------------\n");
                                                    trigger = false;
                                                }
                                            }
                                            else{
                                                System.out.println("Não se encontram disponíveis Ingredientes para remover do Prato, adicione ingredientes.");
                                                System.out.println("-------------------------------------\n");
                                                trigger = false;
                                            }
                                        }  
                                    }
                                    else{
                                        System.out.println("Não se encontram disponíveis Ingredientes para remover do Prato, adicione ingredientes.");
                                        System.out.println("-------------------------------------\n");
                                    }
                                    break;
                                default:
                                    System.out.println("Introduziu uma opção inválida.");
                                    System.out.println("-------------------------------------\n");
                            }
                            break;
                        case 4:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");
                            break;

                        default:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");                    
                    }
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println(" *** Ementa ***");
                    System.out.println("Operações Disponíveis: ");
                    System.out.println("1 - Adicionar Prato");
                    System.out.println("2 - Remover Prato");
                    System.out.println("3 - Imprimir Ementa");
                    System.out.println("4 - Voltar");
                    System.out.print("Opção: ");
                    opcao1 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao1){
                        case 1: 
                            if (pratos.size() != 0){
                                String s = "";
                                for (int i = 0; i < pratos.size(); i++){
                                    if (!(ementa.getPratos().contains(pratos.get(i)))){
                                    s += i + 1 + " - " + pratos.get(i).getNome() + "\n";
                                    }
                                }

                                if (s.equals("")){
                                    System.out.println("Não se encontram disponíveis Pratos para adicionar ao Menu, crie Pratos novos.");
                                    System.out.println("-------------------------------------\n");
                                }

                                else{
                                System.out.println("Pratos Criados que não se encontram na ementa:");
                                System.out.println(s);
                                System.out.print("Selecionar: ");
                                opcao2 = sc.nextInt() - 1;
                                sc.nextLine();

                                ementa.addPrato(pratos.get(opcao2));
                                System.out.println("Prato " + pratos.get(opcao2).getNome() + " adicionado com sucesso à ementa!");
                                System.out.println("-------------------------------------\n");
                                }
                            }
                            else{
                                System.out.println("Não se encontram disponíveis Pratos para adicionar ao Menu, crie Pratos.");
                                System.out.println("-------------------------------------\n");
                            }
                            break;
                        
                        case 2:
                            System.out.println("Pratos que se encontram na ementa: ");
                            String s = "";
                            if (ementa.getPratos().size() != 0){
                                for (int i = 0; i < ementa.getPratos().size(); i++){
                                    s += i + 1 + " - " + ementa.getPratos().get(i).getNome() + "\n";
                                }
                                System.out.println(s);

                                System.out.print("Selecionar: ");
                                opcao2 = sc.nextInt() - 1;
                                sc.nextLine();
                                Prato prato_removido = ementa.getPratos().get(opcao2);
                                ementa.removePrato(prato_removido);
                                System.out.println("Prato " + prato_removido.getNome() + " removido com sucesso da ementa!");
                                
                            }
                            else{
                                System.out.println("Não se encontram disponíveis Pratos para remover do Menu, adicione Pratos.");
                                System.out.println("-------------------------------------\n");
                            }
                            break;
                        
                        case 3:
                            System.out.println("A imprimir ementa...");
                            System.out.println(ementa);
                            break;

                        case 4:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");
                            break;

                        default:
                            System.out.println("A voltar...");
                            System.out.println("-------------------------------------\n");
                            
                    }    
            }

        }
        sc.close();
    }
}
