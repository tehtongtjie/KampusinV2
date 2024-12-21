class PriorityQueue {
    private PriorityNode head;

    private class PriorityNode {
        Node element;
        int priority;
        PriorityNode next;

        public PriorityNode(Node element, int priority) {
            this.element = element;
            this.priority = priority;
            this.next = null;
        }
    }

    public void add(Node element, int priority) {
        PriorityNode newNode = new PriorityNode(element, priority);
        if (head == null || head.priority > priority) {
            newNode.next = head;
            head = newNode;
        } else {
            PriorityNode current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public Node poll() {
        if (head == null) {
            return null;
        }
        Node result = head.element;
        head = head.next;
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }
}