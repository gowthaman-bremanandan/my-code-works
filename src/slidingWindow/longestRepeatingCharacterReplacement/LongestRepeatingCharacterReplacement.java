package slidingWindow.longestRepeatingCharacterReplacement;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement solver =
                new LongestRepeatingCharacterReplacement();

        System.out.println("Example 1:");
        System.out.println(
                solver.characterReplacement("XYYX", 2)
        ); // 4

        System.out.println("Example 2:");
        System.out.println(
                solver.characterReplacement("AAABABB", 1)
        ); // 5

        System.out.println("Example 3:");
        System.out.println(
                solver.characterReplacement("AAABABCAAAACA", 1)
        ); // 6
    }

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            freq[current - 'A']++;

            maxFreq = Math.max(maxFreq, freq[current - 'A']);

            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}