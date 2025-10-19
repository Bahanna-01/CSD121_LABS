package lab3;

import lab3.game.Board;
import lab3.ui.Console;

import java.util.Scanner;

/**
 * Main class that runs the Tic Tac Toe game.
 * It shows a menu, lets players enter their names, and manages the game loop.
 */
public class Main {

    /**
     * Entry point of the program.
     * Displays the menu and handles user choices.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Tic Tac Toe ===");
            System.out.println("1. Start Game");
            System.out.println("2. View Rules");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    startGame(scanner);
                    break;
                case "2":
                    showRules();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    /**
     * Displays the rules of the game to the user.
     */
    public static void showRules() {
        System.out.println("\n=== Game Rules ===");
        System.out.println("- The game is played on a 3x3 grid.");
        System.out.println("- Players take turns placing X or O.");
        System.out.println("- The first to get 3 in a row (horizontally, vertically, or diagonally) wins.");
        System.out.println("- If all cells are filled and no one wins, it's a draw.");
        System.out.println("- To make a move, enter the row and column numbers separated by a space or comma.");
        System.out.println("  Example: 1 1 or 1,1 (this places your mark in the top-left corner).\n");
    }

    /**
     * Starts the game loop, asks for player names, and manages turns.
     *
     * @param scanner Scanner object used to read player input
     */
    public static void startGame(Scanner scanner) {
        System.out.print("Enter name for Player X: ");
        String playerX = scanner.nextLine().trim();

        System.out.print("Enter name for Player O: ");
        String playerO = scanner.nextLine().trim();

        Board board = new Board();
        char currentPlayer = 'X';

        while (true) {
            Console.displayBoard(board);

            if (board.isWin()) {
                String winner = (currentPlayer == 'X') ? playerO : playerX;
                System.out.println("🎉 " + winner + " wins!");
                break;
            }

            if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            String currentName = (currentPlayer == 'X') ? playerX : playerO;
            int[] move = Console.getNextMove(currentName, currentPlayer);
            int row = move[0];
            int col = move[1];

            if (board.isOccupied(row, col)) {
                System.out.println("That position is already taken. Try again.");
                continue;
            }

            board.placeMark(row, col, currentPlayer);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}