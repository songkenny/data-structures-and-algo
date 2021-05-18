import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    @Test
    void mergesort_empty() {
        int[] actual = new int[0];
        MergeSort.sort(actual);
        assertArrayEquals(new int[0], actual);
    }

    @Test
    void mergesort_oneElement () {
        int[] actual = new int[]{5};
        MergeSort.sort(actual);
        assertArrayEquals(new int[]{5}, actual);
    }

    @Test
    void mergesort_randomArray() {
        int[] actual = new int[]{-5, 2, 7, 0, 19, 4};
        MergeSort.sort(actual);
        assertArrayEquals(new int[]{-5, 0, 2, 4, 7, 19}, actual);
    }
}
