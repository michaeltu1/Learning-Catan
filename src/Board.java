import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Board {


    public ArrayList<Integer> red_dice_roll_nums = new ArrayList<>(Arrays.asList(6, 6, 8, 8));
    public ArrayList<Integer> black_dice_roll_nums = new ArrayList<>(
            Arrays.asList(2, 3, 3, 4, 4, 5, 5, 9, 9, 10, 10, 11, 11 ,12));
    public ArrayList<String> resource_tiles = new ArrayList<>(
            Arrays.asList("Wheat", "Wheat", "Wheat", "Wheat", "Sheep", "Sheep", "Sheep", "Sheep",
                    "Ore", "Ore", "Ore", "Clay", "Clay", "Clay", "Wood", "Wood", "Wood", "Wood"));
    public ArrayList<Integer> order = new ArrayList<>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ,18));

    public ArrayList<Tile> board = new ArrayList<>(19);

    private HashSet<Integer> adjacentTiles(Tile t) {
        HashSet<Integer> hs = new HashSet<>();
        switch(t.getPosition()) {
            case 0:
                hs.add(1);
                hs.add(11);
                hs.add(12);
                break;
            case 1:
                hs.add(0);
                hs.add(2);
                hs.add(12);
                hs.add(13);
                break;
            case 2:
                hs.add(1);
                hs.add(3);
                hs.add(13);
                break;
            case 3:
                hs.add(2);
                hs.add(4);
                hs.add(13);
                hs.add(14);
                break;
            case 4:
                hs.add(3);
                hs.add(5);
                hs.add(14);
                break;
            case 5:
                hs.add(4);
                hs.add(6);
                hs.add(14);
                hs.add(15);
                break;
            case 6:
                hs.add(5);
                hs.add(7);
                hs.add(15);
                break;
            case 7:
                hs.add(6);
                hs.add(8);
                hs.add(15);
                hs.add(16);
                break;
            case 8:
                hs.add(7);
                hs.add(9);
                hs.add(16);
                break;
            case 9:
                hs.add(8);
                hs.add(10);
                hs.add(16);
                hs.add(17);
                break;
            case 10:
                hs.add(9);
                hs.add(11);
                hs.add(17);
                break;
            case 11:
                hs.add(0);
                hs.add(10);
                hs.add(12);
                hs.add(17);
                break;
            case 12:
                hs.add(0);
                hs.add(1);
                hs.add(11);
                hs.add(13);
                hs.add(17);
                hs.add(18);
                break;
            case 13:
                hs.add(1);
                hs.add(2);
                hs.add(3);
                hs.add(12);
                hs.add(14);
                hs.add(18);
                break;
            case 14:
                hs.add(3);
                hs.add(4);
                hs.add(5);
                hs.add(13);
                hs.add(15);
                hs.add(18);
                break;
            case 15:
                hs.add(5);
                hs.add(6);
                hs.add(7);
                hs.add(14);
                hs.add(16);
                hs.add(18);
                break;
            case 16:
                hs.add(7);
                hs.add(8);
                hs.add(9);
                hs.add(15);
                hs.add(17);
                hs.add(18);
                break;
            case 17:
                hs.add(9);
                hs.add(10);
                hs.add(11);
                hs.add(12);
                hs.add(16);
                hs.add(18);
                break;
            case 18:
                hs.add(12);
                hs.add(13);
                hs.add(14);
                hs.add(15);
                hs.add(16);
                hs.add(17);
                break;
        }
        return hs;
    }

    public Board(String mode) {

        // Initialize random board
        Collections.shuffle(red_dice_roll_nums);
        Collections.shuffle(black_dice_roll_nums);
        Collections.shuffle(resource_tiles);
        Collections.shuffle(order);

        for (int i = 0; i < 4; i++) {
            Tile t = new Tile(order.get(i), resource_tiles.get(i), red_dice_roll_nums.get(i));
            board.add(order.get(i), t);

        }


//        for (int i = 0; i < 19; i++) {
//            String resource = resource_tiles.remove(0);
//            if (resource.equals("Desert")) {
//                board.add(i, new Tile(resource, -1));
//            } else {
//                board.add(i, new Tile(resource, dice_roll_nums.remove(0)));
//            }
//        }

//        if (mode.equals("random")) {
//            for (int i = 0; i < 19; i++) {
//                String tile = resource_tiles.remove(0);
//                if (tile.equals("Desert")) {
//                    board.add(i, new ArrayList<Object>(Arrays.asList(-1, tile)));
//                } else {
//                    board.add(i, new ArrayList<Object>(Arrays.asList(dice_roll_nums.remove(0), tile)));
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("Board class main method run!");
        Board b = new Board("random");
        System.out.println(b.board);
    }
}
