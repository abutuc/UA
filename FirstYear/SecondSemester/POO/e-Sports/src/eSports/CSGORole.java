package eSports;

public enum CSGORole {
    ENTRYFRAGER("Entry-Frager"),
    SNIPER("Sniper"),
    BOMBPLANTER("Bomb Planter"),
    PUSHER("Pusher"),
    TEAMLEADER("Team Leader"),
    TEAMCALLER("Team Caller");

    private String name;
    
    private CSGORole(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
