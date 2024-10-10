public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }

    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public void use() {
        if (ammo > 0) {
            ammo--;
            // Ranged weapon firing logic
        }
    }

    public int getAmmo() {
        return ammo;
    }
    @Override
    public String toString(){
        return getShortName() + ": " + getLongName() + " Damage: " + getDamage() + " Ammo left: " + getAmmo();
    }
}