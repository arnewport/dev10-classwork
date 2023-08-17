import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise04Test {

    @Test
    void calculateTotalCost() {
        Exercise04 instance = new Exercise04();

        // doubles are notoriously hard to test because they use floating-point rounding.
        // The third argument in `assertEquals` is a delta. It represents the margin of error for equality.
        // As long as the expected and actual differ by less than the delta, the test passes.
        assertEquals(1.25, instance.calculateTotalCost(0.25, 5), 0.001);
        assertEquals(18.0, instance.calculateTotalCost(1.0, 20), 0.001);
        assertEquals(36.0, instance.calculateTotalCost(1.0, 40), 0.001);
        assertEquals(51.0, instance.calculateTotalCost(1.0, 60), 0.001);
        assertEquals(99.06, instance.calculateTotalCost(1.27, 100), 0.001);
    }
}