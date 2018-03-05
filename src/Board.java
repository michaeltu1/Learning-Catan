import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

    // dice_roll_num at 0th index, resource type at 1st index
    public ArrayList<ArrayList> board = new ArrayList<>(19);

    public Board(String mode) {

        // Initialize random board
        ArrayList<Integer> dice_roll_nums = new ArrayList<>(
                Arrays.asList(2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11 ,12));
        Collections.shuffle(dice_roll_nums);

        ArrayList<String> resource_tiles = new ArrayList<>(
                Arrays.asList("Wheat", "Wheat", "Wheat", "Wheat", "Sheep", "Sheep", "Sheep", "Sheep",
                        "Ore", "Ore", "Ore", "Clay", "Clay", "Clay", "Wood", "Wood", "Wood", "Wood", "Desert"));
        Collections.shuffle(resource_tiles);

        if (mode.equals("random")) {
            for (int i = 0; i < 19; i++) {
                String tile = resource_tiles.remove(0);
                if (tile.equals("Desert")) {
                    board.add(i, new ArrayList<Object>(Arrays.asList(-1, tile)));
                } else {
                    board.add(i, new ArrayList<Object>(Arrays.asList(dice_roll_nums.remove(0), tile)));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Board class main method run!");
        Board b = new Board("random");
        System.out.println(b.board);
    }
}
