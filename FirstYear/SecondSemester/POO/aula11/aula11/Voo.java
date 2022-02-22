package aula11;
public class Voo {
    private String hora;
    private String empresa;
    private String id;
    private String origem;
    private String atraso;

    public Voo(String hora, String empresa, String id, String origem, String atraso) {
        this.hora = hora;
        this.empresa = empresa;
        this.id = id;
        this.origem = origem;
        this.atraso = atraso;
    }
    
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getAtraso() {
        return atraso;
    }
    public void setAtraso(String atraso) {
        this.atraso = atraso;
    }

    public String toString(){
        return hora + " " + empresa + " " + id + " " + origem + " " + atraso;
    }

    public boolean equals(Voo v2){
        if (hora.equals(v2.getHora()) && empresa.equals(v2.getEmpresa()) && id.equals(v2.getId()) && origem.equals(v2.getOrigem()) && atraso.equals(v2.getAtraso())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return hora.hashCode() + empresa.hashCode() + id.hashCode() + origem.hashCode() + atraso.hashCode();
    }
    
}
