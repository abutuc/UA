package PPGonçalo;

public class CanalEstrangeiro extends Canal {
    String lingua;
    boolean legendado;

    public CanalEstrangeiro(String nome, boolean codificado, String lingua, boolean legendado){
        super(nome, codificado);
        this.lingua = lingua;
        this.legendado = legendado;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    public String toString(){
        String leg = "";
        if (legendado){
            leg = "Legendado";
        }
        else{
            leg = "Não Legendado";
        }
        return super.toString() + " | Língua: " + lingua + " | " + leg;
    }

    public boolean equals(CanalEstrangeiro c2){
        if (super.equals(c2) && lingua.equals(c2.getLingua()) && (legendado==c2.isLegendado())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        int i = 0;
        if(legendado){
            i = 1;
        }
        return super.hashCode() + lingua.hashCode() + i;
    }
}
