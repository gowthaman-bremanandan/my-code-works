package trees.binaryTree.maxPathSum;

public class MaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int maxSum;

    public static void main(String[] args) {

        /*
              1
             / \
            2   3
        */

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        System.out.println(maxPathSum(root1)); // 6


        /*
                -15
                /   \
              10     20
                     /  \
                    15   5
                   /
                 -5
        */

        TreeNode root2 = new TreeNode(-15);
        root2.left = new TreeNode(10);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(5);
        root2.right.left.left = new TreeNode(-5);

        System.out.println(maxPathSum(root2)); // 40

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(-50);
        root3.right = new TreeNode(-20);
        System.out.println(maxPathSum(root3)); // 40
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}
