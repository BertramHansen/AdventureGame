public class Player {
    Room placement;

    public Player(Room placement) {
        this.placement = placement;
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
}