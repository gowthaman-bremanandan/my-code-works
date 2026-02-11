package binarySearch.firstBadVersion;

import java.util.LinkedHashMap;
import java.util.Set;

public class FirstbadVersion {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "bad");
        map.put(2, "good");
        map.put(3, "good");
        map.put(4, "bad");
        map.put(5, "good");
        map.put(6, "good");
        int firtsBadKey = findTheBadVesrion(map);
        System.out.println(firtsBadKey != Integer.MAX_VALUE ? firtsBadKey : "No Bad mood found");
    }

    private static int findTheBadVesrion(LinkedHashMap<Integer, String> map) {
        Set<Integer> keyset = map.keySet();
        int length = keyset.size();
        Object[] keySetArray = keyset.toArray();
        int left = 0;
        int right = length - 1;
        int firstbadKey = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            Integer key = (Integer) keySetArray[mid];
            String mood = map.get(key);
            if ("bad".equalsIgnoreCase(mood)) {
                firstbadKey = Math.min(firstbadKey, key);
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return firstbadKey;
    }
}
