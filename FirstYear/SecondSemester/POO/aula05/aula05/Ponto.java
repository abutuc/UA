package aula05;
public class Ponto {
    private double x;
    private double y;
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
    public String toString(){
        return "(" + x + ";" + y + ")";
    }

    public boolean equals(Ponto a){
        if ((x == a.getX()) && (y == a.getY())){
            return true;
        }
        else return false;
    }

    public static double distBetweenPontos(Ponto a, Ponto b){
        double xParcel = Math.pow(b.getX() - a.getX(),2);
        double yParcel = Math.pow(b.getY() - a.getY(),2);
        return Math.pow(xParcel + yParcel, 0.5);
    }
}   
