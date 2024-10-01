import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //game metode der tager og instantiere det vi har i adventure klassen som er get current room på players placement
    //og build map metoden.
    public void game() {
        Adventure adventure = new Adventure();

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("\tWelcome to Bertrams Adventure Game!! ");
        System.out.println("Your command options are: ");
        System.out.println("\t1) You can move North, east, south or west. You do by typing ''go'' followed by the one of the 4 compass directions");
        System.out.println("\t2) You can take a look at your surroundings. Type ''look''");
        System.out.println("\t3) Should you be stuck or in need of the instructions again... (noob)... Type ''help''");
        System.out.println("\t4) If you wish to exit the game. Type ''exit'' ");
        System.out.println("\t5) You can take an item by typing ''take'' and then the short name for the item you want to pick up.");
        System.out.println("\t6) If you want to check your inventory, type ''inventory''");
        System.out.println("\t7) If you want to drop an item from your inventory, type ''drop and then the short name for the item you wish to drop.");
        System.out.println("\tNOTE!!!! PRESS ENTER WHEN YOU HAVE TYPED THE COMMAND YOU WISH TO COMPLETE:)");
        System.out.println("\nGood luck... you are going to need it...");
        System.out.println("------------------------------------------------------------------------------------------------------");


        String userChoice = "";
        while (!userChoice.equalsIgnoreCase("exit")) {
            Scanner input = new Scanner(System.in);
            userChoice = input.nextLine().trim();

            //While loop med input i forhold til bevægelse og exit og help og info
            switch (userChoice) {
                case "go north", "go east", "go west", "go south":
                    System.out.println(adventure.move(userChoice));
                    if (adventure.player.placement.getItems().isEmpty()) {
                        System.out.println("There is nothing exciting to take here.");
                    }
                    if (!adventure.player.placement.getItems().isEmpty()) {
                        System.out.println("Items in this room: ");
                        int counting = 0;
                        for (Item item : adventure.player.placement.getItems()) {
                            counting++;
                            System.out.println(counting + ". " + item);

                        }
                    }

                    break;
                case "look", "l":
                    ArrayList<Item> items = adventure.player.placement.getItems();
                    System.out.println("Having a look around!" + "\nYou are in " + adventure.player.placement.getName() + " " + adventure.player.placement.getRoomDescription());
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
                    break;

                case "inventory":
                    if (!adventure.player.inventory.isEmpty()) {
                        System.out.println("Your inventory contains: ");
                        int count = 0;
                        for (Item item : adventure.player.inventory) {
                            count++;
                            System.out.println("\t" + count + ") " + item);
                        }
                    } else {
                        System.out.println("Your inventory is empty. Pick up items by using the ''take'' command!");
                    }
                    break;
                case "help", "h":
                    System.out.println("You are in: " + adventure.player.placement.getName() + "\nYou can type following: ''go'' followed by  on of the 4 compass directions");
                    System.out.println("Type look to have a look at your surroundings");
                    System.out.println("Type exit to exit game  ");
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
                        break;
                    }
                    if (userChoice.startsWith("drop ")) {
                        String itemName = userChoice.substring(5).trim();
                        if (!itemName.isEmpty()) {
                            System.out.println(adventure.player.dropItem(itemName));
                        } else {
                            System.out.println("Invalid input.");
                        }
                        break;

                    }
            }

        }
    }
}


