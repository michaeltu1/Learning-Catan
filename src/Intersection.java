import java.util.ArrayList;

public class Intersection {

    ArrayList<Tile> adjacents;
    String port;
    boolean hasBuilding;


    Intersection(ArrayList<Tile> adjacents, String port) {
        this.adjacents = adjacents;
        this.port = port;
        hasBuilding = false;
    }

    public boolean canSettle() {
        if (hasBuilding) {
            return false;
        } else if () {
            return false;
        }
        return true;
    }

    private class Edge {
        boolean hasRoad;

    }


    public static void main(String[] args) {

    }
}
