import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void constructor_NullParamPassed_ThrowsIllegalArgumentException() {
        List<Horse> nullHorses = null;
        String expectedMessage = "Horses cannot be null.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(nullHorses));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void constructor_EmptyParamPassed_ThrowsIllegalArgumentException() {
        List<Horse> emptyHorses = new ArrayList<>();
        String expectedMessage = "Horses cannot be empty.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyHorses));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}