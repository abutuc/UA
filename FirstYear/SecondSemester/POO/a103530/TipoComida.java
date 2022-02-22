package a103530;

public enum TipoComida {
    CHURRASQUEIRA("Churrasqueira"),ITALIANO("Italiano"),MARISQUEIRA("Marisqueira"),VEGETARIANO("Vegetariano");
    
    private String name;
    
    private TipoComida(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
