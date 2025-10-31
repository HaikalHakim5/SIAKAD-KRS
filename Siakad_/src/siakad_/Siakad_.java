package siakad_;
import java.util.*;

public class Siakad_ {
    static Scanner input = new Scanner(System.in);
    static Mahasiswa[] data = new Mahasiswa[100];
    static int jumlah = 0;

    public static void main(String[] args) {
        // Data awal
        Dosen dsn1 = new Dosen("2455200000", "Bapak Agus", "Teknik Menyerang", "Dosen Wali");
        Dosen dsn2 = new Dosen("123456789", "Bapak Yuli", "Sistem Informasi", "Dosen Wali");

        data[jumlah++] = new Mahasiswa("24552011202", "Haikal", "Teknik Menyerang", dsn1, 3.85);
        data[jumlah++] = new Mahasiswa("2310002", "Budi Santoso", "Sistem Informasi", dsn2, 3.45);

        int pilih;
        do {
            System.out.println("\n=== MENU SIAKAD ===");
            System.out.println("1. Daftar Mahasiswa");
            System.out.println("2. Cari Data Berdasarkan NIM");
            System.out.println("3. Hitung Rata-Rata IPK");
            System.out.println("4. Ganti Dosen Wali");
            System.out.println("5. Tambah Mahasiswa Baru");
            System.out.println("6. Kelola KRS Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tampilSemua();
                case 2 -> cariMahasiswa();
                case 3 -> hitungRataIpk();
                case 4 -> gantiDosen();
                case 5 -> tambahMahasiswa();
                case 6 -> menuKRS();
                case 0 -> System.out.println("Keluar...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    static void tampilSemua() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa!");
            return;
        }
        for (int i = 0; i < jumlah; i++) {
            data[i].tampilData();
            System.out.println();
        }
    }

    static void cariMahasiswa() {
        System.out.print("Masukkan NIM yang dicari: ");
        String nimCari = input.nextLine();
        boolean ketemu = false;
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equalsIgnoreCase(nimCari)) {
                data[i].tampilData();
                ketemu = true;
                break;
            }
        }
        if (!ketemu) System.out.println("Data tidak ditemukan!");
    }

    static void hitungRataIpk() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa!");
            return;
        }
        double total = 0;
        for (int i = 0; i < jumlah; i++) {
            total += data[i].getIpk();
        }
        double rata = total / jumlah;
        System.out.printf("Rata-rata IPK seluruh mahasiswa: %.2f\n", rata);
    }

    static void gantiDosen() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = input.nextLine();
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equalsIgnoreCase(nim)) {
                System.out.print("Masukkan NIDN dosen wali baru: ");
                String nidnDosen = input.nextLine();
                System.out.print("Masukkan nama dosen wali baru: ");
                String namaDosen = input.nextLine();
                Dosen baru = new Dosen(nidnDosen, namaDosen, data[i].getProdi(), "Dosen Wali");
                data[i].setDosenWali(baru);
                System.out.println("Dosen wali berhasil diganti!");
                return;
            }
        }
        System.out.println("Mahasiswa tidak ditemukan!");
    }

    static void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equalsIgnoreCase(nim)) {
                System.out.println("NIM sudah terdaftar!");
                return;
            }
        }

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Prodi: ");
        String prodi = input.nextLine();
        System.out.print("Masukkan IPK (0.0 - 4.0): ");
        double ipk = input.nextDouble();
        input.nextLine();

        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println("IPK harus antara 0.0 - 4.0!");
            return;
        }

        System.out.print("Masukkan NIDN Dosen Wali: ");
        String nidn = input.nextLine();
        System.out.print("Masukkan Nama Dosen Wali: ");
        String namaDosen = input.nextLine();

        Dosen dosen = new Dosen(nidn, namaDosen, prodi, "Dosen Wali");
        data[jumlah++] = new Mahasiswa(nim, nama, prodi, dosen, ipk);

        System.out.println("Mahasiswa baru berhasil ditambahkan!");
    }

    // === MENU KRS ===
    static void menuKRS() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = input.nextLine();
        Mahasiswa mhs = null;

        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equalsIgnoreCase(nim)) {
                mhs = data[i];
                break;
            }
        }

        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan!");
            return;
        }

        int pilih;
        do {
            System.out.println("\n=== Menu KRS Mahasiswa ===");
            System.out.println("1. Tambah Mata Kuliah ke KRS");
            System.out.println("2. Hapus Mata Kuliah dari KRS");
            System.out.println("3. Lihat KRS Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> {
                    System.out.print("Masukkan kode MK: ");
                    String kode = input.nextLine();
                    System.out.print("Masukkan nama MK: ");
                    String namaMk = input.nextLine();
                    System.out.print("Masukkan jumlah SKS: ");
                    int sks = input.nextInt();
                    input.nextLine();
                    try {
                        MataKuliah mk = new MataKuliah(kode, namaMk, sks);
                        mhs.tambahMataKuliah(mk);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Masukkan kode MK yang akan dihapus: ");
                    String kode = input.nextLine();
                    mhs.hapusMataKuliah(kode);
                }
                case 3 -> mhs.tampilKRS();
                case 0 -> System.out.println("Kembali ke menu utama...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }
}
