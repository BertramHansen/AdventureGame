public class Food extends Item{
    private final int healthPoint;
    private boolean edible = false;

    public Food (String shortName, String longname, int healthPoint){
        super(shortName, longname);
        this.healthPoint = healthPoint;
    }

    public boolean isEdible(){
        return true;
    }
    public boolean isnotEdible(){
        return false;
    }
}

