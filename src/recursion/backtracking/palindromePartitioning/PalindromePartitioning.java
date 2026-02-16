package recursion.backtracking.palindromePartitioning;

import java.util.*;

public class PalindromePartitioning {

    public static void main(String[] args) {

        System.out.println(partition("aab"));
        System.out.println(partition("a"));
        System.out.println(partition("abcac"));
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s,
                                  int start,
                                  List<String> current,
                                  List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                // Choose substring
                current.add(s.substring(start, end + 1));

                // Explore remaining
                backtrack(s, end + 1, current, result);

                // Undo
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
