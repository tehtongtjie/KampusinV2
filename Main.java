public class Main {
    public static void main(String[] args) {
        Linkedlist kampusin = new Linkedlist();

        // Menambahkan lokasi
        kampusin.addLocation("Gomong");
        kampusin.addLocation("Kekalik");
        kampusin.addLocation("LabuApi");

        // Menambahkan mahasiswa ke lokasi tertentu
        kampusin.addMahasiswaToLocation("Gomong", "Andi", "101");
        kampusin.addMahasiswaToLocation("Gomong", "Budi", "102");
        kampusin.addMahasiswaToLocation("Kekalik", "Citra", "103");
        kampusin.addMahasiswaToLocation("LabuApi", "Dina", "104");

        // Menambahkan edge antara lokasi
        kampusin.addEdge("Gomong", "Kampus", 2);
        kampusin.addEdge("Gomong", "Kekalik", 1);
        kampusin.addEdge("Kekalik", "Kampus", 3);
        kampusin.addEdge("Kekalik", "LabuApi", 6);
        kampusin.addEdge("LabuApi", "Kekalik", 8);
        kampusin.addEdge("LabuApi", "Gomong", 10);

        // Mencetak graf
        System.out.println("Graf kampus:");
        kampusin.printGraph();

        //pencarian mahasiswa berdasarkan nim pada lokasi yang ditentukan
        System.out.println("Pencarian NIM:");
        kampusin.searchMahasiswa("LabuApi","104");

        System.out.println("Penghapusan Mahasiswa:");


        // Melakukan BFS dari lokasi tertentu
        System.out.println("\nMelakukan BFS dari 'LabuApi':");
        kampusin.bfs("LabuApi");
    }
}
