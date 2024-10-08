public abstract class Weapon extends Item {
    private double damage;
    private double remainingUses;

    public Weapon(String shortName, String longName, double damage, double remainingUses) {
        super(shortName, longName);
        this.shortName = shortName;
        this.longName = longName;
        this.damage = damage;
        this.remainingUses = remainingUses;
    }

    public double getDamage() {
        return damage;
    }
    public double remainingUses(){
        return remainingUses;
    }
}


