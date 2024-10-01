import java.util.ArrayList;

public class Item {
    String shortName;
    String longName;

    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;

    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;

    }

    @Override
    public String toString() {
        return shortName + ": " + longName;
    }
}
