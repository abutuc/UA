package Q4;

public class Complex{
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    public double getImaginary() {
        return imaginary;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public double getReal() {
        return real;
    }

    @Override
    public String toString() {
        return "Complex Number | Real Part: " + real + " | Imaginary Part: " + imaginary;
    }

    public boolean equals(Complex c){
        if (real==c.getReal() && imaginary==c.getImaginary()){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (int) imaginary + (int) real;
    }
}
