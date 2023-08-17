import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise05Test {

    @Test
    void isWithinFiveOfAHundred() {
        assertTrue(Exercise05.isWithinFiveOfAHundred(100));
        assertTrue(Exercise05.isWithinFiveOfAHundred(95));
        assertTrue(Exercise05.isWithinFiveOfAHundred(105));
        assertTrue(Exercise05.isWithinFiveOfAHundred(0));
        assertTrue(Exercise05.isWithinFiveOfAHundred(-100));
        assertFalse(Exercise05.isWithinFiveOfAHundred(50));

    }
}