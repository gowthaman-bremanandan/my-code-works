package greedy.validParenthesisString;

public class ValidParenthesisString {

    public static void main(String[] args) {

        ValidParenthesisString solver = new ValidParenthesisString();

        System.out.println("Example 1:");
        System.out.println(
                solver.checkValidString("((**)")
        ); // true

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.checkValidString("(((*)")
        ); // false
    }

    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;   // treat as ')'
                maxOpen++;   // treat as '('
            }

            if (maxOpen < 0)
                return false;

            minOpen = Math.max(minOpen, 0);
        }

        return minOpen == 0;
    }
}