class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class kth{

    public static Node reverseKGroup(Node head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node groupPrev = dummy;

        while (true) {

            // Find kth node
            Node kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // If fewer than k nodes remain
            if (kth == null) {
                break;
            }

            Node groupNext = kth.next;

            // Reverse current group
            Node prev = groupNext;
            Node curr = groupPrev.next;

            while (curr != groupNext) {

                Node next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            // Connect reversed group
            Node temp = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = temp;
        }

        return dummy.next;
    }

    // Print linked list
    public static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 3;

        System.out.println("Original Linked List:");
        display(head);

        head = reverseKGroup(head, k);

        System.out.println("After Reversing in Groups of " + k + ":");
        display(head);
    }
}
