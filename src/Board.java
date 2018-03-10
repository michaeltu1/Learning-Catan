import java.util.*;

public class Board {

    ArrayList<Integer> red_dice_roll_nums = new ArrayList<>(Arrays.asList(6, 6, 8, 8));

    ArrayList<Integer> black_dice_roll_nums = new ArrayList<>(
            Arrays.asList(2, 3, 3, 4, 4, 5, 5, 9, 9, 10, 10, 11, 11 ,12));

    ArrayList<String> resource_tiles = new ArrayList<>(
            Arrays.asList("Wheat", "Wheat", "Wheat", "Wheat", "Sheep", "Sheep", "Sheep", "Sheep",
                    "Ore", "Ore", "Ore", "Clay", "Clay", "Clay", "Wood", "Wood", "Wood", "Wood"));

    ArrayList<Integer> order = new ArrayList<>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ,18));

    ArrayList<Tile> board = new ArrayList<>(19);

    HashSet<Integer> adjacentTiles(Tile t) {
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

    private boolean checkAdjacentRolls() {
        for (int i = 0; i < 4; i++) {
            Tile t = board.get(order.get(i));
            List<Integer> positions = order.subList(0, 4);
            for (int x : adjacentTiles(t)) {
                if (positions.contains(x)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Board(String mode) {

        // Initialize random board
        Collections.shuffle(red_dice_roll_nums);
        Collections.shuffle(black_dice_roll_nums);
        Collections.shuffle(resource_tiles);

        ArrayList<String> resources = new ArrayList<>();

        boolean neighboringRedRolls = true;
        while (neighboringRedRolls) {
            Collections.shuffle(order);
            board = new ArrayList<>(
                    Arrays.asList(null, null, null, null, null, null, null, null, null,
                            null, null, null, null, null, null, null, null, null, null));
            resources = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Tile t = new Tile(order.get(i), resource_tiles.get(i), red_dice_roll_nums.get(i));
                board.set(order.get(i), t);
                resources.add(resource_tiles.get(i));
            }
            neighboringRedRolls = checkAdjacentRolls();
        }

        for (String resource : resources) {
            resource_tiles.remove(resource);
        }

        for (int i = 0; i < 14; i++) {
            int position = order.remove(4);
            String resource = resource_tiles.remove(0);
            board.set(position, new Tile(position, resource, black_dice_roll_nums.remove(0)));
        }

        int position = order.remove(4);
        board.set(position, new Tile(position, "Desert", 0));
    }

    public void printBoardResourceAssignment() {
        System.out.println();

        System.out.print("     ");
        System.out.print(board.get(2).getResource() + " ");
        System.out.print(board.get(1).getResource() + " ");
        System.out.println(board.get(0).getResource() + " ");

        System.out.print("   ");
        System.out.print(board.get(3).getResource() + " ");
        System.out.print(board.get(13).getResource() + " ");
        System.out.print(board.get(12).getResource() + " ");
        System.out.println(board.get(11).getResource() + " ");

        System.out.print(" ");
        System.out.print(board.get(4).getResource() + " ");
        System.out.print(board.get(14).getResource() + " ");
        System.out.print(board.get(18).getResource() + " ");
        System.out.print(board.get(17).getResource() + " ");
        System.out.println(board.get(10).getResource() + " ");

        System.out.print("   ");
        System.out.print(board.get(5).getResource() + " ");
        System.out.print(board.get(15).getResource() + " ");
        System.out.print(board.get(16).getResource() + " ");
        System.out.println(board.get(9).getResource() + " ");

        System.out.print("     ");
        System.out.print(board.get(6).getResource() + " ");
        System.out.print(board.get(7).getResource() + " ");
        System.out.println(board.get(8).getResource() + " ");
    }

    public void printBoardDiceRollAssignment() {
        System.out.println();

        System.out.print("  ");
        System.out.print(board.get(2).getRollNum() + " ");
        System.out.print(board.get(1).getRollNum() + " ");
        System.out.println(board.get(0).getRollNum() + " ");

        System.out.print(" ");
        System.out.print(board.get(3).getRollNum() + " ");
        System.out.print(board.get(13).getRollNum() + " ");
        System.out.print(board.get(12).getRollNum() + " ");
        System.out.println(board.get(11).getRollNum() + " ");

        System.out.print("");
        System.out.print(board.get(4).getRollNum() + " ");
        System.out.print(board.get(14).getRollNum() + " ");
        System.out.print(board.get(18).getRollNum() + " ");
        System.out.print(board.get(17).getRollNum() + " ");
        System.out.println(board.get(10).getRollNum() + " ");

        System.out.print(" ");
        System.out.print(board.get(5).getRollNum() + " ");
        System.out.print(board.get(15).getRollNum() + " ");
        System.out.print(board.get(16).getRollNum() + " ");
        System.out.println(board.get(9).getRollNum() + " ");

        System.out.print("  ");
        System.out.print(board.get(6).getRollNum() + " ");
        System.out.print(board.get(7).getRollNum() + " ");
        System.out.println(board.get(8).getRollNum() + " ");
    }

    public static void main(String[] args) {
        System.out.println("Board class main method run!");
        Board b = new Board("random");
        b.printBoardDiceRollAssignment();
    }
}
