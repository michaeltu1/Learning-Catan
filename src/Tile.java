import java.util.ArrayList;
import java.util.Arrays;

public class Tile {

    private int position; // board index number
    private String resource; // desert, ocean, wheat, ore, clay, wood, sheep
    private boolean hasRobber;
    private int rollNum;
    private ArrayList<Intersection> vertices;

    public Tile(int position, String resource, int rollNum) {
        this.position = position;
        this.resource = resource;
        this.rollNum = rollNum;
        this.vertices = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5)); // TODO: tell Alex changed to 0-indexed vals

        if (rollNum == 0 && resource.equals("Desert")) {
            this.hasRobber = true;
        } else {
            this.hasRobber = false;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public int getRollNum() {
        return this.rollNum;
    }

    public String getResource() {
        return this.resource;
    }

    public boolean isBlocked() {
        return this.hasRobber;
    }

    public void unBlock() {
        this.hasRobber = false;
    }

    public void block() {
        this.hasRobber = true;
    }

    public static void main(String[] args) {

    }
}
