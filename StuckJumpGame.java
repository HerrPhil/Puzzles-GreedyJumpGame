import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.math.BigInteger;

public class StuckJumpGame {

    public static void main(String [] args) {
        System.out.printf("Hello Stuck Jump Game Solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java StuckJumpGame%n");
            return;
        }

//        int [] input = new int [] {2, 3, 1, 1, 4}; // result is true
//        int [] input = new int [] {3, 2, 1, 0, 4}; // result is false
//        int [] input = new int [] {2, 2, 2, 2, 0}; // result is true
//        int [] input = new int [] {3, 3, 3, 3, 0}; // result is true
//        int [] input = new int [] {4, 4, 4, 4, 0}; // result is true
//        int [] input = new int [] {5, 5, 5, 5, 0}; // result is true
//        int [] input = new int [] {6, 6, 6, 6, 0}; // result is true
//        int [] input = new int [] {3, 0, 0, 5, 0}; // result is true
        int [] input = new int [] {2, 0, 0, 5, 0}; // result is false

        StuckJumpGame stuckJumpGame = new StuckJumpGame(input);

        boolean result = stuckJumpGame.solution();

        if (result) {

            System.out.printf("the goal is reached in the jump game%n");

        } else {

            System.out.printf("the goal is not reached in the jump game%n");

        }

    }

    private int [] input;

    public StuckJumpGame(int [] input) {

        this.input = input;

    }

    public boolean solution() {

        int n = input.length;

        // Initialize the goal based on the value of n
        int goal = n - 1;
        int position = 0;

        // progress forward through the array
        // and fail fast when a jump value is zero (0)
        while (position < goal) {

            int jumpValue = input[position];
            
            if (jumpValue == 0) return false;

            position += jumpValue;

        }

        return true;
    }

}
