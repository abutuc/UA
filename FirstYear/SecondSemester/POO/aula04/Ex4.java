package aula04;
import java.util.Scanner;
public class Ex4 {
    
    public static void main(String[] args){
        int[] data = dataReading();
        int mes = data[0];
        int ano = data[1];
        int dia_semana = data[2];
        int dias = data[3];
        printCalendar(mes, ano, dia_semana, dias);
    }
    
    public static int[] dataReading(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Mês: ");
        int mes = sc.nextInt();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Dia da semana em que começa o mês: ");
        int dia_semana = sc.nextInt();
        int dias = daysOfMonth(mes, ano);
        int[] data = {mes, ano, dia_semana, dias};
        sc.close();
        return data;
    }

    public static int daysOfMonth(int mes, int ano){
        int dias;
        int[] meses = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean isLeap = false;
        if (ano % 4 == 0){
            isLeap = true;
            if (ano % 100 == 0){
                isLeap = false;
                if (ano % 400 == 0){
                    isLeap = true;
                }
            }
        }
        if (isLeap && mes == 2){
            dias = 29;
        }
        else {
            dias = meses[mes];
        }
        return dias;
    }

    public static void printCalendar(int mes, int ano, int dia_semana, int dias){
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.printf("%16s %4d\n", months[mes], ano);
        System.out.printf("  Su  Mo  Tu  We  Th  Fr  Sa\n");
        int[] equivalencia = {0, 8, 12, 16, 20, 24,28, 4};
        int first_spaces = equivalencia[dia_semana];
        dia_semana++;
        System.out.printf("%" + first_spaces + "s", 1);
        int spaces = 4;
        for (int i = 2; i <= dias; i++){
            if(dia_semana > 7){
                dia_semana = 1;
            }
            if (dia_semana + 1 == 7){
                System.out.printf("%" +spaces+ "s\n", i);
            }
            else {
                System.out.printf("%" +spaces+ "s", i);
            }
            dia_semana++;
        }
        System.out.println();
    }
}
