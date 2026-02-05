package linkedList.AddNumbers;

import linkedList.ReOrder.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {

        // Example 1: 321 + 654 = 975
        ListNode l1 = createList(new int[]{1, 2, 3});
        ListNode l2 = createList(new int[]{4, 5, 6});
        ListNode result1 = addTwoNumbers(l1, l2);
        printList(result1); // Expected: 5 -> 7 -> 9

        // Example 2: 9 + 9 = 18
        ListNode l3 = createList(new int[]{9});
        ListNode l4 = createList(new int[]{9});
        ListNode result2 = addTwoNumbers(l3, l4);
        printList(result2); // Expected: 8 -> 1
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
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
