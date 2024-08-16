import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.math.BigInteger;

public class GreedyJumpGame {

    public static void main(String [] args) {
        System.out.printf("Hello Greedy Jump Game Solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GreedyJumpGame%n");
            return;
        }

//        int [] input = new int [] {2, 3, 1, 1, 4}; // result is true
//        int [] input = new int [] {3, 2, 1, 0, 4}; // result is false
//        int [] input = new int [] {2, 2, 2, 2, 0}; // result is ????
//        int [] input = new int [] {3, 3, 3, 3, 0}; // result is true
//        int [] input = new int [] {4, 4, 4, 4, 0}; // result is true
        int [] input = new int [] {5, 5, 5, 5, 0}; // result is true

        GreedyJumpGame greedyJumpGame = new GreedyJumpGame(input);

        boolean result = greedyJumpGame.solution();

        if (result) {

            System.out.printf("the goal is reached in the jump game%n");

        } else {

            System.out.printf("the goal is not reached in the jump game%n");

        }

    }

    private int [] input;

    public GreedyJumpGame(int [] input) {

        this.input = input;

    }

    public boolean solution() {

        int n = input.length;

        // Initialize the goal based on the value of n
        int goal = n - 1;

        // Greedily work backwards through the array
        for (int i = goal; i >= 0; i--) {

            // set the maximum jump to be the current value
            int maxJump = input[i];

            // discover whether i + max jump is greater than or equal to the goal
            if (i + maxJump >= goal) {

                // reset the goal to the current position
                goal = i;

            }

        }

        return goal == 0;
    }

}
