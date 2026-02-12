package trees.binaryTree.serializeDeserialize;

import java.util.*;

public class SerializeDeserializeBinaryTree {

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
              1
             / \
            2   3
               / \
              4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);

        System.out.println("Re-Serialized After Deserialize: " + serialize(deserialized));
    }

    // SERIALIZE
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        return sb.toString();
    }

    private static void preorderSerialize(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        preorderSerialize(node.left, sb);
        preorderSerialize(node.right, sb);
    }

    // DESERIALIZE
    public static TreeNode deserialize(String data) {

        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }
}
