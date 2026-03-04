package greedy.gasStation;

public class GasStation {

    public static void main(String[] args) {

        GasStation solver = new GasStation();

        System.out.println("Example 1:");
        System.out.println(
                solver.canCompleteCircuit(
                        new int[]{1,2,3,4},
                        new int[]{2,2,4,1}
                )
        ); // 3

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.canCompleteCircuit(
                        new int[]{1,2,3},
                        new int[]{2,3,2}
                )
        ); // -1
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum = 0;
        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            totalSum += diff;
            currentSum += diff;

            if (currentSum < 0) {
                start = i + 1;
                currentSum = 0;
            }
        }

        if (totalSum < 0)
            return -1;

        return start;
    }
}