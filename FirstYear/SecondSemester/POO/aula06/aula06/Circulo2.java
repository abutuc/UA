package aula06;

import aula05.Ponto;

public class Circulo2 extends Poligono {
    private double r;
    private Ponto c;

    public Circulo2(String cor, double r, Ponto c){
        super(cor);
        this.r = r;
        this.c = c;
    }

    public double getR(){
        return r;
    }

    public Ponto getC(){
        return c;
    }

    public void setR(double r){
        this.r = r;
    }

    public void setC(Ponto c){
        this.c = c;
    }

    public String toString(){
        if (r > 0) return "Círculo com raio " + r + ", centro " + c + " e cor " + getCor(); 
        return "Círculo com dimensões impossíveis. Raio: " + r + "; Centro: " + c + " e cor " + getCor();
    }

    public boolean equals(Circulo2 a){
        if ((r == a.getR()) && (c.equals(a.getC()))){
            return true;
        }
        else return false;
    }

    public double calcArea(){
        if (r > 0) return Math.PI * Math.pow(r, 2);
        return -1;
    }

    public double calcPerimeter(){
        if (r > 0) return 2*Math.PI*r;
        return -1;
    }

    public static boolean intersectCirculos(Circulo2 circulo1, Circulo2 circulo2){
        circulo1.getC();
        double distanceBetweenCentros = Ponto.distBetweenPontos(circulo1.getC(), circulo2.getC());
        double sumRadious = circulo1.getR() + circulo1.getR();
        if (distanceBetweenCentros >= sumRadious){
            return false;
        }
        else return true;
    }


}
