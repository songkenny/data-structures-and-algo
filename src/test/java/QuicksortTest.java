import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuicksortTest {
    @Test
    void quicksort_empty() {
        int[] actual = new int[0];
        Quicksort.sort(actual);
        assertArrayEquals(new int[0], actual);
    }

    @Test
    void quicksort_oneElement () {
        int[] actual = new int[]{5};
        Quicksort.sort(actual);
        assertArrayEquals(new int[]{5}, actual);
    }

    @Test
    void quicksort_randomArray() {
        int[] actual = new int[]{-5, 2, 7, 0, 19, 4};
        Quicksort.sort(actual);
        assertArrayEquals(new int[]{-5, 0, 2, 4, 7, 19}, actual);
    }
}
