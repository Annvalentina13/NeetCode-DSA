class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        // Step 1: Insert copied nodes after each original node
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list and copied list
        curr = head;
        Node copyHead = head.next;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;
    }
}
