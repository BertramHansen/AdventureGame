import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //game metode der tager og instantiere det vi har i adventure klassen som er get current room på players placement
    //og build map metoden.
    public void game() {
        Adventure adventure = new Adventure();

        System.out.println("==========[======================================================================================>>>>");
        //Emojipedia.com er en hjemmeside hvor man kna kopiere kode til eojis og bruge dem i strings
        System.out.println("\t\uD83D\uDD25Welcome to WitchHunt!!\uD83D\uDD25 ");
        System.out.println("\tThe objective of the game is to find the witch, kill her and equip her weapon!!");
        System.out.println("TIPS: You dont need to fight the enemies, you can move freely around but you will need to get the Sword made out of human bones to defeat The Witch.\n\t  Try and find it!!! Also, food is probably a good idea to save for the big boss fight!");
        System.out.println("\nYour command options are: ");
        System.out.println("\t1) You can move North, east, south or west. You do by typing ''go'' followed by the one of the 4 compass directions");
        System.out.println("\t2) You can take a look at your surroundings. Type ''look''");
        System.out.println("\t3) Should you be stuck or in need of the instructions again... (noob)... Type ''help''");
        System.out.println("\t4) If you wish to exit the game. Type ''exit'' ");
        System.out.println("\t5) You can take an item by typing ''take'' and then the short name for the item you want to pick up.");
        System.out.println("\t6) If you want to check your inventory, type ''inventory''");
        System.out.println("\t7) If you want to drop an item from your inventory, type ''drop and then the short name for the item you wish to drop.");
        System.out.println("\t8) You can gain HP by eating food laying around the room you are standing in or at anytime if you pick it up and place it your inventory.\n\t   You do by typing ''eat'' followed by the food you want to eat.");
        System.out.println("\t9) If you have picked up a weapon you need to equip it before you can use it. Do by typing ''equip'' followed by the weapon you would like to equip.");
        System.out.println("\t10) If you have a weapon equipped and there is an enemy present in the room you are standing in. Type ''attack'' follow by the name of the enemy you wish to attack, but be careful, they might hit you back. .");
        System.out.println("\n\tNOTE!!!! PRESS ENTER WHEN YOU HAVE TYPED THE COMMAND YOU WISH TO COMPLETE:)");
        System.out.println("\nGood luck... you are going to need it...");
        System.out.println("\n==========[======================================================================================>>>>");


        System.out.println("\nYou are starting here:\n" + adventure.getCurrentRoomName() + ": " + adventure.getCurrentRoomDescription());
        int counting = 0;
        for (Item item : adventure.seeItemsInCurrentRoom()) {
            counting++;
            System.out.println(counting + ". " + item);
        }
        String userChoice = "";
        while (!userChoice.equalsIgnoreCase("exit") && !adventure.playerDead()) {
            Scanner input = new Scanner(System.in);
            userChoice = input.nextLine().trim();

            //While loop med input i forhold til bevægelse og exit og help og info
            switch (userChoice) {
                case "go north", "go east", "go west", "go south":
                    String moveResult = adventure.move(userChoice);
                    System.out.println(moveResult);

                    if (!moveResult.equals("You cannot go that way")) {
                        if (!adventure.checkRoomForItems()) {
                            System.out.println("There is nothing exciting to take here.");
                        } else {
                            System.out.println("Items in this room: ");
                            int counter = 0;
                            for (Item item : adventure.seeItemsInCurrentRoom()) {
                                counter++;
                                System.out.println(counter + ". " + item);
                            }
                        }
                    }
                    if (adventure.seeEnemies() != null) {
                        System.out.println("Enemies in this room: " + adventure.seeEnemies());
                    }

                    break;
                case "look", "l":
                    ArrayList<Item> items = adventure.seeItemsInCurrentRoom();
                    System.out.println("Having a look around!" + "\nYou are in " + adventure.getCurrentRoomName() + " " + adventure.getCurrentRoomDescription());
                    if (items.isEmpty()) {
                        System.out.println("There is nothing exciting to pick up here...");
                    } else {
                        System.out.println("Items in this room:");
                        int counter = 0;
                        for (Item item : items) {
                            counter++;
                            System.out.println(counter + ". " + item);
                        }
                    }
                    if (adventure.seeEnemies() != null) {
                        System.out.println("Enemies in this room: " + adventure.seeEnemies());
                    }
                    break;

                case "inventory":
                    if (adventure.checkInventoryForItems()) {
                        System.out.println("Your inventory contains: ");
                        int counters = 0;
                        for (Item item : adventure.seePlayerInventory()) {
                            counters++;
                            System.out.println("\t" + counters + ") " + item);
                        }
//                        System.out.println(adventure.seeCurrentEquipped());
                        if (adventure.seeCurrentEquipped() == null) {
                            System.out.println("Nothing is currently equipped");
                        }
                        if (adventure.seeCurrentEquipped() != null) {
                            System.out.println("current equipped weapon: " + adventure.seeCurrentEquipped());
                        }

                    } else {
                        System.out.println("Your inventory is empty. Pick up items by using the ''take'' command!");
                        System.out.println("current equipped weapon: " + adventure.seeCurrentEquipped());
                    }
                    break;
                case "help", "h":
                    System.out.println("You are in: " + adventure.getCurrentRoomName() + "\nYou can type following: ''go'' followed by  on of the 4 compass directions");
                    System.out.println("Type look to have a look at your surroundings");
                    System.out.println("Type exit to exit game  ");
                    break;


                case "health", "hp":
                    System.out.println("Current health: " + adventure.seeHealth());
                    break;
                case "exit":
                    System.out.println("You have now stopped the game. See ya! ");
                    break;

                default:
                    if (userChoice.startsWith("take ")) {
                        String itemName = userChoice.substring(5).trim();
                        if (!itemName.isEmpty()) {
                            System.out.println(adventure.player.takeItem(itemName));
                        }
                    } else if (userChoice.startsWith("drop ")) {
                        String itemName = userChoice.substring(5).trim();
                        if (!itemName.isEmpty()) {
                            System.out.println(adventure.player.dropItem(itemName));
                        }
                    } else if (userChoice.startsWith("eat ")) {
                        String itemName = userChoice.substring(4).trim();
                        if (!itemName.isEmpty()) {
                            String eatResult = adventure.eat(itemName);
                            System.out.println(eatResult);
                        }
                    } else if (userChoice.startsWith("attack ")) {
                        String attackName = userChoice.substring(7).trim();
                        if (!attackName.isEmpty()) {
                            Enemy target = null;
                            for (Enemy enemy : adventure.player.getPlacement().getEnemyList()) {
                                if (enemy.getName().equalsIgnoreCase(attackName)) {
                                    target = enemy;
                                    break;
                                }
                            }
                            if (target != null) {
                                String attackResult = adventure.attack(target);
                                System.out.println(attackResult);
                            } else {
                                System.out.println("There is no enemy like that in this room");
                            }
                        }
                    } else if (userChoice.startsWith("equip ")) {
                        String itemName = userChoice.substring(6).trim();
                        if (!itemName.isEmpty()) {
                            String equipResult = adventure.equip(itemName);
                            System.out.println(equipResult + ". " + " ");
                        }
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
            }

        }
    }


}




