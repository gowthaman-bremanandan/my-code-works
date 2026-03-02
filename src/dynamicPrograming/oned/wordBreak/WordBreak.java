package dynamicPrograming.oned.wordBreak;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        WordBreak solver = new WordBreak();

        System.out.println("Example 1:");
        System.out.println(solver.wordBreak(
                "neetcode",
                Arrays.asList("neet","code")
        ));

        System.out.println("Example 2:");
        System.out.println(solver.wordBreak(
                "applepenapple",
                Arrays.asList("apple","pen","ape")
        ));

        System.out.println("Example 3:");
        System.out.println(solver.wordBreak(
                "catsincars",
                Arrays.asList("cats","cat","sin","in","car")
        ));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}