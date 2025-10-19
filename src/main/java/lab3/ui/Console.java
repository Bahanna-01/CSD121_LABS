package lab3.ui;

import java.util.Scanner;
import lab3.game.Board;

// This class is for showing the board and asking the player for their move
public class Console {
    // Scanner to read what the player types
    private static final Scanner scanner = new Scanner(System.in);

    // This method prints the board on the screen
    public static void displayBoard(Board board) {
        System.out.println(board); // It uses the board's toString() method
    }

    // This method asks the player to enter their move
    public static int[] getNextMove(String playerName, char mark) {
        while (true) {
            // Show message like: "Barbara (X), enter your move..."
            System.out.print(playerName + " (" + mark + "), enter your move (row and column, e.g., 2 3 or 2,3): ");

            // Read what the player typed and remove extra spaces
            String input = scanner.nextLine().trim();

            // Split the input by comma or space (so both 1 1 and 1,1 work)
            String[] parts = input.split("[,\\s]+");

            // Check if the player typed two things (row and column)
            if (parts.length == 2) {
                try {
                    // Convert the strings to numbers and adjust to start from 0
                    int row = Integer.parseInt(parts[0]) - 1;
                    int col = Integer.parseInt(parts[1]) - 1;

                    // Check if the numbers are between 0 and 2 (valid positions)
                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        return new int[]{row, col}; // Return the move
                    }
                } catch (NumberFormatException ignored) {
                    // If the player typed letters or something wrong, ignore and ask again
                }
            }

            // If the input was wrong, show a message and repeat
            System.out.println("Invalid input. Please try again.");
        }
    }
}