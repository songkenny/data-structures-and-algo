public class BubbleSort {
    public static void sort(int[] arr) {
        boolean isSorted = false;
        int len = arr.length - 1;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
            len--;
        }
    }
}
