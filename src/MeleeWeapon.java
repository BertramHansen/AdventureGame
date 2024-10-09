public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }

    @Override
    public boolean canUse() {
        return true; // Melee weapons can always be used
    }

    @Override
    public void use() {
        // Melee weapon usage logic (e.g., swing, hit)
    }
}