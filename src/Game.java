import java.util.Random;

public class Game {

    public void nextTurn() {
        /*
        TODO:
        playing dev cards
        roll dice
        distr. resources (if possible)
        discard half the hand on 7's
        move robber

        building phase

        return value?
         */
        int diceRoll = rollDice();
    }

    public int rollDice() {
        Random r = new Random();
        return r.nextInt(7) + r.nextInt(7);
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}
