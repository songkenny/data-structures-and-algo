public class MergeSort {
    public static void sort(int[] arr) {
        mergesort(arr, new int[arr.length],0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd){
            return;
        }

        int mid = (leftStart + rightEnd) / 2;
        mergesort(arr, temp, leftStart, mid);
        mergesort(arr, temp, mid + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    public static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int ind = leftStart;

        int left = leftStart;
        int right = rightStart;
        while(left <= leftEnd && right <= rightEnd) {
            if (arr[left] < arr[right]) {
                temp[ind] = arr[left];
                left++;
            } else {
                temp[ind] = arr[right];
                right++;
            }
            ind++;
        }
        System.arraycopy(arr, left, temp, ind, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, ind, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }

}
