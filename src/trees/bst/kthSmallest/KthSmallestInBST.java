package trees.bst.kthSmallest;

public class KthSmallestInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int count = 0;
    private static int result = -1;

    public static void main(String[] args) {

        /*
              4
             / \
            3   5
           /
          2
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);

        int k = 4;

        System.out.println(kthSmallest(root, k)); // 5
    }

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {

        if (node == null || result != -1) {
            return;
        }

        inorder(node.left, k);

        count++;

        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
