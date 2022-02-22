package aula05;
import java.util.Arrays;

public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1,double lado2,double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1(){
        return lado1;
    }

    public double getLado2(){
        return lado2;
    }

    public double getLado3(){
        return lado3;
    }

    public void setLado1(double lado1){
        this.lado1 = lado1;
    }

    public void setLado2(double lado2){
        this.lado2 = lado2;
    }

    public void setLado3(double lado3){
        this.lado3 = lado3;
    }


    public String toString(){
        if (lado1 > 0 && lado2 > 0 && lado3 > 0) return "Triângulo com Lado1 = " + lado1 + "; Lado2 = " + lado2 + "; Lado3 = " + lado3 + ";";
        return "Triângulo com dimensões impossíveis. Lado 1: " + lado1 + "; Lado 2: " + lado2 + "; Lado 3: " + lado3;
    }

    public boolean equals(Triangulo a){
        if ((lado1 == a.getLado1()) && (lado2 == a.getLado2()) && (lado3 == a.getLado3())){
            return true;
        }
        else return false;
    }

    public double calcArea(){
        double s = calcPerimeter()/2;
        double[] values = {lado1, lado2, lado3};
        Arrays.sort(values);
        if ((values[2] < (values[0] + values[1])) && lado1 > 0 && lado2 > 0 && lado3 > 0){
            double a = values[0];
            double b = values[1];
            double c = values[2];
            double area = Math.pow(s*(s-a)*(s-b)*(s-c), 0.5);
            return area;
        }
        return -1;
    }

    public double calcPerimeter(){
        if (lado1 > 0 && lado2 > 0 && lado3 > 0) return lado1 + lado2 + lado3;
        return -1;
    }
}

