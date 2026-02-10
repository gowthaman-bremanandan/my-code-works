package binarySearch.timeBasedKV;

import java.util.*;

public class TimeMap {

    private static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value; // possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // ---- Main method for testing ----
    public static void main(String[] args) {

        TimeMap timeMap = new TimeMap();

        timeMap.set("alice", "happy", 1);
        System.out.println(timeMap.get("alice", 1)); // happy
        System.out.println(timeMap.get("alice", 2)); // happy

        timeMap.set("alice", "sad", 3);
        System.out.println(timeMap.get("alice", 3)); // sad
        System.out.println(timeMap.get("alice", 4)); // sad
        System.out.println(timeMap.get("bob", 1));   // ""
    }
}
