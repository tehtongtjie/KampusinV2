public class NodeQueue {
    private Node front, rear;

    public NodeQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Node node) {
        Node newNode = new Node(node.lokasi);
        newNode.edgeList = node.edgeList;
        newNode.mahasiswaQueue = node.mahasiswaQueue;
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue() {
        if (front == null) return null;
        Node temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
