
import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Comparison ---");
        System.out.println("Size,BruteForce_ms,Kadane_ms,MaxSum");

        for (int n : sizes) {
            int[] arr = generateRandomArrayWithNegatives(n);

            long start = System.nanoTime();
            int bruteResult = MaxSubarraySolver.bruteForceMaxSum(arr);
            double bruteTime = (System.nanoTime() - start) / 1000000.0;

            start = System.nanoTime();
            int kadaneResult = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            double kadaneTime = (System.nanoTime() - start) / 1000000.0;

            // Both algorithms should give the same answer
            if (bruteResult != kadaneResult) {
                throw new RuntimeException("Results do not match!");
            }

            System.out.printf("%d,%.4f,%.4f,%d%n",
                    n, bruteTime, kadaneTime, bruteResult);
        }
    }

    // Creates random positive and negative numbers
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random random = new Random(42 + size);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        return arr;
    }
}
