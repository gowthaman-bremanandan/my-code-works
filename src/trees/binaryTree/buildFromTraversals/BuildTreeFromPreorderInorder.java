package trees.binaryTree.buildFromTraversals;

import java.util.*;

public class BuildTreeFromPreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int preorderIndex = 0;
    private static Map<Integer, Integer> inorderMap;

    public static void main(String[] args) {

        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};

        TreeNode root = buildTree(preorder, inorder);

        printLevelOrder(root);  // should print 2 1 3 4
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderMap.get(rootValue);

        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }

    // Helper to verify
    private static void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing nulls (LeetCode style)
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }
}
