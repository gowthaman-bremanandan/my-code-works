package greedy.jumpGame;

public class JumpGame {

    public static void main(String[] args) {

        JumpGame solver = new JumpGame();

        System.out.println("Example 1:");
        System.out.println(
                solver.canJump(new int[]{1,2,0,1,0})
        ); // true

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.canJump(new int[]{1,2,1,0,1})
        ); // false
    }

    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}