public class SimpleMap {
    private SimpleEntry head;

    private class SimpleEntry {
        Node key;
        Node value;
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
            if (current.key.lokasi.equals(key.lokasi)) {
                current.value = value;
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
        return null;
    }
}