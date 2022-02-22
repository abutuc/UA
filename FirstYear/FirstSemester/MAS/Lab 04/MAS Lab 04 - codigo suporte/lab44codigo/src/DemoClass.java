import ementas.*;

import java.time.LocalDateTime;
import java.util.Random;

public class DemoClass {


    public static void main(String[] args) {

        System.out.println("\n\nA preparar os dados aleatórios...");
        Ementa ementadeHoje = gerarEmentaAleatoria("Menu Primavera", "Loja 1");

        System.out.println("\n\nEmenta para hoje:" + ementadeHoje.toString());

        // criar um pedido de exemplo
        Cliente cliente = new Cliente("Joao Pinto");
        Pedido pedido = new Pedido(cliente, LocalDateTime.now());

        // adiciona um prato à sorte, da ementa do dia
        Prato opcao = ementadeHoje.listarPrato(sortearUmPrato());
        pedido.adicionarPrato(opcao);
        
        // adiciona outro prato à sorte, da ementa do dia
        opcao = ementadeHoje.listarPrato(sortearUmPrato());
        pedido.adicionarPrato(opcao);

        System.out.println("\n\n__Pedido gerado__");
        System.out.println("Pedido: " + pedido);
        System.out.println("Preço do Pedido: " + pedido.calcularTotal());
        System.out.println("Calorias do Pedido: " + pedido.calcularCalorias());
    }
    

    /*
     * retorna uma ordem na ementa (e.g. 3º opção da ementa)
     */
    private static int sortearUmPrato() {
        return ((new Random()).nextInt(Ementa.NR_PRATOS_NA_EMENTA));
    }


    /*
     * Gera uma ementa, com a designação fornecida em parâmetro, e acrescenta
     * alguns pratos aleatoriamente.
     */
    private static Ementa gerarEmentaAleatoria(String designacao, String local) {
        Ementa ementa = new Ementa(designacao, local, LocalDateTime.now());

        for (int nrOpcaoPrato = 0; nrOpcaoPrato < Ementa.NR_PRATOS_NA_EMENTA; nrOpcaoPrato++) {

            Prato prato = gerarPratoAleatorio(nrOpcaoPrato + 1);
            System.out.println("A gerar .. " + prato);

            // Adiciona 2 ingredientes a cada prato
            int nrIngrediente = 1;
            do {
                Alimento aux = gerarAlimentoAleatorio();

                if (prato.addIngrediente(aux)) {
                    System.out.println("\tIngrediente " + nrIngrediente + " adicionado: " + aux);
                    nrIngrediente++;
                } else
                    System.out.println("\tERRO: ingrediente sorteado nao é adequado " + nrIngrediente + ": " + aux);

            } while (nrIngrediente < 3);

            ementa.addPrato(prato);
        }
        return ementa;
    }

    /*
     * Gera uma ocorrencia de Alimento, com dados aleatorios
     */
    public static Alimento gerarAlimentoAleatorio() {
        Alimento res = null;
        switch ((int) (Math.random() * 4)) {
            case 0:
                res = new Carne(VariedadeCarne.FRANGO, 22.3, 345.3, 300);
                break;
            case 1:
                res = new Peixe(TipoPeixe.CONGELADO, 31.3, 25.3, 200);
                break;
            case 2:
                res = new Legume("Couve Flor", 21.3, 22.4, 150);
                break;
            case 3:
                res = new Cereal("Milho", 19.3, 32.4, 110);
                break;
        }
        return res;
    }

    /*
     * Gera uma ocorrencia de Prato, com dados aleatorios
     */
    public static Prato gerarPratoAleatorio(int i) {
        Prato res = null;
        switch ((int) (Math.random() * 3)) {
            case 0:
                res = new Prato("Combinado n." + i, 100d);
                break;
            case 1:
                res = new PratoVegetariano("Vegetariano n." + i, 120d);
                break;
            case 2:
                res = new PratoDieta("Dieta n." + i, 200, 90.8);
                break;
        }
        return res;
    }


    public static Alimento randAlimento() {
        throw new UnsupportedOperationException();
    }


}
