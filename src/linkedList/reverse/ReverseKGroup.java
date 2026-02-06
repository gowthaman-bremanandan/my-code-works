package linkedList.reverse;

import linkedList.reOrder.ListNode;

public class ReverseKGroup {

    public static void main(String[] args) {

        // Example 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        head1 = reverseKGroup(head1, 3);
        printList(head1); // Expected: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7

        // Example 2
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5});
        head2 = reverseKGroup(head2, 3);
        printList(head2); // Expected: 3 -> 2 -> 1 -> 4 -> 5
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            // 1. Check if k nodes exist
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;
            }

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;

            // 2. Reverse k nodes
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 3. Connect previous group with reversed group
            prevGroupEnd.next = kthNode;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private static ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    private static ListNode createList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
