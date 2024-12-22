public class Main {
    public static void main(String[] args) {
        Linkedlist kampusin = new Linkedlist();

        // Set lokasi awal
        kampusin.addLocation("Gomong");
        kampusin.addLocation("Kekalik");
        kampusin.addLocation("Labuapi");
        kampusin.addLocation("Ampenan");
        kampusin.addLocation("Gunung sari");
        kampusin.addLocation("Sangkareang");

        // Set mahasiswa awal
        kampusin.addMahasiswaToLocation("Gomong", "Andi", "101");
        kampusin.addMahasiswaToLocation("Labuapi", "Budi", "102");
        kampusin.addMahasiswaToLocation("Kekalik", "Citra", "103");
        kampusin.addMahasiswaToLocation("Ampenan", "Dina", "104");
        kampusin.addMahasiswaToLocation("Gunung sari", "Edna", "105");
        kampusin.addMahasiswaToLocation("Sangkareang", "Fasha", "106");
        kampusin.addMahasiswaToLocation("Kekalik", "Gian", "107");
        kampusin.addMahasiswaToLocation("Gomong", "Halid", "108");
        kampusin.addMahasiswaToLocation("Sangkareang", "Icha", "109");
        kampusin.addMahasiswaToLocation("Labuapi", "Joko", "110");

        // Set edge lokasi
        kampusin.addEdge("Gomong", "Kampus", 2);
        kampusin.addEdge("Gomong", "Kekalik", 1);
        kampusin.addEdge("Gomong", "Labuapi", 10);
        kampusin.addEdge("Kekalik", "Kampus", 3);
        kampusin.addEdge("Kekalik", "Labuapi", 8);
        kampusin.addEdge("Kekalik", "Gomong", 1);
        kampusin.addEdge("Kekalik", "Ampenan", 13);
        kampusin.addEdge("Labuapi", "Kekalik", 8);
        kampusin.addEdge("Labuapi", "Gomong", 10);
        kampusin.addEdge("Ampenan", "Kampus", 6);
        kampusin.addEdge("Ampenan", "Gunung sari", 4);
        kampusin.addEdge("Ampenan", "Kekalik", 13);
        kampusin.addEdge("Gunung sari", "Ampenan", 4);
        kampusin.addEdge("Gunung sari", "Sangkareang", 7);
        kampusin.addEdge("Sangkareang", "Kampus", 2);
        kampusin.addEdge("Sangkareang", "Gunung sari", 7);

        int pilihan;
        do {
            System.out.println("\033[2j\033[H");
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Lokasi");
            System.out.println("2. Tambah Mahasiswa ke Lokasi");
            System.out.println("3. Tambah Edge antar Lokasi");
            System.out.println("4. Cetak Graph");
            System.out.println("5. Cari Mahasiswa Berdasarkan Lokasi");
            System.out.println("6. Keluarkan Mahasiswa Berdasarkan NIM (Cuti/Drop)");
            System.out.println("7. Jalur Tercepat ke Kampus (BFS)");
            System.out.println("8. Urutan Mahasiswa Berdasarkan Lokasi");
            System.out.println("9. Keluarkan Mahasiswa (Sudah Lulus)");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            pilihan = readInt();

            switch (pilihan) {
                case 1: // Tambah Lokasi
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiBaru = readLine();
                    kampusin.addLocation(lokasiBaru);
                    System.out.println("Lokasi " + lokasiBaru + " berhasil ditambahkan.");
                    break;

                case 2: // Tambah Mahasiswa ke Lokasi
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasi = readLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = readLine();
                    kampusin.addMahasiswaToLocation(lokasi, nama, nim);
                    break;

                case 3: // Tambah Edge antar Lokasi
                    System.out.println("\033[2j\033[H");
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
                    System.out.println("\033[2j\033[H");
                    kampusin.printGraph();
                    break;

                case 5: // Cari Mahasiswa di Lokasi
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiCari = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimCari = readLine();
                    kampusin.searchMahasiswa(lokasiCari, nimCari);
                    break;

                case 6: // Keluarkan Mahasiswa dari Antrian
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiKeluar = readLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimKeluar = readLine();
                    kampusin.dequeueMahasiswaByNim(lokasiKeluar, nimKeluar);
                    break;

                case 7: // Jalur Tercepat ke Kampus (BFS)
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan lokasi awal: ");
                    String startLokasi = readLine();
                    kampusin.bfs(startLokasi);
                    break;

                case 8: // Urutkan Mahasiswa di Lokasi
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiSort = readLine();
                    kampusin.sortMahasiswa(lokasiSort);
                    break;

                case 9: // Keluarkan Mahasiswa Pertama di Lokasi
                    System.out.println("\033[2j\033[H");
                    System.out.print("Masukkan nama lokasi: ");
                    String lokasiDequeue = readLine();
                    kampusin.dequeueMahasiswa(lokasiDequeue);
                    break;

                case 0: // Keluar
                    System.out.println("\033[2j\033[H");
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("\033[2j\033[H");
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