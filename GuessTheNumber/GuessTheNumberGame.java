import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        
        
        System.out.println("Welcome to Guess the Number!");
        System.out.println("Choose your mode:");
        System.out.println("1. Survival");
        System.out.println("2. Leisure");
        System.out.print("Enter your choice (1 or 2): ");
        
        int mode = scanner.nextInt();
        
       
        if (mode != 1 && mode != 2) {
            
            System.out.println("Error: Invalid input. Please enter either 1 or 2.");
            
            return; 
        }
        
        
        int Bingo = random.nextInt(100) + 1;
        // generates a random number between 1 and 100
        int guess = 0;
        int attempts = 0;
        boolean GuessedItRight = false;
        
        if (mode == 1) {
            
            int max_Attempts = 5; 
            // For survival mode a player has only 5 attempts to guess the correct number if they fail
            /*The game tellls them that they are out of tries shows them the correct answer.
             * I still need to figure out how to let a player know that thier guess is in the right range when its 
             * 5 digits below or 5 digits above the correct guess
             * make the player able to play again and 
             */

            
            System.out.println("Survival mode selected! You have " + max_Attempts + " attempts to guess the number.");
            
            while (attempts < max_Attempts && !GuessedItRight) {
                System.out.print("Enter your guess (1-100): ");
                guess = scanner.nextInt();
                attempts++;
                
                if (guess == Bingo ) {
                    GuessedItRight = true;
                }


                else {
                    /*Line below gies the player a higher chance of winning when their guess is with a 5 unit difference from 
                     * the correct number it gives a different message instead of saying its low or high 
                     */
                    if (Math.abs(guess-Bingo) <= 5)   {
                        System.out.println("Getting hot!!!!!!");
                    }
                    else if (guess > Bingo) { 
                        System.out.println("Whoa there, that's reaching for the stars!! Try again.");

                        }
                    else {
                        System.out.println("Oops you just fell too short!! Try again.");

                        
                    }
                }
                    

            }
            
            if (GuessedItRight) {
                System.out.println("Congratulations you are a genius! You guessed the number in " + attempts + " attempts.");
            } else {
                System.out.println("Ooops that's a guess too many. Sorry, you've run out of attempts. The correct number was " + Bingo  + ".");
            }
        } else {
            
            System.out.println("Leisure mode selected! You can keep guessing until you find the correct number.");
            
            while (!GuessedItRight) {
                System.out.print("Enter your guess (1-100): ");
                guess = scanner.nextInt();
                
                if (guess == Bingo ) {
                    GuessedItRight = true;
                } else if (guess < Bingo ) {
                    System.out.println("Oops you just fell too short!!  Try again.");
                } else {
                    System.out.println("That's higher than a giraffe's neck! Try again.");
                }
            }
            
            System.out.println("Congratulations you genius! You guessed the correct number.");
        }
        
        scanner.close();
    }
}
