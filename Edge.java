public class Edge {
    Node from;
    Node to;
    int weight;
    Edge nextEdge;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.nextEdge = null;
    }
}