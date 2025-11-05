// Imports JUnit annotations and assertion methods
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Imports the Board class and Position class used in the tests
import lab4.game.Board;
import lab4.game.Row;
import lab4.game.Position;
import lab4.game.Col;

public class BoardTest {

    // Tests if placing an X token marks the board as occupied at the given position
    @Test
    public void testPlaceXMarksBoard() {
        Board board = new Board(); // Creates a new board
        Position pos = new Position(Row.Top,Col.Left); // Defines a position
        board.placeX(pos); // Places an X token at the position
        assertTrue(board.isOccupiedAt(pos)); // Checks if the position is now occupied
    }

    // Tests if placing an O token marks the board as occupied at the given position
    @Test
    public void testPlaceOMarksBoard() {
        Board board = new Board(); // Creates a new board
        Position pos = new Position(Row.Middle, Col.Right); // Defines a position
        board.placeO(pos); // Places an O token at the position
        assertTrue(board.isOccupiedAt(pos)); // Checks if the position is now occupied
    }
}