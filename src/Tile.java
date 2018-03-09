import java.util.ArrayList;

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

        if (rollNum == -1 && resource.equals("Desert")) {
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

    public static void main(String[] args) {

    }
}
