public class SimpleMap {
    private SimpleEntry head;

    public void put(Node to, Node current) {
    }

    private class SimpleEntry {
        Node key;
        int value;
        SimpleEntry next;

        public SimpleEntry(Node key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(Node key, int value) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        SimpleEntry newEntry = new SimpleEntry(key, value);
        newEntry.next = head;
        head = newEntry;
    }

    public int get(Node key) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return Integer.MAX_VALUE;
    }
}
