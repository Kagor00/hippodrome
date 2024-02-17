import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

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
        double distance = 5.5;
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
    void move_CallsGetRandomDoubleMethodWithCorrectParams() {
        String name = "TestName";
        double speed = 2.5;
        double distance = 10.5;
        double lowerBound = 0.2;
        double upperBound = 0.9;
        Horse horse = new Horse(name, speed, distance);
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            horse.move();
            horseMockedStatic.verify(() -> Horse.getRandomDouble(lowerBound, upperBound));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0, 3, 0.5, 0.8, 10, 12})
    void move_calculateDistanceAfterMove(double fakeRandomValue) {
        String name = "TestName";
        double speed = 2.5;
        double distance = 10.5;
        double lowerBound = 0.2;
        double upperBound = 0.9;
        Horse horse = new Horse(name, speed, distance);
        double expectedDistance = distance + speed * fakeRandomValue;
        try (MockedStatic<Horse> horseMockedStatic = mockStatic(Horse.class)) {
            horseMockedStatic.when(() -> Horse.getRandomDouble(lowerBound, upperBound)).thenReturn(fakeRandomValue);
            horse.move();
        }
        double actualDistance = horse.getDistance();
        assertEquals(expectedDistance, actualDistance);
    }
}