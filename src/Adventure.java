import java.util.ArrayList;

//klassen skal videredelegere. (central) alt SOUT skal i UI.
public class Adventure {

    protected Player player;
    protected Map map;

    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom());
    }

    public String move(String direction) {
        Room room = player.move(direction);
        if (room != null) {
            return "You have just moved to " + player.currentRoomName() + " " + player.currentRoomDescription();

        } else{
            return "You cannot go that way";
        }
    }

    public boolean checkRoomForItems() {
        if (player.getPlacement().getItems().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkInventoryForItems() {
        if (player.getInventory().isEmpty()) {
            return false;
        }
        return true;
    }

    public ArrayList<Item> seePlayerInventory() {
        return player.getInventory();
    }

    public ArrayList<Item> seeItemsInCurrentRoom() {
        ArrayList<Item> itemsInRoom = new ArrayList<>();
        itemsInRoom = player.getPlacement().getItems();
        return itemsInRoom;
    }

    public String getCurrentRoomName() {
        return player.currentRoomName();

    }

    public String getCurrentRoomDescription() {
        return player.currentRoomDescription();
    }

    public int seeHealth(){
        return player.getPlayerHealth();
    }
    public void playerEat(Food item){
        player.eat(item);
    }
}