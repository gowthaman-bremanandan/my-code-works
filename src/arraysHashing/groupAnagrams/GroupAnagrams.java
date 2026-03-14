package arraysHashing.groupAnagrams;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        GroupAnagrams solver = new GroupAnagrams();

        String[] strs = {"act","pots","tops","cat","stop","hat"};

        System.out.println(
                solver.groupAnagrams(strs)
        );
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}