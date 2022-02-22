package aula06;
import java.time.LocalDate;
import java.lang.Comparable;

public class Data implements Comparable<Data>{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return dia;
    }

    public int getAno(){
        return dia;
    }

    public static Data today(){
        String now = LocalDate.now().toString();
        String[] content = now.split("-");

        int t_dia = Integer.parseInt(content[2]);
        int t_mes = Integer.parseInt(content[1]);
        int t_ano = Integer.parseInt(content[0]);

        return new Data(t_dia, t_mes, t_ano);
    }

    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }

    @Override
    public int compareTo(Data d) {

        if ( dia > d.getDia() && mes > d.getMes() && ano > d.getAno()){
            return 1;
        }

        else if (dia < d.getDia() && mes < d.getMes() && ano < d.getAno()){
            return -1;
        }

        return 0;
    }
}
