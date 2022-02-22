package aula05;
public class Retangulo {
    double comprimento;
    double altura;

    public Retangulo(double c, double a){
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
        if (comprimento > 0 && altura > 0) return "Retângulo com comprimento " + comprimento + " e altura " + altura;
        return "Retângulo com dimensões não possíveis. Comprimento: " + comprimento + "; Altura: " + altura;
    }

    public boolean equals(Retangulo a){
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
