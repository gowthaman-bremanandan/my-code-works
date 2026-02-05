package linkedList.removeNode;

import linkedList.reOrder.ListNode;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {

        // Example 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        head1 = removeNthFromEnd(head1, 4);
        printList(head1); // Expected: 1 -> 2 -> 4

        // Example 2
        ListNode head2 = createList(new int[]{5});
        head2 = removeNthFromEnd(head2, 1);
        printList(head2); // Expected: empty

        // Example 3
        ListNode head3 = createList(new int[]{1, 2});
        head3 = removeNthFromEnd(head3, 2);
        printList(head3); // Expected: 2
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases (like removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

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
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
