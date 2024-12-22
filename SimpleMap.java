public class SimpleMap {
    private SimpleEntry head;

    private class SimpleEntry {
        Node key;
        Node value; // Ubah tipe dari int menjadi Node
        SimpleEntry next;

        public SimpleEntry(Node key, Node value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(Node key, Node value) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key.lokasi.equals(key.lokasi)) { // Gunakan .equals untuk membandingkan key
                current.value = value; // Update jika key sudah ada
                return;
            }
            current = current.next;
        }
        SimpleEntry newEntry = new SimpleEntry(key, value);
        newEntry.next = head;
        head = newEntry;
    }

    public Node get(Node key) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Return null jika key tidak ditemukan
    }
}