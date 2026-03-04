package greedy.jumpGameTwo;

public class JumpGameTwo {

    public static void main(String[] args) {

        JumpGameTwo solver = new JumpGameTwo();

        System.out.println("Example 1:");
        System.out.println(
                solver.jump(new int[]{2,4,1,1,1,1})
        ); // 2

        System.out.println();

        System.out.println(
                solver.jump(new int[]{1,2,4,1,2,1,1,1})
        ); // 2

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.jump(new int[]{2,1,2,1,0})
        ); // 2
    }

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}