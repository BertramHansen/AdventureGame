import java.util.ArrayList;
import java.util.Locale;


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

        } else {
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

    public ArrayList<Item> seePlayerEquipped() {
        return player.getEquipped();
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

    public int seeHealth() {
        return player.getPlayerHealth();
    }

    public String eat(String foodName) {
        FoodStatus status = player.eat(foodName);
        switch (status) {
            case GOOD:
                return "You ate the " + foodName + "!" + " You now have: " + player.getPlayerHealth() + " healthpoints.";
            case BAD:
                return "That wasn't good..." + "you just lost health :( Current health:" + player.getPlayerHealth() + " healthpoints";
            case NOT_FOOD:
                return "You cannot eat that!";
            case NOT_HERE:
                return "There is no such thing as " + foodName + " in your inventory or in this room.";

            default:
                return "Invalid input!";
        }
    }

    public Item seeCurrentEquipped() {

        return player.getCurrentEquipped();
    }


    public String equip(String itemName) {
        WeaponStatus status = player.equip(itemName);
        return switch (status) {
            case WEAPON -> "You just equipped the " + itemName;
            case NOT_WEAPON -> "That is not a weapon. You cannot equip that";
            case NOT_IN_INVENTORY -> "You do not have such in inventory.";
            default -> "invalid input!";
        };
    }

    public String attack(Enemy enemy) {
        WeaponStatus status = player.attack();
        switch (status) {
            case NOTHING_EQUIPPED:
                return "Nothing is equipped so you cannot attack";

            case USED:
                enemy.enemyHit(player.getCurrentWeapon().getDamage());
                player.playerHit(enemy.getWeapon().getDamage());

                if (enemy.getHealthPoints() < 1) {
                    Item droppedWeapon = enemy.getWeapon();
                    player.getPlacement().addItem(droppedWeapon);
                    player.getPlacement().removeEnemy(enemy);
                    return "You just used the " + seeCurrentEquipped().getShortName().toLowerCase(Locale.ROOT) + " and dealt "
                            + player.getCurrentWeapon().getDamage() +
                            " damage to the " + enemy.getName() + ". But the " + enemy.getName() + " strikes back dealing: "
                            + enemy.getWeapon().getDamage() + " damage!" +
                            "You defeated the enemy and it dropped a " + droppedWeapon.getShortName() +
                            "\nYou now have " + player.getPlayerHealth() + " HP left.";


                }

                return "You just used the " + seeCurrentEquipped().getShortName().toLowerCase(Locale.ROOT) + " and dealt "
                        + player.getCurrentWeapon().getDamage() +
                        " damage to the " + enemy.getName() + ". But the " + enemy.getName() + " strikes back dealing: "
                        + enemy.getWeapon().getDamage() + " damage!" +
                        "\nYou now have " + player.getPlayerHealth() + " HP left.";


            case NO_AMMO_LEFT:
                return "No uses left.";
            default:

                return "invalid input!";
        }

    }

    public boolean playerDead() {
        if (player.getPlayerHealth()<=0){
            return true;
        }else{
            return false;
        }
    }

    public Enemy seeEnemies() {

        for (Enemy enemy : player.getPlacement().getEnemyList()) {
            return enemy;

        }
        return null;
    }

}