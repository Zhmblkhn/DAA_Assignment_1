package daa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class InsertionSortTest {
    @Test
    void testSort() {
        int[] arr = {5,2,9,1,5,6};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        InsertionSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
