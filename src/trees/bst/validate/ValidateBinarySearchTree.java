package trees.bst.validate;

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Example 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println(isValidBST(root1)); // true


        // Example 2: Invalid BST
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(isValidBST(root2)); // false
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        // If value violates allowed range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Check left and right subtrees
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
