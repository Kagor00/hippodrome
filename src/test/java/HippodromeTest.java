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
    void getHorses_ReturnsCorrectHorseList() {
        List<Horse> expectedHorseList = createListOfDifferenceHorses();
        Hippodrome hippodrome = new Hippodrome(expectedHorseList);
        List<Horse> actualHorseList = hippodrome.getHorses();
        assertEquals(expectedHorseList, actualHorseList);

    }

    private List<Horse> createListOfDifferenceHorses() {
        List<Horse> horseList = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            String name = "Name " + (i + 1);
            double speed = i + 1;
            double distance = i + 1;
            Horse horse = new Horse(name, speed, distance);
            horseList.add(horse);
        }
        return horseList;
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}