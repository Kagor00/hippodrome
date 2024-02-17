import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void constructor_NullListParamPassed_ThrowsIllegalArgumentException() {
        List<Horse> horseList = null;
        String expectedMessage = "Horses cannot be null.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horseList));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void constructor_EmptyListParamPassed_ThrowsIllegalArgumentException() {
        List<Horse> emptyHorseList = new ArrayList<>();
        String expectedMessage = "Horses cannot be empty.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyHorseList));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getHorses_ReturnsCorrectHorseList() {
        List<Horse> expectedHorseList = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            Horse horse = new Horse("Horse " + i, i, i);
            expectedHorseList.add(horse);
        }

        Hippodrome hippodrome = new Hippodrome(expectedHorseList);
        List<Horse> actualHorseList = hippodrome.getHorses();
        assertEquals(expectedHorseList, actualHorseList);
        assertEquals(30, actualHorseList.size());
        assertEquals("Horse 5", actualHorseList.get(5).getName());
        assertEquals("Horse 29", actualHorseList.get(29).getName());
    }


    @Test
    void move_CallsMoveMethodForAllHorses() {
        List<Horse> horseList = new ArrayList<>();

    }

    @Test
    void getWinner() {
    }
}