package aula13;

public class Student {
    private int nmec;
    private String nome;
    private double atp;
    private double ac;
    private double ap;
    private int notaFinal;


    public Student(int nmec, String nome, double atp, double ac, double ap, int notaFinal){
        this.nmec = nmec;
        this.nome = nome;
        this.atp = atp;
        this.ac = ac;
        this.ap = ap;
        this.notaFinal = notaFinal;
    }
    public Student(int nmec, String nome, double atp, double ac){
        this.nmec = nmec;
        this.nome = nome;
        this.atp = atp;
        this.ac = ac;
        this.ap = 0.0;
        this.notaFinal = 0;
    }
    public Student(int nmec, String nome, double atp){
        this.nmec = nmec;
        this.nome = nome;
        this.atp = atp;
        this.ac = 0.0;
        this.ap = 0.0;
        this.notaFinal = 0;
    }
    public Student(int nmec, String nome){
        this.nmec = nmec;
        this.nome = nome;
        this.atp = 0.0;
        this.ac = 0.0;
        this.ap = 0.0;
        this.notaFinal = 0;
    }

    public void setNmec(int nmec) {
        this.nmec = nmec;
    }
    public int getNmec() {
        return nmec;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setAtp(double atp) {
        this.atp = atp;
    }
    public double getAtp() {
        return atp;
    }

    public void setAc(double ac) {
        this.ac = ac;
    }
    public double getAc() {
        return ac;
    }

    public void setAp(double ap) {
        this.ap = ap;
    }
    public double getAp() {
        return ap;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }
    public int getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        String atps;
        String acs;
        String aps;
        if (atp==0.0){
            atps = "";
            acs = "";
            aps = "";
        }
        else if (ac==0.0){
            atps = String.valueOf(atp);
            acs = "";
            aps = "";
        }
        else if(ap == 0.0){
            atps = String.valueOf(atp);
            acs = String.valueOf(ac);
            aps = "";
        }
        else{
            atps = String.valueOf(atp);
            acs = String.valueOf(ac);
            aps = String.valueOf(ap);
        }
        return nmec + " " + nome + " " + atps + " " + acs + " " + aps;
    }

    public boolean equals(Student stu) {
        if (nmec==stu.getNmec() && nome.equals(stu.getNome()) && atp==stu.getAtp() && ac==stu.getAc() && ap==stu.getAtp()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nmec + nome.hashCode() + (int) atp + (int) ac + (int) ap;
    }  
}
