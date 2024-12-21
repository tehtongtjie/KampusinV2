public class Node {
    String nama, nim;
    int jarak;
    Node prev, next;

    public Node(String nama, String nim, int jarak) {
        this.nama = nama;
        this.nim = nim;
        this.jarak = jarak;
    }

    public void print() {
        System.out.println("+-----------------+------------+------------+");
        System.out.printf("| %-15s | %-10s | %-10s |\n", "Nama Mahasiswa", "NIM", "Jarak (km)");
        System.out.println("+-----------------+------------+------------+");
        System.out.printf("| %-15s | %-10s | %-10d |\n", nama, nim, jarak);
        System.out.println("+-----------------+------------+------------+");
    }
}