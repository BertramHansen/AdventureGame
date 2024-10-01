import java.util.Scanner;

//klassen skal videredelegere. (central) alt SOUT skal i UI.
public class Adventure {

    Player player;
    Map map;

    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom());
    }

    public String move(String direction) {
        Room rum = player.move(direction);
        if (rum != null){
            return "You have just moved to " + player.placement.getName() + " " + player.placement.getRoomDescription();

        } else {
            return "You cannot go that way";
        }
    }


}