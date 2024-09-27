public class Map {

    private Room currentRoom;

    public Map (){
        buildMap();
    }
    public void buildMap() {
        Room room1 = new Room("Room 1", "A simple room with 2 doors ");
        Room room2 = new Room("Room 2", "A Small room with a boiling pot and 3 dead mice.");
        Room room3 = new Room("Room 3", " The great forrest filled with poison spiders.");
        Room room4 = new Room("Room 4", "Small den with two dead dragons.");
        Room room5 = new Room("Room 5", "Huge room with a bald man holding a sword");
        Room room6 = new Room("Room 6", "Medium sized room with nothing but a bonsai tree and a sparrow");
        Room room7 = new Room("Room 7", "Big hall with a crystal chandelier and a bloody brides dress");
        Room room8 = new Room("Room 8", "Small mine shaft");
        Room room9 = new Room("Room 9", "Big coal mine where you can hear your Friend john scream for help");

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