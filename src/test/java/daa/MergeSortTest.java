package daa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class MergeSortTest {
    @Test
    void testRandom() {
        int[] a = {15,78,89,9,12,12546,8,879,16,54,1};
        int[] exp = a.clone(); Arrays.sort(exp);
        MergeSort.sort(a);
        assertArrayEquals(exp, a);
    }
}
