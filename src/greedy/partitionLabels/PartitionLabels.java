package greedy.partitionLabels;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {

        PartitionLabels solver = new PartitionLabels();

        System.out.println("Example 1:");
        System.out.println(
                solver.partitionLabels("xyxxyzbzbbisl")
        ); // [5,5,1,1,1]

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.partitionLabels("abcabc")
        ); // [6]
    }

    public List<Integer> partitionLabels(String s) {

        int[] lastIndex = new int[26];

        // Step 1: record last occurrence
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}