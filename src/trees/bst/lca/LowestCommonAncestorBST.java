package trees.bst.lca;

public class LowestCommonAncestorBST {

    // Definition for a BST node
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
                 5
               /   \
              3     8
             / \   / \
            1   4 7   9
             \
              2
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;       // 3
        TreeNode q = root.right;      // 8

        TreeNode lca1 = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 3 and 8: " + lca1.val); // 5

        TreeNode p2 = root.left;            // 3
        TreeNode q2 = root.left.right;      // 4

        TreeNode lca2 = lowestCommonAncestor(root, p2, q2);
        System.out.println("LCA of 3 and 4: " + lca2.val); // 3
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode current = root;

        while (current != null) {

            // Both nodes are smaller → go left
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // Both nodes are bigger → go right
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // Split happens here → this is LCA
            else {
                return current;
            }
        }

        return null; // will never reach here as per constraints
    }
}