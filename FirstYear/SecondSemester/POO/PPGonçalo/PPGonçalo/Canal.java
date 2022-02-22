package PPGonçalo;

public class Canal {
    private static int id_temp = 1;
    private String nome;
    private int id;
    private boolean codificado;
    
    public Canal(String nome, boolean codificado){
        this.nome = nome;
        this.codificado = codificado;
        id = id_temp;
        id_temp++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCodificado() {
        return codificado;
    }

    public void setCodificado(boolean codificado) {
        this.codificado = codificado;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        String cod = "";
        if (codificado){
            cod = "Codificado";
        }
        else{
            cod = "Não Codificado";
        }
        return "Canal " + id + " | " + nome + " | " + cod;
    }

    public boolean equals(Canal c1){
        if(id==c1.getId() && nome.equals(c1.getNome()) && codificado==c1.isCodificado()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        int i = 0;
        if(codificado){
            i = 1;
        }
        return nome.hashCode() + id + i;
    }
}
