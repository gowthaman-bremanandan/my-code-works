package stack.dailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {

        DailyTemperatures solver = new DailyTemperatures();

        System.out.println("Example 1:");
        System.out.println(
                Arrays.toString(
                        solver.dailyTemperatures(
                                new int[]{30,38,30,36,35,40,28}
                        )
                )
        ); // [1,4,1,2,1,0,0]

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                Arrays.toString(
                        solver.dailyTemperatures(
                                new int[]{22,21,20}
                        )
                )
        ); // [0,0,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}