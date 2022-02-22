import aula08.AutoLigeiro;
import aula08.AutoPesado;
import aula08.Empresa;
import aula08.Motociclo;
import aula08.PesadoMercadorias;
import aula08.PesadoPassageiros;
import aula08.Taxi;
import aula08.Viatura;

public class Ex81 {
    
    public static void main (String[] args){
        Empresa empresa = new Empresa("Empresa Butuc", "3800", "andrebutuc@ua.pt");
        System.out.println(empresa);
        System.out.println();
        Viatura viatura1 = new Viatura("ABCABC");
        viatura1.setCilindrada(2000);
        viatura1.setMarca("BMW");
        viatura1.setModelo("X5");

        Motociclo motociclo1 = new Motociclo("BBBBBB", "desportivo");
        motociclo1.setCilindrada(3000);
        motociclo1.setMarca("Bugatti");
        motociclo1.setModelo("Promp");
        
        AutoLigeiro ligeiro = new AutoLigeiro("AAAAA", "120000223");
        ligeiro.setCapacidade_bagageira(200);
        ligeiro.setCilindrada(2300);
        ligeiro.setMarca("VW");
        ligeiro.setModelo("Sharan");
        
        Taxi taxi = new Taxi("CCCCCC", "120940499'", 9999);
        taxi.setCapacidade_bagageira(150);
        taxi.setCilindrada(2400);
        taxi.setMarca("Benz");
        taxi.setModelo("B2");
        
        AutoPesado pesado = new AutoPesado("DDDDDDD", "SOIDJPWOFOK");
        pesado.setCilindrada(3000);
        pesado.setMarca("Rolls");
        pesado.setModelo("XX");
        pesado.setPeso(2501);
        

        PesadoMercadorias pesMer = new PesadoMercadorias("EEEEEEE", "123ODKF33", 1000);
        pesMer.setCilindrada(3500);
        pesMer.setMarca("Toyota");
        pesMer.setModelo("Monster");
        pesMer.setPeso(3000);
        
        PesadoPassageiros pesPar = new PesadoPassageiros("FFFFFF", "124098", 25);
        pesPar.setCilindrada(3220);
        pesPar.setMarca("Ferrari");
        pesPar.setModelo("Bus");
        pesPar.setPeso(2502);
        
        empresa.addViatura(viatura1);
        empresa.addViatura(motociclo1);
        empresa.addViatura(ligeiro);
        empresa.addViatura(taxi);
        empresa.addViatura(pesado);
        empresa.addViatura(pesMer);
        empresa.addViatura(pesPar);

        System.out.println("Matriculas de Viaturas da Empresa:");
        System.out.println(empresa.enumViaturas());
        System.out.println();

        viatura1.trajeto(200);
        viatura1.trajeto(100);
        viatura1.trajeto(400);


        motociclo1.trajeto(125);
        motociclo1.trajeto(100);

        ligeiro.trajeto(50);

        taxi.trajeto(130);

        pesado.trajeto(200);

        pesMer.trajeto(300);

        pesPar.trajeto(20);

        Viatura max_distance = empresa.getViaturas().get(0);
        for (Viatura v: empresa.getViaturas()){
            if (v.distanciaTotal() > max_distance.distanciaTotal()){
                max_distance = v;
            }
        }
        System.out.println("Viatura com maior quilometros percorridos:");
        System.out.println(max_distance + " Distância Total: " + max_distance.distanciaTotal());
        System.out.println();

        System.out.println(empresa.getViaturas());      
    }
}
