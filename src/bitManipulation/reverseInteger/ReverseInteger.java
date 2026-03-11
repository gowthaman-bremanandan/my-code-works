package bitManipulation.reverseInteger;

public class ReverseInteger {

    public static void main(String[] args) {

        ReverseInteger solver = new ReverseInteger();

        System.out.println("Example 1:");
        System.out.println(solver.reverse(1234));   // 4321

        System.out.println("Example 2:");
        System.out.println(solver.reverse(-1234));  // -4321

        System.out.println("Example 3:");
        System.out.println(solver.reverse(1234236467)); // 0
    }

    public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int digit = x % 10;

            if (result > Integer.MAX_VALUE / 10 ||
                    result < Integer.MIN_VALUE / 10) {
                return 0;
            }

            result = result * 10 + digit;

            x = x / 10;
        }

        return result;
    }
}