package stack.largestRectangleInHistogram;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {

        LargestRectangle solver = new LargestRectangle();

        System.out.println("Example 1:");
        System.out.println(
                solver.largestRectangleArea(new int[]{7,1,7,2,2,4})
        ); // 8

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.largestRectangleArea(new int[]{1,3,7})
        ); // 7

        System.out.println("Example 2:");
        System.out.println(
                solver.largestRectangleArea(new int[]{1,2,3,4,2})
        ); // 7
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                    currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int right = i;

                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}