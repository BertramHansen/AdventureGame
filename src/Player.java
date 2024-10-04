import java.util.ArrayList;

public class Player {
    private Room placement;
    private ArrayList<Item> inventory = new ArrayList<>();
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

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
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
                decreaseHealth(- food.getHealthPoint());
                inventory.remove(food);
                placement.removeItem(food);
                return FoodStatus.BAD;
            } else if (!(itemToEat instanceof Food)) {
                return FoodStatus.NOT_FOOD;
            }
        }
        return FoodStatus.NOT_FOOD;
    }
}


//        @Override
//        public String toString {
//            return "Current health: " + playerHealth;





