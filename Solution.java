package Learn_java;

public class For_Loop {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * Adds two numbers represented by linked lists
     * @param l1 The first linked list (in reverse order)
     * @param l2 The second linked list (in reverse order)
     * @return The sum as a new linked list (in reverse order)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head to simplify result list management
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // Initialize carry for addition
        int carry = 0;

        // Traverse both lists while either has nodes or there's a carry
        while (l1 != null || l2 != null || carry > 0) {
            // Get values from current nodes (or 0 if node is null)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum including carry from previous addition
            int sum = x + y + carry;

            // Calculate new carry for next iteration
            carry = sum / 10;

            // Create new node with the ones digit of sum
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the result list (skip the dummy head)
        return dummyHead.next;
    }

    // Helper method to print the list (for testing)
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        For_Loop solution = new For_Loop();
        ListNode result = solution.addTwoNumbers(l1, l2);
        printList(result); // Expected: 7 0 8
    }
}
