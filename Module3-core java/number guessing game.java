import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1;
        int userGuess;

        System.out.println("Guess a number between 1 and 100:");

        do {
            System.out.print("Your guess: ");
            userGuess = sc.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed the number.");
            }

        } while (userGuess != numberToGuess);

        sc.close();
    }
}
