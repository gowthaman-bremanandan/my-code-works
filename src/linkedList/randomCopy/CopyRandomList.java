package linkedList.randomCopy;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    public static void main(String[] args) {

        // Example 1: [[3,null],[7,3],[4,0],[5,1]]
        RandomListNode head1 = createList(
                new int[]{1, 2, 3, 4},
                new Integer[]{null, 1, 2, 3}
        );

        RandomListNode copied1 = copyRandomList(head1);
        printList(copied1);

        // Example 2: [[1,null],[2,2],[3,2]]
        RandomListNode head2 = createList(
                new int[]{1, 2, 3},
                new Integer[]{null, 2, 2}
        );

        RandomListNode copied2 = copyRandomList(head2);
        printList(copied2);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // Step 1: Create new nodes and insert them next to originals
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and copied list
        curr = head;
        RandomListNode newHead = head.next;

        while (curr != null) {
            RandomListNode copy = curr.next;
            curr.next = copy.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            curr = curr.next;
        }

        return newHead;
    }

    // Helper to create list using value[] and random index[]
    private static RandomListNode createList(int[] values, Integer[] randomIndex) {
        if (values.length == 0) return null;

        RandomListNode[] nodes = new RandomListNode[values.length];

        for (int i = 0; i < values.length; i++) {
            nodes[i] = new RandomListNode(values[i]);
        }

        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        for (int i = 0; i < randomIndex.length; i++) {
            if (randomIndex[i] != null) {
                nodes[i].random = nodes[randomIndex[i]];
            }
        }

        return nodes[0];
    }

    // Print list as [val, random_index]
    private static void printList(RandomListNode head) {
        Map<RandomListNode, Integer> indexMap = new HashMap<>();
        RandomListNode curr = head;
        int index = 0;

        while (curr != null) {
            indexMap.put(curr, index++);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Integer randomIdx = curr.random == null ? null : indexMap.get(curr.random);
            System.out.print("[" + curr.val + "," + randomIdx + "] ");
            curr = curr.next;
        }
        System.out.println();
    }
}
