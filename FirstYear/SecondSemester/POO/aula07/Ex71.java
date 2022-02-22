import java.util.Scanner;

import aula07.Agencia;
import aula07.Alojamento;
import aula07.CarroAluguer;

import java.util.ArrayList;
public class Ex71 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Getting into the system...");
        Agencia agencia = new Agencia("Butuc's Agency", "Rua 25 de Abril" );
        System.out.println("Ready!");

        int option = 0;
        ArrayList<String> tiposQuarto = new ArrayList<String>();
        tiposQuarto.add("single");
        tiposQuarto.add("double");
        tiposQuarto.add("twin");
        tiposQuarto.add("triple");
        
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};

        ArrayList<String> tipos_viatura = new ArrayList<String>();
        tipos_viatura.add("diesel");
        tipos_viatura.add("gasolina");


        while(option != 9){
            System.out.println("1 - Registar Alojamento");
            System.out.println("2 - Registar Viatura de Aluguer");
            System.out.println("3 - Editar Alojamento");
            System.out.println("4 - Editar Viatura de Aluguer");
            System.out.println("5 - Listar Alojamentos");
            System.out.println("6 - Listar Viaturas");
            System.out.println("7 - CheckIn/CheckOut Alojamento");
            System.out.println("8 - Alugar/Entregar Viatura");
            System.out.println("9 - Sair");

            System.out.print("Operação: ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:
                    System.out.printf("Deseja registar um:\n1 - Alojamento\n2 - Apartamento\n3 - Quarto de Hotel\n");
                    System.out.print("Opção: ");
                    int optionRegisto = sc.nextInt();
                    sc.nextLine();
                    switch(optionRegisto){
                        case 1:
                            System.out.print("Código: ");
                            String codigo_aloj = sc.nextLine();
                            System.out.print("Nome: ");
                            String nome_aloj = sc.nextLine();
                            System.out.print("Local: ");
                            String local_aloj = sc.nextLine();
        
                            agencia.addAlojamento(agencia.registarAlojamento(codigo_aloj, nome_aloj, local_aloj));
                            System.out.printf("\nAlojamento registado com sucesso!\n");
                            break;
                        case 2:
                            System.out.print("Código: ");
                            String codigo_apart = sc.nextLine();
                            System.out.print("Nome: ");
                            String nome_apart = sc.nextLine();
                            System.out.print("Local: ");
                            String local_apart = sc.nextLine();
                            System.out.print("Número de Quartos: ");
                            int nrQuartos = sc.nextInt();
        
                            agencia.addAlojamento(agencia.registarApartamento(codigo_apart, nome_apart, local_apart, nrQuartos));
                            System.out.printf("\nApartamento registado com sucesso!\n");
                            break;
                        case 3:
                            System.out.print("Código: ");
                            String codigo_q = sc.nextLine();
                            System.out.print("Nome: ");
                            String nome_q = sc.nextLine();
                            System.out.print("Local: ");
                            String local_q = sc.nextLine();
                            System.out.print("Tipo de Quarto: ");
                            String tipoQ = sc.nextLine().toLowerCase();
                            while (!tiposQuarto.contains(tipoQ)){
                                System.out.println("Tipo de Quarto inválido. Introduza um tipo da seguinte lista: " + tiposQuarto.toString());
                                System.out.print("Tipo de Quarto: ");
                                tipoQ = sc.nextLine().toLowerCase();
                            }
                            agencia.addAlojamento(agencia.registarQuartoHotel(codigo_q, nome_q, local_q, tipoQ));
                            System.out.printf("\nQuarto de Hotel registado com sucesso!\n");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Classe: ");
                    char classe_c = Character.toUpperCase(sc.next().toCharArray()[0]);
                    sc.nextLine();
                    boolean valid_input_classe = false;
                    String char_string = "[";
                    for(char c: chars){
                        char_string += c + " ";
                    }
                    char_string += "]";

                    while (!valid_input_classe){
                        for (int i = 0; i < chars.length; i++){
                            if (chars[i] == classe_c){
                                valid_input_classe = true;
                                break;
                            }
                        }
                        if(!valid_input_classe){
                            System.out.println("Classe introduzida inválida. Escolha uma classe da seguinte lista: " + char_string);
                            System.out.print("Classe: ");
                            classe_c = Character.toUpperCase(sc.next().toCharArray()[0]);
                        }
                    }

                    System.out.print("Tipo: ");
                    sc.nextLine();
                    String tipo_c = sc.nextLine().toLowerCase();
                    while(!tipos_viatura.contains(tipo_c)){
                        System.out.println("Tipo de Viatura introduzido inválido. Escolha um tipo da seguinte lista: " + tipos_viatura.toString());
                        System.out.print("Tipo: ");
                        tipo_c = sc.nextLine().toLowerCase();
                    }

                    agencia.addViatura(agencia.registarViatura(classe_c, tipo_c));
                    break;
                case 3:
                    System.out.println("Lista de Alojamentos Registados: ");
                    System.out.println(agencia.enumAlojamentos());
                    System.out.print("Introduza o índice do alojamento que quer editar: ");
                    int escolha_aloj = sc.nextInt()-1;
                    sc.nextLine();
                    Alojamento escolhido = agencia.getAlojamento().get(escolha_aloj);
                    System.out.println("A editar " + escolhido);
                    System.out.printf("Editar :\n1. Preço Noite\n2. Disponibilidade\n3. Avaliação\n4. Código\n5. Nome\n6. Local\n");
                    System.out.print("Opção: ");
                    int edicao_escolhida = sc.nextInt();
                    sc.nextLine();
                    switch(edicao_escolhida){
                        case 1: 
                            System.out.print("Preço Noite: ");
                            escolhido.setPrecoNoite(sc.nextDouble());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 2: 
                            System.out.print("Disponibilidade (true/false): ");
                            escolhido.setDisponibilidade(sc.nextBoolean());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 3: 
                            System.out.print("Avaliação: ");
                            escolhido.setAvaliação(sc.nextDouble());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 4: 
                            System.out.print("Código: ");
                            escolhido.setCodigo(sc.nextLine());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 5: 
                            System.out.print("Nome: ");
                            escolhido.setNome(sc.nextLine());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 6: 
                            System.out.print("Local: ");
                            escolhido.setLocal(sc.nextLine());
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        default:
                            System.out.println("Edição falhada. Reveja os dados introduzidos.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de Viaturas Registadas: ");
                    System.out.println(agencia.enumCarrosAluguer());
                    System.out.print("Introduza o índice da viatura que quer editar: ");
                    int escolha_viatura = sc.nextInt()-1;
                    sc.nextLine();
                    CarroAluguer escolhida = agencia.getCarroAluguer().get(escolha_viatura);
                    System.out.println("A editar " + escolhida);
                    System.out.printf("Editar :\n1. Classe\n2. Tipo\n3. Disponibilidade\n");
                    System.out.print("Opção: ");
                    int edicao_escolhida_v = sc.nextInt();
                    sc.nextLine();
                    switch(edicao_escolhida_v){
                        case 1: 
                        char classe_c_v = Character.toUpperCase(sc.next().toCharArray()[0]);
                        boolean valid_input_classe_v = false;
                        String char_string_v = "[";
                        for(char c: chars){
                            char_string_v += c + " ";
                        }
                        char_string_v += "]";
    
                        while (!valid_input_classe_v){
                            for (int i = 0; i < chars.length; i++){
                                if (chars[i] == classe_c_v){
                                    valid_input_classe_v = true;
                                    break;
                                }
                            }
                            if(!valid_input_classe_v){
                                System.out.println("Classe introduzida inválida. Escolha uma classe da seguinte lista: " + char_string_v);
                                System.out.print("Classe: ");
                                classe_c_v = Character.toUpperCase(sc.next().toCharArray()[0]);
                            }
                        }
                            escolhida.setClasse(classe_c_v);
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 2: 
                            System.out.print("Tipo: ");
                            String tipo_c_v = sc.nextLine().toLowerCase();
                            while(!tipos_viatura.contains(tipo_c_v)){
                                System.out.println("Tipo de Viatura introduzido inválido. Escolha um tipo da seguinte lista: " + tipos_viatura.toString());
                                System.out.print("Tipo: ");
                                tipo_c_v = sc.nextLine().toLowerCase();
                            }
                            escolhida.setTipo(tipo_c_v);
                            System.out.println("Edição realizada com sucesso.");
                            break;
                        case 3: 
                            System.out.print("Disponibilidade (true/false): ");
                            escolhida.setDisponibilidade(sc.nextBoolean());
                            System.out.println("Edição realizada com sucesso.");
                            sc.nextLine();
                            break;
                        default:
                            System.out.println("Edição falhada. Reveja os dados introduzidos.");
                    }
                    break;
                case 5:
                    System.out.println("Alojamentos: ");
                    System.out.println(agencia.enumAlojamentos());
                    break;
                case 6:
                    System.out.println("Viaturas de Aluguer:");
                    System.out.println(agencia.enumCarrosAluguer());
                    break;
                case 7:
                    System.out.print("Escolha a ação que quer executar:\n1 - CheckIn\n2 - CheckOut\n");
                    System.out.print("Opção: ");
                    int opcao_7 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao_7){
                      case 1:
                        if (agencia.enumAlojamentosDisponiveis().equals("")){
                            System.out.println("Não exitem alojamentos disponíveis para check-in neste momento.");
                        }
                        else{
                        System.out.println("Alojamentos disponíveis para checkIn: ");
                        System.out.println(agencia.enumAlojamentosDisponiveis());
                        System.out.print("Indice do alojamento para checkIn: ");
                        int indice_escolhido = sc.nextInt()-1;
                        Alojamento aloj_checkIn = agencia.getAlojamento().get(indice_escolhido);
                        sc.nextLine();
                        aloj_checkIn.checkIn();
                        System.out.println("\nCheck-In realizado com sucesso em " + aloj_checkIn.getNome());
                        }
                        break;
                    case 2:
                        if (agencia.enumAlojamentosInDisponiveis().equals("")){
                            System.out.println("\nNão exitem alojamentos disponíveis para check-out neste momento.");
                        }
                        else{
                            System.out.println("Alojamentos disponíveis para checkOut: ");
                            System.out.println(agencia.enumAlojamentosInDisponiveis());
                            System.out.print("Indice do alojamento para checkOut: ");
                            int indice_escolhido_o = sc.nextInt()-1;
                            Alojamento aloj_checkOut = agencia.getAlojamento().get(indice_escolhido_o);
                            sc.nextLine();
                            System.out.println("Em quanto quer avaliar o serviço do alojamento " + aloj_checkOut.getNome() + "?");
                            System.out.print("Avaliação: ");
                            double avaliacao_checkout = sc.nextDouble();
                            aloj_checkOut.checkOut(avaliacao_checkout);
                            System.out.println("Check-Out realizado com sucesso em " + aloj_checkOut.getNome());
                        }
                        break;
                    default:
                        System.out.println("Operação introduzida inválida.");
                    }
                    break;
                case 8:
                    System.out.print("Escolha a ação que quer executar:\n1 - Alugar\n2 - Entregar\n");
                    System.out.print("Opção: ");
                    int opcao_8 = sc.nextInt();
                    sc.nextLine();
                    switch(opcao_8){
                        case 1:
                            System.out.println("Viaturas disponíveis para alugar: ");
                            System.out.println(agencia.enumCarrosAluguerDisponiveis());
                            System.out.print("Indice da Viatura para alugar: ");
                            int indice_escolhido_v = sc.nextInt()-1;
                            CarroAluguer viatura_aluguer = agencia.getCarroAluguer().get(indice_escolhido_v);
                            sc.nextLine();
                            viatura_aluguer.levantarCarro();
                            System.out.println("Foi efetuado com sucesso o levantamento da viatura com o código " + viatura_aluguer.getCodigo());
                            break;
                        case 2:
                            System.out.println("Viaturas disponíveis para entregar: ");
                            System.out.println(agencia.enumCarrosAluguerIndisponiveis());
                            System.out.print("Indice da Viatura para entregar: ");
                            int indice_escolhido_v_e = sc.nextInt()-1;
                            CarroAluguer viatura_aluguer_e = agencia.getCarroAluguer().get(indice_escolhido_v_e);
                            sc.nextLine();
                            viatura_aluguer_e.entregarCarro();
                            System.out.println("Foi efetuado com sucesso a entrega da viatura com o código " + viatura_aluguer_e.getCodigo());
                            break;
                        default:
                        System.out.println("Opção introduzida inválida.");
                    } 
                    break;
            }
            System.out.println();
        }


        System.out.println("-------------------- Obrigado por utilizar o nosso serviço --------------------\n");

        sc.close();
    }
} 
