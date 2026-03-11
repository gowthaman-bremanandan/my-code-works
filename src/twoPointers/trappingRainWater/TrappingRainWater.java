package twoPointers.trappingRainWater;

public class TrappingRainWater {

    public static void main(String[] args) {

        TrappingRainWater solver = new TrappingRainWater();

        int[] height = {0,2,0,3,1,0,1,3,2,1};

        System.out.println(
                solver.trap(height)
        );

        int[] height2 = {5,4,3,2,1};

        System.out.println(
                solver.trap(height2)
        );
    }

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];

                left++;

            } else {

                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];

                right--;
            }
        }

        return water;
    }
}