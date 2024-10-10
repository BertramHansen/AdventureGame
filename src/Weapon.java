public abstract class Weapon extends Item {
    private String name;
    private int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract boolean canUse();
    public abstract void use();

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
    @Override
    public String toString(){
        return getShortName() + ": " + getLongName() + " Damage: " + getDamage();
    }
}