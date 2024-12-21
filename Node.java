public class Node {
    String lokasi;
    Node next;
    Edge edgeList;
    Queue mahasiswaQueue;

    public Node(String lokasi) {
        this.lokasi = lokasi;
        this.edgeList = null;
        this.next = null;
        this.mahasiswaQueue = new Queue();
    }
}