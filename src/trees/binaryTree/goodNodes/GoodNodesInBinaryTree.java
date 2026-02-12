package trees.binaryTree.goodNodes;

public class GoodNodesInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
                2
              /   \
             1     1
            /     / \
           3     1   5
        */

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(countGoodNodes(root)); // 3
    }

    public static int countGoodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int maxSoFar) {

        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.val >= maxSoFar) {
            count = 1;
        }

        int newMax = Math.max(maxSoFar, node.val);

        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }
}
