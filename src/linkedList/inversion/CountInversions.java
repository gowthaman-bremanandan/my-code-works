package linkedList.inversion;

public class CountInversions {

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr)); // Expected: 3
    }

    public static long countInversions(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return sortAndCount(arr, 0, arr.length - 1);
    }

    // Divide the array
    private static long sortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;

        long count = 0;
        count += sortAndCount(arr, left, mid);
        count += sortAndCount(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);

        return count;
    }

    // Merge two sorted halves and count inversions
    private static long mergeAndCount(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;      // left pointer
        int j = mid + 1;   // right pointer
        int k = 0;

        long inversions = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // 🔥 THIS IS THE KEY LINE
                inversions += (mid - i + 1);
            }
        }

        // Copy leftovers
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy back
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        return inversions;
    }
}
