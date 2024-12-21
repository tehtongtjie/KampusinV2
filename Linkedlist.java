public class Linkedlist {
    Node head, tail;
    Edge edgeHead = null;

    public void add(String nama, String nim, int jarak) {
        Node newNode = new Node(nama, nim, jarak);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addEdge(String fromNim, String toNim, int weight) {
        Node fromNode = searchingNim(fromNim);
        Node toNode = searchingNim(toNim);

        if (fromNode != null && toNode != null) {
            Edge newEdge = new Edge(fromNode, toNode, weight);
            if (edgeHead == null) {
                edgeHead = newEdge;
            } else {
                Edge lastEdge = edgeHead;
                while (lastEdge.nextEdge != null) {
                    lastEdge = lastEdge.nextEdge;
                }
                lastEdge.nextEdge = newEdge;
            }
        }
    }

    public void delete(String nim) {
        Node temp = head;
        while (temp != null) {
            if (temp.nim.equals(nim)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null)
                        head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                if (edgeHead != null) {
                    Edge prevEdge = null;
                    Edge currentEdge = edgeHead;
                    while (currentEdge != null) {
                        if (currentEdge.from.nim.equals(nim) || currentEdge.to.nim.equals(nim)) {
                            if (prevEdge == null) {
                                edgeHead = currentEdge.nextEdge;
                            } else {
                                prevEdge.nextEdge = currentEdge.nextEdge;
                            }
                        } else {
                            prevEdge = currentEdge;
                        }
                        currentEdge = currentEdge.nextEdge;
                    }
                }
                System.out.println("\nPenghapusan Data Mahasiswa :");
                System.out.println("x--------------------------------------------------------------------------------x");
                System.out.println("| Mahasiswa dengan NIM " + nim + " dihapus karena tidak pernah masuk kuliah tanpa kabar. |");
                System.out.println("x--------------------------------------------------------------------------------x");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Tidak ada data mahasiswa.");
            return;
        }

        System.out.println("+-----------------+------------+------------+");
        System.out.printf("| %-15s | %-10s | %-10s |\n", "Nama Mahasiswa", "NIM", "Jarak (km)");
        System.out.println("+-----------------+------------+------------+");
        Node temp = head;
        while (temp != null) {
            System.out.printf("| %-15s | %-10s | %-10d |\n", temp.nama, temp.nim, temp.jarak);
            temp = temp.next;
        }
        System.out.println("+-----------------+------------+------------+");
    }

    public void sortingJarak() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.jarak > current.next.jarak) {
                    String tempName = current.nama;
                    String tempNim = current.nim;
                    int tempJarak = current.jarak;

                    current.nama = current.next.nama;
                    current.nim = current.next.nim;
                    current.jarak = current.next.jarak;

                    current.next.nama = tempName;
                    current.next.nim = tempNim;
                    current.next.jarak = tempJarak;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public Node searchingNim(String nim) {
        Node temp = head;
        while (temp != null) {
            if (temp.nim.equals(nim)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void printEdges() {
        if (edgeHead == null) {
            System.out.println("Tidak ada edge yang terhubung.");
            return;
        }

        Edge tempEdge = edgeHead;
        System.out.println("+-----------------+------------+------------+");
        System.out.printf("| %-15s | %-10s | %-10s |\n", "Dari", "Ke", "Jarak (km)");
        System.out.println("+-----------------+------------+------------+");
        while (tempEdge != null) {
            System.out.printf("| %-15s | %-11s| %-11d|\n",
                    tempEdge.from.nama,
                    tempEdge.to.nama,
                    tempEdge.weight);
            tempEdge = tempEdge.nextEdge;
        }
        System.out.println("+-----------------+-------------+-----------+");
    }
}