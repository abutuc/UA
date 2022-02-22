package aula08;
import java.util.ArrayList;
public class Empresa {
    private String nome;
    private String codigo_postal;
    private String email;
    private ArrayList<Viatura> viaturas;
    
    public Empresa(String nome, String codigo_postal, String email){
        this.nome = nome;
        this.codigo_postal = codigo_postal;
        if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            this.email = email;
        }
        else{
            this.email = "";
        }
        viaturas = new ArrayList<Viatura>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addViatura(Viatura viatura){
        viaturas.add(viatura);
    }

    public void removeViatura(Viatura viatura){
        viaturas.remove(viatura);
    }

    public ArrayList<Viatura> getViaturas(){
        return viaturas;
    }

    public String enumViaturas(){
        String s = "";
        for (Viatura v: viaturas){
            s += v.getMatricula() + "  ";
        }
        return s;
    }

    public String toString(){
        if (viaturas.size() == 0){
            return "Empresa | Nome: " + nome + " | Código Postal: " + codigo_postal + " | Email: " + email;
        }
        return "Empresa | Nome: " + nome + " | Código Postal: " + codigo_postal + " | Email: " + email + " Viaturas: " + enumViaturas();
    }

    public boolean equals(Empresa emp2){
        if ((nome.equals(emp2.getNome())) && (codigo_postal.equals(emp2.getCodigo_postal())) && (email.equals(emp2.getEmail())) && (enumViaturas().equals(emp2.enumViaturas()))){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return nome.hashCode() + codigo_postal.hashCode() + email.hashCode();
    }

    
}
