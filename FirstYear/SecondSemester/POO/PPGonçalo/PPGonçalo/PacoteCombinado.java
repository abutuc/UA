package PPGonçalo;
import java.util.ArrayList;

public class PacoteCombinado{
    private ArrayList<Pacote> pacotes;

    public PacoteCombinado(){
        pacotes = new ArrayList<Pacote>();
    }

    public void addPacote(Pacote p1){
        pacotes.add(p1);
    }

    public void removePacote(Pacote p1){
        pacotes.remove(p1);
    }

    public ArrayList<Pacote> getPacotes(){
        return pacotes;
    }
    public String enumPacotes(){
        String s = "";
        for(Pacote p1: pacotes){
            s += p1.toString() + "\n";
        }
        return s;
    }

    public String toString(){
        return "Pacote Combinado | " + "Pacotes: \n" + enumPacotes();
    }

    public boolean equals(PacoteCombinado p1){
        if(enumPacotes().equals(p1.enumPacotes())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return enumPacotes().hashCode();
    }
}
