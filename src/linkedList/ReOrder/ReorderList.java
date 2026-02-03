package linkedList.ReOrder;

public class ReorderList {

    public static void main(String[] args) {
        // Example 1: [2,4,6,8]
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        reorderList(head1);
        printList(head1);

        // Example 2: [2,4,6,8,10]
        ListNode head2 = createList(new int[]{2, 4, 6, 8, 10});
        reorderList(head2);
        printList(head2);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        // 3. Merge two halves
        ListNode firstHalf = head;

        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
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
