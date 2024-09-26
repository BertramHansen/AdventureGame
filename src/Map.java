public class Map {
    private Room currentRoom;

    public void buildMap() {
        Room room1 = new Room("Room 1", "A simple room with 2 doors ");
        Room room2 = new Room("Room 2", "Small room with bald man");
        Room room3 = new Room("Room 3", "Big forrest with poison spiders.");
        Room room4 = new Room("Room 4", "Small den with two dead dragons.");
        Room room5 = new Room("Room 5", "Small room with bald man");
        Room room6 = new Room("Room 6", "Small room with bald man");
        Room room7 = new Room("Room 7", "Small room with bald man");
        Room room8 = new Room("Room 8", "Small room with bald man");
        Room room9 = new Room("Room 9", "Small room with bald man");

        //room 1 naboer
        room1.setNeighbourEast(room2);
        room1.setNeighbourSouth(room4);

        //room 2 naboer
        room2.setNeighbourEast(room3);
        room2.setNeighbourWest(room1);

        //room 3 naboer
        room3.setNeighbourSouth(room6);
        room3.setNeighbourWest(room2);

        //room 4 naboer
        room4.setNeighbourSouth(room7);
        room4.setNeighbourNorth(room1);

        //room 5 naboer
        room5.setNeighbourSouth(room8);

        //room 6 naboer
        room6.setNeighbourNorth(room3);
        room6.setNeighbourSouth(room9);

        //room 7 naboer
        room7.setNeighbourNorth(room4);
        room7.setNeighbourEast(room8);

        //room 8 naboer
        room8.setNeighbourNorth(room5);
        room8.setNeighbourWest(room7);
        room8.setNeighbourEast(room9);

        //room 9 naboer
        room9.setNeighbourNorth(room6);
        room9.setNeighbourWest(room8);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
