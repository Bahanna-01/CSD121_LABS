package lab3.game;

// This class represents the Tic Tac Toe board and its logic
public class Board {
    // A 3x3 grid to store the marks ('X', 'O', or empty space)
    private final char[][] grid;

    // Constructor: initializes the board with empty spaces
    public Board() {
        grid = new char[3][3]; // Create a 3x3 grid
        for (int i = 0; i < 3; i++) {           // Loop through rows
            for (int j = 0; j < 3; j++) {       // Loop through columns
                grid[i][j] = ' ';               // Set each cell to empty
            }
        }
    }

    // Places a mark (X or O) on the board if the cell is empty
    public boolean placeMark(int row, int col, char mark) {
        if (grid[row][col] == ' ') {           // Check if the cell is empty
            grid[row][col] = mark;             // Place the mark
            return true;                       // Return true (successful move)
        }
        return false;                          // Return false (cell already taken)
    }

    // Checks if a specific cell is already occupied
    public boolean isOccupied(int row, int col) {
        return grid[row][col] != ' ';          // If not empty, it's occupied
    }

    // Checks if the game is a draw (board full and no winner)
    public boolean isDraw() {
        for (char[] row : grid) {              // Loop through each row
            for (char cell : row) {            // Loop through each cell
                if (cell == ' ') return false; // If any cell is empty, not a draw
            }
        }
        return !isWin();                       // If board is full and no win, it's a draw
    }

    // Checks if there's a winning condition on the board
    public boolean isWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) return true; // Row match
            if (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) return true; // Column match
        }
        // Check diagonals
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) return true; // Diagonal top-left to bottom-right
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) return true; // Diagonal top-right to bottom-left

        return false; // No winning condition found
    }

    // Converts the board into a string to display it nicely in the console
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  1   2   3\n"); // Column headers
        for (int i = 0; i < 3; i++) {
            sb.append(i + 1).append(" "); // Row number
            for (int j = 0; j < 3; j++) {
                sb.append(grid[i][j]);    // Show the mark in the cell
                if (j < 2) sb.append(" | "); // Add vertical separator
            }
            sb.append("\n");
            if (i < 2) sb.append(" ---+---+---\n"); // Add horizontal separator
        }
        return sb.toString(); // Return the board as a string
    }
}