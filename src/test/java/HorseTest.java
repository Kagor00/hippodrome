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
        double speed = -10.5;
        double distance = 2.5;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void constructor_NegativeDistanceParamPassed_ThrowsIllegalArgumentException() {
        String expectedMessage = "Distance cannot be negative.";
        String name = "TestName";
        double speed = 2.5;
        double distance = -10.5;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, speed, distance));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getName_ReturnsCorrectName() {
        String name = "TestName";
        double speed = 5.5;
        double distance = 6.5;
        Horse horse = new Horse(name, speed, distance);
        String actualName = horse.getName();
        assertEquals(name, actualName);
    }

    @Test
    void getSpeed_ReturnsCorrectSpeed() {
        String name = "TestName";
        double speed = 7.5;
        double distance = 10.5;
        Horse horse = new Horse(name, speed, distance);
        double actualSpeed = horse.getSpeed();
        assertEquals(speed, actualSpeed);
    }

    @Test
    void getDistance_ReturnsCorrectDistance() {
        String name = "TestName";
        double speed = 7.5;
        double distance = 10.5;
        Horse horse = new Horse(name, speed, distance);
        double actualDistance = horse.getDistance();
        assertEquals(distance, actualDistance);
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}