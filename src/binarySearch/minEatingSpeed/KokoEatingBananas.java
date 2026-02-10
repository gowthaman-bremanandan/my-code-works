package binarySearch.yourName;

public class KokoEatingBananas {

    public static void main(String[] args) {

        int[] piles1 = {1, 4, 3, 2};
        int h1 = 9;
        System.out.println(minEatingSpeed(piles1, h1)); // Expected: 2

        int[] piles2 = {25, 10, 23, 4};
        int h2 = 4;
        System.out.println(minEatingSpeed(piles2, h2)); // Expected: 25
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = getMax(piles);
        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canEatAll(piles, h, mid)) {
                answer = mid;      // possible answer
                right = mid - 1;   // try smaller speed
            } else {
                left = mid + 1;    // need faster speed
            }
        }

        return answer;
    }

    private static boolean canEatAll(int[] piles, int h, int k) {

        long hours = 0;

        for (int pile : piles) {
            // ceil(pile / k)
            hours += (pile + k - 1) / k;
        }

        return hours <= h;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
