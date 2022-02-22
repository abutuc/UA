package aula06;

public class Retangulo2 extends Poligono {
    double comprimento;
    double altura;

    public Retangulo2(String cor, double c, double a){
        super(cor);
        comprimento = c;
        altura = a;
    }

    public double getComprimento(){
        return comprimento;
    }

    public double getAltura(){
        return altura;
    }

    public void setComprimento(double comprimento){
        this.comprimento = comprimento;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public String toString(){
        if (comprimento > 0 && altura > 0) return "Retângulo com comprimento " + comprimento + " e altura " + altura + " e cor " + getCor();
        return "Retângulo com dimensões não possíveis. Comprimento: " + comprimento + "; Altura: " + altura + " e cor " + getCor();
    }

    public boolean equals(Retangulo2 a){
        if ((comprimento == a.getComprimento()) && (altura == a.getAltura())){
            return true;
        }
        else return false;
    }

    public double calcArea(){
        if (comprimento > 0 && altura > 0) return comprimento * altura;
        return -1;
    }

    public double calcPerimeter(){
        if (comprimento > 0 && altura > 0) return (comprimento * 2) + (altura * 2);
        return -1;
    }
}
