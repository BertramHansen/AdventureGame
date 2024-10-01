import java.util.ArrayList;

public class Player {
    Room placement;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(Room placement) {
        this.placement = placement;
        this.inventory = new ArrayList<>(); //initialisering
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

    private Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName) || item.getLongName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}


