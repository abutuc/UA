package Q4;

public class Ponto3D {
    private double x;
    private double y;
    private double z;

    public Ponto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Ponto3D | (" + x + ";" + y + ";" + z + ")";
    }

    public boolean equals(Ponto3D p){
        if (x==p.getX() && y==p.getY() && z==p.getZ()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (int) x + (int) y + (int) z;
    }
}
