public class Food extends Item{
    private final int healthPoint;

    public Food (String shortName, String longname, int healthPoint){
        super(shortName, longname);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint(){
        return healthPoint;
    }
}

