package dynamicPrograming.oned.countPalindromicSubstrings;

public class CountPalindromicSubstrings {

    public static void main(String[] args) {

        CountPalindromicSubstrings solver =
                new CountPalindromicSubstrings();

        String s1 = "abc";
        String s2 = "aaa";
        String s3 = "racecar";

        System.out.println("Input: " + s1);
        System.out.println("Count: " + solver.countSubstrings(s1));
        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Count: " + solver.countSubstrings(s2));
        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Count: " + solver.countSubstrings(s3));
    }

    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd length palindromes
            count += expandFromCenter(s, i, i);

            // even length palindromes
            count += expandFromCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {

        int count = 0;

        while (left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            count++;
            left--;
            right++;
        }

        return count;
    }
}