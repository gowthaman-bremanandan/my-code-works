package recursion.backtracking.generateParentheses;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    private static void backtrack(int n,
                                  int openCount,
                                  int closeCount,
                                  String current,
                                  List<String> result) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            backtrack(n, openCount + 1, closeCount,
                    current + "(", result);
        }

        if (closeCount < openCount) {
            backtrack(n, openCount, closeCount + 1,
                    current + ")", result);
        }
    }
}
