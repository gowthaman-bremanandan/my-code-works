package linkedList.sumOfArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SumOfarrays {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        countInversions(arr); // Expected: 3
    }

    public static void countInversions(int[] arr) {
        if (arr == null || arr.length < 2) return ;
        printMaxSubarray(arr);
    }

    public static void printMaxSubarray(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Step 2: Print result
        System.out.println("Max Sum = " + maxSum);
        System.out.print("Subarray = [ ");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) System.out.print(", ");
        }

        System.out.println(" ]");
    }

}
