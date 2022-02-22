import Q4.Complex;
import Q4.Ponto3D;

public class Q4 {
    public static void main(String[] args){
        Complex c1 = new Complex(3, -2);
        Complex c2 = new Complex(-1, 1);

        Ponto3D p1 = new Ponto3D(1,1,1);
        Ponto3D p2 = new Ponto3D(0, 0, 0);
        Ponto3D[] ps = new Ponto3D[10];

        System.out.println(c1.getImaginary());
        System.out.println(c1.getReal());
        System.out.println(c2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(ps);
    } 
}
