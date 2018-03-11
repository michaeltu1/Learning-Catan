import java.util.Random;

public class Game {

    public int rollDice() {
        Random r = new Random();
        return r.nextInt(7) + r.nextInt(7);
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}
