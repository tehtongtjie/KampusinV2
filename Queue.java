public class Queue {
    Mahasiswa front, rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String nama, String nim) {
        Mahasiswa newMahasiswa = new Mahasiswa(nama, nim);
        if (rear == null) {
            front = rear = newMahasiswa;
        } else {
            rear.next = newMahasiswa;
            rear = newMahasiswa;
        }
    }

    public Mahasiswa dequeue() {
        if (front == null) return null;
        Mahasiswa temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    public Mahasiswa dequeueByNim(String nim) {
        if (front == null) return null;

        if (front.nim.equals(nim)) {
            return dequeue();
        }

        Mahasiswa current = front;
        Mahasiswa prev = null;

        while (current != null && !current.nim.equals(nim)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return null;
        }

        if (prev != null) {
            prev.next = current.next;
        }

        if (current == rear) {
            rear = prev;
        }

        return current;
    }

    public Mahasiswa dequeueByNama(String nama) {
        if (front == null) return null;

        if (front.nama.equals(nama)) {
            return dequeue();
        }

        Mahasiswa current = front;
        Mahasiswa prev = null;

        while (current != null && !current.nama.equals(nama)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return null;
        }

        if (prev != null) {
            prev.next = current.next;
        }

        if (current == rear) {
            rear = prev;
        }

        return current;
    }

    public Mahasiswa search(String nim) {
        Mahasiswa temp = front;
        while (temp != null) {
            if (temp.nim.equals(nim)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void sort() {
        if (front == null || front.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Mahasiswa current = front;
            Mahasiswa prev = null;
            while (current.next != null) {
                if (current.nim.compareTo(current.next.nim) > 0) {
                    Mahasiswa next = current.next;
                    current.next = next.next;
                    next.next = current;
                    if (prev == null) {
                        front = next;
                    } else {
                        prev.next = next;
                    }
                    swapped = true;
                } else {
                    current = current.next;
                }
                if (prev == null) {
                    prev = front;
                } else {
                    prev = prev.next;
                }
            }
        } while (swapped);
    }

    public void printQueue() {
        Mahasiswa temp = front;
        while (temp != null) {
            System.out.println("Nama: " + temp.nama + ", NIM: " + temp.nim);
            temp = temp.next;
        }
    }
}
