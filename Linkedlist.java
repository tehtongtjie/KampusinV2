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
            temp.mahasiswaQueue.printQueue();
            Edge edge = temp.edgeList;
            while (edge != null) {
                System.out.println("  -> " + edge.to.lokasi + " (" + edge.weight + " km)");
                edge = edge.nextEdge;
            }
            temp = temp.next;
        }
    }

    public void searchMahasiswa(String lokasi, String nim) {
        Node node = getNode(lokasi);
        if (node != null) {
            Mahasiswa mahasiswa = node.mahasiswaQueue.search(nim);
            if (mahasiswa != null) {
                System.out.println("Mahasiswa ditemukan di lokasi " + lokasi + ":");
                System.out.println("Nama: " + mahasiswa.nama + ", NIM: " + mahasiswa.nim);
            } else {
                System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan di lokasi " + lokasi + ".");
            }
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
        }
    }

    public void dequeueMahasiswaByNim(String lokasi, String nim) {
        Node node = getNode(lokasi);
        if (node != null) {
            Mahasiswa mahasiswa = node.mahasiswaQueue.dequeueByNim(nim);
            if (mahasiswa != null) {
                System.out.println("Mahasiswa dengan NIM " + nim + " telah keluar dari antrian di lokasi " + lokasi + ":");
                System.out.println("Nama: " + mahasiswa.nama + ", NIM: " + mahasiswa.nim);
            } else {
                System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan di antrian lokasi " + lokasi + ".");
            }
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
        }
    }

    public void dequeueMahasiswaByNama(String lokasi, String nama) {
        Node node = getNode(lokasi);
        if (node != null) {
            Mahasiswa mahasiswa = node.mahasiswaQueue.dequeueByNama(nama);
            if (mahasiswa != null) {
                System.out.println("Mahasiswa dengan nama " + nama + " telah keluar dari antrian di lokasi " + lokasi + ":");
                System.out.println("Nama: " + mahasiswa.nama + ", NIM: " + mahasiswa.nim);
            } else {
                System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan di antrian lokasi " + lokasi + ".");
            }
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
        }
    }

    public void sortMahasiswa(String lokasi) {
        Node node = getNode(lokasi);
        if (node != null) {
            node.mahasiswaQueue.sort();
            System.out.println("Antrian mahasiswa di lokasi " + lokasi + " telah diurutkan berdasarkan NIM.");
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
        }
    }

    public void dequeueMahasiswa(String lokasi) {
        Node node = getNode(lokasi);
        if (node != null) {
            Mahasiswa mahasiswa = node.mahasiswaQueue.dequeue();
            if (mahasiswa != null) {
                System.out.println("Mahasiswa berikut telah keluar dari antrian di lokasi " + lokasi + ":");
                System.out.println("Nama: " + mahasiswa.nama + ", NIM: " + mahasiswa.nim);
            } else {
                System.out.println("Antrian mahasiswa di lokasi " + lokasi + " kosong.");
            }
        } else {
            System.out.println("Lokasi " + lokasi + " tidak ditemukan.");
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

        Node temp = head;
        while (temp != null) {
            distances.put(temp, Integer.MAX_VALUE);
            temp = temp.next;
        }
        distances.put(startNode, 0);

        queue.add(startNode, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.lokasi.equals("Kampus")) {
                System.out.println("Jalur tercepat ke Kampus ditemukan:");
                printPath(predecessors, current);
                System.out.println("\nTotal jarak: " + distances.get(current) + " km");
                return;
            }

            Edge edge = current.edgeList;
            while (edge != null) {
                int newDist = distances.get(current) + edge.weight;
                if (newDist < distances.get(edge.to)) {
                    distances.put(edge.to, newDist);

                    if (predecessors.get(edge.to) == Integer.MAX_VALUE) {
                        predecessors.put(edge.to, current);
                    }

                    queue.add(edge.to, newDist);
                }
                edge = edge.nextEdge;
            }
        }

        System.out.println("Tidak ada jalur ke Kampus.");
    }

    private void printPath(SimpleMap predecessors, Node target) {
        if (predecessors.get(target) == Integer.MAX_VALUE) {
            System.out.print(target.lokasi);
        }
        printPath(predecessors, predecessors.get(target));
        System.out.print(" -> " + target.lokasi);
    }
    private void printPath(SimpleMap predecessors, int i) {
    }
}