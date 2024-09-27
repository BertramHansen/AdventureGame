import java.util.Scanner;

public class UserInterface {

//game metode der tager og instantiere det vi har i adventure klassen som er get current room på players placement
    //og build map metoden.
    public void game() {
        Adventure adventure = new Adventure();
        System.out.println("Welcome to Bertrams Adventure Game!! ");
        System.out.println("Your can move in the following directions: ");
        System.out.println("North, east, south or west. You do by typing ''go'' followed by the one of the 4 compass directions");
        System.out.println("If you want to have a look around the room your are in? Type ''look''");
        System.out.println("Should you be stuck or in need of the instructions again... (noob)... Type ''help''");
        System.out.println("If you wish to exit the game. Type ''exit'' ");
        System.out.println("Good luck... you are going to need it...");
        String userChoice = "";
        while (!userChoice.equalsIgnoreCase("exit")) {
            Scanner input = new Scanner(System.in);
            userChoice = input.nextLine();

            //While loop med input i forhold til bevægelse og exit og help og info
            switch (userChoice) {
                case "go north", "go east", "go west", "go south":
                    System.out.println(adventure.move(userChoice));
                    break;
                case "look", "l":
                    System.out.println("Having a look around!" + "\nYou are in " + adventure.player.placement.getName() + " " + adventure.player.placement.getRoomDescription());
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
                    System.out.println("Invalid input.");
                    break;
            }
        }

    }
}

