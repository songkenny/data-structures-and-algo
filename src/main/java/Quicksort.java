public class Quicksort {
    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[] arr, int left , int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[(right + left)/2];
        int ind = partition(arr, left, right, pivot);
        quicksort(arr, left, ind - 1);
        quicksort(arr, ind, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
