package aula02;

import java.util.Scanner;

public class Ex6b {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduza o tempo em segundos: ");
        int temp_total = sc.nextInt();

        int horas = temp_total / 3600;
        
        temp_total = temp_total % 3600;

        int minutos = temp_total / 60;

        temp_total = temp_total % 60;

        String[] translate = {"zero", "um", "dois","três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", 
                            "doze", "treze", "quatorze", "quinze", "desasseis", "desassete", "dezoito", "dezanove", "vinte", "vinte e um", "vinte e dois",
                            "vinte e três", "vinte e quatro", "vinte e cinco", "vinte e seis", "vinte e sete", "vinte e oito", "vinte e nove", "trinta", "trinta e um",
                            "trinta e dois", "trinta e três", "trinta e quatro", "trinta e cinco", "trinta e seis", "trinta e sete", "trinta e oito", "trinta e nove",
                            "quarenta", "quarenta e um", "quarenta e dois", "quarenta e três", "quarenta e quatro", "quarenta e cinco", "quarenta e seis", "quarenta e sete", 
                            "quarenta e oito", "quarenta e nove, cinquenta", "cinquenta e um","cinquenta e dois", "cinquenta e três", "cinquenta e quatro", "cinquenta e cinco", 
                            "cinquenta e seis", "cinquenta e sete", "cinquenta e oito", "cinquenta e nove", "sessenta"};

        String s_horas;
        
        String[] feminimo = {"uma", "duas"};
        if (horas == 1 || horas == 2){
            s_horas = feminimo[horas-1];
        }
        else {
            s_horas = translate[horas];
        }
        System.out.printf("%s horas, %s minutos e %s segundos. \n", s_horas, translate[minutos], translate[temp_total]);

        sc.close();
    }
}
