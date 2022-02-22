import java.util.ArrayList;

import aula08.Carne;
import aula08.Cereal;
import aula08.Ementa;
import aula08.Legume;
import aula08.Peixe;
import aula08.Prato;
import aula08.PratoDieta;
import aula08.PratoVegetariano;
import aula08.TipoPeixe;
import aula08.VariedadeCarne;
import aula08.Alimento;

public class A08E02 {

	public static void main(String[] args) {
		String [] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
		Ementa ementa = new Ementa("Especial Primavera", "Snack da UA");
		ArrayList <Prato> pratos = new ArrayList<Prato>();
		for (int i = 0; i < diasSemana.length; i++) {
			pratos.add(i, randPrato(i+1));
			System.out.println("A sair .. " + pratos.get(i));

			// Adiciona 2 ingredientes a cada prato
			int ingred = 1;
			do {
				Alimento aux = randAlimento();
				if (pratos.get(i).addAlimento(aux)) {
					System.out.println("\tIngrediente " + ingred + " adicionado: " + aux);
					ingred++;
				} else
					System.out.println("\tERRO: não é possível adicionar Ingrediente " + ingred + ": " + aux);
			} while (ingred < 3);

			ementa.addPratoS(pratos.get(i), diasSemana[i]);
		}
		System.out.println("\nEmenta final\n--------------------");
		System.out.println(ementa);
	}

	public static Alimento randAlimento() {
		Alimento res = null;
		switch ((int) (Math.random() * 4)) {
		case 0:
			res = new Carne(22.3, 345.3, 300, VariedadeCarne.FRANGO);
			break;
		case 1:
			res = new Peixe(31.3, 25.3, 200, TipoPeixe.CONGELADO);
			break;
		case 2:
			res = new Legume(21.3, 22.4, 150, "Couve Flor");
			break;
		case 3:
			res = new Cereal(19.3, 32.4, 110, "Milho");
			break;
		}
		return res;
	}

	public static Prato randPrato(int i) {
		Prato res = null;
		switch ((int) (Math.random() * 3)) {
		case 0:
			res = new Prato("combinado n." + i);
			break;
		case 1:
			res = new PratoVegetariano("combinado n." + i);
			break;
		case 2:
			res = new PratoDieta("combinado n." + i, 90.8);
			break;
		}
		return res;
	}

}
