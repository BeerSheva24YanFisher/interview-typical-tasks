package telran.interview;

import java.util.HashSet;
import java.util.Set;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two numbers,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> seenNumbers = new HashSet<>();
        boolean hasSum = false;
        int index = 0;

        while (index < array.length && hasSum == false) {
            int number = array[index];
            int complement = sum - number;

            if (seenNumbers.contains(complement)) {
                hasSum = true;
            }

            seenNumbers.add(number);
            index++;
        }

        return hasSum;
    }
}