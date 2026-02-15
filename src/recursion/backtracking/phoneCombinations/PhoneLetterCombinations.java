package recursion.backtracking.phoneCombinations;

import java.util.*;

public class PhoneLetterCombinations {

    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("34"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, "", result);
        return result;
    }

    private static void backtrack(String digits,
                                  int index,
                                  String current,
                                  List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {

            backtrack(digits, index + 1,
                    current + c,
                    result);
        }
    }
}
