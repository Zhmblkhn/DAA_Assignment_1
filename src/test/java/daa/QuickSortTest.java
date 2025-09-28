package daa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class QuickSortTest {
    @Test
    void testRandom() {
        int[] a = {10,3,5,2,9,7,1};
        int[] exp = a.clone(); Arrays.sort(exp);
        QuickSort.sort(a);
        assertArrayEquals(exp, a);
    }
}
