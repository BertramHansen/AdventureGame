import java.util.ArrayList;

public class Player {
    private Room placement;
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Item> equipped = new ArrayList<>();
    private Weapon currentEquipped;
    private int playerHealth = 100;

    public Player(Room placement) {
        this.placement = placement;
        this.inventory = new ArrayList<>(); //initialisering
    }

    public void increaseHealth(int increase) {
        playerHealth += increase;
    }

    public void decreaseHealth(int decrease) {
        playerHealth = playerHealth - (decrease);
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public ArrayList<Item> getEquipped() {
        return equipped;
    }

    public Room move(String movement) {
        if (movement.equalsIgnoreCase("go north") && placement.getNeighbourNorth() != null) {
            placement = placement.getNeighbourNorth();
        } else if (movement.equalsIgnoreCase("go south") && placement.getNeighbourSouth() != null) {
            placement = placement.getNeighbourSouth();
        } else if (movement.equalsIgnoreCase("go west") && placement.getNeighbourWest() != null) {
            placement = placement.getNeighbourWest();
        } else if (movement.equalsIgnoreCase("go east") && placement.getNeighbourEast() != null) {
            placement = placement.getNeighbourEast();
        } else {
            return null;
        }
        return placement;
    }


    public String takeItem(String itemName) {
        Item foundItem = placement.findItem(itemName);

        if (foundItem != null) {
            inventory.add(foundItem);
            placement.removeItem(foundItem);
            return "You took the " + foundItem.getShortName();
        } else {
            return "There is no " + itemName + " here.";
        }

    }

    public Item getCurrentEquipped() {
        return currentEquipped;
    }

//    public String equipWeapon(String itemName) {
//        Item foundWeapon = findItemInInventory(itemName);
//        if (foundWeapon != null) {
//            equipped.add(foundWeapon);
//            inventory.remove(foundWeapon);
//

//            return "You just equipped the " + foundWeapon.getShortName();
//        } else {
//            return "There is no " + foundWeapon + " in your inventory";
//        }
//    }

    public String dropItem(String itemName) {
        Item foundItem = findItemInInventory(itemName);

        if (foundItem != null) {
            inventory.remove(foundItem);
            placement.addItem(foundItem);
            return "You dropped the " + foundItem.getShortName();
        } else {
            return "There is no " + itemName + " in your inventory";

        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName) || item.getLongName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String currentRoomName() {
        return placement.getName();
    }

    public String currentRoomDescription() {
        return placement.getRoomDescription();
    }

    public Room getPlacement() {
        return placement;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public FoodStatus eat(String foodName) {
        Item itemToEat = findItemInInventory(foodName);
        if (itemToEat == null) {
            itemToEat = placement.findItem(foodName);
            if (itemToEat == null) {
                return FoodStatus.NOT_HERE; // Mad findes ikke
            }
        }
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;
            if (food.getHealthPoint() > 0) {
                increaseHealth(food.getHealthPoint());
                inventory.remove(food);
                placement.removeItem(food);
                return FoodStatus.GOOD;
            } else if (food.getHealthPoint() < 0) {
                decreaseHealth(-food.getHealthPoint());
                inventory.remove(food);
                placement.removeItem(food);
                return FoodStatus.BAD;
            } else if (!(itemToEat instanceof Food)) {
                return FoodStatus.NOT_FOOD;
            }
        }
        return FoodStatus.NOT_FOOD;
    }

    public WeaponStatus equip(String weaponName) {
        Item weaponEquip = findItemInInventory(weaponName);
        if (weaponEquip == null) {
            return WeaponStatus.NOT_IN_INVENTORY;

        }
        if (weaponEquip instanceof Weapon) {
            Weapon weapon = (Weapon) weaponEquip;
            inventory.remove(weapon);
            equipped.add(weapon);
            currentEquipped = weapon;
            return WeaponStatus.WEAPON;
        } else if (!(weaponEquip instanceof Weapon)) {
            return WeaponStatus.NOT_WEAPON;
        }
        return WeaponStatus.NOT_WEAPON;
    }

    public WeaponStatus attack() {
        Weapon weapon = currentEquipped;
        if (weapon==null){
            return WeaponStatus.NOTHING_EQUIPPED;
        }else if(weapon.canUse()){
            weapon.use();
            return WeaponStatus.USED;
        }else{
            return WeaponStatus.NO_AMMO_LEFT;
        }
    }

}





