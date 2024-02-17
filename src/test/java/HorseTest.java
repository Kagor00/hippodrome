import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructor_NullNameParamPassed_ThrowsIllegalArgumentException() {
        String expectedMassage = "Name cannot be null.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 2));
        assertEquals(expectedMassage, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t\t", "\t \t", "\t  \t"})
    void constructor_EmptyStringNameParamPassed_ThrowsIllegalArgumentException(String name) {
        String expectedMassage = "Name cannot be blank.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1, 2));
        assertEquals(expectedMassage, exception.getMessage());
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