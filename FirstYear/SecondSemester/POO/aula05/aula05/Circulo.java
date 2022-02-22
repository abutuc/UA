package aula05;
public class Circulo {
    private double r;
    private Ponto c;

    public Circulo(double r, Ponto c){
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
        if (r > 0) return "Círculo com raio " + r + " e centro " + c; 
        return "Círculo com dimensões impossíveis. Raio: " + r + "; Centro: " + c;
    }

    public boolean equals(Circulo a){
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

    public static boolean intersectCirculos(Circulo circulo1, Circulo circulo2){
        circulo1.getC();
        double distanceBetweenCentros = Ponto.distBetweenPontos(circulo1.getC(), circulo2.getC());
        double sumRadious = circulo1.getR() + circulo1.getR();
        if (distanceBetweenCentros >= sumRadious){
            return false;
        }
        else return true;
    }
}
