package mathgeometry.powXN;

public class PowXN {

    public static void main(String[] args) {

        PowXN solver = new PowXN();

        System.out.println("Example 1:");
        System.out.println(solver.myPow(2.0, 5)); // 32.0

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(solver.myPow(1.1, 10)); // 2.59374

        System.out.println();

        System.out.println("Example 3:");
        System.out.println(solver.myPow(2.0, -3)); // 0.125
    }

    public double myPow(double x, int n) {

        long N = n; // avoid overflow

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {

        if (n == 0)
            return 1;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}