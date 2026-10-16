
import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");
        System.out.println("Case,Size,Selection_ms,Insertion_ms,Merge_ms");

        for (int n : sizes) {
            runAndTimeAllSorts("Average", generateRandomArray(n));
            runAndTimeAllSorts("Best", generateSortedArray(n));
            runAndTimeAllSorts("Worst", generateReverseSortedArray(n));
        }
    }

    // Runs each sort using a separate copy
    public static void runAndTimeAllSorts(String type, int[] original) {
        int[] selection = Arrays.copyOf(original, original.length);
        int[] insertion = Arrays.copyOf(original, original.length);
        int[] merge = Arrays.copyOf(original, original.length);

        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(selection);
        double selectionTime = (System.nanoTime() - start) / 1000000.0;

        start = System.nanoTime();
        SortingAlgorithms.insertionSort(insertion);
        double insertionTime = (System.nanoTime() - start) / 1000000.0;

        start = System.nanoTime();
        SortingAlgorithms.mergeSort(merge);
        double mergeTime = (System.nanoTime() - start) / 1000000.0;

        // Make sure all algorithms sorted correctly
        if (!Arrays.equals(selection, insertion) ||
            !Arrays.equals(selection, merge) ||
            !isSorted(selection)) {
            throw new RuntimeException("Sorting error!");
        }

        System.out.printf("%s,%d,%.4f,%.4f,%.4f%n",
                type, original.length,
                selectionTime, insertionTime, mergeTime);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Random numbers for average case
    public static int[] generateRandomArray(int size) {
        Random random = new Random(42 + size);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000);
        }

        return arr;
    }

    // Ascending numbers for best case
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    // Descending numbers for worst case
    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }
}
