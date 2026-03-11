package bitManipulation.sumWithoutPlus;

public class SumWithoutPlus {

    public static void main(String[] args) {

        SumWithoutPlus solver = new SumWithoutPlus();

        System.out.println("Example 1:");
        System.out.println(solver.getSum(1, 1)); // 2

        System.out.println("Example 2:");
        System.out.println(solver.getSum(4, 7)); // 11
    }

    public int getSum(int a, int b) {

        while (b != 0) {

            int sum = a ^ b;         // sum without carry
            int carry = (a & b) << 1; // carry

            a = sum;
            b = carry;
        }

        return a;
    }
}