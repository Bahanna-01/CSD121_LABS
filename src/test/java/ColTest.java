// Imports JUnit annotations and assertion methods
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for verifying the behavior of the Color enum
public class ColTest {

    // Tests that valid color strings are correctly converted to enum values
    @Test
    public void testValidColors() {
        assertEquals(Color.RED, Color.valueOf("RED"));
        assertEquals(Color.BLUE, Color.valueOf("BLUE"));
    }

    // Tests that the method handles case-insensitive input correctly
    @Test
    public void testCaseInsensitive() {
        // Converts lowercase input to uppercase before passing to valueOf
        assertEquals(Color.RED, Color.valueOf("red".toUpperCase()));
    }

    // Tests that an invalid color string throws an IllegalArgumentException
    // "PINK" is not a valid enum constant, so this should throw an exception

    @Test
    public void testInvalidColorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Color.valueOf("PINK");
        });
    }
}