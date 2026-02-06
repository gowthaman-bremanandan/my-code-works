package linkedList.sorted;

import linkedList.reOrder.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        // Example 1
        ListNode l1 = createList(new int[]{1, 2, 4});
        ListNode l2 = createList(new int[]{1, 3, 5});
        ListNode l3 = createList(new int[]{3, 6});

        ListNode[] lists1 = {l1, l2, l3};
        ListNode result1 = mergeKLists(lists1);
        printList(result1); // Expected: 1 1 2 3 3 4 5 6

        // Example 2
        ListNode[] lists2 = {};
        printList(mergeKLists(lists2)); // Expected: []

        // Example 3
        ListNode[] lists3 = {null};
        printList(mergeKLists(lists3)); // Expected: []
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add head of each list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    private static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
