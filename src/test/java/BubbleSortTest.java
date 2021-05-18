import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {
    @Test
    void bubblesort_empty() {
        int[] actual = new int[0];
        BubbleSort.sort(actual);
        assertArrayEquals(new int[0], actual);
    }

    @Test
    void bubblesort_oneElement () {
        int[] actual = new int[]{5};
        BubbleSort.sort(actual);
        assertArrayEquals(new int[]{5}, actual);
    }

    @Test
    void bubblesort_randomArray() {
        int[] actual = new int[]{-5, 2, 7, 0, 19, 4};
        BubbleSort.sort(actual);
        assertArrayEquals(new int[]{-5, 0, 2, 4, 7, 19}, actual);
    }
}
