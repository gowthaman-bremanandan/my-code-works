package dynamicPrograming.oned.longestPalindromicSubstring;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        LongestPalindromicSubstring solver =
                new LongestPalindromicSubstring();

        String s1 = "ababd";
        String s2 = "abbc";
        String s3 = "racecar";
        String s4 = "aaaa";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + solver.longestPalindrome(s1));
        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Output: " + solver.longestPalindrome(s2));
        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Output: " + solver.longestPalindrome(s3));
        System.out.println();

        System.out.println("Input: " + s4);
        System.out.println("Output: " + solver.longestPalindrome(s4));
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandFromCenter(s, i, i);       // odd length
            int len2 = expandFromCenter(s, i, i + 1);   // even length

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {

                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}