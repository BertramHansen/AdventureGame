import java.util.ArrayList;

public class Map {

    private Room currentRoom;

    public Map() {
        buildMap();
    }

    public void buildMap() {

        ArrayList<Item> itemsRoom1 = new ArrayList<>();
        ArrayList<Item> itemsRoom2 = new ArrayList<>();
        ArrayList<Item> itemsRoom3 = new ArrayList<>();
        ArrayList<Item> itemsRoom4 = new ArrayList<>();
        ArrayList<Item> itemsRoom5 = new ArrayList<>();
        ArrayList<Item> itemsRoom6 = new ArrayList<>();
        ArrayList<Item> itemsRoom7 = new ArrayList<>();
        ArrayList<Item> itemsRoom8 = new ArrayList<>();
        ArrayList<Item> itemsRoom9 = new ArrayList<>();

        //room 1 opret items og add
        Room room1 = new Room("Room 1", "A simple room with 2 doors ");

        Item sword = new Item("Sword", "Small iron sword.");
        Item lamp = new Item("Lamp", "Cobber lamp with a cobweb");
        Item apple = new Food("Apple", "Delicious sweet juicy apple", 5);
        Item lort = new Food("Berries", "Unknown berries.", (-(5)));

        room1.addItem(apple);
        room1.addItem(sword);
        room1.addItem(lamp);
        room1.addItem(lort);

        //room 2 er tomt for items
        Room room2 = new Room("Room 2", "A Small room with a boiling pot and 3 dead mice.");
        Item gun = new RangedWeapon("Gun", "Good old rusty gun", 5, 2);
        room2.addItem(gun);
        Item bat = new MeleeWeapon("Bat", "Wooden bat with leather grip", 3);
        room2.addItem(bat);

        //room 3 opret
        Room room3 = new Room("Room 3", " The great forrest filled with poison spiders.");

        //items opret og add
        Item cards = new Item("Cards", "playing cards made of leaves");
        Item silverBullets = new Item("Bullets", "Bullets made of silver. Excellent against vampires");
        Item dryInk = new Item("Ink", "Capsule of dried out ink");

        room3.addItem(cards);
        room3.addItem(silverBullets);
        room3.addItem(dryInk);

        //room 4 opret
        Room room4 = new Room("Room 4", "Small den with two dead dragons.");

        //item opret og add
        Item book = new Item("Book", "Old brown book.");
        room4.addItem(book);

        //room 5 opret
        Room room5 = new Room("Room 5", "Huge room with a bald man holding a sword");

        //item opret og add

        Item oldHat = new Item("Hat", "Tophat in the finest wool");
        Item goldCoin = new Item("Coin", "Gold coin with the year and day of today");

        room5.addItem(oldHat);
        room5.addItem(goldCoin);


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