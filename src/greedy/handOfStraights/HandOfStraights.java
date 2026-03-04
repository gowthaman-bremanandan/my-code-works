package greedy.handOfStraights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public static void main(String[] args) {

        HandOfStraights solver = new HandOfStraights();

        System.out.println("Example 1:");
        System.out.println(
                solver.isNStraightHand(
                        new int[]{1,2,4,2,3,5,3,4},
                        4
                )
        ); // true

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.isNStraightHand(
                        new int[]{1,2,3,3,4,5,6,7},
                        4
                )
        ); // false
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for (int card : hand) {

            if (countMap.get(card) == 0)
                continue;

            for (int i = 0; i < groupSize; i++) {

                int current = card + i;

                if (!countMap.containsKey(current) ||
                        countMap.get(current) == 0) {

                    return false;
                }

                countMap.put(current, countMap.get(current) - 1);
            }
        }

        return true;
    }
}