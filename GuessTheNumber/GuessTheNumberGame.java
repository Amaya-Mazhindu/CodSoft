import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        
        System.out.println("**Welcome to Guess the Number**");
        
        System.out.println("   Choose your mode:   ");
        System.out.println("-----------------------");
        System.out.println("   1. Survival ");
        System.out.println("   2. Leisure  ");
        System.out.println("-----------------------");
        System.out.print("Enter your choice (1 or 2): ");
        
        int mode  = getValidIntegerInput(scanner);
        
       
        if (mode != 1 && mode != 2) {
            
            System.out.println("Error: Invalid input. Please enter either 1 or 2.");
            
            return; 
        }
        
        
        int Bingo = random.nextInt(100) + 1;
        // generates a random number between 1 and 100
        /* 
         * Fix first error for when a user inputs a letter instead of number
         * figure out how to make sure that the
        */
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

            
            System.out.println("  Survival mode selected! You have " + max_Attempts + " attempts to guess the number.  ");
            
            while (attempts < max_Attempts && !GuessedItRight) {
                System.out.print("Enter your guess (1-100): ");
                guess = getValidIntegerInput(scanner);

                /*
                 * Fixed the guess error 
                 * made sure that the guess is only allowed to be between a hundred and one
                 */
                 
                while (guess < 1 || guess > 100) {
                    System.out.println("Error: Please enter a number between 1 and 100.");
                    System.out.print("Enter your guess (1-100): ");
                    guess = getValidIntegerInput(scanner);  
                }
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
                guess = getValidIntegerInput(scanner);

                while (guess < 1 || guess > 100) {
                    System.out.println("Error: Please enter a number between 1 and 100.");
                    System.out.print("Enter your guess (1-100): ");
                    guess = getValidIntegerInput(scanner); 

                }

                attempts++;
                /*
                 * now there is matching code for when both in leisure and survival modes 
                 * fixed majority of the errors that you mentioned above 
                 * debug to spot more errors
                 */
                
                if (guess == Bingo) {
                    GuessedItRight = true;
                } else {
                    if (Math.abs(guess - Bingo) <= 5) {
                        System.out.println("Getting hot!!!!!!");
                    } 
                    else if (guess > Bingo) {
                        System.out.println("That's higher than a giraffe's neck! Try again.");
                    } 
                    else {  
                        System.out.println("Oops you just fell too short!! Try again.");
                    }
                }
            }
            
            System.out.println("Congratulations you genius! You guessed the correct number.");
            System.out.println("Hooray!! It took you " + attempts +  " attempts to guess the correct integer");


            scanner.close(); }
        }

        
            
         

    private static int getValidIntegerInput(Scanner scanner) {

        /*
         * makes sure all the user inputs are digits if they are not digits then an error message is printed out
         */
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid input.");
            scanner.next();  
        }
        return scanner.nextInt();
    }


}
