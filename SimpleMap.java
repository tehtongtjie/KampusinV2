public class SimpleMap {
    private SimpleEntry head;

    public void put(Node to, Node current) {
    }

    private class SimpleEntry {
        Node key;
        int value;  // Keep the value as an int to store distance (not Node)
        SimpleEntry next;

        public SimpleEntry(Node key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Put Node -> int pair
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

    // Get int (distance) for the given Node
    public int get(Node key) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return Integer.MAX_VALUE;  // Return Integer.MAX_VALUE if not found
    }

    public boolean containsKey(Node key) {
        SimpleEntry current = head;
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
