
public class MaxSubarraySolver {

    // Checks every possible subarray
    // Time complexity: O(n^2)
    public static int bruteForceMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxSum = Integer.MIN_VALUE;

        // Outer loop runs n times
        // Inner loop runs n-i times
        // Total additions: n(n+1)/2
        // This grows as O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    // Finds the maximum sum in one pass
    // One loop with n iterations = O(n)
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int currentSum = arr[0];
        int maxSum = arr[0];

        // Each number is checked only once
        // Constant work per iteration = O(n)
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
