import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        for (int i = 0; i < 50; i++) {
            horseList.add(Mockito.mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horseList);
        hippodrome.move();

        for (Horse horse: horseList) {
            Mockito.verify(horse, Mockito.times(1)).move();
        }

    }

    @Test
    void getWinner_ReturnsCorrectWinner() {
        Hippodrome hippodrome = new Hippodrome(List.of(
                new Horse("Horse 1", 1, 1),
                new Horse("Horse 2", 5, 5),
                new Horse("Horse 3", 10, 10),
                new Horse("Horse 4", 12, 15),
                new Horse("Horse 5", 15, 20)
        ));
        String expectedWinnerName = "Horse 5";
        String actualWinnerName = hippodrome.getWinner().getName();
        assertEquals(expectedWinnerName, actualWinnerName);
    }
}