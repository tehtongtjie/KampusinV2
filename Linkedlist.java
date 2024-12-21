public class Linkedlist {
    Node head, tail;

    public Linkedlist() {
        this.head = null;
        this.tail = null;
        addLocation("Kampus");
    }

    public void addLocation(String lokasi) {
        Node newNode = new Node(lokasi);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node getNode(String lokasi) {
        Node temp = head;
        while (temp != null) {
            if (temp.lokasi.equals(lokasi)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addMahasiswaToLocation(String lokasi, String nama, String nim) {
        Node node = getNode(lokasi);
        if (node != null) {
            node.mahasiswaQueue.enqueue(nama, nim);
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
        }
    }

    public void addEdge(String fromLokasi, String toLokasi, int weight) {
        Node fromNode = getNode(fromLokasi);
        Node toNode = getNode(toLokasi);

        if (fromNode != null && toNode != null) {
            Edge newEdge = new Edge(fromNode, toNode, weight);
            if (fromNode.edgeList == null) {
                fromNode.edgeList = newEdge;
            } else {
                Edge current = fromNode.edgeList;
                while (current.nextEdge != null) {
                    current = current.nextEdge;
                }
                current.nextEdge = newEdge;
            }
        }
    }

    public void printGraph() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Lokasi: " + temp.lokasi);
            System.out.println("Mahasiswa di lokasi:");
            temp.mahasiswaQueue.printQueue();
            Edge edge = temp.edgeList;
            while (edge != null) {
                System.out.println("  -> " + edge.to.lokasi + " (" + edge.weight + " km)");
                edge = edge.nextEdge;
            }
            temp = temp.next;
        }
    }

    public void bfs(String startLokasi) {
        Node startNode = getNode(startLokasi);
        if (startNode == null) {
            System.out.println("Lokasi " + startLokasi + " tidak ditemukan.");
            return;
        }

        SimpleMap distances = new SimpleMap();
        SimpleMap predecessors = new SimpleMap();
        PriorityQueue queue = new PriorityQueue();

        // Initialize distances to infinity, except for the start node
        Node temp = head;
        while (temp != null) {
            distances.put(temp, Integer.MAX_VALUE);  // Set all distances to infinity initially
            temp = temp.next;
        }
        distances.put(startNode, 0);  // Distance to start node is 0

        queue.add(startNode, 0);  // Add the start node to the priority queue

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // If we reach the target location ("Kampus"), print the path
            if (current.lokasi.equals("Kampus")) {
                System.out.println("Jalur tercepat ke Kampus ditemukan:");
                printPath(predecessors, current);
                System.out.println("\nTotal jarak: " + distances.get(current) + " km");
                return;
            }

            Edge edge = current.edgeList;
            while (edge != null) {
                int newDist = distances.get(current) + edge.weight;  // Calculate new distance for the neighbor
                if (newDist < distances.get(edge.to)) {
                    distances.put(edge.to, newDist);  // Update the distance to the neighbor

                    // Only update predecessor if it has not been set yet
                    if (predecessors.get(edge.to) == Integer.MAX_VALUE) {
                        predecessors.put(edge.to, current);  // Set the predecessor to the current node
                    }

                    queue.add(edge.to, newDist);  // Add the neighbor to the queue
                }
                edge = edge.nextEdge;
            }
        }

        System.out.println("Tidak ada jalur ke Kampus.");
    }

    private void printPath(SimpleMap predecessors, Node target) {
        if (predecessors.get(target) == Integer.MAX_VALUE) {
            System.out.print(target.lokasi);
            return;
        }
        printPath(predecessors, predecessors.get(target));  // Recursively print the path
        System.out.print(" -> " + target.lokasi);
    }
    private void printPath(SimpleMap predecessors, int i) {
    }
}