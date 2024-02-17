import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructor_NullNameParamPassed_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 2));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}