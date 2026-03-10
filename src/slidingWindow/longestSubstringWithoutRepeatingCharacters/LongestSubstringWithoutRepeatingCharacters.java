package slidingWindow.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters solver =
                new LongestSubstringWithoutRepeatingCharacters();

        System.out.println("Example 1:");
        System.out.println(
                solver.lengthOfLongestSubstring("zxyzxyz")
        ); // 3

        System.out.println("Example 2:");
        System.out.println(
                solver.lengthOfLongestSubstring("xxxx")
        ); // 1
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> window = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // If duplicate found, shrink window from left
            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}