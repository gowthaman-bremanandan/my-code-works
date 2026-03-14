package arraysHashing.topKFrequentElements;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {

        TopKFrequentElements solver = new TopKFrequentElements();

        int[] nums = {1,2,2,3,3,3};
        int k = 2;

        System.out.println(
                Arrays.toString(solver.topKFrequent(nums, k))
        );
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int key : freqMap.keySet()) {

            int freq = freqMap.get(key);

            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();

            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {

                    result[index++] = num;

                    if (index == k)
                        break;
                }
            }
        }

        return result;
    }
}