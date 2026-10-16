
public class SortingAlgorithms {

    // Finds the smallest number and moves it to the front
    // Time complexity: O(n^2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Moves each number into its correct position
    // Best case O(n), worst case O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Splits the array into smaller parts
    // Time complexity: O(n log n)
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(
            int[] arr, int[] temp, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSortRecursive(arr, temp, left, mid);
        mergeSortRecursive(arr, temp, mid + 1, right);

        merge(arr, temp, left, mid, right);
    }

    private static void merge(
            int[] arr, int[] temp, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        // Compare both halves
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining numbers
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted numbers back
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
    }
}
