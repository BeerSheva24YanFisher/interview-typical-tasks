package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class InterviewTasksTest {

    @Test
    void testHasSumTwo() {
        int[] array1 = {1, 2, 3, 4, 5};
        int sum1 = 9;
        boolean result1 = InterviewTasks.hasSumTwo(array1, sum1);
        assertTrue(result1);

        int[] array2 = {1, 2, 3, 4, 5};
        int sum2 = 10;
        boolean result2 = InterviewTasks.hasSumTwo(array2, sum2);
        assertFalse(result2);

        int[] array3 = {-1, 1, -2, 2};
        int sum3 = 0;
        boolean result3 = InterviewTasks.hasSumTwo(array3, sum3);
        assertTrue(result3);
    }
}