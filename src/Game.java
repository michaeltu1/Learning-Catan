import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public boolean winCondition() {
        for (Player p : players) {
            if (p.getVictoryPoints() >= 10) {
                return true;
            }
        }
        return false;
    }

    public void nextTurn() {
        /*
        TODO:
        playing dev cards
        roll dice
        distr. resources (if possible)
        discard half the hand on 7's
        move robber

        trading / exchanging with bank or ports

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
