import java.util.ArrayList;

public class Map {

    private Room currentRoom;

    public Map() {
        buildMap();
    }

    public void buildMap() {
        //room 1 make and add
        Room room1 = new Room("Small living room", "A simple room with 2 doors ");
        Item lamp = new Item("Lamp", "Cobber lamp with a cobweb");
        Item couch = new Item("Couch", "Old leather couch.");
        Item apple = new Food("Apple", "Delicious sweet juicy apple", 5);
        Item berries = new Food("Berries", "Unknown berries.", (-(5)));


        //Add
        room1.addItem(couch);
        room1.addItem(apple);;
        room1.addItem(lamp);
        room1.addItem(berries);

        //room 2 make and add
        Room room2 = new Room("Beginning of forrest", "Just at the start of the big dark forrest...");
        Item gun = new RangedWeapon("Gun", "Good old rusty gun", 5, 2);

        //add
        room2.addItem(gun);

        //room 3 make and add
        Room room3 = new Room("Deep forrest", " The great forrest with poison spiders and dead snakes.");
        Weapon sword = new MeleeWeapon("Sword", "Small iron sword.", 12);
        Enemy spider = new Enemy("Spider", "Big black spider", 10 , sword);

        Item snake = new Food("Snake","Dead snake", (-(10)));

        //add
        room3.addItem(snake);
        room3.addEnemy(spider);


        //room 4 make and add
        Room room4 = new Room("Corn field", "Field full of corn");
        Item corn = new Food("Corn", "Juicy corn", 15);
        Item strangeFruit = new Food("Fruit", "Strange fruit you never have seen before", 100);
        Item book = new Item("Book", "Old brown book.");

        //add
        room4.addItem(strangeFruit);
        room4.addItem(corn);
        room4.addItem(book);



        //room 5 make and add
        Room room5 = new Room("THE DUNGEON", "Huge dungeon with spider like chandeliers and lava pits");
        Weapon magicWand = new RangedWeapon("Wand", "Magic wand made out of the oldest oak in the world", 45, 10);
        Enemy witch = new Enemy("Witch", "The oldest witch of the all, said to have cast a freeze spell on rest of humanity", 100, magicWand);
        Item oldHat = new Item("Hat", "Tophat in the finest wool");
        Item goldCoin = new Item("Coin", "Gold coin with the year and day of today");

        //add
        room5.addItem(oldHat);
        room5.addItem(goldCoin);
        room5.addEnemy(witch);


        //room 6 make and add
        Room room6 = new Room("Hanging tree", "By the hanging tree an orc stands with the sword made from human bones");
        Item veggies = new Food("Veggies", "green beans and so on...", 30);
        Weapon humanSword = new MeleeWeapon("HumanSword", "Sword made from human bones", 30);
        Enemy orc = new Enemy("Orc", "Disgusting orc, green coloured skin. kinda looks like Shreck", 20,humanSword);

        //add
        room6.addItem(veggies);
        room6.addEnemy(orc);

        //room 7 make and add ( no items added)
        Room room7 = new Room("Big hall,", "Big hall with a crystal chandelier and a bloody brides dress");

        //room 8 make and add
        Room room8 = new Room("Close to being out of the forrest", "You can see the light from outside the forrest");
        Item meat = new Food("Meat", "Meat, salted for preservation", 20);

        //add
        room8.addItem(meat);

        //room9 make and add
        Room room9 = new Room("Outskirts of the forrest", "All you see is trees.");
        Item orange = new Food("Orange", "It's an orange. what else do you need to know? ", 25);

        //add
        room9.addItem(orange);


        //room 1 Neighbours
        room1.setNeighbourEast(room2);
        room1.setNeighbourSouth(room4);

        //room 2 Neighbours
        room2.setNeighbourEast(room3);
        room2.setNeighbourWest(room1);

        //room 3 Neighbours
        room3.setNeighbourSouth(room6);
        room3.setNeighbourWest(room2);

        //room 4 Neighbours
        room4.setNeighbourSouth(room7);
        room4.setNeighbourNorth(room1);

        //room 5 Neighbours
        room5.setNeighbourSouth(room8);

        //room 6 Neighbours
        room6.setNeighbourNorth(room3);
        room6.setNeighbourSouth(room9);

        //room 7 Neighbours
        room7.setNeighbourNorth(room4);
        room7.setNeighbourEast(room8);

        //room 8 Neighbours
        room8.setNeighbourNorth(room5);
        room8.setNeighbourWest(room7);
        room8.setNeighbourEast(room9);

        //room 9 Neighbours
        room9.setNeighbourNorth(room6);
        room9.setNeighbourWest(room8);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}