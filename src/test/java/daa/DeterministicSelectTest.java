package daa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

public class DeterministicSelectTest {
    @Test
    void testSelectManyRandom() {
        Random rnd = new Random(123);
        for (int t = 0; t < 100; t++) {
            int n = 100;
            int[] a = rnd.ints(n, 0, 1000).toArray();
            int k = rnd.nextInt(n);
            int[] b = a.clone();
            Arrays.sort(b);
            int want = b[k];
            int got = DeterministicSelect.select(a.clone(), k);
            assertEquals(want, got);
        }
    }
}
