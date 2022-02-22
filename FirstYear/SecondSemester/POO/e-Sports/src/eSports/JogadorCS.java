package eSports;

public class JogadorCS extends Jogador {
    private CSGORole role;
    private int kills;
    private int deaths;
    private double kills_p_death;
    private double hs_rate;
    private int points;

    public JogadorCS(String nome, EModalidade modalidade,CSGORole role){
        super(nome, modalidade);
        this.role = role;
        kills = 0;
        deaths = 0;
        kills_p_death = 0.0;
        hs_rate = 0.0;
        points = 0;

    }

    public void setRole(CSGORole role) {
        this.role = role;
    }
    public CSGORole getRole() {
        return role;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
    public int getKills() {
        return kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    public int getDeaths() {
        return deaths;
    }

    public void setKills_p_death(double kills_p_deaths) {
        this.kills_p_death = kills_p_deaths;
    }
    public double getKills_p_death() {
        return kills_p_death;
    }

    public void setHs_rate(double hs_rate) {
        this.hs_rate = hs_rate;
    }
    public double getHs_rate() {
        return hs_rate;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() {
        return points;
    }


    public StringBuilder enumStats(){
        StringBuilder s = new StringBuilder();
        s.append("Kills: " + kills + "\n");
        s.append("Deaths: " + deaths + "\n");
        s.append("Kills/Death: " + kills_p_death + "\n");
        s.append("HS Rate(%): " + hs_rate + "\n");
        s.append("Points: " + points + "\n");
        return s;
    }
    @Override
    public String toString() {
        return super.toString() + " | " + role.toString();
    }


    public boolean equals(JogadorCS j) {
        if (super.equals(j) && role.equals(j.getRole()) && kills==j.getKills() &&
        deaths==j.getDeaths() && kills_p_death==j.getKills_p_death() && 
        hs_rate==j.getHs_rate() && points==j.getPoints()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + role.hashCode() + kills + deaths + (int) kills_p_death + (int) hs_rate + points;
    }



}
