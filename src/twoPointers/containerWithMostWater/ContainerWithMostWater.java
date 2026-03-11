package twoPointers.containerWithMostWater;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        ContainerWithMostWater solver = new ContainerWithMostWater();

        int[] heights = {1,7,2,5,4,7,3,6};

        System.out.println(
                solver.maxArea(heights)
        );
    }

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int width = right - left;

            int area = h * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}