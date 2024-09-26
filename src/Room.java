public class Room {
    private String name;
    private String roomDescription;

    //Naboer
    private Room neighbourNorth, neighbourSouth, neighbourWest, neighbourEast;

    public Room(String name, String roomDescription) {
        this.name = name;
        this.roomDescription = roomDescription;
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
}
