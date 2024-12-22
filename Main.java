public class Main {
    public static void main(String[] args) {
        Linkedlist kampusin = new Linkedlist();

        // Set lokasi
        kampusin.addLocation("Gomong");
        kampusin.addLocation("Kekalik");
        kampusin.addLocation("LabuApi");

        // Set mahasiswa awal
        kampusin.addMahasiswaToLocation("Gomong", "Andi", "101");
        kampusin.addMahasiswaToLocation("Gomong", "Budi", "102");
        kampusin.addMahasiswaToLocation("Kekalik", "Citra", "103");
        kampusin.addMahasiswaToLocation("LabuApi", "Dina", "104");

        // Set edge lokasi
        kampusin.addEdge("Gomong", "Kampus", 2);
        kampusin.addEdge("Gomong", "Kekalik", 1);
        kampusin.addEdge("Kekalik", "Kampus", 3);
        kampusin.addEdge("Kekalik", "LabuApi", 6);
        kampusin.addEdge("LabuApi", "Kekalik", 8);
        kampusin.addEdge("LabuApi", "Gomong", 10);

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Lokasi");
            System.out.println("2. Tambah Mahasiswa ke Lokasi");
            System.out.println("3. Tambah Edge antar Lokasi");
            System.out.println("4. Cetak Graph");
            System.out.println("5. Cari Mahasiswa di Lokasi");
            System.out.println("6. Keluarkan Mahasiswa dari Antrian");
            System.out.println("7. Jalur Tercepat ke Kampus (BFS)");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            pilihan = readInt();

            switch (pilihan) {
                case 1: // Tambah Lokasi
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiBaru = readLine();
                    kampusin.addLocation(lokasiBaru);
                    System.out.println("Lokasi " + lokasiBaru + " berhasil ditambahkan.");
                    break;

                case 2: // Tambah Mahasiswa ke Lokasi
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasi = readLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = readLine();
                    kampusin.addMahasiswaToLocation(lokasi, nama, nim);
                    break;

                case 3: // Tambah Edge antar Lokasi
                    System.out.print("Masukkan lokasi asal: ");
                    String fromLokasi = readLine();
                    System.out.print("Masukkan lokasi tujuan: ");
                    String toLokasi = readLine();
                    System.out.print("Masukkan jarak (km): ");
                    int weight = readInt();
                    kampusin.addEdge(fromLokasi, toLokasi, weight);
                    System.out.println("Edge dari " + fromLokasi + " ke " + toLokasi + " dengan jarak " + weight + " km berhasil ditambahkan.");
                    break;

                case 4: // Cetak Graph
                    kampusin.printGraph();
                    break;

                case 5: // Cari Mahasiswa di Lokasi
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiCari = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimCari = readLine();
                    kampusin.searchMahasiswa(lokasiCari, nimCari);
                    break;

                case 6: // Keluarkan Mahasiswa dari Antrian
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiKeluar = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimKeluar = readLine();
                    kampusin.dequeueMahasiswaByNim(lokasiKeluar, nimKeluar);
                    break;

                case 7: // Jalur Tercepat ke Kampus (BFS)
                    System.out.print("Masukkan lokasi awal: ");
                    String startLokasi = readLine();
                    kampusin.bfs(startLokasi);
                    break;

                case 0: // Keluar
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    private static String readLine() {
        StringBuilder input = new StringBuilder();
        try {
            int c;
            while ((c = System.in.read()) != -1 && c != '\n') {
                if (c != '\r') {
                    input.append((char) c);
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membaca input.");
        }
        return input.toString();
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }
}