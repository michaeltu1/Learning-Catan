import java.util.Random;

public class Game {

    public int rollDice() {
        Random r = new Random();
        int roll = r.nextInt(7) + r.nextInt(7);
        System.out.print("dice roll = ");
        System.out.println(roll);
//        return r.nextInt(7) + r.nextInt(7);
        return roll;
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.rollDice();
        g.rollDice();
        g.rollDice();
    }
}
