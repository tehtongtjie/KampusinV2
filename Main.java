import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            clearScreen();
            System.out.println("+=============================================+");
            System.out.println("|   Sistem Manajemen Data Mahasiswa & Edge    |");
            System.out.println("+=============================================+");
            System.out.println("\nPilih Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tambah Edge (Hubungan Antar Mahasiswa)");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("5. Cetak Semua Mahasiswa");
            System.out.println("6. Cetak Semua Edge");
            System.out.println("7. Urutkan Mahasiswa Berdasarkan Jarak");
            System.out.println("8. Keluar");
            System.out.print("\nMasukkan pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Tambah Data Mahasiswa     |");
                    System.out.println("+-----------------------------+");
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Jarak (km): ");
                    int jarak = scanner.nextInt();
                    scanner.nextLine();
                    list.add(nama, nim, jarak);
                    System.out.println("\nData berhasil ditambahkan!");
                    waitForEnter();
                    break;

                case 2:
                    clearScreen();
                    System.out.println("+-----------------------------------+");
                    System.out.println("|   Tambah Edge Antar Mahasiswa     |");
                    System.out.println("+-----------------------------------+");
                    System.out.print("Masukkan NIM Mahasiswa Asal: ");
                    String fromNim = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa Tujuan: ");
                    String toNim = scanner.nextLine();
                    System.out.print("Masukkan Bobot Jarak: ");
                    int weight = scanner.nextInt();
                    scanner.nextLine();
                    list.addEdge(fromNim, toNim, weight);
                    System.out.println("Edge berhasil ditambahkan!");
                    waitForEnter();
                    break;

                case 3:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Hapus Data Mahasiswa      |");
                    System.out.println("+-----------------------------+");
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String deleteNim = scanner.nextLine();
                    list.delete(deleteNim);
                    waitForEnter();
                    break;

                case 4:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Cari Data Mahasiswa       |");
                    System.out.println("+-----------------------------+");
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String searchNim = scanner.nextLine();
                    Node foundNode = list.searchingNim(searchNim);
                    if (foundNode != null) {
                        foundNode.print();
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + searchNim + " tidak ditemukan.");
                    }
                    waitForEnter();
                    break;

                case 5:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Daftar Semua Mahasiswa    |");
                    System.out.println("+-----------------------------+");
                    list.printAll();
                    waitForEnter();
                    break;

                case 6:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Daftar Semua Edge         |");
                    System.out.println("+-----------------------------+");
                    list.printEdges();
                    waitForEnter();
                    break;

                case 7:
                    clearScreen();
                    System.out.println("+-----------------------------+");
                    System.out.println("|   Urutkan Mahasiswa         |");
                    System.out.println("+-----------------------------+");
                    list.sortingJarak();
                    System.out.println("Mahasiswa berhasil diurutkan berdasarkan jarak!");
                    list.printAll();
                    waitForEnter();
                    break;

                case 8:
                    clearScreen();
                    System.out.println("Keluar dari program");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    waitForEnter();
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void waitForEnter() {
        System.out.println("\nTekan Enter untuk kembali ke menu utama...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
