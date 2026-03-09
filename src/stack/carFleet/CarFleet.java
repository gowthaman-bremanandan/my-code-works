package stack.carFleet;

import java.util.Arrays;

public class CarFleet {

    public static void main(String[] args) {

        CarFleet solver = new CarFleet();

        System.out.println("Example 1:");
        System.out.println(
                solver.carFleet(
                        10,
                        new int[]{1,4},
                        new int[]{3,2}
                )
        ); // 1

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.carFleet(
                        10,
                        new int[]{4,1,0,7},
                        new int[]{2,2,1,1}
                )
        ); // 3
    }

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        double[][] cars = new double[n][2];

        // Store position and time
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {

            double currentTime = cars[i][1];

            if (currentTime > maxTime) {
                fleets++;
                maxTime = currentTime;
            }
        }

        return fleets;
    }
}