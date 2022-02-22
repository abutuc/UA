import aula05.Ponto;
import aula05.Retangulo;
import aula05.Triangulo;
import aula05.Circulo;

public class Ex1 {
    
    public static void main(String[] args){
        Ponto p0 = new Ponto(0,0);
        Ponto p1 = new Ponto(3, 4);
        Ponto p2 = new Ponto(4,5);
        Ponto p3 = new Ponto(24,15);

        System.out.println(p1.getX());
        System.out.println(p1.getY());

        p1.setX(5);
        p1.setY(2);

        System.out.println(p1.getX());
        System.out.println(p1.getY());

        System.out.println(p2.toString());

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p1));

        System.out.println(Ponto.distBetweenPontos(p0, p0));
        System.out.println(Ponto.distBetweenPontos(p0, p1));
        System.out.println(Ponto.distBetweenPontos(p1, p2));

        Triangulo triangulo1 = new Triangulo(3, 6, 7);
        Triangulo triangulo2 = new Triangulo(5, 10, 3);

        System.out.println(triangulo1.getLado1());
        System.out.println(triangulo1.getLado2());
        System.out.println(triangulo1.getLado3());

        triangulo1.setLado1(7);
        triangulo1.setLado2(6);
        triangulo1.setLado3(3);

        System.out.println(triangulo1.getLado1());
        System.out.println(triangulo1.getLado2());
        System.out.println(triangulo1.getLado3());

        System.out.println(triangulo1.toString());

        System.out.println(triangulo1.equals(triangulo2));
        System.out.println(triangulo1.equals(triangulo1));

        System.out.println(triangulo1.calcPerimeter());
        System.out.println(triangulo2.calcPerimeter());

        System.out.println(triangulo1.calcArea());
        System.out.println(triangulo2.calcArea());
        

        Retangulo retangulo1 = new Retangulo(5, 3);
        Retangulo retangulo2 = new Retangulo(3, 10);

        System.out.println(retangulo1.getComprimento());
        System.out.println(retangulo1.getAltura());

        retangulo1.setAltura(6);
        retangulo1.setComprimento(0);

        System.out.println(retangulo1.getComprimento());
        System.out.println(retangulo1.getAltura());

        System.out.println(retangulo1.toString());

        System.out.println(retangulo1.equals(retangulo2));
        System.out.println(retangulo1.equals(retangulo1));
        
        System.out.println(retangulo1.calcArea());
        System.out.println(retangulo1.calcPerimeter());
        
        Circulo circulo1 = new Circulo(4, p0);
        Circulo circulo2 = new Circulo(2, p1);
        Circulo circulo3 = new Circulo(3, p2);
        Circulo circulo4 = new Circulo(3, p3);

        System.out.println(circulo1.getR());
        System.out.println(circulo1.getC());

        circulo1.setR(0);
        circulo1.setC(p1);

        System.out.println(circulo1.getR());
        System.out.println(circulo1.getC());

        System.out.println(circulo1.toString());

        System.out.println(circulo1.equals(circulo2));
        System.out.println(circulo1.equals(circulo3));
        System.out.println(circulo1.equals(circulo1));

        System.out.println(circulo1.calcArea());
        System.out.println(circulo1.calcPerimeter());

        System.out.println(circulo3.calcArea());
        System.out.println(circulo3.calcPerimeter());

        System.out.println(Circulo.intersectCirculos(circulo2, circulo3));
        System.out.println(Circulo.intersectCirculos(circulo2, circulo4));


    }
}
