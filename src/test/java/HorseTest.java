import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    void constructor_NullNameParamPassed_ThrowsIllegalArgumentException() {
        String expectedMessage = "Name cannot be null.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 2));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t\t", "\t \t", "\t  \t"})
    void constructor_EmptyStringNameParamPassed_ThrowsIllegalArgumentException(String name) {
        String expectedMessage = "Name cannot be blank.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1, 2));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void constructor_NegativeSpeedParamPassed_ThrowsIllegalArgumentException() {
        String expectedMessage = "Speed cannot be negative.";
        String name = "TestName";
        int speed = -10;
        int distance = 2;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void constructor_NegativeDistanceParamPassed_ThrowsIllegalArgumentException() {
        String expectedMessage = "Distance cannot be negative.";
        String name = "TestName";
        int speed = 2;
        int distance = -10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getName_ReturnsCorrectName() {
        String expectedName = "Mark";
        int speed = 1;
        int distance = 1;
        Horse horse = new Horse(expectedName, speed, distance);
        String actualName = horse.getName();
        assertEquals(expectedName, actualName);
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