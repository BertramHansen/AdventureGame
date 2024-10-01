import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;

public class Room {
    private String name;
    private String roomDescription;
    private ArrayList<Item> items = null;

    //Naboer
    private Room neighbourNorth, neighbourSouth, neighbourWest, neighbourEast;

    public Room(String name, String roomDescription) {
        this.name = name;
        this.roomDescription = roomDescription;
        this.items = new ArrayList<>();
    }

    //getter for name og description
    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        return roomDescription;
    }
    //setter og getter af naboer


    public Room getNeighbourEast() {
        return neighbourEast;
    }

    public Room getNeighbourNorth() {
        return neighbourNorth;
    }

    public Room getNeighbourSouth() {
        return neighbourSouth;
    }

    public Room getNeighbourWest() {
        return neighbourWest;
    }

    public void setNeighbourSouth(Room south) {
        this.neighbourSouth = south;
    }

    public void setNeighbourEast(Room east) {
        this.neighbourEast = east;
    }

    public void setNeighbourWest(Room west) {
        this.neighbourWest = west;
    }

    public void setNeighbourNorth(Room north) {
        this.neighbourNorth = north;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item findItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }


    @Override
    public String toString() {
        return name + ": " + roomDescription;
    }
}
