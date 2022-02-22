package aula07;
import aula05.Ponto;

public class ObjetoMovel {
    private Ponto coordenadas;
    private double distancia_percorrida;

    public ObjetoMovel(Ponto coordenadas){
        this.coordenadas = coordenadas;
        distancia_percorrida = 0;
    }

    public void setCoordenadas(Ponto coordenadas){
        this.coordenadas = coordenadas;
    }

    public void setDistanciaPercorrida(int distancia_percorrida){
        this.distancia_percorrida = distancia_percorrida;
    }

    public Ponto getCoordenadas(){
        return coordenadas;
    }

    public double getDistanciaPercorrida(){
        return distancia_percorrida;
    }

    public String toString(){
        return "Coordenadas: " + coordenadas.toString() + " | Distancia Percorrida: " + distancia_percorrida;
    }

    public boolean equals(ObjetoMovel obj2){
        if ((coordenadas.equals(obj2.getCoordenadas())) && (distancia_percorrida == obj2.getDistanciaPercorrida())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return coordenadas.hashCode();
    }

    public void move(int newX, int newY){
        Ponto new_coords = new Ponto(newX, newY);
        distancia_percorrida += (Ponto.distBetweenPontos(coordenadas, new_coords)*100.0)/100.0;
        coordenadas = new_coords;
    }
}
